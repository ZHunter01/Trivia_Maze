/**
 * Trivia Maze TCSS 360 Spring 2021
 */

package view;

import model.Question;
import model.Room;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


/**
 * This class is a panel where the user can enter their answer
 * This is a Singleton class
 *
 * @author Alik Balika
 * @author Oleksandr Maistruk
 */
public class AnswerPanel extends JPanel {
    /**String message for when game is won */
    private final static String WIN_MESSAGE = "You have won the Trivia Maze!";
    /**String message for when game is lost */
    private final static String LOSE_MESSAGE = "GAME OVER. All routes blocked.";
    /**String message for when a question is answered incorrectly */
    private final static String LOCK_MESSAGE = "Answer was incorrect! Door permanently locked!";
    /**String message for when a question is answered correctly */
    private final static String CORRECT_MESSAGE = "Answer was correct! Door unlocked!";
    /**String message for if a room contains a free question */
    private final static String FREE_QUESTION = "You have been awarded a FREE QUESTION PowerUp!"
            + " Use it to skip any question into the next room!";
    private final static String PERMA_UNLOCK = "You have been awarded a PERMA UNLOCK PowerUp!"
            + " Use it to unlock doors that have been Perma-Locked!";
    /**A JLabel that prompts the user to answer the question*/
    private JLabel myAnswerPrompt;
    /** A JTextField object that the user can use to answer the question */
    private JTextField myAnswerField;
    /** The menu for multichoice answers. */
    private JMenuBar myMultiAnswer;
    /** A button that the user can use to submit their answer*/
    private JButton mySubmit;
    /** The player's answer*/
    private String myAnswer;
    /** The direction that the player is facing */
    private int myDirection;
    /** Reference to the maze panel */
    private MazePanel myMazePanel;
    /** Reference to the question panel */
    private QuestionPanel myQuestionPanel;
    /** Reference to the PowerUp menu */
    private PowerUpMenu myPowerUpMenu;

    /**
     * constructs the panel and initializes everything
     */
    public AnswerPanel() {
        setPreferredSize(new Dimension(222, 0));
        setBackground(Color.BLACK);
        myAnswer = "";

    }
    
    /**
     * @return the answer that the user inputed
     */
    public String getAnswer() {
        return myAnswer;
    }
    
    /**
     * @return the answer field
     */
    public JTextField getAnswerField() {
        return myAnswerField;
    }
    
    /**
     * @return the answer prompt
     */
    public JLabel getAnswerPrompt() {
        return myAnswerPrompt;
    }

    /**
     * @return the submit button
     */
    public JButton getSubmit() {
        return mySubmit;
    }

    /**
     * Sets the myAnswer field to theAnswer
     */
    public void setAnswer(final String theAnswer) {
        this.myAnswer = theAnswer;
    }

    /**
     * Displays the components on the JPanel
     * @param theVisibility will display components if set to true
     */
    public void setAnswerPanel(final boolean theVisibility) {

        initAndAddAnswerPrompt(theVisibility);
        initAndAddSubmit(theVisibility);
        initAndAddAnswer(theVisibility);

    }

    /**
     * Sets the power up menu so it can be referenced
     * @param theMenu is the PowerUpMenu
     */
    public void setPowerUpMenu(final PowerUpMenu theMenu) {
        myPowerUpMenu = theMenu;
    }

    /**
     * Action Listener for when user presses submit or chooses an option from the multiple
     * choice buttons. It will check if the user answer was correct as well as play sounds
     * depending on what action the user takes
     */
    public void buttonListener() {
        myAnswer = myAnswerField.getText();

        Room myRoom = myMazePanel.getMaze().getCurrentRoom();

        myMazePanel.getMaze().doorSolution(myAnswer, myDirection);

        if (myRoom.getUserDoor(myDirection).isPermaLocked()) {
            myQuestionPanel.setMyQuestion(LOCK_MESSAGE);
            mySubmit.setVisible(false);

            try {
                File audioFile = new File("resources/music/wrongAnswer3.wav");
                playSound(audioFile);

            } catch (Exception ex) {
                System.out.println(ex);
            }


        } else {
            myQuestionPanel.setMyQuestion(CORRECT_MESSAGE);
            checkForPowerUps();
            try {
                File audioFile = new File("resources/music/correctAnswer1.wav");
                playSound(audioFile);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

        setAnswerPanel(false);

        myMazePanel.repaint();

        myAnswerField.setText("");
        myAnswer = "";

        if (myMazePanel.getMaze().getWin()) {
            myMazePanel.stopGameAudio();

            try {
                File audioFile = new File("resources/music/win.wav");
                playSound(audioFile);

            } catch (Exception ex) {
                System.out.println(ex);
            }
            this.displayWin();
        } else if (myMazePanel.getMaze().getLose()) {
            myMazePanel.stopGameAudio();
            try {
                File audioFile = new File("resources/music/lose.wav");
                playSound(audioFile);

            } catch (Exception ex) {
                System.out.println(ex);
            }
            this.displayLose();
        }
    }

    /**
     * Takes in a file with the given sound and plays the sound.
     * @param theAudioFile the current sound effect
     * @throws UnsupportedAudioFileException
     * @throws IOException
     * @throws LineUnavailableException
     */
    private void playSound(final File theAudioFile) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(theAudioFile);

        AudioFormat format = audioStream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);

        Clip audioClip = (Clip) AudioSystem.getLine(info);

        audioClip.open(audioStream);
        audioClip.start();
    }


