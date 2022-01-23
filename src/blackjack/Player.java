package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final ArrayList<Card> bet;

    public Player(ArrayList<Card> bet) {
        this.bet = bet;
    }
    
    public void addCard(Card card){
        this.bet.add(card);
    }

    public List<Card> getBet() {
        return bet;
    }
    
}
