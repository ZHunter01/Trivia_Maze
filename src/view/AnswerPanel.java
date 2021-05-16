package view;

import javax.swing.*;
import java.awt.*;

public class AnswerPanel extends JPanel {

    private JLabel myAnswerPrompt;
    private JTextField myAnswer;
    private JButton mySubmit;

    public AnswerPanel() {
        setPreferredSize(new Dimension(222, 0));
        setBackground(Color.RED);

        initAndAddAnswerPrompt();
        initAndAddAnswer();
        initAndAddSubmit();
    }

    private void initAndAddSubmit() {
        mySubmit = new JButton("SUBMIT");
        mySubmit.setBackground(Color.BLACK);
        mySubmit.setForeground(Color.WHITE);
        mySubmit.setFocusable(false);
        mySubmit.setPreferredSize(new Dimension(205, 30));
        add(mySubmit);
    }

    private void initAndAddAnswer() {
        myAnswer = new JTextField(20);

        add(myAnswer);
    }

    private void initAndAddAnswerPrompt() {
        myAnswerPrompt = new JLabel("Please enter your answer: ");
        myAnswerPrompt.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));

        add(myAnswerPrompt);
    }

    public JLabel getMyAnswerPrompt() {
        return myAnswerPrompt;
    }

    public JTextField getMyAnswer() {
        return myAnswer;
    }

}
