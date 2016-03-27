package gottesman.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

@Singleton
public class PaintToolbar extends Container {

	@Inject
	public PaintToolbar(final Canvas canvas, PaintProperties properties) {

		setLayout(new BorderLayout());
		Dimension dim = new Dimension(800, 250);
		setPreferredSize(dim);

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		JPanel botPanel = new JPanel();
		botPanel.setLayout(new FlowLayout());

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
			button.setPreferredSize(new Dimension(120, 120));
			topPanel.add(button);
		}

		JButton undoButton = new JButton("Undo");
		undoButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				canvas.undoAndRedo("undo");
			}

		});

		botPanel.add(undoButton);

		JButton redoButton = new JButton("Redo");
		redoButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				canvas.undoAndRedo("redo");
			}

		});
		botPanel.add(redoButton);

		final JButton colorButton = new JButton("Choose Color");

		colorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Color color = JColorChooser.showDialog(canvas, "Choose background color", Color.BLACK);

				if (color != null) {
					canvas.setColor(color);
				}
			}
		});
		botPanel.add(colorButton);

		add(topPanel, BorderLayout.NORTH);
		add(botPanel, BorderLayout.CENTER);
	}

}