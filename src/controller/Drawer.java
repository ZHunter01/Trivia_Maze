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
        g.drawImage(player.getImage(), player.getX(), player.getY(), mazePanel);
    }

    /**
     * Draws the room object onto the mazePanel
     * @param g the Graphics drawer
     * @param room the room object
     */
    public static void drawRoom(final Graphics g, final Room room) {

        g.setColor(Color.BLACK);
        g.drawRect(room.getX(), room.getY(), 166, 110);

        g.setColor(new Color(165, 42, 42));

        drawDoors(g, room);
    }

    /**
     * Draws the doors to each room
     * @param g the Graphics drawer
     * @param room the room object
     */
    private static void drawDoors(final Graphics g, final Room room) {


        // height of panel: 440
        // width of panel: 664
        if (!(room.getX() + 166 >= 664)) {
            Door door = room.getUserDoor(Room.RIGHT);
            g.fillRect(door.getX(), door.getY(), 5, 70);
        }


        g.setColor(new Color(165, 42, 42));
        if (!(room.getX() == 0)) {
            Door door = room.getUserDoor(Room.LEFT);

            g.fillRect(door.getX(), door.getY(), 5, 70);
        }
        g.setColor(new Color(165, 42, 42));
        if (!(room.getY() + 110 >= 440)) {
            Door door = room.getUserDoor(Room.DOWN);

            g.fillRect(door.getX(), door.getY(), 70, 5);
        }
        g.setColor(new Color(165, 42, 42));
        if (!(room.getY() == 0)) {
            Door door = room.getUserDoor(Room.UP);

            g.fillRect(door.getX(), door.getY(), 70, 5);
        }
    }
}