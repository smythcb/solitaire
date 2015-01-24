package Solitaire;

import java.awt.Graphics;
import java.util.List;

import Solitaire.Model.* ; 

public class TalonView extends PileView {

	private TalonWaste2 model;  
	
	public TalonView(TalonWaste2 model, int x, int y) {
		super(x,y,GameView.cardWidth, GameView.cardHeight);
		this.model = model;  
	}
	
	void draw(Graphics g) {
		if (model.talonEmpty()) {
			CardView.drawOutline(g, startX, startY); 
		}
		else {
			CardView.drawBack(g, startX, startY);
		}
	}
	
	public void moveCards(PileView toPile, int x, int y) {
		
		
	}

	@Override
	public void addCards(List<Card> cards) {
		throw new UnsupportedOperationException(); 
		
	}

	@Override
	public boolean accepts(List<Card> cards) {
		return false;
	
	}

}
