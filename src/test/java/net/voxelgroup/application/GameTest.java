package net.voxelgroup.application;

import net.voxelgroup.classes.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static net.voxelgroup.utilities.RandomCreator.generateRandomColor;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Player testPlayer;
    private final List<Player> testPlayerList = new ArrayList<>();
    private Game testGame;

    @BeforeEach
    void setUp() {
        testPlayer = new Player("Test Player", generateRandomColor());
        testGame = new Game();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test_setMinimumPlayers_ok() {
        assertEquals(2, testGame.setMinimumPlayers(1));
    }

    @Test
    void test_create5Player_ok() {
        for (int i = 1; i <= 5; i++) {
            testPlayerList.add(testGame.createPlayer("Jane" + i));
        }
        assertEquals(5, testPlayerList.size());
    }

    @Test
    void test_moveToken_rollingOnce_ok() {
        testGame.moveToken(3, testPlayer);
        assertEquals(4, testPlayer.getPosition());
    }

    @Test
    void test_moveToken_rollingTwice_ok() {
        testGame.moveToken(3, testPlayer);
        testGame.moveToken(4, testPlayer);
        assertEquals(8, testPlayer.getPosition());
    }

    @Test
    void test_moveToken_nok() {
        testGame.moveToken(1, testPlayer);
        assertNotEquals(9, testPlayer.getPosition());
    }

    @Test
    void test_winnerCondition_ok() {
        assertTrue(testGame.winnerCondition(testPlayer, 100));
    }

    @Test
    void test_winnerCondition_nok() {
        assertFalse(testGame.winnerCondition(testPlayer, 97));
    }
}