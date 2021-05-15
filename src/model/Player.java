package model;

import java.awt.Color;

import javax.swing.ImageIcon;

public class Player {
    private ImageIcon myPlayerImage;
    private Color myPlayerColor;
    private int myX;
    private int myY;
    private PowerUp myPowerUp;
    
    //1 Perma locked door unlock key
    //Method that checks if user has one
    //Room will contain it and will give it to user upon entry
    //1 free question answer
    //Method that checks if user has it
    
    
    
    /** Creates a default player object with default black color
     * 
     */
    public Player() {
        myPlayerImage = new ImageIcon();
        
        myPowerUp = new PowerUp();
        
        //Set default color to black
        myPlayerColor = new Color(0, 0, 0);
        myX = 0;
        myY = 0;
    }
    
    /** Creates player object with specified ImageIcon as the object's icon
     * 
     * @param theIcon
     */
    public Player(final ImageIcon theIcon) {
        myPlayerImage = theIcon;
        myPowerUp = new PowerUp();

        myPlayerColor = new Color(0, 0, 0);
        myX = 0;
        myY = 0;
    }
    
    /** Creates player object with specified Color as the object's color
     * 
     * @param theColor
     */
    public Player(final Color theColor) {
        myPlayerColor = theColor;
        myPowerUp = new PowerUp();

        myX = 0;
        myY = 0;
    }
    
    /** Returns current ImageIcon of the player
     * 
     * @return
     */
    public ImageIcon getIcon() {
        return myPlayerImage;   
    }
    
    /** Returns current color of the player 
     * 
     * @return
     */
    public Color getColor() {
        return myPlayerColor;
    }
    
    /** Returns current X coordinate position of player
     * 
     * @return
     */
    public int getX() {
        return myX;
    }
    
    /** Returns current Y coordinate position of player
     * 
     * @return
     */
    public int getY() {
        return myY;
    }
    
    /** Sets player ImageIcon to input ImageIcon
     * 
     * @param theImage
     */
    public void setIcon(final ImageIcon theImage) {
        myPlayerImage = theImage;
    }
    
    /** Sets player Color to input Color
     * 
     * @param theColor
     */
    public void setColor(final Color theColor) {
        myPlayerColor = theColor;
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
    
    public boolean containsPermaUnlock() {
        return myPowerUp.isPermaUnlock();
    }
    
    public boolean containsFreeQuestion() {
        return myPowerUp.isPermaUnlock();
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
