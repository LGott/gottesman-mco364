package gottesman.paint;

import java.awt.Graphics;

public class OvalTool extends Tool {

	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int width;
	private int height;

	public OvalTool(PaintProperties properties) {
		super(properties);

	}

	public void mousePressed(Graphics g, int x, int y) {
		g.setColor(properties.getColor());
		g.fillOval(x, y, 1, 1);
		x1 = x;
		y1 = y;
		x2 = x;
		y2 = y;
	}

	public void mouseReleased(Graphics g, int x, int y) {
		g.setColor(properties.getColor());
		width = x - x1;
		height = y - y1;
		g.drawOval(x1, y1, width, height);

	}

	public void mouseDragged(Graphics g, int x, int y) {
		x2 = x;
		y2 = y;
	}

	public void drawPreview(Graphics g) {
		g.setColor(properties.getColor());
		width = x2 - x1;
		height = y2 - y1;
		g.drawOval(x1, y1, width, height);

	}

}