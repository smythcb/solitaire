package Solitaire;

import java.awt.Graphics;
import java.util.List;

import Solitaire.Model.*;

public class FoundationView extends PileView {

	protected Foundation2 model;  
	public FoundationView(Foundation2 model, int x, int y) {
		super(x,y,GameView.cardHeight, GameView.cardWidth);
		this.model = model;  
		//draw(g, foundations1[i], Margin+shiftX*(i+3), Margin ); 
		
	}
	
	void draw(Graphics g) {
		if (model.size() == 0) {
			CardView.drawOutline(g, startX, startY); 
		}
		else {
			CardView.drawPicture(g, model.giveTopCard(), startX, startY);
		}
	}

	@Override
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
