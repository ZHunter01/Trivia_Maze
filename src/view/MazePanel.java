package view;

import controller.Drawer;
import model.Maze;
import model.Question;
import model.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Alik Balika
 * This class contains the Maze object and player object and displays the entire maze and where the player will move
 *
 * This is a Singleton class
 */
public class MazePanel extends JPanel {

    /**
     * The maze object that contains all of the data
     */
    private final Maze maze;

    /**
     * The adapter controls the movement of the player
     */
    private final TAdapter myAdapter;

    /**
     * Create an instance of the MazePanel
     */
    private static final MazePanel mazePanel = new MazePanel();

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

//    /**
//     * @return the only instance of mazePanel
//     */
//    public static MazePanel getInstance() {
//        return mazePanel;
//    }

    //166 - width of the room
    //110 - height of the room

    /**
     * Draws all of the GameObjects onto the panel
     * @param g the Graphics drawer
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int y = 0;
//        int i = 0;
        for (Room[] rooms : maze.getMaze()) {
            int x = 0;
            for (Room room : rooms) {
                room.setX(x);
                room.setY(y);
                if (x == 0) {
                    room.setUserDoor(Room.LEFT, null);
                }
                if (y == 0) {
                    room.setUserDoor(Room.UP, null);
                }
                if (x + 166 >= getWidth()) {
                    room.setUserDoor(Room.RIGHT, null);
                }
                if (y + 110 >= getHeight()) {
                    room.setUserDoor(Room.DOWN, null);
                }
//                System.out.println("room #" + i + ": \nLEFT: " + room.getMyDoorLeft()+"\nRIGHT: " + room.getMyDoorRight()
//                + "\nUP: " + room.getMyDoorUp() + "\nDOWN: " + room.getMyDoorDown());
//                i++;
                //g.drawImage(room.getImage(), x, y, this);
                Drawer.drawRoom(g, room);
                x+= 166;

            }
            y += 110;
        }
        Drawer.drawPlayer(g, maze.getPlayer(), this);
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
                    if (maze.getPlayer().getX() - 166 < 0) {
                        return;
                    }
//                    Question question = maze.doorQuestion(Room.LEFT);
//                    if (question != null) {
//                        QuestionPanel.getInstance().setMyQuestion(question.getQuestion());
//                    }

                    maze.getPlayer().move(-166, 0);
                    break;

                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    if (maze.getPlayer().getX() + 166 > getWidth()) {
                        return;
                    }

//                    Question question = maze.doorQuestion(Room.RIGHT);
//                    if (question != null) {
//                        QuestionPanel.getInstance().setMyQuestion(question.getQuestion());
//                    }
                    maze.getPlayer().move(166, 0);
                    break;

                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    if (maze.getPlayer().getY() - 110 <= 0) {
                        return;
                    }

                    //QuestionPanel.getInstance().setMyQuestion("Going Up!");
                    maze.getPlayer().move(0, -110);
                    break;

                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    if (maze.getPlayer().getY() + 110 >= getHeight()) {
                        return;
                    }

                    //QuestionPanel.getInstance().setMyQuestion("Going Down!");
                    maze.getPlayer().move(0, 110);
                    break;
                default:
                    break;
            }
            repaint();
        }
    }


}
