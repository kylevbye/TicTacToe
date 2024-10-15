/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.lewisu.cs.group3;

/**
 * Responsible for containing two int values.
 * @author Kyle Bye
 */
public class IntPair {
    
    private int int1;
    private int int2;
    
    /**
     * Return the first int value
     * @return first int value
     */
    public final int getInt1() {
        return int1;
    }
    
    /**
     * Return the second int value
     * @return second int value
     */
    public final int getInt2() {
        return int2;
    }
    
    /**
     * Sets the first int value.
     * @param int1 first int value
     */
    public final void setInt1(int int1) {
        this.int1 = int1;
    }
    
    /**
     * Sets the second int value
     * @param int2 second int value
     */
    public final void setInt2(int int2) {
        this.int2 = int2;
    }
    
    /**
     * Returns String representation in form of
     * "IntPair:[int1:val1; int2:val2]".
     * 
     * @return string representation of a pair of int values.
     */
    @Override
    public String toString() {
        String format = "FloatPair:[int1:%d; int2:%d]";    
        return String.format(format, int1, int2); 
    }
    
    /**
     * Initializes both int with 0s.
     */
    public IntPair() {
        this(0, 0);
    }
    
    /**
     * Initializes both int to the provided integers.
     * @param int1 first float value
     * @param int2 second float value
     */
    public IntPair(int int1, int int2) {
        setInt1(int1);
        setInt2(int2);
    }
    
}
