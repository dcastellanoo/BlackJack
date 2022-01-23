package blackjack;

public class CardWithValue10 extends Card{

    public CardWithValue10(Suit suit) {
        super(suit);
    }

    @Override
    public int value() {
        return 10;
    }
    
}
