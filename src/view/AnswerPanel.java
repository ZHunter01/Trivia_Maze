

/**
 * Trivia Maze TCSS 360 Spring 2021
 */

package view;

import model.Maze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

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

    public void setAnswerPanel() {

        initAndAddAnswerPrompt();
        initAndAddAnswer();
        initAndAddSubmit();
    }

    public void setPowerUpMenu(final PowerUpMenu theMenu) {
        myPowerUpMenu = theMenu;
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
    /**
     * initializes the submit button and adds it to the panel
     */
    private void initAndAddSubmit() {
        if (mySubmit == null) {
            mySubmit = new JButton("SUBMIT");
            mySubmit.setBackground(Color.BLACK);
            mySubmit.setForeground(Color.WHITE);
            mySubmit.setFocusable(false);
            mySubmit.setPreferredSize(new Dimension(205, 30));
            add(mySubmit);


            mySubmit.addActionListener(e -> actionListener());
//                myAnswer = myAnswerField.getText();
//
//                myMaze.doorSolution(myAnswer, myDirection);
//
//                if (myMaze.getCurrentRoom().getUserDoor(myDirection).isPermaLocked()) {
//                    myQuestionPanel.setMyQuestion(LOCK_MESSAGE);
//                } else {
//                    myQuestionPanel.setMyQuestion(CORRECT_MESSAGE);
//                }
//                
//                myAnswerField.setVisible(false);
//                mySubmit.setVisible(false);
//                myAnswerPrompt.setVisible(false);
//
//                myMazePanel.repaint();
//
//                myAnswerField.setText("");
//                myAnswer = "";

//                if (myMaze.getWin()) {
//                    this.displayWin();
//                } else if (myMaze.getLose()) {
//                    this.displayLose();
//                }
//                
//                checkForPowerUps();
                
               // System.out.println("Answer: " + myAnswer);

            myAnswerField.addActionListener(e -> myAnswer = myAnswerField.getText());

        } else {
            mySubmit.setVisible(true);
        }

    }

    public void setMaze(final Maze theMaze) {
        myMaze = theMaze;
    }
    
    public Maze getMaze() {
        return myMaze;
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
    private void initAndAddAnswer() {
        if (myAnswerField == null) {
            myAnswerField = new JTextField(20);

            add(myAnswerField);
            myAnswerField.setFocusable(true);
            myAnswerField.addActionListener(e -> actionListener());
        } else {
            myAnswerField.setVisible(true);
            myAnswerField.setFocusable(true);
            myAnswerField.setText("");
        }
//        myAnswerField = new JTextField(20);
//
//        add(myAnswerField);
        
    }

    /**
     * initializes the JLabel prompt and adds it to the panel
     */
    private void initAndAddAnswerPrompt() {
        if (myAnswerPrompt == null) {
            myAnswerPrompt = new JLabel("Please enter your answer: ");
            myAnswerPrompt.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));

            add(myAnswerPrompt);
        } else {
            myAnswerPrompt.setVisible(true);
        }
    }
  
    private void actionListener() {
        myAnswer = myAnswerField.getText();

        myMaze.doorSolution(myAnswer, myDirection);

        if (myMaze.getCurrentRoom().getUserDoor(myDirection).isPermaLocked()) {
            myQuestionPanel.setMyQuestion("Answer was incorrect! Door permanently locked!");
        } else {
            myQuestionPanel.setMyQuestion("Answer was correct! Door unlocked!");
        }

//        if (myMaze.getWin()) {
//            this.displayWin();
//        } else if (myMaze.getLose()) {
//            this.displayLose();
//        }

        myAnswerField.setVisible(false);
        mySubmit.setVisible(false);
        myAnswerPrompt.setVisible(false);

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
        System.out.println("Answer: " + myAnswer);
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
