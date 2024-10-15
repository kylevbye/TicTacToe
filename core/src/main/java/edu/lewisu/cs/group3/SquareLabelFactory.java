/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.lewisu.cs.group3;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 * Label Factory designed for SquareLabels
 * 
 * Use's <code>LabelFactory</code>'s font,
 * which is DeterminationMono.
 * 
 * @author Kyle Bye
 * @see LabelFactory
 */
public class SquareLabelFactory extends LabelFactory {
    
    /**
     * Creates a square label instance containing the information
     * of the square to represent.
     * 
     * Uses Determination Mono as the font from
     * <code>LabelFactory</code>
     * 
     * If the font is not loaded, then it will be loaded
     * using <code>loadUTFont()</code>.
     * 
     * @param square square to represent
     * @return square label instance 
     * @see loadUTFont()
     */
    public SquareLabel createSquareLabel(Square square) {
        SquareLabel squareLabel = null;

        if (utFont == null) loadUTFont();
        squareLabel = new SquareLabel(square, new Label.LabelStyle(utFont, Color.WHITE));
        return squareLabel;

    }
    
}
