package gottesman.paint;

import java.awt.Graphics;

public class RectangleTool extends Tool {

	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int width;
	private int height;

	public RectangleTool(PaintProperties properties) {

		super(properties);
	}

	@Override
	public void mousePressed(Graphics g, int x, int y) {
		g.setColor(properties.getColor());
		g.fillRect(x, y, 1, 1);
		x1 = x;
		y1 = y;
		x2 = x;
		y2 = y;
	}

	@Override
	public void mouseReleased(Graphics g, int x, int y) {
		g.setColor(properties.getColor());
		width = x - x1;
		height = y - y1;
		g.drawRect(x1, y1, width, height);

	}

	@Override
	public void mouseDragged(Graphics g, int x, int y) {
		x2 = x;
		y2 = y;
	}

	@Override
	public void drawPreview(Graphics g) {
		g.setColor(properties.getColor());
		width = x2 - x1;
		height = y2 - y1;
		g.drawRect(x1, y1, width, height);

	}
}