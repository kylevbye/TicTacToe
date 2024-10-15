package edu.lewisu.cs.group3;

/**
 * Represents a position in terms of x, y, origin point
 * scale, width, height, and rotation.
 * 
 * @author Kyle Bye
 */
public class Dimension {
    
    protected float x, y;
    protected float originX, originY;
    protected float scaleX, scaleY;
    protected float width, height;
    protected float rotation;

    /**
     * Returns x coordinate
     * @return x coordinate
     */
    public final float getX() { return x; }
    
    /**
     * Returns y coordinate
     * @return y coordinate
     */
    public final float getY() { return y; }
    
    /**
     * Returns origin x coordinate
     * @return origin x coordinate
     */
    public final float getOriginX() { return originX; }
    
    /**
     * Returns origin y coordinate
     * @return origin y coordinate
     */
    public final float getOriginY() { return originY; }
    
    /**
     * Returns scaling value for x direction
     * @return scaling value for x direction
     */
    public final float getScaleX() { return scaleX; }
    
    /**
     * Returns scaling value for y direction
     * @return scaling value for y direction
     */
    public final float getScaleY() { return scaleY; }
    
    /**
     * Returns width of dimension
     * @return width
     */
    public final float getWidth() { return width; }
    
    /**
     * Returns height of dimension
     * @return height
     */
    public final float getHeight() { return height; }
    
    /**
     * Returns rotation angle in degrees
     * @return angle in degrees
     */
    public final float getRotation() { return rotation; }
    
    /**
     * Sets x-coordinate
     * @param x x-coordinate
     */
    public final void setX(float x) { this.x = x; }
    
    /**
     * Sets y-coordinate
     * @param y y-coordinate
     */
    public final void setY(float y) { this.y = y; }
    
    /**
     * Sets origin x coordinate
     * @param originX origin x coordinate
     */
    public final void setOriginX(float originX) { this.originX = originX; }
    
    /**
     * Sets origin y coordinate
     * @param originY origin y coordinate
     */
    public final void setOriginY(float originY) { this.originY = originY; }
    
    /**
     * Sets scaling in x direction
     * @param scaleX scaling in x direction
     */
    public final void setScaleX(float scaleX) { this.scaleX = scaleX; }
    
    /**
     * Sets scaling in y direction
     * @param scaleY scaling in y direction
     */
    public final void setScaleY(float scaleY) { this.scaleY = scaleY; }
    
    /**
     * Sets width
     * @param width width
     */
    public final void setWidth(float width) { this.width = width; }
    
    /**
     * Sets height
     * @param height height
     */
    public final void setHeight(float height) { this.height = height; }
    
    /**
     * Sets rotation angle in degree
     * @param rotation rotation
     */
    public final void setRotation(float rotation) { this.rotation = rotation; }
    
    /**
     * Returns the center point in the x direction
     * based on width and x coordinate
     * @return center point x calculated
     */
    public final float findCenterX() { return x + width/2f; }
    
    /**
     * Returns the center point in the y direction
     * based on height and y coordinate
     * @return center point y calculated
     */
    public final float findCenterY() { return y + height/2f; }
    
    /**
     * Returns String representation of this dimension in the form of:
     * "Dimension:[X:_; Y:_; OriginX:_; OriginY:_; ScaleX:_; ScaleY:_;
     * Width:_; Height:_; Rotation:_;"
     * 
     * @return string representation of dimension
     */
    @Override
    public String toString() {
        String format = "Dimension:[X:%.2f, Y:%.2f, OriginX:%.2f, OriginY:%.2f, ScaleX:%.2f, ScaleY:%.2f, Width:%.2f, Height:%.2f, Rotation:%.2f]";
	return String.format(format, x, y, originX, originY, scaleX, scaleY, width, height, rotation);
    }
    
    /**
     * Creates dimensions based on provided values.
     * 
     * @param x x coordinate
     * @param y y coordinate
     * @param originX origin of x position
     * @param originY origin of y position
     * @param scaleX scaling in x direction
     * @param scaleY scaling in y direction
     * @param width width
     * @param height height
     * @param rotation rotation angle in degrees
     */
    public Dimension(float x, float y, float originX, float originY, float scaleX, float scaleY, float width, float height, float rotation) {
        setX(x); setY(y);
        setOriginX(originX); setOriginY(originY);
        setScaleX(scaleX); setScaleY(scaleY);
        setWidth(width); setHeight(height);
        setRotation(rotation);
    }



    
}
