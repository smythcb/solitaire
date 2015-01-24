package Solitaire.Model;

public class Card {

		
		private Suit suit;
		private int value;  
		
		public Card(Suit s, int value) {
			this.suit = s; 
			this.value = value; 
		}
		
		public Suit suit(){
			return suit ;
			}
		
		public int value(){
			return value; 
		}
		
		public boolean isBlack() {
			return (suit == Suit.Clubs || suit == Suit.Spades);
		}
		
}
