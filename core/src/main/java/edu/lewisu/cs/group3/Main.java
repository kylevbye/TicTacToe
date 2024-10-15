package edu.lewisu.cs.group3;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Cursor.SystemCursor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Runs Tic-Tac-Toe Game
 * 
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all
 * platforms.
 * @author Kyle Bye
 * @author Kevin Nguyen
 * @author Giridhar Kumar Jogi
 */
public class Main extends ApplicationAdapter {

    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;

    private SpriteBatch batch;
    private Viewport viewport;
    private Camera camera;
    private MouseInputHandler mouseHandler;
    
    // Models
    private GameState gameState;
    private BoardGame boardGame;
    
    // Views
    private BoardGameView boardGameView;
    private ScoreBoardView scoreBoardView;
    
    /**
     * Initializes the game models, game views, and LibGDX
     * attributes needed to run Tic-Tac-Toe
     */
    @Override
    public void create() {
        
        // Initialize LibGDX Standard parameters
        Gdx.graphics.setWindowedMode(WIDTH, HEIGHT);
        batch = new SpriteBatch();
        camera = new OrthographicCamera(WIDTH, HEIGHT);
        viewport = new FitViewport(WIDTH, HEIGHT, camera);
        mouseHandler = new MouseInputHandler(camera);
        Gdx.input.setInputProcessor(mouseHandler);
        
        // Create Models
        boardGame = new BoardGame();
        gameState = new GameState(boardGame);
        gameState.startGame();

        // Setup Factories
        ScreenObjectFactory sFactory = new ScreenObjectFactory(); 
        SquareLabelFactory slFactory = new SquareLabelFactory();
        LabelFactory lFactory = new LabelFactory();
        
        // Create BoardGameView
        Square[] squares = boardGame.getSquares();
        Label turnLabel = lFactory.createLabel("_'s Turn!");
        ScreenObject bgScreenObject = sFactory.createBoardGameObject();
        SquareLabel[] squareLabels = new SquareLabel[squares.length];
        for (int i = 0; i<squares.length; ++i) {
            squareLabels[i] = slFactory.createSquareLabel(squares[i]);
        }
        boardGameView = new BoardGameView(bgScreenObject, turnLabel, squareLabels);
        
        // Create ScoreBoardView
        scoreBoardView = new ScoreBoardView(
                lFactory.createLabel("X: 0"), lFactory.createLabel("X: 0"),
                lFactory.createLabel("_ won!"), boardGame.getPlayers()
        );
    }

    /**
     * This function represents the game loop. Input is
     * handled by LibGDX before this function is called.
     */
    @Override
    public void render() {
        logic();
        draw();
    }

    /**
     * Process the game. This means managing turns,
     * x/o positions, and win tracking.
     */
    private void logic() {
        // WIP
        Gdx.graphics.setSystemCursor(SystemCursor.Arrow);
        
        // Get Row & Col based on Mouse Position
        // 0 on either means that no square is being hovered
        IntPair squareCoords = boardGameView.checkMousePositionOnBoard(mouseHandler);
        gameState.update(squareCoords, mouseHandler.leftClicked());
        scoreBoardView.getWonLabel().setVisible(false);
        if (!gameState.isActive() ) {
            scoreBoardView.setWinText(gameState.getWinner());
            scoreBoardView.getWonLabel().setVisible(true);
        }
        scoreBoardView.update();
        boardGameView.update(gameState.getTurn());
        mouseHandler.resetClickedState();
    }

    /**
     * Presents the game state to the screen
     * by drawing all the assets to the screen.
     */
    private void draw() {
        ScreenUtils.clear(Color.BLACK);
        viewport.getCamera().update();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        
        // Fade out game board if
        // there is no active game
        float boardOpacity = 1.0f;
        if (!gameState.isActive()) {
            boardOpacity = 0.1f;
        }
        boardGameView.draw(batch, boardOpacity);
        
        scoreBoardView.draw(batch, 1.0f);
        batch.end();
    }
    
    /**
     * Called when closing application. Releases textures
     * held in factory classes.
     */
    @Override
    public void dispose() {
        batch.dispose();
        ScreenObjectFactory.disposeTextures();
        LabelFactory.disposeFonts();
    }
    
    /**
     * Ensures the game scales properly during
     * resizing operation.
     * @param width width to scale to
     * @param height height to scale to
     */
    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

}
