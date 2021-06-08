package controller;

import model.Door;
import model.Player;
import model.Room;
import view.MazePanel;

import java.awt.*;

/**
 * @author Alik Balika
 */
public class Drawer {

    /**
     * Draws the player icon onto the mazePanel
     * @param g the Graphics drawer
     * @param player the player object
     * @param mazePanel the observer
     */
    public static void drawPlayer(final Graphics g, final Player player, final MazePanel mazePanel) {
        //g.setColor(Color.PINK);
        g.drawImage(player.getImage(), player.getX(), player.getY(), mazePanel);
    }

    /**
     * Draws the room object onto the mazePanel
     * @param g the Graphics drawer
     * @param room the room object
     */
    public static void drawRoom(final Graphics g, final Room room) {
        g.setColor(Color.DARK_GRAY);
        //g.fillRect(room.getX(), room.getY(), 166, 110);
        g.setColor(Color.BLACK);
        g.drawRect(room.getX(), room.getY(), 166, 110);
        //g.drawOval((room.getX() + room.getX() + 166) / 2 - 15, (room.getY() + room.getY() + 110) / 2 - 15, 30, 30);

        g.setColor(new Color(165, 42, 42));

        drawDoors(g, room);
    }

    /**
     * Draws the doors to each room as well as sets their coordinates
     * @param g the Graphics drawer
     * @param room the room object
     */
    private static void drawDoors(final Graphics g, final Room room) {

        // height of panel: 440
        // width of panel: 664
        if (!(room.getX() + 166 >= 664)) {
            room.getUserDoor(Room.RIGHT).setX(room.getX() + 161);
            room.getUserDoor(Room.RIGHT).setY(room.getY() + 20);
//            if (!room.getUserDoor(Room.RIGHT).isLocked()) {
//                g.setColor(Color.GREEN);
//                System.out.println("(R)Door Green! - ("+room.getX()+","+room.getY()+")");
//            }
            g.fillRect(room.getX() + 161, room.getY() + 20, 5, 70);
        }
        g.setColor(new Color(165, 42, 42));
        if (!(room.getX() == 0)) {
            room.getUserDoor(Room.LEFT).setX(room.getX());
            room.getUserDoor(Room.LEFT).setY(room.getY() + 20);
//            if (!room.getUserDoor(Room.LEFT).isLocked()) {
//                g.setColor(Color.GREEN);
//                System.out.println("(L)Door Green! - ("+room.getX()+","+room.getY()+")");
//            }
            g.fillRect(room.getX(), room.getY() + 20, 5, 70);
        }
        g.setColor(new Color(165, 42, 42));
        if (!(room.getY() + 110 >= 440)) {
            room.getUserDoor(Room.DOWN).setX(room.getX() + 50);
            room.getUserDoor(Room.DOWN).setY(room.getY() + 105);
//            if (!room.getUserDoor(Room.DOWN).isLocked()) {
//                g.setColor(Color.GREEN);
//                System.out.println("(D)Door Green! - ("+room.getX()+","+room.getY()+")");
//            }
            g.fillRect(room.getX() + 50, room.getY() + 105, 70, 5);
        }
        g.setColor(new Color(165, 42, 42));
        if (!(room.getY() == 0)) {
            room.getUserDoor(Room.UP).setX(room.getX() + 50);
            room.getUserDoor(Room.UP).setY(room.getY());
//            if (!room.getUserDoor(Room.UP).isLocked()) {
//                g.setColor(Color.GREEN);
//                System.out.println("(U)Door Green! - ("+room.getX()+","+room.getY()+")");
//            }
            g.fillRect(room.getX() + 50, room.getY(), 70, 5);
        }
    }

//    public static void setToGreen(final Graphics g, final Room theRoom, final int theDir) {
//        g.setColor(Color.GREEN);
//        theRoom.getUserDoor(theDir);
//        if (theDir == Room.RIGHT) {
//
//        }
//    }

}