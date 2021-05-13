package model;

import javax.swing.ImageIcon;

public class Room {
    private Room myRoom;
    private Door myDoorUp;
    private Door myDoorLeft;
    private Door myDoorRight;
    private Door myDoorDown;
    /**Int value to indicate up door is selected */
    private final static int UP = 0;
    /**Int value to indicate left door is selected */
    private final static int LEFT = 1;
    /**Int value to indicate down door is selected */
    private final static int DOWN = 2;
    /**Int value to indicate right door is selected */
    private final static int RIGHT = 3;
    private ImageIcon myIcon;
    
    
    public Room() {
        myDoorUp = new Door();
        myDoorLeft = new Door();
        myDoorRight = new Door();
        myDoorDown = new Door();
        myRoom = new Room();
        myIcon = new ImageIcon();
    }
    
    public Room getRoom() {
        return myRoom;
    }
    
    public ImageIcon getRoomIcon() {
        return myIcon;
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
    
    public void setRoomIcon(final ImageIcon theIcon) {
        myIcon = theIcon;
    }
    
}
