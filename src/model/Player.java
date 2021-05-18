package model;

import java.awt.Color;

import javax.swing.ImageIcon;

public class Player extends GameObject {
    //private ImageIcon myPlayerImage;
    private Color myPlayerColor;
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
        //myPlayerImage = new ImageIcon();
        setImage("src/resources/player.png");

        myPowerUp = new PowerUp();
        //Set default color to black
        myPlayerColor = new Color(0, 0, 0);
        setX(68);
        setY(40);
    }


    /** Creates player object with specified ImageIcon as the object's icon
     *
     * @param theIcon
     */
    public Player(final ImageIcon theIcon) {
        //myPlayerImage = theIcon;
        myPowerUp = new PowerUp();

        myPlayerColor = new Color(0, 0, 0);
        setX(0);
        setY(0);
    }

    /** Creates player object with specified Color as the object's color
     *
     * @param theColor
     */
    public Player(final Color theColor) {
        myPlayerColor = theColor;
        myPowerUp = new PowerUp();

        setX(0);
        setY(0);
    }

    /** Returns current color of the player
     *
     * @return
     */
    public Color getColor() {
        return myPlayerColor;
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
        setX(theX);
        setY(theY);
    }

    public void addPowerUp(final PowerUp thePowerUp) {
        myPowerUp = thePowerUp;
    }

    public boolean containsPermaUnlock() {
        return myPowerUp.isPermaUnlock();
    }

    public boolean containsFreeQuestion() {
        return myPowerUp.isPermaUnlock();
    }

    /** Remove PowerUp from player by setting value to false
     *
     * @param thePowerUp
     */
    public void removePowerUp(final PowerUp thePowerUp) {
        if (thePowerUp.isFreeQuestion()) {
            myPowerUp.setFreeQuestion(false);
        } else {
            myPowerUp.setPermaUnlock(false);
        }
    }

    public void move(int x, int y) {
        setX(getX() + x);
        setY(getY() + y);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        
        str.append(getX());
        str.append(", ");
        str.append(getY());
        
        return str.toString();
    }
    
}
