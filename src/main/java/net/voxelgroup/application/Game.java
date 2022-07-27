package net.voxelgroup.application;

import net.voxelgroup.classes.Player;

import static net.voxelgroup.utilities.RandomCreator.*;

public class Game {
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
        currentPlayer.setPosition(newPosition);
        return newPosition;
    }

    public boolean winnerCondition(Player currentPlayer){
        if(currentPlayer.getPosition() == 100) currentPlayer.setWinner(true);
        return currentPlayer.isWinner();
    }
}