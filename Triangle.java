import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends AtomicShape{
	private Color color;

	protected int x, y, width, height;
	
	protected Triangle(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}
    
    public void move(int buttonDownX, int buttonDownY, int newx, int newy) {
    	if (buttonDownX >= this.x && buttonDownX <= this.x + this.width)
    	{
    		if (buttonDownY >= this.y && buttonDownY <= this.y + this.height)
        	{
    			changeCoords(buttonDownX, buttonDownY, newx, newy);
        	}
    	}
    }
    
    protected void changeCoords(int buttonDownX, int buttonDownY, int newx, int newy) {
		int deltaX = this.x - buttonDownX;
    	int deltaY = this.y - buttonDownY;
    	this.x = newx + deltaX;
    	this.y = newy + deltaY;
    }
    
    public void paint(Graphics g){
    	g.setColor(color);
    	g.drawPolygon(new int[] {x, y}, new int[] {x+y, x+y}, height);
    }
    
    @Override
    public String toString() {
    	return "Triangle: " + x + " " + y + " " + width + " " + height;
    }
}
