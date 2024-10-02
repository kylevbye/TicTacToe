package edu.lewisu.cs.group3;

public class Square {
    private final int rowNum, colNum;
    private boolean isOccupied;

    public Square(int rowNum, int colNum) {
        this.rowNum = rowNum;
        this.colNum = colNum;
        this.isOccupied = false;
    }

    public int getRowCoordinate() {
        return rowNum;
    }

    public int getColCoordinate() {
        return colNum;
    }

    public boolean getIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }
}