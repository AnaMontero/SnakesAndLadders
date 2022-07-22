# Voxel Technical Interview - SnakesAndLadders Solution
## Backend project

### Technology Stack
* IntelliJ IDEA 2022.1.3 (Community Edition)
* Java 17
* Maven 3.8.6
* JUnit 5

### User stories
* US 1 - Token Can Move Across the Board
* US 2 - Player Can Win the Game
* US 3 - Moves Are Determined By Dice Rolls

### Project Description
* The project has been separated in different packages, so it's better structured. 
* The core logic to win a game is included in the [Game class](src/main/java/net/voxelgroup/application/Game.java)
* In the [Player class](src/main/java/net/voxelgroup/classes/Player.java), it can be found:
  * the player attributes
  * the method to move a player based on dice rolls
* The application includes test classes too, to support some functions of the game

### How to play the game
1. Run the [Main class](src/main/java/net/voxelgroup/Main.java)
2. The necessary info will be displayed in the console
3. Enter the total amount of players (minimum 2)
4. Choose between entering the players' names or skipping this option (PLAYER will be used for the name then)
5. Pres enter to start the game
6. Read along the console output the game progress until the winner player beats the others!