package gottesman.mco364;

import gottesman.paint.PaintProperties;
import gottesman.paint.PencilTool;

import java.awt.Color;
import java.awt.Graphics;

import org.junit.Test;
import org.mockito.Mockito;

public class PencilToolTest {

	@Test
	public void testMousePressed() {

		PaintProperties properties = Mockito.mock(PaintProperties.class);
		PencilTool tool = new PencilTool(properties);

		Mockito.when(properties.getColor()).thenReturn(Color.RED);

		Graphics g = Mockito.mock(Graphics.class);
		tool.mousePressed(g, 5, 10);

		Mockito.verify(g).setColor(Color.RED);
		Mockito.verify(g).drawLine(5, 5, 10, 10);
	}

	@Test
	public void testMouseDragged() {
		PaintProperties properties = Mockito.mock(PaintProperties.class);
		PencilTool tool = new PencilTool(properties);

		Mockito.when(properties.getColor()).thenReturn(Color.RED);

		Graphics g = Mockito.mock(Graphics.class);
		tool.mouseDragged(g, 5, 10);
		tool.mouseDragged(g, 5, 10);

		Mockito.verify(g, Mockito.atLeastOnce()).setColor(Color.RED);
		Mockito.verify(g).drawLine(5, 10, 5, 10);
		// Mockito.verify(g).drawLine(6, 9, 6, 9);
		// Mockito.verify(g).drawLine(5, 10, 6, 9);
	}

}