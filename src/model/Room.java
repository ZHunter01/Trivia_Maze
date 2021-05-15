package model;

/**
 * 
 * @author Zach Hunter
 *
 */
public class Room {
    private Door myDoorUp;
    private Door myDoorLeft;
    private Door myDoorRight;
    private Door myDoorDown;
    private Player myPlayer;
    private PowerUp myPowerUp;
    /**Int value to indicate up door is selected */
    public final static int UP = 0;
    /**Int value to indicate left door is selected */
    public final static int LEFT = 1;
    /**Int value to indicate down door is selected */
    public final static int DOWN = 2;
    /**Int value to indicate right door is selected */
    public final static int RIGHT = 3;
    
    public Room() {
        myDoorUp = new Door();
        myDoorLeft = new Door();
        myDoorRight = new Door();
        myDoorDown = new Door();
        
        myPlayer = new Player();
        
        myPowerUp = new PowerUp();
        //myRoom = new Room();
    }
    
    public Room getRoom() {
        return this;
    }
    
    public PowerUp getRoomPowerUp() {
        return myPowerUp;
    }
    
    public Door getUserDoor(final int theDir) {
        Door userDoor = new Door();
        
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
    
    public boolean getDoorLock(final int theDir) {
        boolean userLock = false;
        
        if (theDir == UP) {
            userLock = myDoorUp.isLocked(); 
        } else if (theDir == LEFT) {
            userLock = myDoorLeft.isLocked(); 
        } else if (theDir == DOWN) {
            userLock = myDoorDown.isLocked(); 
        } else if (theDir == RIGHT) {
            userLock = myDoorRight.isLocked(); 
        } else {
            throw new IllegalArgumentException("Error: Parameter must be an int value from 0 to 3");
        }
        
        return userLock;
    }
    
    public boolean getDoorPermaLock(final int theDir) {
        boolean userLock = false;
        
        if (theDir == UP) {
            userLock = myDoorUp.isPermaLocked(); 
        } else if (theDir == LEFT) {
            userLock = myDoorLeft.isPermaLocked(); 
        } else if (theDir == DOWN) {
            userLock = myDoorDown.isPermaLocked(); 
        } else if (theDir == RIGHT) {
            userLock = myDoorRight.isPermaLocked(); 
        } else {
            throw new IllegalArgumentException("Error: Parameter must be an int value from 0 to 3");
        }
        
        return userLock;
    }
    
    public void roomWithPowerUp(final PowerUp thePowerUp) {
        myPowerUp = thePowerUp;
    }
    
    public boolean containsPermaUnlock() {
        return myPowerUp.isPermaUnlock();
    }
    
    public boolean containsFreeQuestion() {
        return myPowerUp.isPermaUnlock();
    }
    
}
