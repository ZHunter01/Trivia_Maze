/**
 * Trivia Maze TCSS 360 Spring 2021
 */

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.Maze;
import model.Question;

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
            + " Use it to skip ay quesiton into the next room!";
    private final static String PERMA_UNLOCK = "You have been awarded a PERMA UNLOCK PowerUp!"
            + " Use it to unlock doors that have been Perma-Locked!";
    /**
     * The serial number
     */
    private static final long serialVersionUID = 7889243050424110037L;

    /**
     * A JLabel that prompts the user to answer the question
     */
    private JLabel myAnswerPrompt;
    /**
     * A JTextField object that the user can use to answer the question
     */
    private JTextField myAnswerField;

    /** The menu for multichoice answers. */
    private JMenuBar myMultiAnswer;

    /**
     * A button that the user can use to submit their answer
     */
    private JButton mySubmit;

    /**
     * The player's answer
     */
    private transient String myAnswer;

    private Maze myMaze;

    private int myDirection;

    private MazePanel myMazePanel;

    private QuestionPanel myQuestionPanel;

    private PowerUpMenu myPowerUpMenu;

//    /**
//     * Create an instance of the AnswerPanel
//     */
//    private static final AnswerPanel answerPanel = new AnswerPanel();

    /**
     * constructs the panel and initializes everything
     */
    public AnswerPanel() {
        setPreferredSize(new Dimension(222, 0));
        setBackground(new Color(98, 0, 134));
        myAnswer = "";
//        initAndAddAnswerPrompt();
//        initAndAddAnswer();
//        initAndAddSubmit();
    }

    public void setAnswerPanel(final boolean theVisibility) {

        initAndAddAnswerPrompt(theVisibility);
//        if(Question.getQuestionInstance().isMultiple(myQuestionPanel.getMyQuestionId())) {
//
//        }
        initAndAddAnswer(theVisibility);
        initAndAddSubmit(theVisibility);
    }

    public void setPowerUpMenu(final PowerUpMenu theMenu) {
        myPowerUpMenu = theMenu;
    }


    /**
     * initializes the submit button and adds it to the panel
     */
    private void initAndAddSubmit(final boolean theVicible) {
        if (mySubmit == null) {
            mySubmit = new JButton("SUBMIT");
            mySubmit.setBackground(Color.BLACK);
            mySubmit.setForeground(Color.WHITE);
            mySubmit.setFocusable(theVicible);
            mySubmit.setPreferredSize(new Dimension(205, 30));
            add(mySubmit);


            mySubmit.addActionListener(e -> {
//                if(!Question.getQuestionInstance().isMultiple(myQuestionPanel.getMyQuestionId())) {
                myAnswer = myAnswerField.getText();
//                } else {

//                }
                myMaze.doorSolution(myAnswer, myDirection);

                if (myMaze.getCurrentRoom().getUserDoor(myDirection).isPermaLocked()) {
                    myQuestionPanel.setMyQuestion("Answer was incorrect! Door permanently locked!");
                } else {
                    myQuestionPanel.setMyQuestion("Answer was correct! Door unlocked!");
                }

//                if (myMaze.getWin()) {
//                    this.displayWin();
//                } else if (myMaze.getLose()) {
//                    this.displayLose();
//                }

//                myAnswerField.setVisible(false);
//                mySubmit.setVisible(false);
//                myAnswerPrompt.setVisible(false);
                setAnswerPanel(false);

                myMazePanel.repaint();

                myAnswerField.setText("");
                myAnswer = "";

                if (myMaze.getWin()) {
                    this.displayWin();
                } else if (myMaze.getLose()) {
                    this.displayLose();
                }
                
                checkForPowerUps();
                
                //if (!myAnswer.equals("")) myAnswerField.setFocusable(false);
                System.out.println("Answer23: " + myAnswer);
            });

            myAnswerField.addActionListener(e -> myAnswer = myAnswerField.getText());

        } else {
            mySubmit.setVisible(theVicible);
        }

    }

    public void setMaze(final Maze theMaze) {
        myMaze = theMaze;
    }

    public void setDirection(final int theDirection) {
        myDirection = theDirection;
    }

    public void setMazePanel(final MazePanel theMazePanel) {
        myMazePanel = theMazePanel;
    }

    public void setQuestionPanel(final QuestionPanel theQuestionPanel) {
        myQuestionPanel = theQuestionPanel;
    }

    /**
     *
     */
    private void checkForPowerUps() {
        if (myMaze.getCurrentRoom().getRoomPowerUp().isFreeQuestion()) {
            myQuestionPanel.setMyQuestion(FREE_QUESTION);
            myPowerUpMenu.enableFreeQuestion();

        } else if (myMaze.getCurrentRoom().getRoomPowerUp().isPermaUnlock()) {
            myQuestionPanel.setMyQuestion(PERMA_UNLOCK);
            myPowerUpMenu.enablePermaUnlock();
        }

    }

    /**
     * initializes the JTextField and adds it to the panel
     */
    private void initAndAddAnswer(final boolean theVicible) {
        if (myAnswerField == null) {
            myAnswerField = new JTextField(20);

            add(myAnswerField);
            myAnswerField.setFocusable(false);
            myAnswerField.setVisible(false);
            myAnswerField.setText("");
        }
        if (myMultiAnswer == null) {
            myMultiAnswer = new JMenuBar();
            add(myMultiAnswer);
            myMultiAnswer.setVisible(false);
//            myMultiAnswer.setBackground(new Color(98, 0, 134));

        }
        if(!Question.getQuestionInstance().isMultiple(myQuestionPanel.getMyQuestionId())) {
            myAnswerField.setVisible(theVicible);
            myAnswerField.setFocusable(theVicible);
            myAnswerField.setText("");

        } else {

            myMultiAnswer.removeAll();
            Box box = Box.createVerticalBox();
            String multi = Question.getQuestionInstance()
                    .getMultiAnswer(myQuestionPanel.getMyQuestionId());

            for (String word : multi.split(",")){
                final JRadioButton btn = new JRadioButton(word.strip());
//                btn.setBackground(new Color(98, 0, 134));
                btn.addActionListener(e -> {
                    myAnswerField.setText(btn.getText());
                });
                box.add(btn);
                myMultiAnswer.add(box);

            }
//            box.setLayout(new GridLayout(9, 1));
            myMultiAnswer.setVisible(theVicible);
            myMultiAnswer.setFocusable(theVicible);
        }

    }

    /**
     * initializes the JLabel prompt and adds it to the panel
     */
    private void initAndAddAnswerPrompt(final boolean theVicible) {
        if (myAnswerPrompt == null) {
            myAnswerPrompt = new JLabel("Please enter your answer: ");
            myAnswerPrompt.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));

            add(myAnswerPrompt);
        } else {
            myAnswerPrompt.setVisible(theVicible);
        }
    }

    /**
     * @return the answer that the user inputed
     */
    public String getMyAnswer() {
        return myAnswer;
    }

    public JTextField getAnswerField() {
        return myAnswerField;
    }

    public JLabel getAnswerPrompt() {
        return myAnswerPrompt;
    }

    public JButton getSubmit() {
        return mySubmit;
    }

    public void setMyAnswer(final String myAnswer) {
        this.myAnswer = myAnswer;
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