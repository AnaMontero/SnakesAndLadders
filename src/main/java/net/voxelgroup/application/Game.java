package net.voxelgroup.application;

import net.voxelgroup.classes.Player;

import static net.voxelgroup.utilities.RandomCreator.*;

public class Game {

    public int setMinimumPlayers(int numberOfPlayers) {
        if (numberOfPlayers < 2) numberOfPlayers = 2;
        return numberOfPlayers;
    }

    public Player createPlayer(String playerName) {
        return new Player(playerName, generateRandomColor());
    }

    public int moveToken(int number, Player currentPlayer) {
        int currentPosition = currentPlayer.getPosition();
        int newPosition = currentPosition + number;
        winnerCondition(currentPlayer, newPosition);
        return currentPlayer.getPosition();
    }

    public boolean winnerCondition(Player currentPlayer, int newPosition) {
        int MAX_TILE = 100;
        if (newPosition == MAX_TILE) {
            currentPlayer.setPosition(newPosition);
            currentPlayer.setWinner(true);
        } else if (newPosition > MAX_TILE) {
            currentPlayer.setWinner(false);
        } else {
            currentPlayer.setWinner(false);
            currentPlayer.setPosition(newPosition);
        }
        return currentPlayer.isWinner();
    }
}