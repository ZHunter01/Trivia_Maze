package view;

import javax.swing.*;
import java.awt.*;

/**
 * @author Alik Balika
 *
 * This class is a panel where the user can enter their answer
 * This is a Singleton class
 */
public class AnswerPanel extends JPanel {

    /**
     * A JLabel that prompts the user to answer the question
     */
    private JLabel myAnswerPrompt;
    /**
     * A JTextField object that the user can use to answer the question
     */
    private JTextField myAnswer;
    /**
     * A button that the user can use to submit their answer
     */
    private JButton mySubmit;

    /**
     * Create an instance of the AnswerPanel
     */
    private static final AnswerPanel answerPanel = new AnswerPanel();

    /**
     * constructs the panel and initializes everything
     */
    private AnswerPanel() {
        setPreferredSize(new Dimension(222, 0));
        setBackground(Color.RED);

        initAndAddAnswerPrompt();
        initAndAddAnswer();
        initAndAddSubmit();
    }

    /**
     * @return the only instance of AnswerPanel
     */
    public static AnswerPanel getInstance() {
        return answerPanel;
    }

    /**
     * initializes the submit button and adds it to the panel
     */
    private void initAndAddSubmit() {
        mySubmit = new JButton("SUBMIT");
        mySubmit.setBackground(Color.BLACK);
        mySubmit.setForeground(Color.WHITE);
        mySubmit.setFocusable(false);
        mySubmit.setPreferredSize(new Dimension(205, 30));
        add(mySubmit);
    }

    /**
     * initializes the JTextField and adds it to the panel
     */
    private void initAndAddAnswer() {
        myAnswer = new JTextField(20);

        add(myAnswer);
    }

    /**
     * initializes the JLabel prompt and adds it to the panel
     */
    private void initAndAddAnswerPrompt() {
        myAnswerPrompt = new JLabel("Please enter your answer: ");
        myAnswerPrompt.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));

        add(myAnswerPrompt);
    }

    /**
     * @return the answer that the user inputted
     */
    public JTextField getMyAnswer() {
        return myAnswer;
    }

}
