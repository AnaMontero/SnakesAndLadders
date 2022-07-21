package net.voxelgroup.utilities;

import net.voxelgroup.classes.Player;

import static net.voxelgroup.utilities.RandomCreator.generateRandomColor;

public final class PlayerCreator {

    public static Player createPlayer(String playerName) {
        return new Player(playerName, generateRandomColor());
    }
}
