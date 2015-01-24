package Solitaire.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Random;

//the game strategy 
public class Game {
	
	private List<Card> pack = new ArrayList<Card>();
	private TalonWaste2 talonWaste;  
	private Foundation2[] foundations;
	private Tableau2[] tableaus;
	
	//initialises a game
	public Game() {
		foundations = new Foundation2[4]; 
		tableaus = new Tableau2[7]; 
		newGame();
		
	}
	
	
	
	// cards are indexed in the range [1..Solitaire.suitSize]
	public boolean wonGame() {
		if (foundations[0].giveTopCard().value() == 13 && foundations[1].giveTopCard().value() == 13 && foundations[2].giveTopCard().value() == 13 && foundations[3].giveTopCard().value() == 13) {
			return true; 
		}
		return false;
	}
	
	private static List<Card> createPack() {
		List<Card> newPack = new ArrayList<Card>();
		for ( Suit s: Suit.values() ) {
			for ( int cn=0 ; cn<13 ; cn++ ) {
				newPack.add(new Card(s, cn+1));
			}
		}
		return newPack; 
	}

	
	
	public void newGame() {
		
		pack = createPack(); 
		
		//shuffles cards
		shuffle(pack, pack.size()); 
		
		//creates foundations 
		for (int foundation = 0; foundation < 4; foundation++) {
			foundations[foundation] = new Foundation2(); 
		}
		
		
		//index of pack 
		int packIndex = 0; 
		
		//creates tableaus 
		for (int tableau = 0; tableau < 7; tableau++) {
			int startIndex = packIndex;  
			int endIndex = startIndex+tableau+1; 
			List<Card> startCards = pack.subList(startIndex, endIndex); 
			tableaus[tableau] = new Tableau2(startCards); 
			packIndex = endIndex; 
		}
		
	
		
		// creates talon
		List<Card> startCards = pack.subList(packIndex, pack.size()); 
		talonWaste = new TalonWaste2(startCards); 
		
	}
	
	
	
	private static void shuffle( List<Card> cards, int length) {
		Random rgen = new Random();
	/** Shuffle the first n cards in list in-place, using the random
	 *  number generator rgen
	 */
    
		if ( length <= 1 ) return; // finished!
		
		// select a card number in the range [0..n), and swap that with position n-1
		int cn = (int) (length * rgen.nextFloat());
		assert cn>=0 && cn < length;
		Card cv = cards.get( cn), lv = cards.get( length-1);
		cards.set( cn, lv);  cards.set( length-1, cv);
		
		// recursively shuffle the rest 
		shuffle( cards, length-1);
		return;
    }
	
	

	
	
	public Foundation2 getFoundation(int i) {
		assert i<4 && i>=0 ;
		return foundations[i]; 
	}
	
	public Tableau2 getTableau(int i) {
		assert i<7 && i>=0 ;
		return tableaus[i]; 
	}
	
	public TalonWaste2 getTalonWaste() {
		return talonWaste; 
	}
	
	//creating waste2 has meant that no cards are dealt!

	
	
	
	

}
