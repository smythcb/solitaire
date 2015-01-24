package Solitaire.Model;

import java.util.ArrayList;
import java.util.List;

public abstract class Pile2 {

	List<Card> pile;
	
	public Pile2(List<Card> startCards) {
		pile = new ArrayList<Card>(startCards); 
	}
	
	public Pile2() {
		pile = new ArrayList<Card>();
	}
	
	
	
	//a pile of cards are indexed 0 to pile.size-1, with the top card at pile.size-1
	public Card giveTopCard() {
		if (!pile.isEmpty()){
			return pile.get(pile.size()-1); 
		}
		return null; 
	}
	
	
	
	public void removeTopCard(int n) {
		if (canRemoveTopCards(n)) {
			for (int i = 0; i < n; i++) {
				pile.remove(pile.size() - 1); 
			}
		}
	}
	
	
	public void addCards(List<Card> cards){
		if (canAddCards(cards)) {
			pile.addAll(cards);
		}

	}
	
	public List<Card> getPile() {
		return pile; 
	}
	
	public int size() {
		return pile.size(); 
	}
	
	public abstract boolean canAddCards(List<Card> cards);
	
	public abstract boolean canRemoveTopCards(int i);

	
}
