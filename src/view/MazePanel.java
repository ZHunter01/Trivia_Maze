package view;

import controller.Drawer;
import model.Door;
import model.Maze;
import model.Room;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

/**
 * @author Alik Balika
 * This class contains the Maze object and player object and displays the entire maze and where the player will move
 *
 */
public class MazePanel extends JPanel {

    /**
     * The maze object that contains all of the data
     */
    private Maze myMaze;

    /**
     * The adapter controls the movement of the player
     */
    private final TAdapter myAdapter;

    /**
     * background images
     */
    public final static String SPORT_BACKGROUND = "src/resources/lightStadium.jpg";
    public final static String WORLD_BACKGROUND = "src/resources/world.png";
    public final static String MUSIC_BACKGROUND = "src/resources/musicBackground.jpg";

    /**
     * music options
     */
    public static final String SPORTS_SONG = "src/resources/music/gameMusic.wav";
    public static final String GEOGRAPHY_SONG = "src/resources/music/Geography_Song.wav";
    public static final String MUSIC_SONG = "src/resources/music/Music_Song.wav";

    /**
     * holds the current background image
     */
    private String myBackgroundImage;

    /**
     * Plays the music in the game
     */
    private Clip myAudioClip;

    /**
     * reference to the answer panel
     */
    private final AnswerPanel myAnswerPanel;

    /**
     * reference to the question panel
     */
    private final QuestionPanel myQuestionPanel;


    /**
     * initializes the maze and constructs the panel
     */
    public MazePanel(final AnswerPanel theAnswerPanel, final QuestionPanel theQuestionPanel) {

        myAdapter = new TAdapter();
        setFocusable(true);
        myMaze = new Maze();
        addKeyListener(myAdapter);

        myAnswerPanel = theAnswerPanel;
        myQuestionPanel = theQuestionPanel;
        myAnswerPanel.setMazePanel(this);
        myAnswerPanel.setQuestionPanel(myQuestionPanel);

        myBackgroundImage = SPORT_BACKGROUND;

        setMusic(SPORTS_SONG);

        setCoordinates();

    }

    private void setCoordinates() {
        // x and y are the coordinates that the rooms use to be drawn onto the panel
        int y = 0;
        for (Room[] rooms : myMaze.getMaze()) {
            int x = 0;
            for (Room room : rooms) {
                room.setX(x);
                room.setY(y);
                room.getUserDoor(Room.RIGHT).setX(room.getX() + 161);
                room.getUserDoor(Room.RIGHT).setY(room.getY() + 20);
                room.getUserDoor(Room.LEFT).setX(room.getX());
                room.getUserDoor(Room.LEFT).setY(room.getY() + 20);
                room.getUserDoor(Room.DOWN).setX(room.getX() + 50);
                room.getUserDoor(Room.DOWN).setY(room.getY() + 105);
                room.getUserDoor(Room.UP).setX(room.getX() + 50);
                room.getUserDoor(Room.UP).setY(room.getY());

                // 166 is a the width of a room
                x += 166;

            }
            // 110 is the height of a room
            y += 110;
        }
    }

