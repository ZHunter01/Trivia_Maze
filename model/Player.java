package model;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;


/** Player object class
 * 
 * @author Zach Hunter, Alik Balika
 *
 */
public class Player extends GameObject {
    /** */
    private Image myPlayerImage;
    /** */
    private int myX;
    /** */
    private int myY;
    /** */
    private ArrayList<PowerUp> myPowerUps;
    /** */
    private static final int MY_START_X = 68;
    /** */
    private static final int MY_START_Y = 40;
   
    /** Creates a default player object with default black color
     * 
     */
    public Player() {
       myPlayerImage = new ImageIcon("./resources/Oldman.gif").getImage();
        myPowerUps = new ArrayList<>();     
        
        //Set start point
        setX(MY_START_X);
        setY(MY_START_Y);
    }
    
    /** Creates player object with specified ImageIcon as the object's icon
     * 
     * @param theIcon
     */
    public Player(final Image theIcon) {
        myPlayerImage = theIcon;
        myPowerUps = new ArrayList<>();
            
        //Sets start point
        setX(MY_START_X);
        setY(MY_START_Y);
    }
    
    
    /** Returns current ImageIcon of the player
     * 
     * @return
     */
    public Image getIcon() {
        return myPlayerImage;   
    }

    public ArrayList<PowerUp> getPowerUps() {
        return myPowerUps;
    }
    
    /** Sets player ImageIcon to input ImageIcon
     * 
     * @param theImage
     */
    public void setImage(final Image theImage) {
        myPlayerImage = theImage;
    }  
    
    /** Sets the x and y location of the player object
     * 
     * @param theX
     * @param theY
     */
    public void setLocation(final int theX, final int theY) {
        if (theX < 0 || theY < 0) {
            throw new IllegalArgumentException("Input Error: Values must be greater than or equal to 0.");
        }
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
     * @return
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
     * @return
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
//        if (theX < 0 || theY < 0) {
//            throw new IllegalArgumentException("Input Error: Values must be greater than or equal to 0.");
//        }
        setX(getX() + theX);
        setY(getY() + theY);
    }
    
    /** Updates the x and y coordinates of the Player 
     * 
     * @param theDir
     */
    public void move(final int theDir) {
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
    
//       
//    public void move(int theDir) {
//        switch (theDir) {
//            case Room.UP -> move(0, -110);
//            case Room.DOWN -> move(0, 110);
//            case Room.LEFT -> move(-166, 0);
//            case Room.RIGHT -> move(166, 0);
//        }
//    }
    
    public void setPlayerIcon(final String theName) {
        myPlayerImage = new ImageIcon("./resources/" + theName + ".gif").getImage();
    }
    
    @Override 
    public String toString() {
        StringBuilder str = new StringBuilder();
        
        str.append(myX);
        str.append(", ");
        str.append(myY);
        
        return str.toString();
    }
    
}
