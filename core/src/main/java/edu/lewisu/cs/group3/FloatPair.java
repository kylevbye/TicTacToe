/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.lewisu.cs.group3;

/**
 * Responsible for containing two float values.
 * @author Kyle Bye
 */
public class FloatPair {
    
    private float float1;
    private float float2;
    
    /**
     * Return the first float value
     * @return first float value
     */
    public final float getFloat1() {
        return float1;
    }
    
    /**
     * Returns the second float value
     * @return second float value
     */
    public final float getFloat2() {
        return float2;
    }
    
    /**
     * Sets the first float value.
     * @param float1 first float value
     */
    public final void setFloat1(float float1) {
        this.float1 = float1;
    }
    
    /**
     * Sets the second float value
     * @param float2 second float value
     */
    public final void setFloat2(float float2) {
        this.float2 = float2;
    }
    
    /**
     * Returns String representation in form of
     * "FloatPair:[float1:val1; float2:val2]".
     * 
     * @return string representation of a pair of float values.
     */
    @Override
    public String toString() {
        String format = "FloatPair:[float1:%.2f; float2:%.2f]";    
        return String.format(format, float1, float2); 
    }
    
    /**
     * Initializes both floats with 0s.
     */
    public FloatPair() {
        this(0.f, 0.f);
    }
    
    /**
     * Initializes both floats to the provided floats.
     * @param float1 first float value
     * @param float2 second float value
     */
    public FloatPair(float float1, float float2) {
        setFloat1(float1);
        setFloat2(float2);
    }
    
}
