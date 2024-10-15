package edu.lewisu.cs.group3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

/**
 * Responsible for creating Labels. Holds
 * the bitmap font instance to create Labels
 * from.
 * 
 * Determination Mono is the font used.
 * 
 * @author Kyle Bye
 * @see Bitmap
 * @see Label
 */
public class LabelFactory {

    protected static BitmapFont utFont;
    
    /**
     * Creates a label instance containing the text
     * provided.
     * 
     * Uses Determination Mono as the font.
     * If the font is not loaded, then it will be loaded
     * using <code>loadUTFont()</code>.
     * 
     * @param text text the label should display
     * @return label instance 
     * @see loadUTFont()
     */
    public Label createLabel(String text) {
        Label returnLabel = null;
        if (utFont == null) loadUTFont();

        returnLabel = new Label("", new LabelStyle(utFont, Color.WHITE));

        return returnLabel;
    }
    
    /**
     * Loads the bitmap font used for creating Labels.
     * Loads it from a file under "assets/undertale.fnt".
     */
    protected static void loadUTFont() {
        utFont = new BitmapFont(Gdx.files.internal("undertale.fnt"));
    }

    /**
     * If the bitmap font resource is available, this will
     * destroy it and set it to null.
     */
    public static void disposeFonts() {
        if (utFont != null) {
            utFont.dispose();
            utFont = null;
        }
    }
    
}
