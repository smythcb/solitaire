package Solitaire.Model;

import java.util.List;

public class Foundation2 extends Pile2 {


	@Override
	public boolean canAddCards(List<Card> cards) {
		
		if (cards.size() != 1) return false;
		// cards should be size 1, so get(0) should return last and only (aka top) card
		Card newCard = cards.get(0);
		Card oldTopCard = giveTopCard();
		
		//if the new card is an Ace, we ignore later checks on suit and value 
		if (oldTopCard == null && newCard.value() == 1) return true; 
		
		if ((oldTopCard.value() + 1) != newCard.value()) return false;
		if ((oldTopCard.suit() != newCard.suit())) return false;
		
		return true;
	}
	
	//public List<Card> getPile() {
	//	return foundation; 
	//
	public boolean canRemoveTopCards(int n) {
		return (!pile.isEmpty() && n==1) ; 
	}
}
