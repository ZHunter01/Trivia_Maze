package view;

import controller.Drawer;
import model.Door;
import model.Maze;
import model.Room;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

/**
 * @author Alik Balika
 * This class contains the Maze object and player object and displays the entire maze and where the player will move
 *
 * 
 */
public class MazePanel extends JPanel {
    /** The maze object that contains all of the data */
    private Maze myMaze;

    /** The adapter controls the movement of the player */
    private final TAdapter myAdapter;

    /**
     * background images
     */
    public final static String SPORT_BACKGROUND = "resources/lightStadium.jpg";
    public final static String WORLD_BACKGROUND = "resources/world.png";
    public final static String MUSIC_BACKGROUND = "resources/musicBackground.jpg";
    
    /**
     * music options
     */
    public static final String SPORTS_SONG = "resources/music/gameMusic.wav";
    public static final String GEOGRAPHY_SONG = "resources/music/Geography_Song.wav";
    public static final String MUSIC_SONG = "resources/music/Music_Song.wav";
    
    /** holds the current background image */
    private String myBackgroundImage;
    /** reference to the answer panel */
    private AnswerPanel myAnswerPanel;
    /** reference to the question panel */
    private QuestionPanel myQuestionPanel;
    /** Plays the music in the game */
    private Clip myAudioClip;

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

        this.setMusic(SPORTS_SONG);

        this.setCoordinates();
    }

    /**
     * Sets the coordinates of the Rooms and Doors in the maze object
     */
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
     * sets the volume of the game audio
     * @param theGain the volume level
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
    }
    
    /**
     * sets the background image to a new background image
     * @param thePath the current background
     */
    public void setBackgroundImage(final String thePath) {
        myBackgroundImage = thePath;
    }
    

    /**
     * Sets the current music depending on which category a player chooses
     * @param myMusic the category of music
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
     * @return an instance of the TAdapter that controls the player
     */
    public TAdapter getMyAdapter() {
        return myAdapter;
    }

    /**
     * @return the maze object that the maze panel contains
     */
    public Maze getMaze() {
        return myMaze;
    }

    /**
     * sets the maze of the maze panel (primarily used for serialization)
     * @param theMaze the old maze object with all of its data
     */
    public void setMaze(Maze theMaze) {
        myMaze = theMaze;
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


        for (Room[] rooms : myMaze.getMaze()) {

            for (Room room : rooms) {

                Drawer.drawRoom(g, room);
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
        public void keyPressed(final KeyEvent theEvent) {
            int key = theEvent.getKeyCode();

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
        private void keySwitch(final int theKey) {

            switch (theKey) {

                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
                    if (!myMaze.isInBounds(Room.LEFT)) {
                        myQuestionPanel.setMyQuestion("You cannot move there!");
                        return;
                    }
                    
                    myMaze.setDirection(Room.LEFT);
                    retrieveQuestion(Room.LEFT);
                    break;

                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    if (!myMaze.isInBounds(Room.RIGHT)) {
                        myQuestionPanel.setMyQuestion("You cannot move there!");
                        return;
                    }

                    myMaze.setDirection(Room.RIGHT);
                    retrieveQuestion(Room.RIGHT);
                    break;

                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    if (!myMaze.isInBounds(Room.UP)) {
                        myQuestionPanel.setMyQuestion("You cannot move there!");
                        return;
                    }

                    myMaze.setDirection(Room.UP);
                    retrieveQuestion(Room.UP);
                    break;

                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    if (!myMaze.isInBounds(Room.DOWN)) {
                        myQuestionPanel.setMyQuestion("You cannot move there!");
                        return;
                    }

                    myMaze.setDirection(Room.DOWN);
                    retrieveQuestion(Room.DOWN);
                    break;

                default:
                    break;
            }
            repaint();
        }
        
        /**
         * gets the questions and updates the gui to display the question as well as the AnswerPanel. Checks if
         * the user is correct or incorrect.
         *
         * @param theDir the direction that the player is moving in
         */
        private void retrieveQuestion(int theDir) {
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
        }
    }

    /**
     * returns the reference to the answer panel
     */
    public AnswerPanel getAnswerPanel() {
        return myAnswerPanel;
    }
}
