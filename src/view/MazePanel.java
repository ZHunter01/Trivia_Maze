<<<<<<< HEAD


=======
>>>>>>> zach_branch
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
     * 
     */
<<<<<<< HEAD
    private static final long serialVersionUID = -4675791810380683974L;
=======
    private static final long serialVersionUID = -2890387412303301149L;
>>>>>>> zach_branch

    /**
     * The maze object that contains all of the data
     */
<<<<<<< HEAD
    private Maze myMaze;
=======
    private Maze maze;
>>>>>>> zach_branch

    /**
     * The adapter controls the movement of the player
     */
    private final TAdapter myAdapter;

<<<<<<< HEAD
=======
    /**
     * background images
     */
    public final static String SPORT_BACKGROUND = "resources/seaStadium.jpg";
    public final static String WORLD_BACKGROUND = "resources/world.png";

    private String myBackgroundImage;

>>>>>>> zach_branch
//    /**
//     * Create an instance of the MazePanel
//     */
//    private static final MazePanel mazePanel = new MazePanel();

    private AnswerPanel myAnswerPanel;
    private QuestionPanel myQuestionPanel;

<<<<<<< HEAD
    private String myBackgroundImage;

    /**
     * background images
     */
    public final static String SPORT_BACKGROUND = "resources/seaStadium.jpg";
    public final static String WORLD_BACKGROUND = "resources/world.png";
    
    
    /**
=======

    /**
>>>>>>> zach_branch
     * initializes the maze and constructs the panel
     */
    public MazePanel(final AnswerPanel theAnswerPanel, final QuestionPanel theQuestionPanel) {

        myAdapter = new TAdapter();
        setFocusable(true);
<<<<<<< HEAD
        myMaze = new Maze();
=======
        maze = new Maze();
>>>>>>> zach_branch
        addKeyListener(myAdapter);

        myAnswerPanel = theAnswerPanel;
        myQuestionPanel = theQuestionPanel;
<<<<<<< HEAD
        myAnswerPanel.setMaze(myMaze);
        myAnswerPanel.setMazePanel(this);
        myAnswerPanel.setQuestionPanel(myQuestionPanel);

        
        myBackgroundImage = SPORT_BACKGROUND;
    }

    /** Get MazePanel's current Maze object
     * 
     * @return
     */
    Maze getMaze() {
        return myMaze;
    }

    public void setBackgroundImage(final String path) {
        myBackgroundImage = path;
    }
    
    /** Sets the Maze object to the input maze
     * 
     * @param theMaze
     */
    public void setMaze(final Maze theMaze) {
        myMaze = theMaze;
    }
=======
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
>>>>>>> zach_branch

    //166 - width of the room
    //110 - height of the room


    // height of panel: 440
    // width of panel: 664

<<<<<<< HEAD
    /**
     * Draws all of the GameObjects onto the panel
=======
    public void setBackgroundImage(String path) {
        myBackgroundImage = path;
    }

    /**
     * Draws all of the GameObjects onto the panel
     *
>>>>>>> zach_branch
     * @param g the Graphics drawer
     */
    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);

        Image ii = Toolkit.getDefaultToolkit().getImage(myBackgroundImage);
        g.drawImage(ii, 0, 0, this);
        int y = 0;
<<<<<<< HEAD
        for (Room[] rooms : myMaze.getMaze()) {
=======
        for (Room[] rooms : maze.getMaze()) {
>>>>>>> zach_branch
            int x = 0;
            for (Room room : rooms) {
                room.setX(x);
                room.setY(y);

                Drawer.drawRoom(g, room);
<<<<<<< HEAD
                x+= 166;
=======
                x += 166;
>>>>>>> zach_branch

            }
            y += 110;
        }
<<<<<<< HEAD
        Drawer.drawPlayer(g, myMaze.getPlayer(), this);
=======
        Drawer.drawPlayer(g, maze.getPlayer(), this);
>>>>>>> zach_branch
    }

    /**
     * @return an instance of the TAdapter that controls the player
     */
    public TAdapter getMyAdapter() {
        return myAdapter;
    }

