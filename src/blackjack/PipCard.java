package blackjack;

public class PipCard extends Card{
    private final int value;

    public PipCard(Suit suit, int value) {
        super(suit);
        this.value = value;
    }
    
    @Override
    public int value() {
        return this.value;
    }
    
}
