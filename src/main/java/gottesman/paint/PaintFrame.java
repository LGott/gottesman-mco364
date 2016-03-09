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

	private JButton colorChooser;
	private JButton undo;
	private JButton redo;
	private Color color = Color.black;

	public PaintFrame() {

		setTitle("PaintFrame");
		setSize(1000, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		final PaintProperties properties = new PaintProperties();

		final Canvas canvas = new Canvas(properties);
		container.add(canvas, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

		this.colorChooser = new JButton("Choose Color");
		this.undo = new JButton("Undo");
		this.redo = new JButton("Redo");

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ToolButton button = (ToolButton) event.getSource();
				canvas.setTool(button.getTool());
			}
		};

		ToolButton[] buttons = new ToolButton[] { new ToolButton(new PencilTool(properties), "/pencil.png"),
				new ToolButton(new LineTool(properties), "/line.png"),
				new ToolButton(new RectangleTool(properties), "/square.png"),
				new ToolButton(new OvalTool(properties), "/circle.png"),
				new ToolButton(new PaintBucket(properties), "/bucket.png") };

		for (ToolButton button : buttons) {
			button.addActionListener(listener);
			panel.add(button);
		}

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

		colorChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				color = JColorChooser.showDialog(canvas, "Choose background color", Color.BLACK);

				if (color != null) {
					canvas.setColor(color);

				}
			}
		});
		buttonPanel.add(colorChooser);

		undo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				canvas.undoAndRedo("undo");
			}
		});
		buttonPanel.add(undo);

		redo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				canvas.undoAndRedo("redo");
			}
		});
		buttonPanel.add(redo);

		container.add(buttonPanel, BorderLayout.SOUTH);
		container.add(panel, BorderLayout.NORTH);
		setVisible(true);

	}

	public static void main(String[] args) {
		new PaintFrame();
	}

}