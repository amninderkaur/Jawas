/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jawas;

/**
 *
 * @author amnin
 */
public class WarCard extends Card{
private final String suit;
    private final int rank; // 2-10 for numbered cards, 11 for Jack, 12 for Queen, 13 for King, 14 for Ace

    public WarCard(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "WarCard{" + "suit='" + suit + '\'' + ", rank=" + rank + '}';
    }
}
