import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends AtomicShape {

	private Color color;

	protected int x, y, width, height;
	
	protected Rectangle(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}
    
    @Override
    public String toString() {
    	return "Rect: " + x + " " + y + " " + width + " " + height;
    }
}
