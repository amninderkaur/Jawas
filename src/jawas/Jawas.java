/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jawas;

/**
 *
 * @author amnin
 */
public class Jawas {

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) {
        // Create a game instance
        WarGame game = new WarGame("War");

        // Add players to the game
        WarPlayer player1 = new WarPlayer("Player 1");
        WarPlayer player2 = new WarPlayer("Player 2");

        // Since the game's constructor is initializing the deck and shuffling,
        // and the play method is handling the logic, we only need to start the game.
        game.play();
    }
    
}
