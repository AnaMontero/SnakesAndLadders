package net.voxelgroup.application;

import net.voxelgroup.classes.Player;
import java.util.ArrayList;
import java.util.Scanner;
import static net.voxelgroup.utilities.PlayerCreator.createPlayer;
import static net.voxelgroup.utilities.RandomCreator.*;

public class Game {
    private final Scanner scanner = new Scanner(System.in);
    private ArrayList<Player> playerList;
    private int numberOfPlayers;

    public Game() {
    }

    public void start() {
        System.out.println("Game has started!");
        this.selectPlayers();
        this.pressEnter();
        this.playGame();
    }

    private void pressEnter() {
        System.out.println("Press ENTER to start the game");
        try {
            System.in.read();
        } catch (Exception e) {
            System.out.println("Incorrect selection");
        }
    }

    private void selectPlayers() {
        playerList = new ArrayList<>();
        System.out.print("How many players? (minimum 2): ");
        numberOfPlayers = scanner.nextInt();
        if (numberOfPlayers < 2) numberOfPlayers = 2;
        this.choosePlayersName();
    }

    public void choosePlayersName() {
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
            Player player = createPlayer(playerName);
            System.out.printf("Created %s, using color %s. \n", player.getName(), player.getTokenColor());
            playerList.add(player);
        }
    }

    public void playGame() {
        int turn = 1;
        boolean exit = false;
        do {
            System.out.printf("Turn #%s: \n", turn);
            for (Player player : this.playerList) {
                int diceNumber = rollDice();
                int playerPosition = player.getPosition();
                System.out.printf("%s in tile %s rolls %s\n", player.getName(), playerPosition, diceNumber);
                int newPosition = playerPosition + diceNumber;
                if (newPosition == 100) {
                    System.out.printf("%s is the WINNER!!\n", player.getName());
                    player.setWinner(true);
                    exit = true;
                    break;
                } else if (newPosition > 100) {
                    System.out.println("Can't move further than 100. Roll again! ");
                } else {
                    player.moveToken(diceNumber);
                    System.out.printf("Moving to tile %s\n", newPosition);
                }
            }
            System.out.println("----------------");
            turn++;
        }
        while (!exit);
    }
}