package edu.lewisu.cs.group3;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;

/**
 * The Graphical View model of the board game that contains
 * the screen object of the TicTacToe board, the label displaying
 * the player's turn, and the text labels of the squares of the board.
 * 
 * @author Kyle Bye
 * @see BoardGame
 * @see ScreenObject
 * @see SquareLabel
 * @see Label
 */
public class BoardGameView implements Drawable {

    private ScreenObject boardScreenObject;
    private Label turnLabel;
    private SquareLabel[] squareLabels;
    
    /**
     * Returns the Screen Object of the game board.
     * @return game board screen object
     */
    public ScreenObject getBoardScreenObject() { return boardScreenObject; }
    
    /**
     * Returns the label responsible for displaying
     * the player's turn.
     * @return 
     */
    public Label getTurnLabel() { return turnLabel; }
    
    /**
     * Returns an array of SquareLabels
     * @return square labels
     */
    public SquareLabel[] getSquareLabels() { return squareLabels; }
    
    /**
     * Sets the board screen object to the provided object.
     * @param boardScreenObject board graphical screen object
     */
    public final void setBoardScreenObject(ScreenObject boardScreenObject) {
        this.boardScreenObject = boardScreenObject;
    }
    
    /**
     * Sets turn label to the provided turn label.
     * @param turnLabel turn label
     */
    public final void setTurnLabel(Label turnLabel) {
        this.turnLabel = turnLabel;
    }
   /**
    * Sets the array of square labels to the provided squareLabels.
    * @param squareLabels square labels
    */
    public final void setSquareLabels(SquareLabel[] squareLabels) {
        this.squareLabels = squareLabels;
    }
    
    /**
     * Constructs and places all the screen objects and labels
     * for the board model for TicTacToe.
     * 
     * @param boardScreenObject Board Screen Object
     * @param turnLabel Label displaying player's turn
     * @param squareLabels Label containing the square on the board
     */
    public BoardGameView(ScreenObject boardScreenObject, Label turnLabel, 
            SquareLabel[] squareLabels) {
        setBoardScreenObject(boardScreenObject);
        setTurnLabel(turnLabel);
        setSquareLabels(squareLabels);
        placeLabels();
    }
    
    /**
     * Returns the row and column values of what square the mouse is 
     * hovered over into an IntPair container. If either value is 0, 
     * then the mouse is not over any square.
     * 
     * @param mouseHandler Mouse handler that contains mouse coords.
     * @return Row/Col values of the hovered square instance.
     */
    public IntPair checkMousePositionOnBoard(MouseInputHandler mouseHandler) {
        int col = checkMousePositionX(mouseHandler.mouseWorldX());
        int row = checkMousePositionY(mouseHandler.mouseWorldY());
        return new IntPair(row, col);
    }
    
    /**
     * Updates all the square labels to display what Player is
     * occupying them. Updates the turn label too based on who's
     * turn it is. 
     * 
     * If the passed Player is NULL, then it is no
     * one's turn. Meaning that turnLabel is set invisible.
     * @param playingPlayer The player who in turn
     */
    public void update(Player playingPlayer) {
        for (SquareLabel sq : squareLabels) sq.update();
        if (playingPlayer == null) turnLabel.setVisible(false);
        else {
            turnLabel.setVisible(true);
            turnLabel.setText(String.format("%s's turn", playingPlayer.getPlayerType()));
        }
    }
    
    /**
     * Draws the game board, each square label, and the player's
     * turn label onto the screen. If the game is not active, then
     * turn label does not get drawn.
     * 
     * @param batch batch to draw on
     * @param parentAlpha opacity
     */
    @Override
    public void draw(Batch batch, float parentAlpha) {
        boardScreenObject.draw(batch, parentAlpha);
        for (SquareLabel sLabel : squareLabels) {
            sLabel.draw(batch, parentAlpha);
        }
        if (turnLabel.isVisible()) {
            turnLabel.draw(batch, parentAlpha);
        }
    }
    
    /**
     * Places each square label its designed position on the board
     * based on the row and col coordinate of each square
     * object.
     */
    private void placeLabels() {
        for (SquareLabel sLabel : squareLabels) {
            placeSquareLabel(sLabel);
        }
        placeTurnLabel();
    }
    
    /**
     * Places the turn label on top of the screen.
     */
    private void placeTurnLabel() {
        turnLabel.setPosition(640*0.5f, 450.f);
        turnLabel.setFontScale(1.5f);
        turnLabel.setAlignment(Align.center);
    }
    
    /**
     * Places provided label onto the board based on
     * row and col coordinate.
     * @param sLabel square label to place
     */
    private void placeSquareLabel(SquareLabel sLabel) {
        Square sq = sLabel.getSquare();
        sLabel.setFontScale(2);

        // Place each square label in its spot
        switch (sq.getRowCoordinate()) {
            case 1:
                if (sq.getColCoordinate() == 1) {
                    sLabel.setPosition(207f, 125.f);
                }
                if (sq.getColCoordinate() == 2) {
                    sLabel.setPosition(315.f, 125.f);
                }
                if (sq.getColCoordinate() == 3) {
                    sLabel.setPosition(422.5f, 125.f);
                }
                break;
            case 2:
                if (sq.getColCoordinate() == 1) {
                    sLabel.setPosition(207f, 237.5f);
                }
                if (sq.getColCoordinate() == 2) {
                   sLabel.setPosition(315.f, 237.5f);
                }
                if (sq.getColCoordinate() == 3) {
                    sLabel.setPosition(422.5f, 237.5f);
                }
                break;
            case 3:
                if (sq.getColCoordinate() == 1) {
                    sLabel.setPosition(207f, 355.f);
                }
                if (sq.getColCoordinate() == 2) {
                    sLabel.setPosition(315.f, 355.f);
                }
                if (sq.getColCoordinate() == 3) {
                    sLabel.setPosition(422.5f, 355.f);
                }
                break;
        
            default:
                break;
        }

        // Centers text
        float xOffset, yOffset;
        xOffset = sLabel.getWidth()*0.5f;
        yOffset = sLabel.getHeight()*0.5f;
        sLabel.moveBy(-xOffset, -yOffset);
        
    }
    
    /**
     * Compares the x coordinate to what column on
     * the board that the mouse's x is positioned on.
     * Parameter should be the mouse's x world coordinate
     * position. Returns 0 if the x coordinate is not
     * in the range of the board.
     * 
     * @param x x world coordinate
     * @return col number associated with x position
     */
    private int checkMousePositionX(float x) {
        int col = 0;

        if (x >= 155 && x<= 260) col = 1;
        else if (x>= 270 && x<=370) col = 2;
        else if (x>= 380 && x<= 485) col = 3;

        return col;
    }
    
    /**
     * Compares the y coordinate to what row on
     * the board that the mouse's y is positioned on.
     * Parameter should be the mouse's y world coordinate
     * position. Returns 0 if the y coordinate is not
     * in the range of the board.
     * 
     * @param y y world coordinate
     * @return row number associated with y position
     */
    private int checkMousePositionY(float y) {
        int row = 0;

        if (y >= 75 && y<= 170) row = 1;
        else if (y>= 185 && y<=290) row = 2;
        else if (y>= 305 && y<= 405) row = 3;

        return row;
    }

    
}
