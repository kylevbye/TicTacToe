package edu.lewisu.cs.group3;

public class Dimension {
    
    protected float x, y;
    protected float originX, originY;
    protected float scaleX, scaleY;
    protected float width, height;
    protected float rotation;

    public float getX() { return x; }
    public float getY() { return y; }
    public float getOriginX() { return originX; }
    public float getOriginY() { return originY; }
    public float getScaleX() { return scaleX; }
    public float getScaleY() { return scaleY; }
    public float getWidth() { return width; }
    public float getHeight() { return height; }
    public float getRotation() { return rotation; }

    public void setX(float x) { this.x = x; }
    public void setY(float y) { this.y = y; }
    public void setOriginX(float originX) { this.originX = originX; }
    public void setOriginY(float originY) { this.originY = originY; }
    public void setScaleX(float scaleX) { this.scaleX = scaleX; }
    public void setScaleY(float scaleY) { this.scaleY = scaleY; }
    public void setWidth(float width) { this.width = width; }
    public void setHeight(float height) { this.height = height; }
    public void setRotation(float rotation) { this.rotation = rotation; }

    ///
	///	Functionality
	///
	
	public float findCenterX() { return x + width/2f; }
	public float findCenterY() { return y + height/2f; }

    @Override
	public String toString() {
		return String.format("Dimension:[X:%.2f, Y:%.2f, OriginX:%.2f, OriginY:%.2f, ScaleX:%.2f, ScaleY:%.2f, Width:%.2f, Height:%.2f, Rotation:%.2f]", 
				 x, y, originX, originY, scaleX, scaleY, width, height, rotation
                );
	}

    ///
    /// Constructors
    ///

    public Dimension(float x, float y, float originX, float originY, float scaleX, float scaleY, float width, float height, float rotation) {
        setX(x); setY(y);
        setOriginX(originX); setOriginY(originY);
        setScaleX(scaleX); setScaleY(scaleY);
        setWidth(width); setHeight(height);
        setRotation(rotation);
    }



    
}
