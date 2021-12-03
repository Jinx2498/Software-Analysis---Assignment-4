import java.awt.Color;

public abstract class AtomicShape extends Shape{

	private Color color;

	protected int x, y, width, height;
	
	protected AtomicShape(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}
    
}
