package edu.lewisu.cs.group3;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Disposable;

/**
 * This class represents a object that can be drawn on the screen. 
 * It holds a <code>TextureRegion</code> instance to do so. 
 * 
 * @author Kyle Bye
 * @see	TextureRegion
 * @see	Disposable
 * @see	Drawable
 */
public class ScreenObject implements Disposable, Drawable {
	
	private TextureRegion textureRegion;
	private Dimension dimension;
	private Color color;
	private boolean centered;
	
        /**
         * Returns the texture region that is to be drawn to the screen.
         * @return Texture region that is to be drawn
         */
	public TextureRegion getTextureRegion() { return textureRegion; }
        
        /**
         * Returns the dimension of the screen object
         * @return dimension of the screen object
         */
	public Dimension getDimension() { return dimension; }
        
        /**
         * Returns the color of the screen object.
         * @return color
         */
	public Color getColor() { return color; }
        
        /**
         * Returns true if the object is to be centered before
         * being drawn.
         * @return true if to be centered when drawn
         */
	public boolean isCentered() { return centered; }
        
        /**
         * Sets the texture region of the screen object
         * @param textureRegion texture region that is to be drawn
         */
	public void setTextureRegion(TextureRegion textureRegion) { this.textureRegion = textureRegion; }
        
        /**
         * Sets the dimension of the screen object
         * @param dimension dimension of the screen object
         */
	public void setDimension(Dimension dimension) { this.dimension = dimension; }
        
        /**
         * Sets the color of the screen object.
         * @param color color to be set
         */
	public void setColor(Color color) {this.color = color; }
        
        /**
         * Sets if the object should be centered before drawn.
         * @param centered flag that determines centering
         */
	public void setCentered(boolean centered) { this.centered = centered; }

	/**
         * Draws object onto batch.
         * @param batch batch to draw on
         * @param parentAlpha opacity
         */
        @Override
	public void draw(Batch batch, float parentAlpha) {

		batch.enableBlending();
		Color oldColor = batch.getColor();
		if (color != null) batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);

		// If centered, calculate offset then adjust
		float x = dimension.getX();
		float y = dimension.getY();
		if (centered) {
			float offsetX = 0.5f*(dimension.getWidth()*dimension.getScaleX());
			float offsetY = 0.5f*(dimension.getHeight()*dimension.getScaleY());;
			x -= offsetX;
			y -= offsetY;
		}

		batch.draw(textureRegion, x, y, dimension.getOriginX(), dimension.getOriginY(), dimension.getWidth(), dimension.getHeight(), dimension.getScaleX(), dimension.getScaleY(), dimension.getRotation());
		batch.setColor(oldColor);
	}
	
        /**
         * Returns string representation of this instance in the format of
         * "ScreenObject:[Texture:_; Dimension:_; Color:_]"
         * @return string representation of a screen object
         */
	@Override
	public String toString() {
		String textureString = "null";
		if (textureRegion != null) textureString = textureRegion.toString();
                String format = "ScreenObject:[Texture:%s, Dimension:%s, Color:%s]";
		return String.format(format, textureString, dimension, color);
	}
	
	/**
         * Constructs the screen object by creating a texture region
         * and calculating width and height. Everything else is set to 0.
         * @param textureIn texture to draw
         */
	public ScreenObject(Texture textureIn) {
		this(textureIn, 0, 0, 0, 0, 0, 0 , 0);
	}
        
        /**
         * Constructs the screen object by creating a texture region
         * and calculate width and height. Everything else is set by the
         * provided dimension.
         * @param textureIn texture to draw
         */
	public ScreenObject(Texture texture, Dimension dimension) {
		setTextureRegion(new TextureRegion(texture));
		setDimension(dimension);
		setColor(null);
		setCentered(false);
	}
	
        /**
         * Constructs the screen object by creating a texture region
         * and calculate width and height. Dimension is constructed
         * based on provided parameters.
         * 
         * @param texture texture to draw
         * @param x x coordinate
         * @param y y coordinate
         * @param originX origin x coordinate
         * @param originY origin y coordinate
         * @param scaleX scale value x direction
         * @param scaleY scale value y direction
         * @param rotation rotation angle in degrees
         */
	public ScreenObject(Texture texture, float x, float y, float originX, float originY, float scaleX, float scaleY, float rotation) {

		// 0 if given null texture instance
		float width = 0.f;
		float height = 0.f;

		// Texture
		textureRegion = null;
		if (texture != null) {
			setTextureRegion(new TextureRegion(texture));
			width = texture.getWidth();
			height = texture.getHeight();
		}

		setDimension(new Dimension(x, y, originX, originY, scaleX, scaleY, width, height, rotation));
		setColor(null);
		setCentered(false);
	}
	
        /**
         * Disposes texture
         */
	@Override
	public void dispose() {
		textureRegion.getTexture().dispose();
		textureRegion = null;
	}
	
	
}

