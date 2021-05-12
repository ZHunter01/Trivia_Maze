package model;

public class Room {
    private Door myDoorUp;
    private Door myDoorLeft;
    private Door myDoorRight;
    private Door myDoorDown;
    
    
    public Room() {
        myDoorUp = new Door();
        myDoorLeft = new Door();
        myDoorRight = new Door();
        myDoorDown = new Door();
    }
    
    
    public Door accessUp() {
        return myDoorUp;
    }
    
    public Door accessLeft() {
        return myDoorLeft;
    }
    
    public Door accessRight() {
        return myDoorRight;
    }
    
    public Door accessDown() {
        return myDoorDown;
    }
}
