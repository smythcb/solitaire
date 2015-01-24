package Solitaire;

import java.awt.Graphics;
import java.util.List;

import Solitaire.Model.* ;

public class TableauView extends PileView {

	private Tableau2 model;
	public TableauView(Tableau2 model, int x, int y) {
		super(x,y,GameView.cardHeight,Solitaire.TableHeight - y);
		this.model= model; 
		 
		
	}
	
	void draw(Graphics g) {
		
		CardView.drawOutline(g, startX, startY);
		
		for (int i = 0; i < model.getUnrevealed(); i++) {
			CardView.drawBack(g, startX, startY+GameView.cardShift*i);
		}
		
		for (int i = model.getUnrevealed(); i < model.size(); i++) {
			CardView.drawPicture(g, model.getPile().get(i), startX, startY+GameView.cardShift*i);
		}
		
	}

	//x and y click coords
	public void moveCards(PileView toPile, int x, int y) {
		int n = Math.max(model.size() - (y - startY) / (GameView.cardShift), 1) ;
		System.out.println(n); 
		if (model.canRemoveTopCards(n)) {
			System.out.println("can remove hi!");
			if(toPile.accepts(model.getPile().subList(model.size()-n, model.size()))) {
				System.out.println("accepts hi!");
				toPile.addCards(model.getPile().subList(model.size()-n, model.size())) ; 
				model.removeTopCard(n);
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
