package Solitaire;

import java.awt.Graphics;
import java.util.List;

import Solitaire.Model.* ; 
//shows top three cards, shifted. 

public class WasteView extends PileView {
	
	private TalonWaste2 model; 
	
	public WasteView(TalonWaste2 model, int x, int y) {
		super(x,y, GameView.cardWidth+2*GameView.cardShift, GameView.cardHeight);
		this.model = model; 
	}
	
	
	void draw(Graphics g) { 
		
		if (model.size() == 0) {
			CardView.drawOutline(g, startX, startY);
		}
		
		 
		int n = Math.min(model.size(), 3);
		
		for (int i = 0; i < n ; i++) {
			CardView.drawPicture(g, model.getPile().get(model.size()-n+i), startX+GameView.cardShift*i, startY);
		}
		
		
	}
	
	//user means to always take top card
	public void moveCards(PileView toPile, int x, int y) {
		if (model.canRemoveTopCards(1)) {
			if(toPile.accepts(model.getPile().subList(model.size()-1, model.size()))) {
				toPile.addCards(model.getPile().subList(model.size()-1, model.size())) ; 
				model.removeTopCard(1);
			}
		}
		
	}

	@Override
	public void addCards(List<Card> cards) {
		model.addCards(cards);
		
	}

	@Override
	public boolean accepts(List<Card> cards) {
		return model.canAddCards(cards);
	
	}

}
