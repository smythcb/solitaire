/** Initial version of Solitaire.java
 */

package Solitaire;

import Solitaire.Model.* ; 
//import java.awt.*;
//import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings({ "serial"})
public class Solitaire extends JApplet{

	
	public static final int suitSize = 13;
	//table height and width effect how it's shown, look into this
	public static final int TableWidth = 740, TableHeight = 600; 
	public static final int baseX = 40, baseY = 10; 
	
	public static Solitaire innerFrame; 
 	static protected Game currentGame; 
 	static protected JPanel buttonPanel; 
 	static protected GameView table; 

	
 	
    public static void main(String[] args) { 
    	
 
    	
    	JFrame outerFrame = new JFrame("Solitaire");
    	//Solitaire innerFrame = new Solitaire(); 
    	
    	
    	//initialises model
    	currentGame = new Game();
    	table = new GameView();
    	//new GameController(table);
    	
    	innerFrame = new Solitaire();
    	//sets the size of the whole window 
    	innerFrame.setLayout(new FlowLayout());
    	//innerFrame.setPreferredSize(new Dimension(TableWidth, TableHeight));
    	
    	
    	buttonPanel = new JPanel();
    	buttonPanel.setLayout(new FlowLayout());

    	
    	JButton bs = new JButton("New Game");
    	bs.addActionListener( new ActionListener() {
		    public void actionPerformed( ActionEvent e) {
			// something wrong with newgame, it doesn't paint properly 
			currentGame.newGame();
			table.clearMarkers();
			//table.revalidate();
			table.gameChanged();
			innerFrame.repaint();
		    }
    	});
    	buttonPanel.add(bs);
    	
    	
    	JButton bq = new JButton("Quit");
    	bq.addActionListener( new ActionListener() {
		    public void actionPerformed( ActionEvent e) {
		    	System.exit(0);
		    }
		});
    	buttonPanel.add(bq);
    	
    	
    
    	
    	
    	//table = new GameView(currentGame); 
    	table.setPreferredSize(new Dimension(TableWidth, TableHeight));
    	table.setLayout(new FlowLayout()); 
    	
    	
    	
		innerFrame.add(table);
    
    	innerFrame.add(buttonPanel);
    	//innerFrame.validate(); 
    	
		//outerFrame.add(buttonPanel); 
		outerFrame.add(innerFrame);
		outerFrame.pack();
    	outerFrame.setVisible(true); 
		//outerFrame.validate(); 

		
	}
    
    
}

    
        
