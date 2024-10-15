package edu.lewisu.cs.group3;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;

/**
 * Factory pattern that creates screen object.
 * 
 * Has a method specifically designed to create
 * the game board screen object for TicTacToe.
 * Holds texture used for the game board. Texture
 * must be manually disposed.
 * 
 * @author Kyle Bye
 * @see ScreenObject
 * @see Texture
 */
public class ScreenObjectFactory {

    private static Texture gameBoardTexture;
    
    /**
     * Creates a screen object using the image at the
     * provided file path. Default file path is under
     * the assets folder. Dimension uses the default
     * constructor.
     * 
     * @param filePath image to use as a texture
     * @return screen object
     */
    public ScreenObject createScreenObject(String filePath) {
        ScreenObject returnObject = null;
        Texture texture = new Texture(filePath);
        returnObject = new ScreenObject(texture);
        return returnObject;
    }
    
    /**
     * Creates a game board screen object using the image under
     * "assets/TicTacToeBoard.png"
     * 
     * @return game board screen object
     */
    public ScreenObject createBoardGameObject() {
        ScreenObject returnObject = null;

        if (gameBoardTexture == null) loadGameBoardTexture();
        Dimension dim = new Dimension(640*0.5f, 480*0.5f, 0, 0, 1.1f, 1.1f, gameBoardTexture.getWidth(), gameBoardTexture.getHeight(), 0);
        returnObject = new ScreenObject(gameBoardTexture, dim);
        returnObject.setCentered(true);
        returnObject.setColor(Color.WHITE);

        return returnObject;
    }
    
    /**
     * Releases game board texture
     */
    public static void disposeTextures() {
        if (gameBoardTexture != null) {
            gameBoardTexture.dispose();
            gameBoardTexture = null;
        }
    }
    
    /**
     * Loads texture located at
     * "assets/TicTacToeBoard.png"
     */
    private void loadGameBoardTexture() {
        Texture texture = new Texture("TicTacToeBoard.png");
        gameBoardTexture = texture;
    }
    

}
