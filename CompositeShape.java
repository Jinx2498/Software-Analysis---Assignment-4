import java.awt.Color;
import java.util.ArrayList;

public class CompositeShape extends Shape {
	private Color color;

	protected int x=0, y=0, width=0, height=0;
	public ArrayList<Shape> childShapes = new ArrayList<Shape>();
	
	protected CompositeShape(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}

	// @Override
	// public void move(int buttonDownX, int buttonDownY, int newx, int newy) {
    // 	if (buttonDownX >= this.x && buttonDownX <= this.x + this.width)
    // 	{
    // 		if (buttonDownY >= this.y && buttonDownY <= this.y + this.height)
    //     	{
    // 			changeCoords(buttonDownX, buttonDownY, newx, newy);
    //     	}
    // 	}
    // }
    
	// @Override
    // protected void changeCoords(int buttonDownX, int buttonDownY, int newx, int newy) {
	// 	int deltaX = this.x - buttonDownX;
    // 	int deltaY = this.y - buttonDownY;
    // 	this.x = newx + deltaX;
    // 	this.y = newy + deltaY;
    // }

    // @Override
    // public void paint(Graphics g){
    // 	g.setColor(color);
    // 	g.drawRect(x, y, width, height);
    // }
    
    // @Override
    // public String toString() {
    // 	return "Rect: " + x + " " + y + " " + width + " " + height;
    // }

}
