package Solitaire.Model;

import java.util.ArrayList;
import java.util.List;

public class TalonWaste2 extends Pile2 {

	private List<Card> talon; 
	
	public TalonWaste2(List<Card> startCards) {
		super();  
		talon = new ArrayList<Card>(startCards);	
	}
	

	
	@Override
	public boolean canAddCards(List<Card> cards) {
		return false;
	}

	@Override
	public boolean canRemoveTopCards(int n) {
		return (!pile.isEmpty() && n==1); 
	}
	
	public void deal() {

		if (talon.isEmpty()) {
			while (!pile.isEmpty()) {
				talon.add(0, pile.remove(0));
			}
		}
		else {
			for (int x = 0; x < 3 && !talon.isEmpty(); x++) {
				pile.add(talon.remove(talon.size()-1));
			}
		}
		
	}
	
	//checks if talon is empty
	public boolean talonEmpty() {
		return (talon.isEmpty());
	}
}
