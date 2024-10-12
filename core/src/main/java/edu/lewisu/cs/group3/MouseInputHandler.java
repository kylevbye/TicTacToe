package edu.lewisu.cs.group3;

import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;

/**
 * Responsible for observing and recording mouse
 * events and positions. Only currently observes
 * left clicks.
 * 
 * @author Kyle Bye
 * @see InputProcessor
 */
public class MouseInputHandler extends InputAdapter  {

    // Mouse Coords
    private int mouseX, mouseY;

    // Left Mouse Button (Mouse 1)
    private Vector2 leftClickLocation;
    private boolean leftDown;
    private boolean leftClicked;

    // Getters 
    public int getMouseX() { return mouseX; }
    public int getMouseY() { return mouseY; }
    public Vector2 getLeftClickPosition() { return leftClickLocation; }
    public boolean leftDown() { return leftDown; }
    public boolean leftClicked() { return leftClicked; }

	@Override
	public boolean mouseMoved (int screenX, int screenY) {
		
		super.mouseMoved(screenX, screenY);
		mouseX = screenX;
        mouseY = screenY;
		
		return true;
		
	}
	
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
     * end of the game loop.
     */
    public void resetClickedState() {
        leftClicked = false;
    }

    /**
     * Sets every numerical and boolean value 
     * to 0 or false respectively.
     */
    public MouseInputHandler() {
        mouseX = 0;
        mouseY = 0;
        leftClickLocation = new Vector2(0.f, 0.f);
        leftDown = false;
        leftClicked = false;
    }
	
}
