package edu.lewisu.cs.group3;

public class Square {
    private final int rowNum, colNum;
    // Is Occuped By can either be X, O, or empty string
    private PlayerType isOccupiedBy;

    public Square(int rowNum, int colNum) {
        this.rowNum = rowNum;
        this.colNum = colNum;
        this.isOccupiedBy = PlayerType.NULL;
    }

    public int getRowCoordinate() {
        return rowNum;
    }

    public int getColCoordinate() {
        return colNum;
    }

    public PlayerType getIsOccupiedBy() {
        return isOccupiedBy;
    }

    public void setIsOccupiedBy(PlayerType playerType) {
        this.isOccupiedBy = playerType;
    }
}