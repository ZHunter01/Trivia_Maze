package model;

import java.awt.Color;

import javax.swing.ImageIcon;

public class Player {
    private ImageIcon myPlayerImage;
    private Color myPlayerColor;
    private int myX;
    private int myY;
    
    public Player() {
        myPlayerImage = new ImageIcon();
        
        //Set default color to black
        myPlayerColor = new Color(0, 0, 0);
        myX = 0;
        myY = 0;
    }
    
    
    public Player(final ImageIcon theIcon) {
        myPlayerImage = theIcon;
        myPlayerColor = new Color(0, 0, 0);
        myX = 0;
        myY = 0;
    }
    
    public Player(final Color theColor) {
        myPlayerColor = theColor;
        myX = 0;
        myY = 0;
    }
    
    
    public ImageIcon getIcon() {
        return myPlayerImage;   
    }
    
    public Color getColor() {
        return myPlayerColor;
    }
    
    public int getX() {
        return myX;
    }
    
    public int getY() {
        return myY;
    }
    
    public void setIcon(final ImageIcon theImage) {
        myPlayerImage = theImage;
    }
    
    public void setColor(final Color theColor) {
        myPlayerColor = theColor;
    }
    
    
    /** Sets the x and y location of the player object
     * 
     * @param theX
     * @param theY
     */
    public void setLocation(final int theX, final int theY) {
        myX = theX;
        myY = theY;
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
