package edu.lewisu.cs.group3;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 * Label that displays the data of the contained square
 * 
 * @author Kyle Bye
 * @see Square
 * @see BoardGame
 */
public class SquareLabel extends Label {

    private Square square;
    
    /**
     * Returns the square the label is represented
     * @return square
     */
    public Square getSquare() { return square; }
    
    /**
     * Updates text to display what player is
     * occupying the square
     */
    public void update() {
        updateText();
    }
    
    /**
     * Draws label to the provided batch.
     * @param batch batch to draw on
     * @param parentAlpha opacity
     */
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch,parentAlpha);
    }
    
    /**
     * Returns the string representation of the label
     * @return label attributes in string form
     */
    public String toString() {
        String returnStr;

        returnStr = String.format("SquareLabel:[X:%.2f; Y:%.2f; W:%.2f H:%.2f; SX:%.2f; SY:%.2f; SFX: %.2f; SFY: %.2f]", getX(), getY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getFontScaleX(), getFontScaleY());

        return returnStr;
    }
    
    /**
     * Constructs the square label based on the data provided by
     * the square and uses the label style provided.
     * @param square square to represent
     * @param labelStyle label style to follow
     */
    public SquareLabel(Square square, LabelStyle labelStyle) {
        super(" ", labelStyle);
        this.square = square;
        updateText();
    }
    
    /**
     * Changes text based on who's occupying the square.
     */
    private void updateText() {
        switch (square.getIsOccupiedBy()) {
            case X:
                setText("X");
                break;
            case O:
                setText("O");
                break;
            default:
                setText(" ");
                break;
        }
    }
    
}
