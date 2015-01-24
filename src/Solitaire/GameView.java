package Solitaire;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
//import java.lang.reflect.Array;
//import java.util.ArrayList;



import javax.swing.JPanel;

//The table class, sets the layout of the whole thing 
// sets 13 stack views 
@SuppressWarnings("serial")
public class GameView extends JPanel {
	
	//protected Game2 game1; 
	//protected static FoundationView[] foundations1 = new FoundationView[4]; 
	//protected TalonView talon1; 
	//protected WasteView waste1;  
	//protected TableauView[] tableaus1 = new TableauView[7];
	
	public static final int baseX = 40, baseY = 10, shiftX = 80, shiftY = 160, cardShift = 15, cardWidth = 73, cardHeight = 97; 
	public static final int Margin = 40; 

	
	static int anchorX, anchorY, currentX, currentY;
    static boolean drawLine = false;
    static boolean lineRed = false;
    static boolean fromTalon = true; 
    
    public PileView[] pileViewArray;
    public void clearMarkers() { drawLine = false; }
	
    
    
    public GameView() {
    	
    	// Define, instantiate and register a MouseListener object
    	addMouseListener(new MouseAdapter() {
    	    public void mousePressed(MouseEvent e) {
    		// remember the end of a rubber line
    		anchorX = e.getX();
    		anchorY = e.getY();
    	    }
    	    public void mouseClicked(MouseEvent e) {
    	    	if (pileViewArray[12].inPile(e.getX(), e.getY())) {
    	    		Solitaire.currentGame.getTalonWaste().deal();
    	    	}
    	    }
    	});

    	// Define, instantiate and register a MouseListener object
    	addMouseListener(new MouseAdapter() {
    	    public void mouseReleased(MouseEvent e) {
    		// paint the last rubber-line in red
    		int anchor = 0; 
    		while (!pileViewArray[anchor].inPile(anchorX, anchorY) && anchor < 12) {
    			anchor++; 
    		}
    		
    		int current = 0; 
    		while (!pileViewArray[current].inPile(currentX, currentY) && current < 12) {
    			current++; 
    		}
    		
    		if (current == 12 || anchor == 12) return; 
    		
    		pileViewArray[anchor].moveCards(pileViewArray[current], anchorX, anchorY); 
    		drawLine = false;  
    		repaint();
    		if (Solitaire.currentGame.wonGame()) { System.out.println("You won the game!"); }
    	    }
    	});

    	// Define, instantiate and register a MouseMotionListener object
    	addMouseMotionListener(new MouseMotionAdapter() {
    	    public void mouseDragged(MouseEvent e) {
    		// draw a rubber line (in black)
    		currentX = e.getX();  currentY = e.getY();
    		drawLine = true; lineRed = false; 	
    		repaint();
    	    }
    	});
    	gameChanged();
    }
    public void gameChanged(){
    	
    	pileViewArray = new PileView[13]; 

		for (int i = 0; i < 4; i++) {
			
			pileViewArray[i] = new FoundationView(Solitaire.currentGame.getFoundation(i),  Margin+shiftX*(i+3) , Margin);
		}
		
		for(int i = 0; i < 7; i++) {
			pileViewArray[i+4] = new TableauView(Solitaire.currentGame.getTableau(i), Margin+i*shiftX, Margin+shiftY);
		}
		
		
		pileViewArray[11] = new WasteView(Solitaire.currentGame.getTalonWaste(), Margin+shiftX, Margin);
		pileViewArray[12] = new TalonView(Solitaire.currentGame.getTalonWaste(), Margin, Margin) ; 
		repaint();
    }
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); 
		g.setColor(Color.green);
		g.fillRect(0, 0, getWidth(), getHeight());
 
		for (int i = 0; i < 13; i++) {
			pileViewArray[i].draw(g);
		}
		
		
		
		if ( drawLine ){
	    	g.setColor( lineRed ? Color.RED : Color.BLACK);
	    	g.drawLine( anchorX,  anchorY,  currentX,  currentY);
	    }
		
		repaint();
	}

	
	public static int getCardShift() {
		return cardShift; 
	}
	
	
    public Dimension getMinimumSize() {
    	return getPreferredSize();
    }

    public Dimension getMaximumSize() {
    	return getPreferredSize();
    }

     
    /*public void fromPile(int x, int y) {
    	//if from pile is talon 
    	if (Margin < x && x < (cardWidth+Margin) && Margin < y && y < cardHeight+Margin) {
    		fromTalon = true; 
    	}
    	//if from pile is waste pile 
    	else if ()
    }
	
   */
    
    //mouselistener stuff
    

}
