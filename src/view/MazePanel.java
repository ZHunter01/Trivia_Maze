package view;

import controller.Drawer;
import model.Maze;
import model.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MazePanel extends JPanel {

    /**
     * The maze object that contains all of the data
     */
    private Maze maze;

    /**
     * The adapter controls the movement of the player
     */
    private TAdapter myAdapter;

//    private Timer timer;
//
//    public static int DELAY = 100;

    /**
     * initializes the maze and constructs the panel
     */
    public MazePanel() {

        myAdapter = new TAdapter();
        setFocusable(true);
        maze = new Maze();
        addKeyListener(myAdapter);

    }

    //166 - width of the room
    //110 - height of the room

    /**
     * Draws all of the GameObjects onto the panel
     * @param g the Graphics drawer
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

//        drawObjects(g);
        System.out.println(getWidth());
        int y = 0;
        for (Room[] rooms : maze.getMyMaze()) {
            int x = 0;
            for (Room room : rooms) {
                room.setX(x);
                room.setY(y);
                if (x == 0) {
                    room.setMyDoorLeft(null);
                }
                if (y == 0) {
                    room.setMyDoorUp(null);
                }
                if (x + 166 >= getWidth()) {
                    room.setMyDoorRight(null);
                }
                if (y + 110 >= getHeight()) {
                    room.setMyDoorDown(null);
                }

                System.out.println(x);
                //g.drawImage(room.getImage(), x, y, this);
                Drawer.drawRoom(g, room);
                x+= 166;

            }
            y += 110;
        }
        Drawer.drawPlayer(g, maze.getMyPlayer(), this);
    }

    /**
     * @return an instance of the TAdapter that controls the player
     */
    public TAdapter getMyAdapter() {
        return myAdapter;
    }

    /**
     * This class handles the movement of the player object
     */
    public class TAdapter extends KeyAdapter {

        /**
         * handles the button that the user pressed
         * @param e the KeyEvent
         */
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            keySwitch(key);
        }

        /**
         * handles the button that the user pressed. Used for the button actionListeners in DirectionPanel
         * @param theKey the KeyEvent
         */
        public void keyPressed(int theKey) {
            keySwitch(theKey);
        }

        /**
         * Chooses the direction that the player object will move in as well as does not allow user to go
         * out of bounds
         * @param key the code of the button that the user pressed
         */
        private void keySwitch(int key) {
            switch (key) {

                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
                    if (maze.getMyPlayer().getX() - 166 < 0) {
                        return;
                    }
                    maze.getMyPlayer().move(-166, 0);
                    break;

                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    if (maze.getMyPlayer().getX() + 166 > getWidth()) {
                        return;
                    }
                    maze.getMyPlayer().move(166, 0);
                    break;

                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    if (maze.getMyPlayer().getY() - 110 <= 0) {
                        return;
                    }
                    maze.getMyPlayer().move(0, -110);
                    break;

                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    if (maze.getMyPlayer().getY() + 110 >= getHeight()) {
                        return;
                    }
                    maze.getMyPlayer().move(0, 110);
                    break;
                default:
                    break;
            }
            repaint();
        }
    }


}
