package gottesman.mco364;

import gottesman.paint.LineTool;
import gottesman.paint.PaintProperties;

import java.awt.Color;
import java.awt.Graphics;

import org.junit.Test;
import org.mockito.Mockito;

public class LineToolTest {

	@Test
	public void testMouseReleased() {
		PaintProperties properties = Mockito.mock(PaintProperties.class);
		Mockito.when(properties.getColor()).thenReturn(Color.RED);
		LineTool tool = new LineTool(properties);

		Graphics g = Mockito.mock(Graphics.class);

		tool.mousePressed(g, 2, 5);
		tool.mouseReleased(g, 12, 10);

		Mockito.verify(g).setColor(Color.RED);
		Mockito.verify(g).drawLine(2, 5, 12, 10);
	}

	@Test
	public void testDrawPreview() {
		PaintProperties properties = Mockito.mock(PaintProperties.class);
		Mockito.when(properties.getColor()).thenReturn(Color.RED);
		LineTool tool = new LineTool(properties);

		Graphics g = Mockito.mock(Graphics.class);
		tool.mousePressed(g, 6, 1);
		tool.mouseDragged(g, 9, 7);
		tool.drawPreview(g);

		Mockito.verify(g).setColor(Color.RED);
		Mockito.verify(g).drawLine(6, 1, 9, 7);
	}
}