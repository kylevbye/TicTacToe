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
	
	public TextureRegion getTextureRegion() { return textureRegion; }
	public Dimension getDimension() { return dimension; }
	public Color getColor() { return color; }
	public boolean isCentered() { return centered; }
	public void setTextureRegion(TextureRegion textureRegion) { this.textureRegion = textureRegion; }
	public void setDimension(Dimension dimension) { this.dimension = dimension; }
	public void setColor(Color color) {this.color = color; }
	public void setCentered(boolean centered) { this.centered = centered; }

	///
	///	Functionality
	///

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
	
	///
	///	toString
	///
	
	@Override
	public String toString() {
		
		String textureString = "null";
		if (textureRegion != null) textureString = textureRegion.toString();
		
		return String.format("ScreenObject:[Texture:%s, Dimension:%s, Color:%s]", 
				textureString, dimension, color
				);
		
	}
	
	///
	///	Constructor
	///
	
	public ScreenObject() {
		this(null, 0, 0, 0, 0, 0, 0, 0);
	}
	
	public ScreenObject(Texture textureIn) {
		this(textureIn, 0, 0, 0, 0, 0, 0 , 0);
	}

	public ScreenObject(Texture texture, Dimension dimension) {
		setTextureRegion(new TextureRegion(texture));
		setDimension(dimension);
		setColor(null);
		setCentered(false);
	}
	
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
	
	///
	///	Destructor
	///
	
	@Override
	public void dispose() {
		textureRegion.getTexture().dispose();
		textureRegion = null;
	}
	
	
}

