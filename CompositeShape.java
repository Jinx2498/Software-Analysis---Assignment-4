import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class CompositeShape extends Shape {
	private Color color;

	protected int x=0, y=0, width=0, height=0;
	public ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	protected CompositeShape(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}

	@Override
	public void move(int buttonDownX, int buttonDownY, int newx, int newy) {
    	if (buttonDownX >= this.x && buttonDownX <= this.x + this.width)
    	{
    		if (buttonDownY >= this.y && buttonDownY <= this.y + this.height)
        	{
    			changeCoords(buttonDownX, buttonDownY, newx, newy);
        	}
    	}
    }
    
	@Override
    protected void changeCoords(int buttonDownX, int buttonDownY, int newx, int newy) {
		int deltaX = this.x - buttonDownX;
    	int deltaY = this.y - buttonDownY;
    	this.x = newx + deltaX;
    	this.y = newy + deltaY;
    }

    @Override
    public void paint(Graphics g){
    	g.setColor(color);
        g.drawRect(x, y, width, height);
        g.drawOval(x, y, width, height);
        g.drawPolygon(new int[] {x, y}, new int[] {x+y, x+y}, height);
    }
    
    @Override
    public String toString() {
    	return "Composite: {" + shapes + "}";
    }

    public ArrayList<Shape> getAllChildren() {

        ArrayList<Shape> newChildShapes = new ArrayList<Shape>();

        for (Shape s: shapes) {

            newChildShapes.add(s);

        }

        return newChildShapes;

    }

    public void addShape(Shape a) {

        shapes.add(a);

    }

}
