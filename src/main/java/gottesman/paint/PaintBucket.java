package gottesman.paint;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Queue;

public class PaintBucket extends Tool {

	public PaintBucket(PaintProperties properties) {
		super(properties);
	}

	@Override
	public void mousePressed(Graphics g, int x, int y) {

		// Call the buketFill method when the mouse is pressed,
		// passing in the coordinates,old color, new color, and buffered image.

		bucketFill(x, y, properties.getImage().getRGB(x, y), properties.getColor().getRGB());

	}

	@Override
	public void mouseReleased(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawPreview(Graphics g) {
		// TODO Auto-generated method stub

	}

	private void bucketFill(int x, int y, int prevColor, int newColor) {

		Queue<Point> queue = new LinkedList<Point>();

		queue.add(new Point(x, y));

		Point p;

		while (!queue.isEmpty()) {

			// Remove the first element in the queue
			p = queue.remove();

			// Get the x,y coordinates
			int x2 = p.getX();
			int y2 = p.getY();

			// Switch the color as long as the color is equal to the old color

			if ((x2 > 0) && (y2 > 0) && (x2 < properties.getImage().getWidth())
					&& (y2 < properties.getImage().getHeight()) && (properties.getImage().getRGB(x2, y2) == prevColor)) {

				properties.getImage().setRGB(x2, y2, newColor);

				// Add the surrounding points to the queue

				queue.add(new Point(x2 - 1, y2));

				queue.add(new Point(x2 + 1, y2));

				queue.add(new Point(x2, y2 - 1));

				queue.add(new Point(x2, y2 + 1));
			}
		}

	}

}