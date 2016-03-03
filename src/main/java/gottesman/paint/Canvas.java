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

public class Canvas extends JPanel {

	private static final long serialVersionUID = 1L;

	private Stack<BufferedImage> undo;
	private Stack<BufferedImage> redo;
	private BufferedImage buffer;
	private Tool tool;
	Color color = Color.black;

	public Canvas() {

		this.buffer = new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);
		tool = new PencilTool(color);
		undo = new Stack<BufferedImage>();
		redo = new Stack<BufferedImage>();

		addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {

				undo.push(copy(buffer));

				tool.mousePressed(buffer.getGraphics(), e.getX(), e.getY());
				repaint();
			}

			public void mouseReleased(MouseEvent e) {

				tool.mouseReleased(buffer.getGraphics(), e.getX(), e.getY());
				repaint();
			}

		});

		this.addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent e) {
				tool.mouseDragged(buffer.getGraphics(), e.getX(), e.getY());
				repaint();
			}

			public void mouseMoved(MouseEvent e) {
			}
		});
	}

	public void setColor(Color color) {
		tool.setColor(color);
	}

	public Tool getTool() {
		return this.tool;
	}

	public void setTool(Tool tool) {

		this.tool = tool;

	}

	public void undoAndRedo(String ur) {
		if (ur.equals("undo") && (!(undo.isEmpty()))) {
			redo.push(copy(buffer));
			buffer = undo.pop();
			repaint();
		}
		if (ur.equals("redo") && (!(redo.isEmpty()))) {
			undo.push(copy(buffer));
			buffer = redo.pop();
			repaint();
		}
	}

	public BufferedImage getBuffer() {
		return this.buffer;
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
		g.drawImage(buffer, 0, 0, null);
		tool.drawPreview(g);
	}
}