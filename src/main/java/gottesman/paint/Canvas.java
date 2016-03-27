package gottesman.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Stack;

import javax.swing.JPanel;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class Canvas extends JPanel {

	private Stack<BufferedImage> undo;
	private Stack<BufferedImage> redo;
	private Tool tool;
	private PaintProperties properties;

	@Inject
	public Canvas(final PaintProperties properties) {

		this.properties = properties;
		this.undo = new Stack<BufferedImage>();
		this.redo = new Stack<BufferedImage>();
		this.tool = new PencilTool(properties);
		addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {

				undo.push(copy(properties.getImage()));

				tool.mousePressed(properties.getImage().getGraphics(), e.getX(), e.getY());
				repaint();
			}

			public void mouseReleased(MouseEvent e) {

				tool.mouseReleased(properties.getImage().getGraphics(), e.getX(), e.getY());
				repaint();
			}

		});

		this.addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent e) {
				tool.mouseDragged(properties.getImage().getGraphics(), e.getX(), e.getY());
				repaint();
			}

			public void mouseMoved(MouseEvent e) {
			}
		});
	}

	public Tool getTool() {
		return this.tool;
	}

	public void setTool(Tool tool) {

		this.tool = tool;

	}

	public void setColor(Color newColor) {
		properties.setColor(newColor);
	}

	public void undoAndRedo(String ur) {
		if (ur.equals("undo") && (!(undo.isEmpty()))) {
			redo.push(copy(properties.getImage()));
			properties.setImage(undo.pop());
			repaint();
		}
		if (ur.equals("redo") && (!(redo.isEmpty()))) {
			undo.push(copy(properties.getImage()));
			properties.setImage(redo.pop());
			repaint();
		}
	}

	public BufferedImage getBuffer() {
		return this.properties.getImage();
	}

	public PaintProperties getProperties() {
		return this.properties;
	}

	public BufferedImage copy(BufferedImage img) {

		BufferedImage newBuffer = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
		Graphics2D g2 = newBuffer.createGraphics();
		g2.drawImage(img, 0, 0, null);

		return newBuffer;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(properties.getImage(), 0, 0, null);
		tool.drawPreview(g);
	}
}