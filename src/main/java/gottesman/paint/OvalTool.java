package gottesman.paint;

import java.awt.Color;
import java.awt.Graphics;

public class OvalTool implements Tool {

	private int x1;
	private int y1;
	private int x2;
	private int y2;

	public void mousePressed(Graphics g, int x, int y) {
		g.setColor(Color.BLACK);
		g.fillOval(x, y, 1, 1);
		x1 = x;
		y1 = y;
		x2 = x;
		y2 = y;
	}

	public void mouseReleased(Graphics g, int x, int y) {
		g.setColor(Color.BLACK);
		g.drawOval(x1, y1, x, y);

	}

	public void mouseDragged(Graphics g, int x, int y) {
		x2 = x;
		y2 = y;
	}

	public void drawPreview(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawOval(x1, y1, x2, y2);

	}

}