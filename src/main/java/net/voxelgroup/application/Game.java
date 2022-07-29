package net.voxelgroup.application;

import net.voxelgroup.classes.Player;

import static net.voxelgroup.utilities.RandomCreator.*;

public class Game {
    private final int MAX_TILE = 100;

    public int selectPlayers(int numberOfPlayers) {
        if (numberOfPlayers < 2) numberOfPlayers = 2;
        return numberOfPlayers;
    }

    public Player createPlayer(String playerName) {
        return new Player(playerName, generateRandomColor());
    }

    public int moveToken(int number, Player currentPlayer) {
        int currentPosition = currentPlayer.getPosition();
        int newPosition = currentPosition + number;
        if (newPosition == 100) {
            currentPlayer.setWinner(true);
            return newPosition;
        } else if (newPosition > MAX_TILE) {
            currentPlayer.setPosition(currentPosition);
            return currentPosition;
        } else {
            currentPlayer.setPosition(newPosition);
            return newPosition;
        }
    }

    public boolean winnerCondition(Player currentPlayer) {
        if (currentPlayer.getPosition() == MAX_TILE) currentPlayer.setWinner(true);
        return currentPlayer.isWinner();
    }
}