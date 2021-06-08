/**
 * Trivia Maze TCSS 360 Spring 2021
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;


/** Player object class
 * 
 * @author Zach Hunter, Alik Balika
 *
 */
public class Player extends GameObject implements Serializable{
    /**Serializable generated number */
    private static final long serialVersionUID = 3311504575818535717L;
    /**Int field for current x position of the player */
    private int myX;
    /**Int field for current y position of the player */
    private int myY;
    /**ArrayList for holding Player's PowerUps */
    private ArrayList<PowerUp> myPowerUps;
    /**Default starting x position */
    private static final int MY_START_X = 68;
    /**Default starting y position */
    private static final int MY_START_Y = 40;
    /**Default Image for the Player object */
    private static final String DEFAULT_IMAGE = "resources/Oldman.gif";
   
    /** Creates a default player object with default black color
    *
    */
   public Player() {
       setImage(DEFAULT_IMAGE);
       myPowerUps = new ArrayList<>();

       //Set Player start point
       setX(MY_START_X);
       setY(MY_START_Y);
   }
    
   /** Returns current ArrayList of PowerUps for the Player
    * 
    * @return myPowerUps
    */
    public ArrayList<PowerUp> getPowerUps() {
        return myPowerUps;
    }
    
    /** Sets the x and y location of the player object
     * x and y can be negative
     * 
     * @param theX
     * @param theY
     */
    public void setLocation(final int theX, final int theY) {
        myX = theX;
        myY = theY;
    }
    
    /** Adds PowerUp to player PowerUp array
     * 
     * @param thePowerUp
     */
    public void addPowerUp(final PowerUp thePowerUp) {
        myPowerUps.add(thePowerUp);
    }
    
    /** Returns boolean if player has a PermaUnlock PowerUp
     * 
     * @return doesContain
     */
    public boolean containsPermaUnlock() {
        boolean doesContain = false;
        for (int n = 0; n < myPowerUps.size(); n++) {
            if (myPowerUps.get(n).isPermaUnlock()) doesContain = true;
        }
        return doesContain;
    }
    
    /** Returns boolean if player has a FreeQuestion PowerUp
     * 
     * @return doesContain
     */
    public boolean containsFreeQuestion() {
        boolean doesContain = false;
        for (int n = 0; n < myPowerUps.size(); n++) {
            if (myPowerUps.get(n).isFreeQuestion()) doesContain = true;
        }
        return doesContain;
    }
    
    /** Remove PowerUp from player by setting value to false
     * 
     * @param thePowerUp
     */
    public void removePowerUp(final PowerUp thePowerUp) {
        myPowerUps.remove(thePowerUp);        
    }
    
    /** Updates the x and y coordinates of the Player
     * 
     * @param x
     * @param y
     */
    public void move(final int theX, final int theY) {
        setX(getX() + theX);
        setY(getY() + theY);
    }
    
    /** Updates the x and y coordinates of the Player 
     * 
     * @param theDir
     */
    public void move(final int theDir) {
        //Moves user based on direction
        switch (theDir) {
            case Room.UP:
                move(0, -110); break;
            case Room.DOWN: 
                move(0, 110); break;
            case Room.LEFT: 
                move(-166, 0);break;
            case Room.RIGHT:
                move(166, 0); break;
        }
    }
    
    @Override 
    public String toString() {
        //String of Player is simply it's x and y coordinates
        StringBuilder str = new StringBuilder();
        
        str.append(myX);
        str.append(", ");
        str.append(myY);
        
        return str.toString();
    }
    
}