import java.awt.Color;

public abstract class Shape {
	private Color color;

	protected int x, y, width, height;
	
	protected Shape(int x, int y, int width, int height, Color color) {
		this.x =x;
		this.y= y;
		this.width = width;
		this.height = height;
		this.color = color;
	}
}
