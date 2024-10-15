package edu.lewisu.cs.group3;

import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * Responsible for observing and recording mouse
 * events and positions. Only currently observes
 * left clicks. Also, calculates world coordinates
 * of the mouse based on the camera display the world.
 * 
 * @author Kyle Bye
 * @see InputProcessor
 * @see Camera camera
 */
public class MouseInputHandler extends InputAdapter  {
    
    // Camera to calulate world coordinates
    private Camera camera;

    // Mouse Screen Coords
    private int mouseX, mouseY;
    
    // Mouse World Coords
    private float mouseWorldX, mouseWorldY;

    // Left Mouse Button (Mouse 1)
    private Vector2 leftClickLocation;
    private boolean leftDown;
    private boolean leftClicked;

    /**
     * Returns camera used for world coordinate
     * calculation.
     * @return camera used for world coordinate calculation
     */
    public Camera getCamera() { return camera; }
    
    /**
     * Returns the mouse's x screen coordinate 
     * @return mouse x screen coordinate
     */
    public int getMouseX() { return mouseX; }
    
    /**
     * Returns the mouse's y screen coordinate 
     * @return mouse y screen coordinate
     */
    public int getMouseY() { return mouseY; }
    
    /**
     * Returns the mouse's x world coordinate based
     * on the camera used.
     * @return mouse x world coordinate
     */
    public float mouseWorldX() { return mouseWorldX; }
    
    /**
     * Returns the mouse's y world coordinate based
     * on the camera used.
     * @return mouse y world coordinate
     */
    public float mouseWorldY() { return mouseWorldY; }
    
    /**
     * Returns true is the mouse is currently held left down
     * during this iteration of the game loop.
     * @return true/false if mouse is held down
     */
    public boolean leftDown() { return leftDown; }
    
    /**
     * Returns true is the mouse was left clicked at all
     * during this iteration of the game loop. 
     * @return true/false if mouse was clicked
     */
    public boolean leftClicked() { return leftClicked; }
    
    /**
     * Updates mouseX, mouseY and calculates mouseWorldX, mouseWorldY.
     * Returns true if handled properly.
     * 
     * @param screenX mouse screen coordinate x
     * @param screenY mouse screen coordinate y
     * @return whether handled properly
     */
    @Override
    public boolean mouseMoved (int screenX, int screenY) {
		
	super.mouseMoved(screenX, screenY);
	mouseX = screenX;
        mouseY = screenY;
                
        Vector3 mouseScreenPos = new Vector3(screenX, screenY, 0);
        camera.unproject(mouseScreenPos);
        mouseWorldX = mouseScreenPos.x;
        mouseWorldY = mouseScreenPos.y;
		
        return true;
		
    }

    /**
     * Updates leftDown and leftClick if left click (mouse 1) is
     * held down.
     * @param screenX mouse screen coordinate x
     * @param screenY mouse screen coordinate y
     * @param pointer pointer for event
     * @param button mouse button
     * @return true if handled properly
     */
    @Override 
    public boolean touchDown (int screenX, int screenY, int pointer, int button) {
		
	super.touchDown(screenX, screenY, pointer, button);
		
        if (button == Buttons.LEFT) {
            leftDown = true;
            leftClicked = true;
            leftClickLocation = new Vector2(screenX, screenY);
        }
		
	return true;
		
    }
    
    /**
     * Updates leftDown to false if left click isn't held down.
     * 
     * @param screenX mouse screen coordinate x
     * @param screenY mouse screen coordinate y
     * @param pointer pointer for event
     * @param button mouse button
     * @return true if handled properly
     */
    @Override 
    public boolean touchUp (int screenX, int screenY, int pointer, int button) {
		
	super.touchUp(screenX, screenY, pointer, button);

        if (button == Buttons.LEFT) {
            leftDown = false;
        }
		
	return true;
		
    }

    /**
     * This sets all the clicked values to false. 
     * This assumes that the events are already
     * handled, so this should be called at the
     * end of the logic section of the game loop.
     */
    public void resetClickedState() {
        leftClicked = false;
    }

    /**
     * Sets every numerical and boolean value 
     * to 0 or false respectively. Camera provided
     * is used for calculating world coordinates of the
     * mouse.
     * 
     * @param camera Camera to calculate world coords
     */
    public MouseInputHandler(Camera camera) {
        mouseX = 0;
        mouseY = 0;
        leftClickLocation = new Vector2(0.f, 0.f);
        leftDown = false;
        leftClicked = false;
        this.camera = camera;
    }
	
}
