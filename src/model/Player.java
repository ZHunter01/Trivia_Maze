package model;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;


/**
 * 
 * @author Zach Hunter, Alik Balika
 *
 */
public class Player extends GameObject{
    private Image myPlayerImage;
    //private Color myPlayerColor;
    private int myX;
    private int myY;
    private ArrayList<PowerUp> myPowerUps;
    
    //1 Perma locked door unlock key
    //Method that checks if user has one
    //Room will contain it and will give it to user upon entry
    //1 free question answer
    //Method that checks if user has it
    
    
    
    /** Creates a default player object with default black color
     * 
     */
    public Player() {
       myPlayerImage = new ImageIcon("./resources/player.png").getImage();
        myPowerUps = new ArrayList<>();
        //Set default color to black
        //myPlayerColor = new Color(0, 0, 0);
        //myPlayerColor = Color.BLACK;
        
        
        setX(68);
        setY(40);
    }
    
    /** Creates player object with specified ImageIcon as the object's icon
     * 
     * @param theIcon
     */
    public Player(final Image theIcon) {
        myPlayerImage = theIcon;
        //myPowerUp = new PowerUp();

       // myPlayerColor = new Color(0, 0, 0);
     //   myPlayerColor = Color.BLACK;
         
        setX(68);
        setY(40);
    }
    
    /** Returns current ImageIcon of the player
     * 
     * @return
     */
    public Image getIcon() {
        return myPlayerImage;   
    }
    
//    /** Returns current X coordinate position of player
//     * 
//     * @return
//     */
//    public int getX() {
//        return myX;
//    }
//    
//    /** Returns current Y coordinate position of player
//     * 
//     * @return
//     */
//    public int getY() {
//        return myY;
//    }
    
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
    
    public void addPowerUp(final PowerUp thePowerUp) {
        myPowerUps.add(thePowerUp);
    }
    
    public boolean containsPermaUnlock() {
        boolean doesContain = false;     
        if (!myPowerUps.isEmpty()) {
            for (int n = 0; n < myPowerUps.size(); n++) {
                if (myPowerUps.get(n).isPermaUnlock()) doesContain = true;
            }
        }
        return doesContain;
    }
    
    public boolean containsFreeQuestion() {
        boolean doesContain = false;     
        if (!myPowerUps.isEmpty()) {
            for (int n = 0; n < myPowerUps.size(); n++) {
                if (myPowerUps.get(n).isFreeQuestion()) doesContain = true;
            }
        }
        return doesContain;
    }
    
    /** Remove PowerUp from player by setting value to false
     * 
     * @param thePowerUp
     */
    public void removePowerUp(final PowerUp thePowerUp) {
        myPowerUps.remove(thePowerUp);
//        if (thePowerUp.isFreeQuestion()) {
//            myPowerUps.remove(thePowerUp);
//        } else if (thePowerUp.isPermaUnlock()){
//            myPowerUps.remove(thePowerUp);
//        } 
        //
        //myPowerUp = null;
        
    }
    
    /** Updates x and y
     * 
     * @param x
     * @param y
     */
    public void move(int theX, int theY) {
//        if (theX < 0 || theY < 0) {
//            throw new IllegalArgumentException("Input Error: Values must be greater than or equal to 0.");
//        }
        setX(getX() + theX);
        setY(getY() + theY);
    }
    
    public void move(int theDir) {
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
    
    @Override 
    public String toString() {
        StringBuilder str = new StringBuilder();
        
        str.append(myX);
        str.append(", ");
        str.append(myY);
        
        return str.toString();
    }
    
}
