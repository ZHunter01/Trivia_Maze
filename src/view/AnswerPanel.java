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

//    /**
//     * Create an instance of the AnswerPanel
//     */
//    private static final AnswerPanel answerPanel = new AnswerPanel();

    /**
     * constructs the panel and initializes everything
     */
    public AnswerPanel() {
        setPreferredSize(new Dimension(222, 0));
        setBackground(Color.RED);
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


            mySubmit.addActionListener(e -> {
                myAnswer = myAnswerField.getText();

                myMaze.doorSolution(myAnswer, myDirection);

                if (myMaze.getCurrentRoom().getUserDoor(myDirection).isPermaLocked()) {
                    myQuestionPanel.setMyQuestion("Answer was incorrect! Door permanently locked!");
                } else {
                    myQuestionPanel.setMyQuestion("Answer was correct! Door unlocked!");
                }

                myAnswerField.setVisible(false);
                mySubmit.setVisible(false);
                myAnswerPrompt.setVisible(false);

                myMazePanel.repaint();

                myAnswerField.setText("");
                myAnswer = "";
                //if (!myAnswer.equals("")) myAnswerField.setFocusable(false);
                System.out.println("Answer: " + myAnswer);
            });

            myAnswerField.addActionListener(e -> myAnswer = myAnswerField.getText());

        } else {
            mySubmit.setVisible(true);
        }

    }

    public void setMaze(Maze theMaze) {
        myMaze = theMaze;
    }

    public void setDirection(int theDirection) {
        myDirection = theDirection;
    }

    public void setMazePanel(MazePanel theMazePanel) {
        myMazePanel = theMazePanel;
    }

    public void setQuestionPanel(QuestionPanel theQuestionPanel) {
        myQuestionPanel = theQuestionPanel;
    }

    /**
     * initializes the JTextField and adds it to the panel
     */
    private void initAndAddAnswer() {
        if (myAnswerField == null) {
            myAnswerField = new JTextField(20);

            add(myAnswerField);
            myAnswerField.setFocusable(true);
//            myAnswerField.addActionListener(new GrabText());
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

    public void setMyAnswer(String myAnswer) {
        this.myAnswer = myAnswer;
    }
}