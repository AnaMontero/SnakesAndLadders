package net.voxelgroup.application;

import net.voxelgroup.classes.Player;
import net.voxelgroup.utilities.RandomCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static net.voxelgroup.utilities.RandomCreator.rollDice;

public class Dashboard {
    private final int MAX_TILE = 100;
    private final Game game = new Game();
    private final Scanner scanner = new Scanner(System.in);
    private int numberOfPlayers;
    private String playerName;
    List<Player> playerList = new ArrayList<>();

    public void start() {
        createBoard();
        this.pressEnter();
        System.out.print("How many players? (minimum 2): ");
        numberOfPlayers = scanner.nextInt();
        this.selectPlayerName();
        this.playTurn();
        pressEnter();
    }

    private void selectPlayerName() {
        System.out.println("Select 1 to choose name or 2 to skip name selection");
        int selection = this.scanner.nextInt();
        for (int i = 1; i <= numberOfPlayers; i++) {

            switch (selection) {
                case 1 -> {
                    System.out.print("Enter player " + i + " name: ");
                    playerName = this.scanner.next();
                }
                case 2 -> playerName = "player" + i;
                default -> throw new IllegalStateException("Unexpected value: " + selection);
            }
            playerList.add(game.createPlayer(playerName));
        }
    }

    private Player selectFirstPlayer(){
        var firstPlayer = playerList.get(RandomCreator.randomFirstPlayer(game.selectPlayers(numberOfPlayers)));
        System.out.printf("%s starts!!\n", firstPlayer.getName());
        return firstPlayer;
    }

    private void createBoard() {
        System.out.println("Game has started!");
        int counter = 100;
        int iteration = -1;
        System.out.println("---------------Game Board---------------");

        while (counter > 0) {
            if (counter % 10 == 0 && counter != MAX_TILE) {
                if (iteration == -1) {
                    counter -= 9;
                    iteration = 1;
                } else {
                    System.out.print(counter + "\t");
                    counter -= 10;
                    iteration = -1;
                }
                if (counter != 0)
                    System.out.print("\n" + counter + "\t");
            } else
                System.out.print(counter + "\t");
            counter += iteration;
        }
        System.out.println();
        System.out.println("----------------------------------------");
    }

    private void playTurn(){
        Player currentPlayer = this.selectFirstPlayer();
        while(!currentPlayer.isWinner()) {
            int turn = 1;
            System.out.printf("Turn #%s: \n", turn);
            game.winnerCondition(currentPlayer);
            int diceNumber = rollDice();
            int playerPosition = currentPlayer.getPosition();
            int newPosition = game.moveToken(diceNumber, currentPlayer);
            System.out.printf("%s rolls %d and moves from tile %d to tile %d\n", currentPlayer.getName(), diceNumber, playerPosition, newPosition);
        }
//        turn++;
//        int nextPlayer = playerList.indexOf(currentPlayer) + 1;
//        playerList.get(nextPlayer);
//        do {
//
//            for (Player player : this.playerList) {
//                int diceNumber = rollDice();
//                int playerPosition = player.getPosition();
//                System.out.printf("%s in tile %s rolls %s\n", player.getName(), playerPosition, diceNumber);
//                int newPosition = playerPosition + diceNumber;
//                if (newPosition == 100) {
//                    System.out.printf("%s is the WINNER!!\n", player.getName());
//                    player.setWinner(true);
//                    exit = true;
//                    break;
//                } else if (newPosition > 100) {
//                    System.out.println("Can't move further than 100. Roll again! ");
//                } else {
//                    player.moveToken(diceNumber);
//                    System.out.printf("Moving to tile %s\n", newPosition);
//                }
//            }
//            System.out.println("----------------");
//            turn++;
//        }
//        while (game.winnerPlayer(player));
    }

    private void pressEnter() {
        System.out.println("Press ENTER to continue");
        try {
            System.in.read();
        } catch (Exception e) {
            System.out.println("Incorrect selection");
        }
    }
}

