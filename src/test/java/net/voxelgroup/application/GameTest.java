package net.voxelgroup.application;

import net.voxelgroup.classes.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static net.voxelgroup.utilities.RandomCreator.generateRandomColor;

class GameTest {

    private Player testPlayer1;
    private Player testPlayer2;
    private Player testPlayer3;
    private ArrayList<Player> testPlayerList;
    Game game;

    @BeforeEach
    void setUp() {
        testPlayer1 = new Player("Test Player 1", generateRandomColor());
        testPlayer2 = new Player("Test Player 2", generateRandomColor());
        testPlayer3 = new Player("Test Player 3", generateRandomColor());
        game = new Game();
    }

    @Test
    void test_playGame_winnerPlayer() {
        game.start();
        boolean winnerCheck1 = testPlayer1.isWinner();
        boolean winnerCheck2 = testPlayer2.isWinner();
        boolean winnerCheck3 = testPlayer3.isWinner();
        System.out.printf("winners %s %s %s", winnerCheck1, winnerCheck2, winnerCheck3);
    }

    @Test
    void test_playGame_winner() {
    }
}