package Solitaire;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.JPanel;
import Solitaire.Model.* ;

@SuppressWarnings("serial")
public class CardView extends JPanel {
 
	public static void drawPicture(Graphics g, Card card, int x, int y) {
		g.drawImage(Images.getPicture(card), x, y, null);
	}
	
	
	public static void drawOutline(Graphics g, int x, int y) {
		g.drawImage(Images.getOutline(), x, y, null);
	}
	
	public static void drawBack(Graphics g, int x, int y) {
		g.drawImage(Images.getBack(), x, y, null);  
	}
	
}
