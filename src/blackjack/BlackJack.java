package blackjack;

import java.util.ArrayList;
import java.util.List;


public class BlackJack {

    public static boolean isBlackJack(List<Card> bet) {
        return getSumOfBet(bet) == 21 && bet.size() == 2;
    }

    public static int getSumOfBet(List<Card> bet) {
        int sum_max = 21;
        int sum = 0;
        int numOfAces = 0;
        
        for (Card card : bet) {
            sum += card.value();
            if (card instanceof Ace){
                numOfAces++;
            }
        }
        
        for (Card card : bet) {
            if (sum <= sum_max) {
                break;
            }
            if (card instanceof Ace && numOfAces > 0){
                sum -= (card.value() - ((Ace) card).secondValue());
                numOfAces--;
            }
        }
        return sum;
    }
    
    public static List<Player> getWinners(Player player1, Player player2, Player player3, Player crupier, List<Card> deck){
        int sum_max = 21;
        int sum_min = 17;
        
        while (getSumOfBet(crupier.getBet()) < sum_min){
            crupier.addCard(deck.get(0));
            deck.remove(0);
        }
        List<Player> winners = new ArrayList<Player>();
        
        if (isBlackJack(crupier.getBet())){
            return winners;
        } 
        
        if ((isBlackJack(player1.getBet()) | (getSumOfBet(player1.getBet()) > getSumOfBet(crupier.getBet())) | (getSumOfBet(crupier.getBet()) > sum_max))
                && (getSumOfBet(player1.getBet()) <= sum_max)){
            winners.add(player1);
        }
        if ((isBlackJack(player2.getBet()) | (getSumOfBet(player2.getBet()) > getSumOfBet(crupier.getBet())) | (getSumOfBet(crupier.getBet()) > sum_max)) 
                && (getSumOfBet(player2.getBet()) <= sum_max)){
            winners.add(player2);
        }
        if ((isBlackJack(player3.getBet()) | (getSumOfBet(player3.getBet()) > getSumOfBet(crupier.getBet())) | (getSumOfBet(crupier.getBet()) > sum_max))
                && (getSumOfBet(player3.getBet()) <= sum_max)){
            winners.add(player3);
        }
        
        return winners;
    }
}
