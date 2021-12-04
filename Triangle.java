import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends AtomicShape{
	private Color color;

	protected int x, y, width, height;
	
	protected Triangle(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
		this.x =x;
		this.y= y;
		this.width = width;
		this.height = height;
		this.color = color;
	}

	// public void move(int buttonDownX, int buttonDownY, int newx, int newy) {
	// 	if (buttonDownX >= this.x && buttonDownX <= this.x + this.width)
	// 	{
	// 		if (buttonDownY >= this.y && buttonDownY <= this.y + this.height)
	// 		{
	// 			changeCoords(buttonDownX, buttonDownY, newx, newy);
	// 		}
	// 	}
	// }

	// protected void changeCoords(int buttonDownX, int buttonDownY, int newx, int newy) {
	// 	int deltaX = this.x - buttonDownX;
	// 	int deltaY = this.y - buttonDownY;
	// 	this.x = newx + deltaX;
	// 	this.y = newy + deltaY;
	// }

	public void paint(Graphics g){
		g.setColor(Color.GREEN);
		g.drawPolygon(new int[]{x, (x+(int)Math.round(width/2.0)), (x+width)}, new int[]{(y+height), y, (y+height)}, 3);
	}

    @Override
    public String toString() {
    	return "Triangle: " + x + " " + y + " " + width + " " + height;
    }
}
