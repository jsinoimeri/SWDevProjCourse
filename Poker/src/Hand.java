import java.util.*;

/**
 * A poker hand is a list of cards, which can be of some "kind" (pair, straight, etc.)
 *
 * @author Jeton Sinoimeri
 * @version 1.0 - Sept 24, 2014
 * 
 */

public class Hand implements Comparable<Hand> {

    public enum Kind {HIGH_CARD, PAIR, TWO_PAIR, THREE_OF_A_KIND, STRAIGHT, 
        FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH}

    private final List<Card> cards;

    /**
     * Create a hand from a string containing all cards (e,g, "5C TD AH QS 2D")
     * 
     */
    public Hand(String c) {
    	
        this.cards = new ArrayList<Card>();
        
        String[] card = c.split(" ");
        		
        for(String s: card)
        	this.cards.add(new Card(s));
    }
    
    /**
     * @returns true if the hand has n cards of the same rank
	   * e.g., "TD TC TH 7C 7D" returns True for n=2 and n=3, and False for n=1 and n=4
     */
    protected boolean hasNKind(int n) {
    	
    	List<Integer> card = new ArrayList<Integer>();
    	
    	    	
    	for(Card c: this.cards)
    		card.add(c.getRank().ordinal());
    	
    	Collections.sort(card);
    	
    	    		
    	if (n == 2)
    	{
	    	for(int i = 0; i < card.size() - 1; i++)
	    		if (card.get(i) == card.get(i+1))
	    			return true;
    	}
    	
    	else if (n == 3)
    	{
    		for(int i = 0; i < card.size() - 2; i++)
	    		if (card.get(i) == card.get(i+1) && card.get(i+1) == card.get(i+2))
	    			return true;
    	}
    	
    	else if (n == 4)
    	{
    		for(int i = 0; i < card.size() - 3; i++)
	    		if (card.get(i) == card.get(i+1) && card.get(i+1) == card.get(i+2)
	    			&& card.get(i+2) == card.get(i+3) && card.get(i+3) == card.get(i+4))
	    			
	    			return true;
    	}
    	
    	
        return false;
    }
    
    /**
	   * Optional: you may skip this one. If so, just make it return False
     * @returns true if the hand has two pairs
     */
    public boolean isTwoPair() {
    	List<Integer> card = new ArrayList<Integer>();

    	for(Card c: this.cards)
    		card.add(c.getRank().ordinal());
    	
    	Collections.sort(card);
    	
    	int pairin = -1;
    	int pairfound = 0;
    	
    	for(int i = 0; i < card.size() - 1; i++)
    		if (card.get(i) == card.get(i+1))
    			pairin = i;
    	
    	
    	for (int j = pairin + 2; j< card.size(); j++)
        	if (card.get(j) == card.get(j+1))
        		if (pairin != -1)
        			pairfound = 2;
    	
    	if (pairfound == 2)
    		return true;
    	
    	return false;

    }   
    
    /**
     * @returns true if the hand is a straight 
     */
    public boolean isStraight() {
    	List<Integer> card = new ArrayList<Integer>();
    	
    	int count = 0;
    	
    	for(Card c: this.cards)
    		card.add(c.getRank().ordinal());
    	
    	Collections.sort(card);
    	
    	for(int i = 0; i < card.size() - 1; i++)
    	{
    		if (card.get(i+1) - card.get(i) == 1)
    			count++;   			
    	}
    	   		
    	if (count == 4)
    		return true;
    	
        return false;
    }
    
    /**
     * @returns true if the hand is a flush
     */
    public boolean isFlush() {
    	
    	int count = 0;
    	
    	for (int i = 0; i < this.cards.size() - 1; i++ )
    		if (this.cards.get(i).getSuit() == this.cards.get(i+1).getSuit())
    			count++;
    	
    	if (count == 4)
    		return true;
    	
        return false;
    }
    
    @Override
    public int compareTo(Hand h) {
        //hint: delegate!
		    //and don't worry about breaking ties
    	if (this.kind().ordinal() > h.kind().ordinal())
    		return 1;
    	
    	else if (this.kind().ordinal() < h.kind().ordinal())
    		return -1;
    	
    	return 0;
    }
    
    /**
	   * This method is already implemented and could be useful! 
     * @returns the "kind" of the hand: flush, full house, etc.
     */
    public Kind kind() {
        if (isStraight() && isFlush()) 
        	return Kind.STRAIGHT_FLUSH;
        
        else if (hasNKind(4)) 
        	return Kind.FOUR_OF_A_KIND; 
        
        else if (hasNKind(3) && hasNKind(2)) 
        	return Kind.FULL_HOUSE;
        
        else if (isFlush()) 
        	return Kind.FLUSH;
        
        else if (isStraight()) 
        	return Kind.STRAIGHT;
        
        else if (hasNKind(3))
        	return Kind.THREE_OF_A_KIND;
        
        else if (isTwoPair()) 
        	return Kind.TWO_PAIR;
        
        else if (hasNKind(2)) 
        	return Kind.PAIR; 
        
        else 
        	return Kind.HIGH_CARD;
    }

}