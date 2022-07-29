package net.voxelgroup.utilities;

import net.voxelgroup.classes.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static net.voxelgroup.utilities.RandomCreator.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RandomCreatorTest {
    private Player testPlayer;

    @BeforeEach
    void setUp() {
        testPlayer = new Player("Test Player", "non existing color");
    }

    @Test
    void test_rollDice_ok() {
        List<Integer> range = new ArrayList<>();
        range.add(1);
        range.add(2);
        range.add(3);
        range.add(4);
        range.add(5);
        range.add(6);
        assertThat(rollDice()).isIn(range);
    }

    @Test
    void test_randomFirstPlayer_ok() {
        List<Integer> range = new ArrayList<>();
        range.add(0);
        range.add(1);
        range.add(2);
        assertThat(randomFirstPlayer(2)).isIn(range);
    }

}