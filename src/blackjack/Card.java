package blackjack;

public abstract class Card {
    public Suit suit;
    
    public Card(Suit suit){
        this.suit = suit;
    }
    public abstract int value(); 
}
