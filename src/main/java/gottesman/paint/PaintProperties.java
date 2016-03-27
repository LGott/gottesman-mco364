package gottesman.paint;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.inject.Singleton;

@Singleton
public class PaintProperties {

	private int width;
	private int height;
	private BufferedImage image;
	private Color color;
	private int weight;
	private boolean fill;

	public PaintProperties() {
		image = new BufferedImage(800, 700, BufferedImage.TYPE_INT_ARGB);
		width = image.getWidth();
		height = image.getHeight();
		color = Color.BLACK;
		weight = 1;
		fill = false;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public boolean isFill() {
		return fill;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}
}