package gottesman.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JButton ovalTool;
	private JButton rectTool;
	private JButton paintBucket;
	private JButton lineTool;
	private JButton pencilTool;
	private JButton colorChooser;
	private JButton undo;
	private JButton redo;

	private Canvas canvas;
	private Tool tool;
	private Color color;

	public PaintFrame() {

		setTitle("PaintFrame");
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

		container.add(buttons, BorderLayout.NORTH);
		pencilTool = new JButton("Pencil");
		rectTool = new JButton("Box");
		ovalTool = new JButton("Oval");
		lineTool = new JButton("Line");
		paintBucket = new JButton("Bucket");
		colorChooser = new JButton("Choose Color");
		color = Color.BLACK;
		undo = new JButton("Undo");
		redo = new JButton("Redo");
		buttons.add(rectTool);
		buttons.add(pencilTool);
		buttons.add(lineTool);
		buttons.add(paintBucket);
		buttons.add(ovalTool);
		buttons.add(colorChooser);
		buttons.add(undo);
		buttons.add(redo);

		canvas = new Canvas();
		container.add(canvas, BorderLayout.CENTER);

		pencilTool.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				tool = new PencilTool(color);
				canvas.setTool(tool);
			}

		});

		ovalTool.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				tool = new OvalTool(color);
				canvas.setTool(tool);
			}

		});

		lineTool.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				tool = new LineTool(color);
				canvas.setTool(tool);
			}

		});

		rectTool.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				tool = new RectangleTool(color);
				canvas.setTool(tool);
			}

		});
		paintBucket.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				tool = new PaintBucket(color, canvas.getBuffer());
				canvas.setTool(tool);
			}

		});

		colorChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				color = JColorChooser.showDialog(canvas, "Choose background color", Color.BLACK);

				if (color != null) {
					canvas.setColor(color);

				}
			}
		});

		undo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				canvas.undoAndRedo("undo");
			}
		});

		redo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				canvas.undoAndRedo("redo");
			}
		});

		setVisible(true);

	}

	public static void main(String[] args) {
		new PaintFrame();
	}

}