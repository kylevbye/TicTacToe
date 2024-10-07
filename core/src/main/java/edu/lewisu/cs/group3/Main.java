package edu.lewisu.cs.group3;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {

    private SpriteBatch batch;
    private ScreenObject image;
    private Viewport viewport;
    private Camera camera;

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera(640, 480);
        viewport = new FitViewport(640, 480, camera);
        image = new ScreenObject(new Texture("TicTacToeBoard.png"), 640*0.5f, 480*0.5f, 0, 0, 1.35f, 1.35f, 0);
        image.setCentered(true);
    }

    @Override
    public void render() {
        input();
        logic();
        draw();
    }

    private void input() {
        // WIP

        // Do Process handling stuff here
    }

    private void logic() {
        // WIP

        // Process game logic... something something...
        // here
    }

    private void draw() {
        // Gonna refactor this out next week
        ScreenUtils.clear(Color.BLACK);
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        image.draw(batch, 1.0f);
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
