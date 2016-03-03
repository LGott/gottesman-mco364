package gottesman.paint;

import java.awt.Color;
import java.awt.Graphics;

public class PencilTool implements Tool {

	private int x;
	private int y;
	private Color color;

	public PencilTool(Color color) {
		this.color = color;
	}

	public void mousePressed(Graphics g, int x, int y) {
		g.setColor(color);
		g.fillOval(x, y, 1, 1);
		this.x = x;
		this.y = y;
	}

	public void mouseReleased(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(Graphics g, int x, int y) {

		g.setColor(color);
		g.drawLine(this.x, this.y, x, y);
		this.x = x;
		this.y = y;
	}

	public void drawPreview(Graphics g) {
		// TODO Auto-generated method stub

	}

	public void setColor(Color color) {
		this.color = color;

	}

}