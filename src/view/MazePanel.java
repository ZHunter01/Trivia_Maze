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
 * This is a Singleton class
 */
public class MazePanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = -2890387412303301149L;

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
    public final static String SPORT_BACKGROUND = "resources/lightStadium.jpg";
    public final static String WORLD_BACKGROUND = "resources/world.png";
    public final static String MUSIC_BACKGROUND = "resources/music.png";
    
    public static final String SPORTS_SONG = "resources/music/gameMusic.wav";
    public static final String GEOGRAPHY_SONG = "resources/music/Geography_Song.wav";
    public static final String MUSIC_SONG = "resources/music/Music_Song.wav";
    
    private String myBackgroundImage;
    
//    /**
//     * Create an instance of the MazePanel
//     */
//    private static final MazePanel mazePanel = new MazePanel();

    private AnswerPanel myAnswerPanel;
    private QuestionPanel myQuestionPanel;
    private Clip myAudioClip;

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
        myAnswerPanel.setMazePanel(this);
        myAnswerPanel.setQuestionPanel(myQuestionPanel);

        myBackgroundImage = SPORT_BACKGROUND;

        this.setMusic(SPORTS_SONG);

    }

    /**
     * 
     * @param theGain
     */
    public void setVolume(final int theGain) {
        FloatControl gainControl = (FloatControl) myAudioClip.getControl(FloatControl.Type.MASTER_GAIN);
        double gain = ((double)theGain)/10.0;
        float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
        gainControl.setValue(dB);
    }

    /**
     * 
     */
    public void stopGameAudio() {
        myAudioClip.stop();
    }
    
    /**
     * 
     * @param thePath
     */
    public void setBackgroundImage(final String thePath) {
        myBackgroundImage = thePath;
    }
    

    /*
     * 
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
     * Draws all of the GameObjects onto the panel
     *
     * @param g the Graphics drawer
     */
    @Override
    protected void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);

        Image ii = Toolkit.getDefaultToolkit().getImage(myBackgroundImage);
        theGraphics.drawImage(ii, 0, 0, this);
        int y = 0;
        for (Room[] rooms : maze.getMaze()) {
            int x = 0;
            for (Room room : rooms) {
                room.setX(x);
                room.setY(y);

                Drawer.drawRoom(theGraphics, room);
                x += 166;

            }
            y += 110;
        }
        Drawer.drawPlayer(theGraphics, maze.getPlayer(), this);
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
                    if (!maze.isInBounds(Room.LEFT)) {
                        return;
                    }
                    
                    maze.setDirection(Room.LEFT);
                    retrieveQuestion(Room.LEFT);
                    break;

                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    if (!maze.isInBounds(Room.RIGHT)) {
                        return;
                    }

                    maze.setDirection(Room.RIGHT);
                    retrieveQuestion(Room.RIGHT);
                    break;

                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    if (!maze.isInBounds(Room.UP)) {
                        return;
                    }

                    maze.setDirection(Room.UP);
                    retrieveQuestion(Room.UP);
                    break;

                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    if (!maze.isInBounds(Room.DOWN)) {
                        return;
                    }

                    maze.setDirection(Room.DOWN);
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
                myAnswerPanel.setAnswerPanel(false);
                return;
            }

            myAnswerPanel.setDirection(theDir);

            System.out.println("in mazePanel: " + myDoor.getQuestion());
            if (!myAnswerPanel.getAnswer().equalsIgnoreCase("")) {
                System.out.println("Entered if statement");

            }
        }
    }

    public AnswerPanel getAnswerPanel() {
        return myAnswerPanel;
    }
}