package blackjack;

public class Ace extends Card {
    public Ace(Suit suit){
        super(suit);
    }

    @Override
    public int value() {
        return 11;
    }
    public int secondValue() {
        return 1;
    }
}
