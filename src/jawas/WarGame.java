/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jawas;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
/**
 *
 * @author amnin
 */
public class WarGame extends Game {
     private GroupOfCards deck; // You need a deck to draw cards from

    public WarGame(String name) {
        super(name);
        deck = new GroupOfCards(52); // This should initialize the deck with 52 cards
        // Populate the deck
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (String suit : suits) {
            for (int rank = 2; rank <= 14; rank++) {
                deck.getCards().add(new WarCard(suit, rank));
            }
        }
        deck.shuffle(); // Shuffle the deck

        // Create two players
        WarPlayer player1 = new WarPlayer("Player 1");
        WarPlayer player2 = new WarPlayer("Player 2");
        this.getPlayers().add(player1);
        this.getPlayers().add(player2);

        // Deal cards to players
        // You need a method in GroupOfCards to deal cards, this code assumes such a method exists.
        deck.dealCards(player1, player2);
    }

    @Override
    public void play() {
        WarPlayer player1 = (WarPlayer) getPlayers().get(0);
        WarPlayer player2 = (WarPlayer) getPlayers().get(1);

        // Main game loop
        while (player1.hasCards() && player2.hasCards()) {
            WarCard card1 = player1.playCard();
            WarCard card2 = player2.playCard();

            System.out.println(player1.getName() + " plays " + card1 + " and " + player2.getName() + " plays " + card2);

            if (card1.getRank() > card2.getRank()) {
                player1.collectCards(new LinkedList<>(Collections.singletonList(card2)));
                player1.collectCards(new LinkedList<>(Collections.singletonList(card1)));
                System.out.println(player1.getName() + " wins the round.");
            } else if (card2.getRank() > card1.getRank()) {
                player1.collectCards(new LinkedList<>(Collections.singletonList(card2)));
                player1.collectCards(new LinkedList<>(Collections.singletonList(card1)));
                System.out.println(player2.getName() + " wins the round.");
            } else {
                // Handle tie scenario ("war")
                System.out.println("War!");
                // Implement war scenario logic
            }
        }

        // Declare the winner
        declareWinner();
    }

    @Override
    public void declareWinner() {
        WarPlayer player1 = (WarPlayer) getPlayers().get(0);
        WarPlayer player2 = (WarPlayer) getPlayers().get(1);

        if (player1.getHandSize() > player2.getHandSize()) {
            System.out.println(player1.getName() + " wins the game with " + player1.getHandSize() + " cards!");
        } else if (player2.getHandSize() > player1.getHandSize()) {
            System.out.println(player2.getName() + " wins the game with " + player2.getHandSize() + " cards!");
        } else {
            System.out.println("The game is a draw!");
        }
    }
}
