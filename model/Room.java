package model;

import java.awt.Image;

/**
 * 
 * @author Zach Hunter
 *
 */
public class Room extends GameObject {
    /**Door object to represent door at the top of the room */
    private Door myDoorUp;
    /**Door object to represent door at the left side of the room */
    private Door myDoorLeft;
    /**Door object to represent door at the right side of the room */
    private Door myDoorRight;
    /**Door object to represent door at the bottom of the room */
    private Door myDoorDown;
    /**PowerUp object that is contained in a room */
    private PowerUp myPowerUp;
    /**Image object that represents the room */
    private Image myRoomIcon;
    /**Int value to indicate up door is selected */
    public final static int UP = 0;
    /**Int value to indicate left door is selected */
    public final static int LEFT = 1;
    /**Int value to indicate down door is selected */
    public final static int DOWN = 2;
    /**Int value to indicate right door is selected */
    public final static int RIGHT = 3;
    
    /** Creates default Room object
     * 
     */
    public Room() {
        myDoorUp = new Door();
        myDoorLeft = new Door();
        myDoorRight = new Door();
        myDoorDown = new Door();
                
    }
    
    /** Get current Room Image
     * 
     * @return
     */
    public Image getRoomImage() {
        return myRoomIcon;
    }
    
    /**
     * 
     * @param theIcon
     */
    public void setRoomImage(final Image theIcon) {
        myRoomIcon = theIcon;
    }
    
    /** Returns PowerUp object contained in the room
     * 
     * @return myPowerUp
     */
    public PowerUp getRoomPowerUp() {
        return myPowerUp;
    }
    
    /** Returns boolean if the two doors are the same
     * 
     * @param theDir
     * @param theDoor
     * @return boolean theDoor.equals(getUserDoor(theDir))
     */
    public boolean isCorrectDoor(final int theDir, final Door theDoor) {
        if (theDoor.equals(getUserDoor(theDir))) return true;
        return false;
    }
    
    /** Returns the door user is pointing at. Determined by input 0-3
     * 
     * @param theDir
     * @return userDoor
     */
    public Door getUserDoor(final int theDir) {
        Door userDoor;
        
        if (theDir == UP) {
            userDoor = myDoorUp; 
        } else if (theDir == LEFT) {
            userDoor = myDoorLeft; 
        } else if (theDir == DOWN) {
            userDoor = myDoorDown; 
        } else if (theDir == RIGHT) {
            userDoor = myDoorRight; 
        } else {
            throw new IllegalArgumentException("Error: Parameter must be an int value from 0 to 3");
        }
        
        return userDoor;
    }
    
    public void setUserDoor(final int theDir, final Door theDoor) {        
        if (theDir == UP) {
            myDoorUp = theDoor; 
        } else if (theDir == LEFT) {
            myDoorLeft = theDoor; 
        } else if (theDir == DOWN) {
            myDoorDown = theDoor; 
        } else if (theDir == RIGHT) {
            myDoorRight = theDoor; 
        } else {
            throw new IllegalArgumentException("Error: Parameter must be an int value from 0 to 3");
        }
        
    }
    
    /** Returns current state of the lock on the door user is pointing at
     * 
     * @param theDir
     * @return userLock
     */
    public boolean getDoorLock(final int theDir) {
        return getUserDoor(theDir).isLocked();  

    }
    
    /** Returns current state of the permaLock on the door user is pointing at
     * 
     * @param theDir
     * @return userLock
     */
    public boolean getDoorPermaLock(final int theDir) {
        return getUserDoor(theDir).isPermaLocked();
    }
    
    /** Sets room PowerUp to input PowerUp
     * 
     * @param thePowerUp
     */
    public void setRoomWithPowerUp(final PowerUp thePowerUp) {
        myPowerUp = thePowerUp;
    }   
        
    /** Unlocks door that has a PermaLock value of true
     *  
     * @param theDir
     */
    public void unlockPermaLock(final int theDir) {
        getUserDoor(theDir).setPermaLock(false);
         
    }
    
}