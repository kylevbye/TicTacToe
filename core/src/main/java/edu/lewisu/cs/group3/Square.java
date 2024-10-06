package edu.lewisu.cs.group3;

public class Square {
    private final int rowNum, colNum;
    // Is Occuped By can either be X, O, or empty string
    private String isOccupiedBy;

    public Square(int rowNum, int colNum) {
        this.rowNum = rowNum;
        this.colNum = colNum;
        this.isOccupiedBy = "";
    }

    public int getRowCoordinate() {
        return rowNum;
    }

    public int getColCoordinate() {
        return colNum;
    }

    public String getIsOccupiedBy() {
        return isOccupiedBy;
    }

    public void setIsOccupiedBy(String xo) {
        this.isOccupiedBy = xo;
    }
}