    /**
     * Sets the current music depending on which category a player chooses
     * @param myMusic
     */
    public void setMusic(final String myMusic) {
        try {
            File audioFile = new File(myMusic);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);

            myAudioClip = (Clip) AudioSystem.getLine(info);

            myAudioClip.open(audioStream);
            myAudioClip.start();

            setVolume(MyMenuBar.myVolumeBar.getValue());

            myAudioClip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * sets the volume of the game audio
     * @param theGain
     */
    public void setVolume(final int theGain) {
        FloatControl gainControl = (FloatControl) myAudioClip.getControl(FloatControl.Type.MASTER_GAIN);
        double gain = ((double)theGain)/10.0;
        float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
        gainControl.setValue(dB);
    }

    /**
     * stops the game audio
     */
    public void stopGameAudio() {
        myAudioClip.stop();
        myAudioClip.close();
    }

    // height of panel: 440
    // width of panel: 664

    /**
     * sets the background image to a new background image
     * @param thePath
     */
    public void setBackgroundImage(final String thePath) {
        myBackgroundImage = thePath;
    }

    /**
     * sets the maze of the maze panel (primarily used for serialization)
     * @param theMaze
     */
    public void setMaze(final Maze theMaze) {
        myMaze = theMaze;
    }

    /**
     * @return an instance of the TAdapter that controls the player
     */
    public TAdapter getMyAdapter() {
        return myAdapter;
    }

    /**
     * @return the reference to the answer panel
     */
    public AnswerPanel getAnswerPanel() {
        return myAnswerPanel;
    }

    /**
     * @return the maze object that the maze panel contains
     */
    public Maze getMaze() {
        return myMaze;
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

        System.out.println("PAINT COMPONENT METHOD");
        int i = 1;

        for (Room[] rooms : myMaze.getMaze()) {

            for (Room room : rooms) {

                System.out.println("Room #" + i+": " + room.getX()+"," + room.getY() );
                System.out.println("RIGHT: " + room.getUserDoor(Room.RIGHT).getX()+","+room.getUserDoor(Room.RIGHT).getY() + room.getUserDoor(Room.RIGHT).isLocked());
                System.out.println("LEFT: " + room.getUserDoor(Room.LEFT).getX()+","+room.getUserDoor(Room.LEFT).getY() + room.getUserDoor(Room.LEFT).isLocked());
                System.out.println("UP: " + room.getUserDoor(Room.UP).getX()+","+room.getUserDoor(Room.UP).getY() + room.getUserDoor(Room.UP).isLocked());
                System.out.println("DOWN: " + room.getUserDoor(Room.DOWN).getX()+","+room.getUserDoor(Room.DOWN).getY() + room.getUserDoor(Room.DOWN).isLocked());
                System.out.println();
                Drawer.drawRoom(g, room);
                i++;
            }
        }

        Drawer.drawPlayer(g, myMaze.getPlayer(), this);
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
         * @param theKey the code of the button that the user pressed
         */
        private void keySwitch(final int theKey) {

            switch (theKey) {

                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
                    if (!myMaze.isInBounds(Room.LEFT)) {
                        myQuestionPanel.setMyQuestion("You cannot move there!");
                        return;
                    }

                    retrieveQuestion(Room.LEFT);
                    break;

                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    if (!myMaze.isInBounds(Room.RIGHT)) {
                        myQuestionPanel.setMyQuestion("You cannot move there!");
                        return;
                    }

                    retrieveQuestion(Room.RIGHT);
                    break;

                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    if (!myMaze.isInBounds(Room.UP)) {
                        myQuestionPanel.setMyQuestion("You cannot move there!");
                        return;
                    }

                    retrieveQuestion(Room.UP);
                    break;

                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    if (!myMaze.isInBounds(Room.DOWN)) {
                        myQuestionPanel.setMyQuestion("You cannot move there!");
                        return;
                    }

                    retrieveQuestion(Room.DOWN);
                    break;

                default:
                    break;
            }
            System.out.println("(" + myMaze.getXCount() + "," + myMaze.getYCount() + ")");
            repaint();
        }

        /**
         * gets the questions and updates the gui to display the question as well as the AnswerPanel. Checks if
         * the user is correct or incorrect.
         *
         * @param theDir
         */
        private void retrieveQuestion(final int theDir) {
            Room myRoom = myMaze.getCurrentRoom();
            Door myDoor = myRoom.getUserDoor(theDir);
            myQuestionPanel.setMyQuestion(myDoor.getQuestion());
            myQuestionPanel.setMyQuestionId(myDoor.getId());
            myAnswerPanel.setAnswerPanel(true);

            if (myDoor.isPermaLocked()) {
                myQuestionPanel.setMyQuestion("That door is permanently locked!");
                myAnswerPanel.setAnswerPanel(false);
                return;
            }

            myAnswerPanel.setDirection(theDir);

            System.out.println("in mazePanel: " + myDoor.getQuestion());
            if (!myAnswerPanel.getMyAnswer().equalsIgnoreCase("")) {
                System.out.println("Entered if statement");

            }
        }
    }
}
