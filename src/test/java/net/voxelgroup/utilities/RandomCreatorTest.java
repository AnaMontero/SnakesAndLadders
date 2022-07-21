package net.voxelgroup.utilities;

import net.voxelgroup.classes.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static net.voxelgroup.utilities.RandomCreator.generateRandomColor;
import static net.voxelgroup.utilities.RandomCreator.rollDice;
import static org.junit.jupiter.api.Assertions.*;

class RandomCreatorTest {
    private Player testPlayer;

    @BeforeEach
    void setUp() {
        testPlayer = new Player("Test Player", "non existing color");
    }

    @Test
    void test_rollDice_ok() {
        ArrayList<Integer> rollingList = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            rollingList.add(rollDice());
        }
        boolean diceCheck = rollingList.contains(5);
        assertTrue(diceCheck);
    }

    @Test
    void test_rollDice_nok() {
        ArrayList<Integer> rollingList = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            rollingList.add(rollDice());
        }
        boolean diceCheck = rollingList.contains(7);
        assertFalse(diceCheck);
    }

    @Test
    void test_generateRandomColor_ok() {
        ArrayList<String> colorList = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            colorList.add(generateRandomColor());
        }
        boolean colorCheck = colorList.contains("green");
        assertTrue(colorCheck);
    }

    @Test
    void test_generateRandomColor_nok() {
        ArrayList<String> colorList = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            colorList.add(generateRandomColor());
        }
        boolean colorCheck = colorList.contains(testPlayer.getTokenColor());
        assertFalse(colorCheck);
    }
}