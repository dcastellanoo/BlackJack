/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import blackjack.*;

/**
 *
 * @author diego
 */
public class BlackJackTest {
    
    public BlackJackTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void bet_with_J_and_A_isBlackJack(){
        List<Card> bet = new ArrayList<Card>();
        bet.add(new CardWithValue10(Suit.DIAMONDS));
        bet.add(new Ace(Suit.DIAMONDS));
        
        assert (BlackJack.isBlackJack(bet));
    }    
/*
    ### Caso 1
Player 1: "J", "A" (21, Black Jack)
Player 2: "10", "5", "6" (21)
Player 3: "3", "6", "A", "3", "A", "K" (24)
Croupier: "9", "7" (16)
Deck: "5", "4", "K", "2"
getWinners(...) -----> [Player1] 
*/
    
    @Test
    public void return_player1_when_we_present_case_1(){
        Player player1 = new Player(new ArrayList<Card>());
        Player player2 = new Player(new ArrayList<Card>());
        Player player3 = new Player(new ArrayList<Card>());
        Player crupier = new Player(new ArrayList<Card>());
        
        player1.addCard(new CardWithValue10(Suit.HEARTS));
        player1.addCard(new Ace(Suit.PIKES));
        
        assertEquals(BlackJack.getSumOfBet(player1.getBet()), 21);
        
        player2.addCard(new CardWithValue10(Suit.PIKES));
        player2.addCard(new PipCard(Suit.DIAMONDS, 5));
        player2.addCard(new PipCard(Suit.CLOVERS, 6));
        
        assertEquals(BlackJack.getSumOfBet(player2.getBet()), 21);

        player3.addCard(new PipCard(Suit.HEARTS, 3));
        player3.addCard(new PipCard(Suit.DIAMONDS, 6));  
        player3.addCard(new Ace(Suit.HEARTS));
        player3.addCard(new PipCard(Suit.CLOVERS, 3));
        player3.addCard(new Ace(Suit.CLOVERS));
        player3.addCard(new CardWithValue10(Suit.PIKES));
        
        assertEquals(BlackJack.getSumOfBet(player3.getBet()), 24);
        
        crupier.addCard(new PipCard(Suit.HEARTS, 9));
        crupier.addCard(new PipCard(Suit.DIAMONDS, 7));
        
        List<Card> deck = new ArrayList<Card>();
        deck.add(new PipCard(Suit.HEARTS, 5));
        deck.add(new PipCard(Suit.CLOVERS, 6));
        deck.add(new CardWithValue10(Suit.CLOVERS));
        deck.add(new PipCard(Suit.DIAMONDS, 2));
        
        List<Player> realWinners = new ArrayList<Player>();
        realWinners.add(player1);
        
        assertEquals(realWinners, BlackJack.getWinners(player1, player2, player3, crupier, deck));
    }

/*
    Player 1: "10", "K" (20)
Player 2: "10", "2", "6" (18)
Player 3: "8", "8", "5" (21)
Croupier: "5", "10" (15)
Deck: "A" , "3" , "K" , "2"
    
getWinners(...) -----> [Player1, Player3]
*/
    
    @Test 
    public void return_player1_and_palyer2_when_we_present_case_2(){
        Player player1 = new Player(new ArrayList<Card>());
        Player player2 = new Player(new ArrayList<Card>());
        Player player3 = new Player(new ArrayList<Card>());
        Player crupier = new Player(new ArrayList<Card>());
        
        player1.addCard(new CardWithValue10(Suit.HEARTS));
        player1.addCard(new CardWithValue10(Suit.PIKES));
        
        assertEquals(BlackJack.getSumOfBet(player1.getBet()), 20);
        
        player2.addCard(new CardWithValue10(Suit.PIKES));
        player2.addCard(new PipCard(Suit.DIAMONDS, 2));
        player2.addCard(new PipCard(Suit.CLOVERS, 6));
        
        assertEquals(BlackJack.getSumOfBet(player2.getBet()), 18);
        
        player3.addCard(new PipCard(Suit.PIKES, 8));
        player3.addCard(new PipCard(Suit.DIAMONDS, 8));
        player3.addCard(new PipCard(Suit.HEARTS, 5));
        
        assertEquals(BlackJack.getSumOfBet(player3.getBet()), 21);
        
        crupier.addCard(new PipCard(Suit.CLOVERS, 5));
        crupier.addCard(new CardWithValue10(Suit.DIAMONDS));
        
        List<Card> deck = new ArrayList<Card>();
        deck.add(new Ace(Suit.HEARTS));
        deck.add(new PipCard(Suit.CLOVERS, 3));
        deck.add(new CardWithValue10(Suit.CLOVERS));
        deck.add(new PipCard(Suit.HEARTS, 2));
        
        List<Player> realWinners = new ArrayList<Player>();
        realWinners.add(player1);
        realWinners.add(player3);
        
        assertEquals(realWinners, BlackJack.getWinners(player1, player2, player3, crupier, deck));
    }
/*
Player 1: "10", "6", "J" (26)
Player 2: "K", "A" (21, BlackJack)
Player 3: "6", "7", "7" (20)
Croupier: "K" (10)
Deck: "A" , "7" , "J" , "5"
getWinners(...) -----> []
*/
    
