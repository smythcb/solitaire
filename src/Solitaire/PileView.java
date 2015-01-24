package Solitaire;

import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import Solitaire.Model.Card;

public abstract class PileView {

	protected int startX, startY, pileHeight, pileWidth; 
	
	 
	public PileView(int x, int y, int width, int height) {
		startX = x; 
		startY = y; 
		pileWidth = width; 
		pileHeight = height; 
	}
	
	public boolean inPile(int x, int y) {
		return (x <= startX+pileWidth && x >= startX && y <= startY+pileHeight && y >= startY ); 
	}
	
	public abstract void addCards(List<Card> cards); 
	
	public abstract void moveCards(PileView toPile, int x, int y) ;
	
	public abstract boolean accepts(List<Card> cards); 
	
	abstract void draw(Graphics g) ;
	
	
	

}
