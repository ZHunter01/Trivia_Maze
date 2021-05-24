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
//        g.setColor(Color.BLACK);
//        g.fillRect(room.getX(), room.getY(), 166, 110);
//        g.setColor(Color.gray);
//        g.drawRect(room.getX(), room.getY(), 166, 110);
//        g.drawOval((room.getX() + room.getX() + 166) / 2 - 15, (room.getY() + room.getY() + 110) / 2 - 15, 30, 30);

        g.setColor(new Color(165, 42, 42));

        drawDoors(g, room);
    }

    /**
     * Draws the doors to each room as well as sets their coordinates
     * @param g the Graphics drawer
     * @param room the room object
     */
    private static void drawDoors(Graphics g, Room room) {
//        if (room.getMyDoorRight() != null) {
//            room.getMyDoorRight().setX(room.getX() + 161);
//            room.getMyDoorRight().setY(room.getY() + 20);
//            g.fillRect(room.getX() + 161, room.getY() + 20, 5, 70);
//        }
//        if (room.getMyDoorLeft() != null) {
//            room.getMyDoorLeft().setX(room.getX());
//            room.getMyDoorLeft().setY(room.getY() + 20);
//            g.fillRect(room.getX(), room.getY() + 20, 5, 70);
//        }
//        if (room.getMyDoorDown() != null) {
//            room.getMyDoorDown().setX(room.getX() + 50);
//            room.getMyDoorDown().setY(room.getY() + 105);
//            g.fillRect(room.getX() + 50, room.getY() + 105, 70, 5);
//        }
//        if (room.getMyDoorUp() != null) {
//            room.getMyDoorUp().setX(room.getX() + 50);
//            room.getMyDoorUp().setY(room.getY());
//            g.fillRect(room.getX() + 50, room.getY(), 70, 5);
//        }
    }

}