    @Test
    public void return_no_player_when_we_present_case_3(){
        Player player1 = new Player(new ArrayList<Card>());
        Player player2 = new Player(new ArrayList<Card>());
        Player player3 = new Player(new ArrayList<Card>());
        Player crupier = new Player(new ArrayList<Card>());
        
        player1.addCard(new CardWithValue10(Suit.HEARTS));
        player1.addCard(new PipCard(Suit.HEARTS, 6));
        player1.addCard(new CardWithValue10(Suit.HEARTS));
        
        assertEquals(BlackJack.getSumOfBet(player1.getBet()), 26);
        
        player2.addCard(new CardWithValue10(Suit.PIKES));
        player2.addCard(new Ace(Suit.HEARTS));
        
        assertEquals(BlackJack.getSumOfBet(player2.getBet()), 21);
        
        player3.addCard(new PipCard(Suit.PIKES, 6));
        player3.addCard(new PipCard(Suit.DIAMONDS, 7));
        player3.addCard(new PipCard(Suit.HEARTS, 7));
        
        assertEquals(BlackJack.getSumOfBet(player3.getBet()), 20);
        
        crupier.addCard(new CardWithValue10(Suit.DIAMONDS));
        
        List<Card> deck = new ArrayList<Card>();
        deck.add(new Ace(Suit.CLOVERS));
        deck.add(new PipCard(Suit.CLOVERS, 7));
        deck.add(new CardWithValue10(Suit.DIAMONDS));
        deck.add(new PipCard(Suit.HEARTS, 5));
        
        List<Player> realWinners = new ArrayList<Player>();
        
        assertEquals(realWinners, BlackJack.getWinners(player1, player2, player3, crupier, deck));
    }
    
/*
Player 1: "10", "6", "5" (21)
Player 2: "8", "8", "3" (19)
Player 3: "10", "8" (18)
Croupier: "K", "5" (15)
Deck: "A" , "8" , "3" , "2"
getWinners(...) -----> [Player1, Player2, Player3]
*/
    @Test
    public void return_player1_player2_and_player3_when_we_present_case_4(){
        Player player1 = new Player(new ArrayList<Card>());
        Player player2 = new Player(new ArrayList<Card>());
        Player player3 = new Player(new ArrayList<Card>());
        Player crupier = new Player(new ArrayList<Card>());
        
        player1.addCard(new CardWithValue10(Suit.PIKES));
        player1.addCard(new PipCard(Suit.CLOVERS, 6));
        player1.addCard(new PipCard(Suit.DIAMONDS, 5));
        
        assertEquals(BlackJack.getSumOfBet(player1.getBet()), 21);
        
        player2.addCard(new PipCard(Suit.DIAMONDS, 8));
        player2.addCard(new PipCard(Suit.HEARTS, 8));
        player2.addCard(new PipCard(Suit.CLOVERS, 3));
        
        assertEquals(BlackJack.getSumOfBet(player2.getBet()), 19);
        
        player3.addCard(new CardWithValue10(Suit.DIAMONDS));
        player3.addCard(new PipCard(Suit.PIKES, 8));
        
        assertEquals(BlackJack.getSumOfBet(player3.getBet()), 18);
        
        crupier.addCard(new CardWithValue10(Suit.HEARTS));
        crupier.addCard(new PipCard(Suit.PIKES, 5));
        
        List<Card> deck = new ArrayList<Card>();
        deck.add(new Ace(Suit.CLOVERS));
        deck.add(new PipCard(Suit.CLOVERS, 8));
        deck.add(new PipCard(Suit.HEARTS, 3));
        deck.add(new PipCard(Suit.HEARTS, 2));
        
        List<Player> realWinners = new ArrayList<Player>();
        realWinners.add(player1);
        realWinners.add(player2);
        realWinners.add(player3);
        
        assertEquals(realWinners, BlackJack.getWinners(player1, player2, player3, crupier, deck));
    }
}
