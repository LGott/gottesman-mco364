package gottesman.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PaintBucket implements Tool {

	private BufferedImage buffer;

	public PaintBucket(BufferedImage buffer) {
		this.buffer = buffer;
	}

	public void paintbucket(int x, int y, int color) {

		int toFill = Color.blue.getRGB();

		if ((x >= 0) && (y >= 0) && (buffer.getRGB(x, y) != color)) {

			paintbucket(x - 1, y, toFill);
			paintbucket(x, y - 1, toFill);
			paintbucket(x + 1, y, toFill);
			paintbucket(x, y + 1, toFill);
			paintbucket(x - 1, y - 1, toFill);
			paintbucket(x + 1, y + 1, toFill);
			paintbucket(x + 1, y - 1, toFill);
			paintbucket(x - 1, y + 1, toFill);
		}
	}

	public void mousePressed(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

		paintbucket(x, y, g.getColor().getRGB());
	}

	public void mouseReleased(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

	}

	public void drawPreview(Graphics g) {
		// TODO Auto-generated method stub

	}
}