package Solitaire;

import java.awt.Image;
import java.awt.Toolkit;
import Solitaire.Model.* ; 

//contains images of all the cards
public class Images {
	
	private final static String directory = "cards", extension = ".gif",
    		cardBackFilename = "back122", cardOutlineFilename = "bottom01";
	
	
	
	private static Image loadImage( String path) {
		try {
			return Toolkit.getDefaultToolkit().getImage( path);
			}
		catch ( Exception e ) {
		    System.err.println( "Error " + e.getMessage() );
		    return null; 
			}
	    }

	
	public static Image getPicture(Card c) { 
		return loadImage( directory+"/"+FileName( c.suit(), c.value())); 
		
	}
	
	public static Image getBack() {
		return loadImage(directory+"/"+cardBackFilename+extension );
	}
	
	public static Image getOutline(){
		return loadImage(directory+"/"+cardOutlineFilename+extension) ; 
	}
	
	private static String FileName( Suit s, int value) throws IllegalArgumentException {
		char cardSuit;
			
		if ( value < 1){
		    throw new IllegalArgumentException( "Bad Card Number Too Low" + value);
		}
		if (value > Solitaire.suitSize ) {
			throw new IllegalArgumentException("Bad Card Number Too High" + value);
		}
		
		if ( s==Suit.Clubs )
		    cardSuit = 'c';
		else if ( s==Suit.Diamonds )
		    cardSuit = 'd';
		else if ( s==Suit.Hearts )
		    cardSuit = 'h';
		else if ( s==Suit.Spades )
		    cardSuit = 's';
		else
		    throw new IllegalArgumentException( "Bad Card Suit");
	
		if ( value <10 )
		    return "0" + value + cardSuit + extension;
		else
		    return "" + value + cardSuit + extension;
	    }
}
