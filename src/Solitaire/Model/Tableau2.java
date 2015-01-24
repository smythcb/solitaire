package Solitaire.Model;

import java.util.List;

public class Tableau2 extends Pile2{

	private int unrevealed; 
	
	
	@Override
	public boolean canRemoveTopCards(int n) {
		return n <= pile.size() - unrevealed; 
	}
	
	
	@Override
	public boolean canAddCards(List<Card> cards) {
		
		//bottom of pile is beginning of list 
		Card topOfNewPile = cards.get(0); 
		Card oldEndOfTableau = giveTopCard();
		
		//if new card is a King, and there is no existing pile, ignore later checks
		if (oldEndOfTableau == null && topOfNewPile.value() == 13) return true; 
		
		//other rules: card can be added if it is -1 value of existing card and a different colour
		if ((oldEndOfTableau.value() - 1) != topOfNewPile.value()) return false;
		
		//xor the two colours of the suits of the two cards that are being compared
		//if colours are different, it will return true, if they are different it will return false 
		return ((oldEndOfTableau.isBlack() && !topOfNewPile.isBlack()) || (!oldEndOfTableau.isBlack() && topOfNewPile.isBlack()));

	}
	
	
	public Tableau2(List<Card> startCards) {
		super(startCards);
		//all start unrevealed apart from last card in list 
		unrevealed = startCards.size()-1;

	}
	
	@Override
	public void removeTopCard(int n) {
		super.removeTopCard(n);
		if (unrevealed == size() && unrevealed > 0) {
			unrevealed--; 
		}
	}
	//returns index of last unrevealed card
	public int getUnrevealed() {
		return unrevealed;
	}
}