    /**
     * initializes the submit button and adds it to the panel
     */
    private void initAndAddSubmit(final boolean theVisibility) {
        if (mySubmit == null) {
            mySubmit = new JButton("SUBMIT");
            mySubmit.setBackground(Color.BLACK);
            mySubmit.setForeground(Color.WHITE);
            mySubmit.setFocusable(theVisibility);
            mySubmit.setPreferredSize(new Dimension(205, 30));
            add(mySubmit);


            mySubmit.addActionListener(e -> buttonListener());

        } else {
            mySubmit.setVisible(theVisibility);
        }

    }

    /**
     * Sets the current direction that the player is facing
     * @param theDirection the direction in which the user is facing
     */
    public void setDirection(final int theDirection) {
        myDirection = theDirection;
    }

    /**
     * Sets the maze panel so it can be referenced
     * @param theMazePanel the MazePanel object that is referenced
     */
    public void setMazePanel(final MazePanel theMazePanel) {
        myMazePanel = theMazePanel;
    }

    /**
     * Sets the questionPanel so it can be referenced
     * @param theQuestionPanel the QuestionPanel object that is referenced
     */
    public void setQuestionPanel(final QuestionPanel theQuestionPanel) {
        myQuestionPanel = theQuestionPanel;
    }

    /**
     * Checks to see if a room contains a power up. Will display to user that power up has been obtained
     * and will activate the power up
     */
    private void checkForPowerUps() {
        if (myMazePanel.getMaze().getCurrentRoom().getRoomPowerUp().isFreeQuestion()) {
            myQuestionPanel.setMyQuestion(FREE_QUESTION);
            myPowerUpMenu.enableFreeQuestion();

        } else if (myMazePanel.getMaze().getCurrentRoom().getRoomPowerUp().isPermaUnlock()) {
            myQuestionPanel.setMyQuestion(PERMA_UNLOCK);
            myPowerUpMenu.enablePermaUnlock();
        }
        myMazePanel.getMaze().getCurrentRoom().removePowerUp();
    }

    /**
     * initializes the JTextField and adds it to the panel. Also depending on if a Question is
     * a Multichoice question or not, it will display a different view of the panel
     */
    private void initAndAddAnswer(final boolean theVisiblity) {
        if (myAnswerField == null) {
            myAnswerField = new JTextField(20);

            add(myAnswerField);
            myAnswerField.setFocusable(false);
            myAnswerField.setVisible(false);
            myAnswerField.setText("");
            myAnswerField.addActionListener(e -> buttonListener());
        }
        if (myMultiAnswer == null) {
            myMultiAnswer = new JMenuBar();
            add(myMultiAnswer);
            myMultiAnswer.setVisible(false);

        }
        if(!Question.getQuestionInstance().isMultiple(myQuestionPanel.getMyQuestionId())) {
            myAnswerField.setVisible(theVisiblity);
            myAnswerField.setFocusable(theVisiblity);
            myAnswerField.setText("");
            myMultiAnswer.setVisible(false);

            if (mySubmit != null) {
                add(mySubmit);
            }
        } else {
            if (mySubmit != null) {
                remove(mySubmit);
            }

            myAnswerField.setVisible(false);
            myMultiAnswer.removeAll();
            JPanel box = new JPanel();

            box.setPreferredSize(new Dimension(200, 200));

            box.setBackground(Color.BLACK);
            box.setForeground(Color.BLACK);

            String multi = Question.getQuestionInstance()
                    .getMultiAnswer(myQuestionPanel.getMyQuestionId());
            int i = 0;
            for (String word : multi.split(",")){

                final JButton btn = new JButton(word.strip());
                btn.setBackground(Color.BLACK);
                btn.setForeground(Color.WHITE);

                btn.addActionListener(e -> {
                    myAnswerField.setText(btn.getText());
                    buttonListener();
                });
                box.add(btn);
                i++;

            }
            box.setLayout(new GridLayout(i, 0));
            myMultiAnswer.add(box);
            myMultiAnswer.setVisible(theVisiblity);
            myMultiAnswer.setFocusable(theVisiblity);

        }

    }

    /**
     * initializes the JLabel prompt and adds it to the panel
     */
    private void initAndAddAnswerPrompt(final boolean theVisiblity) {
        if (myAnswerPrompt == null) {
            myAnswerPrompt = new JLabel("Please enter your answer: ");
            myAnswerPrompt.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
            myAnswerPrompt.setForeground(Color.WHITE);

            add(myAnswerPrompt);
        } else {
            myAnswerPrompt.setVisible(theVisiblity);
        }
    }

    /** Displays a JOptionPane with a win message
     *
     */
    private void displayWin() {
        int result = JOptionPane.showConfirmDialog(null,
                WIN_MESSAGE, "Exit", JOptionPane.DEFAULT_OPTION);
        if (result == JOptionPane.YES_OPTION) System.exit(0);
    }

    /** Displays a JOptionPane with a lose message
     *
     */
    private void displayLose() {
        int result = JOptionPane.showConfirmDialog(null,
                LOSE_MESSAGE, "Exit", JOptionPane.DEFAULT_OPTION);
        if (result == JOptionPane.YES_OPTION) System.exit(0);
    }
}
