import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class SmellyCode extends JPanel {

    private DrawingArea drawingArea;
    JTextArea textArea;
    public JPanel buttonPanel = new JPanel(new GridLayout(2, 3));
    
    
    public static void main(String[] args) {
        //Create and set up the window.
        JFrame frame = new JFrame("MouseEventDemo");
        
        //Create and set up the content pane
        JComponent newContentPanel = new SmellyCode();
        
        frame.setContentPane(newContentPanel);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public SmellyCode() {
        super(new GridLayout(0,1));	//Don't worry about this, it's just another layout manager
        drawing();
        textAndScroll();
        createAllButtons();
        setPreferredSize(new Dimension(600, 600));
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));	//Adds a border to the panel
    }

    void drawing() {
        
        drawingArea = new DrawingArea(); //Instantiate our blank area
        add(drawingArea);

        // Register for mouse events on drawingArea and the panel.
        drawingArea.addMouseListener(new MouseListener(){
            public void mousePressed(MouseEvent e) { //Mouse pressed event
                eventOutput("Mouse pressed on drawingArea (# of clicks: "				//Fires when the mouse is pushed down
                        + e.getClickCount() + ")");
                drawingArea.setMouseDownPosition(e.getX(), e.getY());
            }
            
            public void mouseReleased(MouseEvent e) {				//Mouse released event
                eventOutput("Mouse released on drawingArea (# of clicks: "				//Fires when the mouse is released
                        + e.getClickCount() + ")");
                drawingArea.setMouseUpPosition(e.getX(), e.getY());
                drawingArea.repaint();
            }
            
            public void mouseEntered(MouseEvent e) {				//Mouse entered event
                eventOutput("Mouse entered on drawingArea");						//Fires when the mouse enters the listening component
            }
            
            public void mouseExited(MouseEvent e) {					//Mouse exited event
                eventOutput("Mouse exited on drawingArea");							//Fires when the mouse exits the listening component
            }
            
            public void mouseClicked(MouseEvent e) {				//Mouse clicked event
                eventOutput("Mouse clicked on drawingArea (# of clicks: "				//Fires when the mouse is pushed down and released with minimal displacement
                        + e.getClickCount() + ")");						//If there is displacement, it's a drag not a click
            }
        }); //Add a mouse listener to the drawingArea
        
        this.addMouseListener(new MouseListener(){
            public void mousePressed(MouseEvent e) {				//Mouse pressed event
                eventOutput("Mouse pressed on panel (# of clicks: "				//Fires when the mouse is pushed down
                        + e.getClickCount() + ")");
            }
            
            public void mouseReleased(MouseEvent e) {				//Mouse released event
                eventOutput("Mouse released on panel (# of clicks: "				//Fires when the mouse is released
                        + e.getClickCount() + ")");
            }
            
            public void mouseEntered(MouseEvent e) {				//Mouse entered event
                eventOutput("Mouse entered on panel");						//Fires when the mouse enters the listening component
            }
            
            public void mouseExited(MouseEvent e) {					//Mouse exited event
                eventOutput("Mouse exited on panel");							//Fires when the mouse exits the listening component
            }
            
            public void mouseClicked(MouseEvent e) {				//Mouse clicked event
                eventOutput("Mouse clicked on panel (# of clicks: "				//Fires when the mouse is pushed down and released with minimal displacement
                        + e.getClickCount() + ")");						//If there is displacement, it's a drag not a click
            }
        });	//Add a mouse listener to this as well

        drawingArea.addMouseMotionListener(new MouseMotionListener(){

            @Override
            public void mouseDragged(MouseEvent e) {
                eventOutput("Mouse dragged on drawingArea (" + e.getXOnScreen() + ", " + e.getYOnScreen() + ")");
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                eventOutput("Mouse moved on drawingArea (" + e.getXOnScreen() + ", " + e.getYOnScreen() + ")");
                
            }
            
        });	//Add a mouse motion listener to the drawingArea
        
        this.addMouseMotionListener(new MouseMotionListener(){

            @Override
            public void mouseDragged(MouseEvent e) {
                eventOutput("Mouse dragged on panel (" + e.getXOnScreen() + ", " + e.getYOnScreen() + ")");
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                eventOutput("Mouse moved on panel (" + e.getXOnScreen() + ", " + e.getYOnScreen() + ")");
                
            }
        });	
    }

    void textAndScroll() {
        textArea = new JTextArea();	//Create the text area
        textArea.setEditable(false); //Don't let the user edit the text

        JScrollPane scrollPane = new JScrollPane(textArea);	//Add a scrollbar to the text
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); //Have the vertical scroll always there
                
        scrollPane.setPreferredSize(new Dimension(200, 200));
        add(scrollPane); //Add the scrollbar to the panel
        
    }

    void makeAndAddButton(int a) {
        
        if (a == 1){

            JButton buttonMove = new JButton("Move");
            buttonMove.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    drawingArea.changeState(DrawingArea.State.Moving);
                } 

            });
            buttonPanel.add(buttonMove);

        } else if (a == 2) {

            JButton buttonNewRect = new JButton("New Rectangle");
            buttonNewRect.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    drawingArea.changeState(DrawingArea.State.Rectangle);
                } 
            });
            buttonPanel.add(buttonNewRect);

        } else if (a == 3) {

            JButton buttonNewOval = new JButton("New Oval");
            buttonNewOval.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    drawingArea.changeState(DrawingArea.State.Oval);
                } 
            });
            buttonPanel.add(buttonNewOval);

        } else if (a == 4) {

            JButton buttonNewTriangle = new JButton("New Triangle");
            buttonNewTriangle.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    drawingArea.changeState(DrawingArea.State.Triangle);
                } 
            });
            buttonPanel.add(buttonNewTriangle);

        } else if (a == 5) {

            JButton buttonMerge = new JButton("Merge All");
            buttonMerge.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    //drawingArea.mergeAll();
                } 
            });
            buttonPanel.add(buttonMerge);

        } else if (a == 6) {

            JButton buttonUnmerge = new JButton("Unmerge All");
            buttonUnmerge.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    //drawingArea.unmergeAll();
                } 
            });
            buttonPanel.add(buttonUnmerge);

        }
    }

    void createAllButtons() {
        
        int move = 1;
        makeAndAddButton(move);

        int rectangle = 2;
        makeAndAddButton(rectangle);
        
        int oval = 3;
        makeAndAddButton(oval);

        int triangle = 4;
        makeAndAddButton(triangle);

        int merge = 5;
        makeAndAddButton(merge);

        int unmerge = 6;
        makeAndAddButton(unmerge);

        add(buttonPanel);
    }
    
    void eventOutput(String eventDescription) {		//We just forward mouse events to this method
        textArea.append(eventDescription + " detected.\n");
    }
}