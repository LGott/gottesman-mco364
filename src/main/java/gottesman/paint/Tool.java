package gottesman.paint;

import java.awt.Graphics;

public abstract class Tool {

	protected PaintProperties properties;

	public Tool(PaintProperties properties) {
		this.properties = properties;
	}

	abstract void mousePressed(Graphics g, int x, int y);

	abstract void mouseReleased(Graphics g, int x, int y);

	abstract void mouseDragged(Graphics g, int x, int y);

	abstract void drawPreview(Graphics g);
}