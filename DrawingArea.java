import javax.swing.*;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawingArea extends JLabel {
    Dimension minSize = new Dimension(100, 50);
    private int x1, y1, x2, y2;
   
    public static enum State{
    	Start,
    	Moving,
    	Rectangle,
    	Oval,
    	Triangle
    }
    
    private State state = State.Start;
    
    private ArrayList<Rectangle> shapesR = new ArrayList<Rectangle>();
	private ArrayList<Oval> shapesO = new ArrayList<Oval>();
	private ArrayList<Triangle> shapesT = new ArrayList<Triangle>();
    
    public DrawingArea() {
    	this.setBackground(Color.BLACK);
        setOpaque(true);
    }
    
    public Dimension getMinimumSize() {
        return minSize;
    }

    public Dimension getPreferredSize() {
        return minSize;
    }
    
    public void setMouseDownPosition(int x, int y){
    	x1 = x;
    	y1 = y;
    	//System.out.println(x1 + " " + y1);
    }
    
    public void setMouseUpPosition(int x, int y){
    	x2 = x;
    	y2 = y;
    	//System.out.println(x2 + " " + y2);
    }
    
    public void paint(Graphics g){
    	super.paint(g);

    	if (x1 == 0 && x2 == 0 && y1 == 0 && y2 == 0) return;
    	
    	if (state == State.Moving){

    		for (Rectangle s: shapesR) {
	    		s.move(x1, y1, x2, y2);
	    		s.paint(g);
    		}

			for (Oval s: shapesO) {
	    		s.move(x1, y1, x2, y2);
	    		s.paint(g);
    		}

			for (Triangle s: shapesT) {
	    		s.move(x1, y1, x2, y2);
	    		s.paint(g);
    		}

    	} else if (state == State.Rectangle) {

        	shapesR.add(new Rectangle(x1, y1, x2-x1, y2-y1, Color.BLUE));

    	} else if (state == State.Oval) {

			shapesO.add(new Oval(x1, y1, x2-x1, y2-y1, Color.RED));

		} else if (state == State.Triangle) {

			shapesT.add(new Triangle(x1, y1, x2-x1, y2-y1, Color.GREEN));

		}

    	for (Rectangle s: shapesR){
    		s.paint(g);
    	}

		for (Oval s: shapesO){
    		s.paint(g);
    	}

		for (Triangle s: shapesT){
    		s.paint(g);
    	}

    }
    
    public void changeState(State newState) {
    	state = newState;
    }
    
    public State getState() {
    	return state;
    }
}