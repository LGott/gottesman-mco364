package gottesman.paint;

import java.awt.Color;
import java.awt.Graphics;

public class PencilTool implements Tool {

	private int x;
	private int y;

	public void mousePressed(Graphics g, int x, int y) {
		g.setColor(Color.BLACK);
		g.fillOval(x, y, 1, 1);
		this.x = x;
		this.y = y;
	}

	public void mouseReleased(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(Graphics g, int x, int y) {

		g.setColor(Color.BLACK);
		g.drawLine(this.x, this.y, x, y);
		this.x = x;
		this.y = y;
	}

	public void drawPreview(Graphics g) {
		// TODO Auto-generated method stub

	}

}