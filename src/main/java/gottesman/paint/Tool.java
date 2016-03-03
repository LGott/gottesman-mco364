package gottesman.paint;

import java.awt.Color;
import java.awt.Graphics;

public interface Tool {

	void mousePressed(Graphics g, int x, int y);

	void mouseReleased(Graphics g, int x, int y);

	void mouseDragged(Graphics g, int x, int y);

	void drawPreview(Graphics g);

	void setColor(Color color);
}