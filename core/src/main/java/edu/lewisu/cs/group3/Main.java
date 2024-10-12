package edu.lewisu.cs.group3;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all
 * platforms.
 */
public class Main extends ApplicationAdapter {

    private final int WIDTH = 640;
    private final int HEIGHT = 480;

    private SpriteBatch batch;
    private Viewport viewport;
    private Camera camera;
    private MouseInputHandler mouseHandler;

    // Refactor this later
    private Label xLabel, oLabel;
    private Label dMouseCoords, dMouseClickPos;
    private ScreenObject image;

    @Override
    public void create() {

        Gdx.graphics.setWindowedMode(WIDTH, HEIGHT);
        batch = new SpriteBatch();
        camera = new OrthographicCamera(WIDTH, HEIGHT);
        viewport = new FitViewport(WIDTH, HEIGHT, camera);
        mouseHandler = new MouseInputHandler();
        Gdx.input.setInputProcessor(mouseHandler);

        // Refactor Later
        image = new ScreenObject(new Texture("TicTacToeBoard.png"), 640 * 0.5f, 480 * 0.5f, 0, 0, 1.1f, 1.1f, 0);
        image.setCentered(true);
        xLabel = new Label("X: ", new LabelStyle(new BitmapFont(Gdx.files.internal("undertale.fnt")), Color.WHITE));
        xLabel.setPosition(30,420);
        oLabel = new Label("O: ", new LabelStyle(new BitmapFont(Gdx.files.internal("undertale.fnt")), Color.WHITE));
        oLabel.setPosition(30,380);

        // For Debug Purposes. Should delete/move later.
        dMouseCoords = new Label("MPos:()", new LabelStyle(new BitmapFont(Gdx.files.internal("undertale.fnt")), Color.WHITE));
        dMouseCoords.setPosition(30,10);
        dMouseClickPos = new Label("MLCPos:()", new LabelStyle(new BitmapFont(Gdx.files.internal("undertale.fnt")), Color.WHITE));
        dMouseClickPos.setPosition(30,40);
    }

    /**
     * This function represents the game loop. 
     */
    @Override
    public void render() {
        input(); // Might remove this
        logic();
        draw();
        mouseHandler.resetClickedState();
    }

    /**
     * Processes mouse input and updates the coordinates
     * of the mouse's x and y.
     * 
     * I might delete this later because the mouse events
     * are called before render() is even called. This kinda
     * defeats the purpose of this function :/
     */
    private void input() {
        // WIP
        dMouseCoords.setText(String.format("MPos:(%d, %d)", mouseHandler.getMouseX(), mouseHandler.getMouseY()));

        Vector2 leftMouse = mouseHandler.getLeftClickPosition();
        dMouseClickPos.setText(String.format("MCPos:(%.0f, %.0f)", leftMouse.x, leftMouse.y));
    }

    /**
     * Process the game. This means managing turns,
     * x/o positions, and win tracking.
     */
    private void logic() {
        // WIP
        BoardGame boardGame = new BoardGame();

    }

    /**
     * Presents the game state to the screen
     * by drawing all the assets to the screen.
     */
    private void draw() {
        // Gonna refactor this out next week
        ScreenUtils.clear(Color.BLACK);
        viewport.getCamera().update();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        image.draw(batch, 1.0f);
        xLabel.draw(batch, 1.0f);
        oLabel.draw(batch, 1.0f);
        dMouseCoords.draw(batch, 1.0f);
        dMouseClickPos.draw(batch, 1.0f);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

}
