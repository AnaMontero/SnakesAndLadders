package net.voxelgroup.application;

import net.voxelgroup.classes.Player;
import net.voxelgroup.utilities.RandomCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static net.voxelgroup.utilities.RandomCreator.randomFirstPlayer;
import static net.voxelgroup.utilities.RandomCreator.rollDice;

public class Dashboard {
    private final Game game = new Game();
    private final Scanner scanner = new Scanner(System.in);
    private int numberOfPlayers;
    List<Player> playerList = new ArrayList<>();

    public void start() {
        createBoard();
        this.pressEnter();
        System.out.print("How many players? (minimum 2): ");
        numberOfPlayers = scanner.nextInt();
        numberOfPlayers = game.selectPlayers(numberOfPlayers);
        this.selectPlayerName();
        this.playTurns();
        pressEnter();
    }

    private void selectPlayerName() {
        System.out.println("Select 1 to choose name or 2 to skip name selection");
        int selection = this.scanner.nextInt();
        for (int i = 1; i <= numberOfPlayers; i++) {

            String playerName;
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

    private void selectFirstPlayer() {
        var firstPlayer = playerList.get(randomFirstPlayer(numberOfPlayers));
        playerList.remove(firstPlayer);
        playerList.add(0, firstPlayer);
        System.out.printf("%s starts!!\n", firstPlayer.getName());
    }

    private void playTurns() {
        selectFirstPlayer();
        boolean exit = false;

        int turn = 1;
        while (!exit) {
            System.out.printf("Turn #%s: \n", turn);
            System.out.println("-------------------");
            for (Player player : playerList) {
                int diceNumber = rollDice();
                int playerPosition = player.getPosition();
                int newPosition = game.moveToken(diceNumber, player);
                System.out.printf("%s rolls %d and moves from tile %d to tile %d\n", player.getName(), diceNumber, playerPosition, newPosition);
                exit = game.winnerCondition(player);
                if (game.winnerCondition(player)) {
                    exit = true;
                }
            }
            turn++;
            System.out.println("-------------------");
        }
    }

    private void createBoard() {
        System.out.println("Game has started!");
        int counter = 100;
        int iteration = -1;
        System.out.println("---------------Game Board---------------");

        while (counter > 0) {
            int MAX_TILE = 100;
            if (counter % 10 == 0 && counter != MAX_TILE) {
                if (iteration == -1) {
                    counter -= 9;
                    iteration = 1;
                } else {
                    System.out.print(counter + "\t");
                    counter -= 10;
                    iteration = -1;
                }
                if (counter != 0) System.out.print("\n" + counter + "\t");
            } else System.out.print(counter + "\t");
            counter += iteration;
        }
        System.out.println();
        System.out.println("----------------------------------------");
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

