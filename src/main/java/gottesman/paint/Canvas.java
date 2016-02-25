package gottesman.paint;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Canvas extends JPanel {

	private static final long serialVersionUID = 1L;

	private BufferedImage buffer;
	private Tool tool;

	public Canvas() {

		this.buffer = new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);
		tool = new OvalTool();

		this.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
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

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(buffer, 0, 0, null);
		tool.drawPreview(g);

	}
}