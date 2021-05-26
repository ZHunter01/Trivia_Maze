package controller;

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
    public static void drawPlayer(Graphics g, Player player, MazePanel mazePanel) {
        g.setColor(Color.PINK);
        //g.fillRect(player.getX(), player.getY(), 30, 30);
        g.drawImage(player.getIcon(), player.getX(), player.getY(), mazePanel);
    }

    /**
     * Draws the room object onto the mazePanel
     * @param g the Graphics drawer
     * @param room the room object
     */
    public static void drawRoom(Graphics g, Room room) {
        g.setColor(Color.BLACK);
        g.fillRect(room.getX(), room.getY(), 166, 110);
        g.setColor(Color.gray);
        g.drawRect(room.getX(), room.getY(), 166, 110);
        g.drawOval((room.getX() + room.getX() + 166) / 2 - 15, (room.getY() + room.getY() + 110) / 2 - 15, 30, 30);

        g.setColor(new Color(165, 42, 42));

        drawDoors(g, room);
    }
  
       /** 
        * Draws the doors to each room as well as sets their coordinates
        * @param g the Graphics drawer
        * @param room the room object
        */
        private static void drawDoors(Graphics g, Room room) {
            if (room.getUserDoor(Room.RIGHT) != null) {
                room.getUserDoor(Room.RIGHT).setX(room.getX() + 161);
                room.getUserDoor(Room.RIGHT).setY(room.getY() + 20);
                g.fillRect(room.getX() + 161, room.getY() + 20, 5, 70);
            }
            if (room.getUserDoor(Room.LEFT) != null) {
                room.getUserDoor(Room.LEFT).setX(room.getX());
                room.getUserDoor(Room.LEFT).setY(room.getY() + 20);
                g.fillRect(room.getX(), room.getY() + 20, 5, 70);
            }
            if (room.getUserDoor(Room.DOWN) != null) {
                room.getUserDoor(Room.DOWN).setX(room.getX() + 50);
                room.getUserDoor(Room.DOWN).setY(room.getY() + 105);
                g.fillRect(room.getX() + 50, room.getY() + 105, 70, 5);
            }
            if (room.getUserDoor(Room.UP) != null) {
                room.getUserDoor(Room.UP).setX(room.getX() + 50);
                room.getUserDoor(Room.UP).setY(room.getY());
                g.fillRect(room.getX() + 50, room.getY(), 70, 5);
            }
        }

}
