/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jawas;
import java.util.Collection;
import java.util.LinkedList;
/**
 *
 * @author amnin
 */
public class WarPlayer extends Player {
    private LinkedList<WarCard> hand = new LinkedList<>();

    public WarPlayer(String name) {
        super(name);
        this.hand = new LinkedList<>();
    }

    public void receiveCard(WarCard card) {
        hand.add(card);
    }

    public WarCard playCard() {
        return hand.pop(); // Removes and returns the top card
    }

    public void collectCards(Collection<WarCard> cards) {
        hand.addAll(cards);
    }

    public boolean hasCards() {
        return !hand.isEmpty();
    }

    public int getHandSize() {
        return hand.size();
    }
    public LinkedList<WarCard> getHand() {
        return hand;
    }

    @Override
    public void play() {
        // The play method could be responsible for just printing out the card that is played
        // or returning it if we change the method's return type.
        // For now, let's print the card that is being played.
        if (!hand.isEmpty()) {
            WarCard card = hand.poll();
            System.out.println(getName() + " plays " + card);
            // Note: You might want to return or store this card depending on your game structure.
        } else {
            System.out.println(getName() + " has no more cards to play.");
        }
    }

    public WarCard drawCard() {
        // You could also move the draw card logic here from the WarGame play method
        return hand.poll();
    }

    public void collectCard(WarCard card) {
        // When a player wins a battle, they collect the card at the bottom of their hand
        hand.addLast(card);
    }

    public void collectCards(LinkedList<WarCard> cards) {
        // When a player wins a battle, they collect the losing cards at the bottom of their hand
        hand.addAll(cards);
    }
}

