package view;

import controller.Drawer;
import model.Door;
import model.Maze;
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
    private Maze maze;

    /**
     * The adapter controls the movement of the player
     */
    private final TAdapter myAdapter;

    /**
     * background images
     */
    public final static String SPORT_BACKGROUND = "src/resources/seaStadium.jpg";
    public final static String WORLD_BACKGROUND = "src/resources/world.png";

    private String myBackgroundImage;

//    /**
//     * Create an instance of the MazePanel
//     */
//    private static final MazePanel mazePanel = new MazePanel();

    private AnswerPanel myAnswerPanel;
    private QuestionPanel myQuestionPanel;


    /**
     * initializes the maze and constructs the panel
     */
    public MazePanel(final AnswerPanel theAnswerPanel, final QuestionPanel theQuestionPanel) {

        myAdapter = new TAdapter();
        setFocusable(true);
        maze = new Maze();
        addKeyListener(myAdapter);

        myAnswerPanel = theAnswerPanel;
        myQuestionPanel = theQuestionPanel;
        myAnswerPanel.setMaze(maze);
        myAnswerPanel.setMazePanel(this);
        myAnswerPanel.setQuestionPanel(myQuestionPanel);

        myBackgroundImage = SPORT_BACKGROUND;

    }

//    /**
//     * @return the only instance of mazePanel
//     */
//    public static MazePanel getInstance() {
//        return mazePanel;
//    }

    //166 - width of the room
    //110 - height of the room


    // height of panel: 440
    // width of panel: 664

    public void setBackgroundImage(String path) {
        myBackgroundImage = path;
    }

    /**
     * Draws all of the GameObjects onto the panel
     *
     * @param g the Graphics drawer
     */
    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);

        Image ii = Toolkit.getDefaultToolkit().getImage(myBackgroundImage);
        g.drawImage(ii, 0, 0, this);
        int y = 0;
        for (Room[] rooms : maze.getMaze()) {
            int x = 0;
            for (Room room : rooms) {
                room.setX(x);
                room.setY(y);

                Drawer.drawRoom(g, room);
                x += 166;

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

    public Maze getMaze() {
        return maze;
    }

    public void setMaze(Maze theMaze) {
        maze = theMaze;
    }

    /**
     * This class handles the movement of the player object
     */
    public class TAdapter extends KeyAdapter {

        /**
         * handles the button that the user pressed
         *
         * @param e the KeyEvent
         */
        @Override
        public void keyPressed(final KeyEvent e) {
            int key = e.getKeyCode();

            keySwitch(key);
        }

        /**
         * handles the button that the user pressed. Used for the button actionListeners in DirectionPanel
         *
         * @param theKey the KeyEvent
         */
        public void keyPressed(final int theKey) {
            keySwitch(theKey);
        }

        /**
         * Chooses the direction that the player object will move in as well as does not allow user to go
         * out of bounds
         *
         * @param key the code of the button that the user pressed
         */
        private void keySwitch(final int key) {

            switch (key) {

                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
                    if (!maze.isInBounds(Room.LEFT)) {
                        return;
                    }

                    retrieveQuestion(Room.LEFT);
                    break;

                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    if (!maze.isInBounds(Room.RIGHT)) {
                        return;
                    }

                    retrieveQuestion(Room.RIGHT);
                    break;

                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    if (!maze.isInBounds(Room.UP)) {
                        return;
                    }

                    retrieveQuestion(Room.UP);
                    break;

                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    if (!maze.isInBounds(Room.DOWN)) {
                        return;
                    }

                    retrieveQuestion(Room.DOWN);
                    break;

                default:
                    break;
            }
            System.out.println("(" + maze.getXCount() + "," + maze.getYCount() + ")");
            System.out.println(maze.getWin());
            repaint();
        }

        /**
         * gets the questions and updates the gui to display the question as well as the AnswerPanel. Checks if
         * the user is correct or incorrect.
         *
         * @param theDir
         */
        private void retrieveQuestion(int theDir) {
            Room myRoom = maze.getCurrentRoom();
            Door myDoor = myRoom.getUserDoor(theDir);
            myQuestionPanel.setMyQuestion(myDoor.getQuestion());
            myQuestionPanel.setMyQuestionId(myDoor.getId());
            myAnswerPanel.setAnswerPanel(true);

            if (myDoor.isPermaLocked()) {
                myQuestionPanel.setMyQuestion("That door is permanently locked!");
//                myAnswerPanel.getAnswerField().setVisible(false);
//                myAnswerPanel.getSubmit().setVisible(false);
//                myAnswerPanel.getAnswerPrompt().setVisible(false);
                myAnswerPanel.setAnswerPanel(false);
                return;
            }

//            myAnswerPanel.getAnswerField().setFocusable(true);
            myAnswerPanel.setDirection(theDir);

            System.out.println("in mazePanel: " + myDoor.getQuestion());
            if (!myAnswerPanel.getMyAnswer().equalsIgnoreCase("")) {
                System.out.println("Entered if statement");

            }

//        private void retrieveQuestion(final int theDir) {
//            Room myRoom = maze.getCurrentRoom();
//            Door myDoor = myRoom.getUserDoor(theDir);
//            myQuestionPanel.setMyQuestion(myDoor.getQuestion());
//            myQuestionPanel.setMyQuestionId(myDoor.getId());
//            myAnswerPanel.setAnswerPanel(true);
//
//            if (myDoor.isPermaLocked()) {
//                myQuestionPanel.setMyQuestion("That door is permanently locked!");
//                myAnswerPanel.getAnswerField().setVisible(false);
//                myAnswerPanel.getSubmit().setVisible(false);
//                myAnswerPanel.getAnswerPrompt().setVisible(false);
//                return;
//            }
//
//            myAnswerPanel.getAnswerField().setFocusable(true);
//            myAnswerPanel.setDirection(theDir);
//
//            System.out.println("in mazePanel: " + myDoor.getQuestion());
//        }
        }
    }
}
