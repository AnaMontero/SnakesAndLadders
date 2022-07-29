package net.voxelgroup.classes;

public class Player {
    private int position;
    private final String name;
    private final String tokenColor;
    private boolean winner;

    public Player(String name, String tokenColor) {
        this.position = 1;
        this.name = name.toUpperCase();
        this.tokenColor = tokenColor;
        this.winner = false;
    }

    public String getName() {
        return name.toUpperCase();
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

}
