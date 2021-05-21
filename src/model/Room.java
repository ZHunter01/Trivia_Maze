package model;

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
    private Player myPlayer;
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

        myPowerUp = new PowerUp();
        myPlayer = new Player();

        //setImage("src/resources/roomm.png");
    }

    /** Returns PowerUp object contained in the room
     *
     * @return myPowerUp
     */
    public PowerUp getRoomPowerUp() {
        return myPowerUp;
    }

    /** Returns the door user is pointing at. Determined by input 0-3
     *
     * @param theDir
     * @return userDoor
     */
    public Door getUserDoor(final int theDir) {
        if (theDir == UP) {
            return myDoorUp;
        } else if (theDir == LEFT) {
            System.out.println("Door left: " + myDoorLeft);
            return myDoorLeft;
        } else if (theDir == DOWN) {
            return myDoorDown;
        } else if (theDir == RIGHT) {
            return myDoorRight;
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

        if (theDir == UP) {
            return myDoorUp.isLocked();
        } else if (theDir == LEFT) {
            return myDoorLeft.isLocked();
        } else if (theDir == DOWN) {
            return myDoorDown.isLocked();
        } else if (theDir == RIGHT) {
            return myDoorRight.isLocked();
        } else {
            throw new IllegalArgumentException("Error: Parameter must be an int value from 0 to 3");
        }
    }

     /** Returns current state of the permaLock on the door user is pointing at
     *
     * @param theDir
     * @return userLock
     */
    public boolean getDoorPermaLock(final int theDir) {
        
        if (theDir == UP) {
            return myDoorUp.isPermaLocked();
        } else if (theDir == LEFT) {
            return myDoorLeft.isPermaLocked();
        } else if (theDir == DOWN) {
            return myDoorDown.isPermaLocked();
        } else if (theDir == RIGHT) {
            return myDoorRight.isPermaLocked();
        } else {
            throw new IllegalArgumentException("Error: Parameter must be an int value from 0 to 3");
        }
    }

    /** Sets room PowerUp to input PowerUp
     *
     * @param thePowerUp
     */
    public void roomWithPowerUp(final PowerUp thePowerUp) {
        myPowerUp = thePowerUp;
    }

    /** Returns boolean if PowerUp in the room is a PermaUnlock PowerUp
     *
     * @return myPowerUp.isPermaUnlock()
     */
    public boolean containsPermaUnlock() {
        return myPowerUp.isPermaUnlock();
    }

    /**Returns boolean if PowerUp in the room is a FreeQuestion PowerUp
     *
     * @return myPowerUp.isPermaUnlock()
     */
    public boolean containsFreeQuestion() {
        return myPowerUp.isPermaUnlock();
    }

    /** Unlocks door that has a PermaLock value of true
     *
     * @param theDir
     */
    public void unlockPermaLock(final int theDir) {
        getUserDoor(theDir).setPermaLock(false);
    }

    public Door getMyDoorUp() {
        return myDoorUp;
    }

    public Door getMyDoorLeft() {
        return myDoorLeft;
    }

    public Door getMyDoorRight() {
        return myDoorRight;
    }

    public Door getMyDoorDown() {
        return myDoorDown;
    }

    public void setMyDoorUp(Door myDoorUp) {
        this.myDoorUp = myDoorUp;
    }

    public void setMyDoorLeft(Door myDoorLeft) {
        this.myDoorLeft = myDoorLeft;
    }

    public void setMyDoorRight(Door myDoorRight) {
        this.myDoorRight = myDoorRight;
    }

    public void setMyDoorDown(Door myDoorDown) {
        this.myDoorDown = myDoorDown;
    }
}
