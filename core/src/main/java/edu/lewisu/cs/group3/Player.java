package edu.lewisu.cs.group3;

public class Player {
    // Type is either X or O
    private final String type;
    private int score;

    public Player(String type) {
        this.type = type;
        this.score = 0;
    }

    public String getPlayerType() {
        return type;
    }

    public int getPlayerScore() {
        return score;
    }

    public void addPlayerScore() {
        this.score++;
    }

    public void makeMove(Square square) {
        if (square.getIsOccupied()) {
            System.out.println("Cannot place in this square!");
        } else {
            square.setIsOccupied(true);
        }
    }
}