package edu.lewisu.cs.group3;

public class Player {
    // Type is either X or O
    private final PlayerType type;
    private int score;

    public Player(PlayerType type) {
        this.type = type;
        this.score = 0;
    }

    public PlayerType getPlayerType() {
        return type;
    }

    public int getPlayerScore() {
        return score;
    }

    public void addPlayerScore() {
        this.score++;
    }

    public void makeMove(Square square) {
        PlayerType squareOccupiedBy = square.getIsOccupiedBy();
        if (squareOccupiedBy != PlayerType.NULL) {
            square.setIsOccupiedBy(type);
        } else {
            System.out.println("Cannot place in this square!");
        }
    }
}