<<<<<<< HEAD
=======
    public Maze getMaze() {
        return maze;
    }

    public void setMaze(Maze theMaze) {
        maze = theMaze;
    }

>>>>>>> zach_branch
    /**
     * This class handles the movement of the player object
     */
    public class TAdapter extends KeyAdapter {

        /**
         * handles the button that the user pressed
<<<<<<< HEAD
=======
         *
>>>>>>> zach_branch
         * @param e the KeyEvent
         */
        @Override
        public void keyPressed(final KeyEvent e) {
            int key = e.getKeyCode();

            keySwitch(key);
        }

        /**
         * handles the button that the user pressed. Used for the button actionListeners in DirectionPanel
<<<<<<< HEAD
=======
         *
>>>>>>> zach_branch
         * @param theKey the KeyEvent
         */
        public void keyPressed(final int theKey) {
            keySwitch(theKey);
        }
<<<<<<< HEAD
        
        /**
         * Chooses the direction that the player object will move in as well as does not allow user to go
         * out of bounds
=======

        /**
         * Chooses the direction that the player object will move in as well as does not allow user to go
         * out of bounds
         *
>>>>>>> zach_branch
         * @param key the code of the button that the user pressed
         */
        private void keySwitch(final int key) {

            switch (key) {

                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
<<<<<<< HEAD
                    if (!myMaze.isInBounds(Room.LEFT)) {
=======
                    if (!maze.isInBounds(Room.LEFT)) {
>>>>>>> zach_branch
                        return;
                    }

                    retrieveQuestion(Room.LEFT);
                    break;

                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
<<<<<<< HEAD
                    if (!myMaze.isInBounds(Room.RIGHT)) {
=======
                    if (!maze.isInBounds(Room.RIGHT)) {
>>>>>>> zach_branch
                        return;
                    }

                    retrieveQuestion(Room.RIGHT);
                    break;

                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
<<<<<<< HEAD
                    if (!myMaze.isInBounds(Room.UP)) {
=======
                    if (!maze.isInBounds(Room.UP)) {
>>>>>>> zach_branch
                        return;
                    }

                    retrieveQuestion(Room.UP);
                    break;

                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
<<<<<<< HEAD
                    if (!myMaze.isInBounds(Room.DOWN)) {
=======
                    if (!maze.isInBounds(Room.DOWN)) {
>>>>>>> zach_branch
                        return;
                    }

                    retrieveQuestion(Room.DOWN);
                    break;

                default:
                    break;
            }
<<<<<<< HEAD
            System.out.println("(" + myMaze.getXCount() + "," + myMaze.getYCount() + ")");
            repaint();
        }

        private void retrieveQuestion(final int theDir) {
            Room myRoom = myMaze.getCurrentRoom();
            Door myDoor = myRoom.getUserDoor(theDir);
            myQuestionPanel.setMyQuestion(myDoor.getQuestion());
=======
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
>>>>>>> zach_branch
            myAnswerPanel.setAnswerPanel(true);

            if (myDoor.isPermaLocked()) {
                myQuestionPanel.setMyQuestion("That door is permanently locked!");
<<<<<<< HEAD
                myAnswerPanel.getAnswerField().setVisible(false);
                myAnswerPanel.getSubmit().setVisible(false);
                myAnswerPanel.getAnswerPrompt().setVisible(false);
=======
//                myAnswerPanel.getAnswerField().setVisible(false);
//                myAnswerPanel.getSubmit().setVisible(false);
//                myAnswerPanel.getAnswerPrompt().setVisible(false);
>>>>>>> zach_branch
                myAnswerPanel.setAnswerPanel(false);
                return;
            }

<<<<<<< HEAD
            myAnswerPanel.getAnswerField().setFocusable(true);
            myAnswerPanel.setDirection(theDir);

            System.out.println("in mazePanel: " + myDoor.getQuestion());

        }
    }
}
=======
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
>>>>>>> zach_branch
