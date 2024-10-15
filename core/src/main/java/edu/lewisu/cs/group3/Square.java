package edu.lewisu.cs.group3;

/**
 * Represents a square that exists on a game board
 * of TicTacToe. Can contain NULL, X or O.
 *
 * @author Kevin Nguyen
 * @see PlayerType
 */
public class Square {
    
    private final int rowNum, colNum;
    private PlayerType isOccupiedBy;
    
    /**
     * Initializes this instance as an empty
     * square with no occupant. Row and col are
     * set based on parameters.
     * 
     * @param rowNum row coordinate
     * @param colNum column coordinate
     */
    public Square(int rowNum, int colNum) {
        this.rowNum = rowNum;
        this.colNum = colNum;
        this.isOccupiedBy = PlayerType.NULL;
    }
    
    /**
     * Returns the row value of this square instance.
     * @return row coordinate
     */
    public int getRowCoordinate() {
        return rowNum;
    }
    
    /**
     * Returns the column value of this square instance.
     * @return column coordinate
     */
    public int getColCoordinate() {
        return colNum;
    }
    
    /**
     * Returns who is occupying this square instance.
     * If unoccupied, then it would be null.
     * 
     * @return player type that is occupying this instance
     * @see PlayerType
     */
    public PlayerType getIsOccupiedBy() {
        return isOccupiedBy;
    }
    
    /**
     * Sets the player who is going to occupy this instance.
     * If NULL is passed, then no one is occupying this instance.
     * @param playerType 
     * @see PlayerType
     */
    public void setIsOccupiedBy(PlayerType playerType) {
        this.isOccupiedBy = playerType;
    }
}