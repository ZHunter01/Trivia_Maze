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
    
    public void setIcon(final ImageIcon theImage) {
        myPlayerImage = theImage;
    }
    
    public ImageIcon getIcon() {
        return myPlayerImage;
    }
    
    public void setColor(final Color theColor) {
        myPlayerColor = theColor;
    }
    
    public Color getColor() {
        return myPlayerColor;
    }
    
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
