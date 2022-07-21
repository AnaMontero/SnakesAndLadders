package net.voxelgroup.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static net.voxelgroup.utilities.RandomCreator.generateRandomColor;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player testPlayer;

    @BeforeEach
    void setUp() {
        testPlayer = new Player("Test Player", generateRandomColor());
    }

    @Test
    void test_moveToken_rollingOnce_ok() {
        testPlayer.moveToken(3);
        assertEquals(4, testPlayer.getPosition());
    }

    @Test
    void test_moveToken_rollingTwice_ok() {
        testPlayer.moveToken(3);
        testPlayer.moveToken(4);
        assertEquals(8, testPlayer.getPosition());
    }

    @Test
    void test_moveToken_nok() {
        testPlayer.moveToken(3);
        assertNotEquals(9, testPlayer.getPosition());
    }
}