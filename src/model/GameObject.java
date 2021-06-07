package model;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

/**
 * @author Alik Balika
 *
 * This class is the parent class for all the objects inside the game that will be displayed on screen
 */
public abstract class GameObject implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 3588155796279251981L;

    /**
     * The x-coordinate of the object
     */
    private int myX;

    /**
     * The y-coordinate of the object
     */
    private int myY;

    /**
     * The icon of the object
     */
    private transient Image image;

    /**
     * @return the x-coordinate of the object
     */
    public int getX() {
        return myX;
    }

    /**
     * @return the y-coordinate of the object
     */
    public int getY() {
        return myY;
    }

    /**
     * Sets the current x-coordinate to a new x-coordinate
     * @param theX the new x-coordinate
     */
    public void setX(int theX) {
        myX = theX;
    }

    /**
     * Sets the current y-coordinate to a new y-coordinate
     * @param theY the new y-coordinate
     */
    public void setY(int theY) {
       myY = theY;
    }

    /**
     * Sets the image of the object from the file path passed in
     * @param imageName the file path to the image
     */
    public void setImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
    }

    /**
     * @return the image of the object
     */
    public Image getImage() {
        return image;
    }
}