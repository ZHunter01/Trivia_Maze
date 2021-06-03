package model;

import java.awt.Color;
import java.awt.Image;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Zach Hunter, Alik Balika
 *
 */
public class Player extends GameObject implements Serializable {

    @Serial
    private static final long serialVersionUID = -2940779389095085938L;

    /** */
    private transient Image myPlayerImage;
    /** */
    private Color myPlayerColor;
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

    //1 Perma locked door unlock key
    //Method that checks if user has one
    //Room will contain it and will give it to user upon entry
    //1 free question answer
    //Method that checks if user has it



    /** Creates a default player object with default black color
     *
     */
    public Player() {
        setImage("src/resources/Oldman.gif");
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

    /**
     *
     * @param thePowerUp
     */
    public void addPowerUp(final PowerUp thePowerUp) {
        myPowerUps.add(thePowerUp);
    }

    /**
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

    /**
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

    /** Updates x and y
     *
     * @param theX
     * @param theY
     */
    public void move(int theX, int theY) {
//        if (theX < 0 || theY < 0) {
//            throw new IllegalArgumentException("Input Error: Values must be greater than or equal to 0.");
//        }
        setX(getX() + theX);
        setY(getY() + theY);
    }

    /**
     *
     * @param theDir
     */
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
