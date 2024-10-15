package edu.lewisu.cs.group3;

/**
 * Represents a player that is either X or O.
 * Holds their own score value.
 * 
 * @author Kevin Nguyen
 * @see PlayerType
 */
public class Player {
    
    // Type is either X or O
    private final PlayerType type;
    private int score;
    
    /**
     * Initializes this instance with its type
     * and sets its score to 0.
     * @param type X or 0
     * @see PlayerType
     */
    public Player(PlayerType type) {
        this.type = type;
        this.score = 0;
    }
    
    /**
     * Returns what this player represents.
     * Is either X or O.
     * @return 
     */
    public PlayerType getPlayerType() {
        return type;
    }
    
    /**
     * Returns this player's score
     * @return score value
     */
    public int getPlayerScore() {
        return score;
    }
    
    /**
     * Increments the score by 1.
     */
    public void addPlayerScore() {
        this.score++;
    }

    /**
     * Places X or O in the desired square
     * 
     * @param square The square that the player wishes to occupy
     */
    public void makeMove(Square square) {
        PlayerType squareOccupiedBy = square.getIsOccupiedBy();
        if (squareOccupiedBy != PlayerType.NULL) {
            square.setIsOccupiedBy(type);
        } else {
            System.out.println("Cannot place in this square!");
        }
    }
}