package view;

import javax.swing.*;
import java.awt.*;

/**
 * @author Alik Balika
 *
 * This class is a panel that will display the question
 */
public class QuestionPanel extends JPanel {

    /**
     * The JLabel will hold the question
     */
    private JLabel myQuestion;

    /**
     * Constructs the panel as well as initializes myQuestion
     */
    public QuestionPanel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(50, 50));
        setBackground(Color.GREEN);

        myQuestion = new JLabel("This is where the question will show up");
        myQuestion.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
        myQuestion.setHorizontalAlignment(JLabel.CENTER);
        myQuestion.setVerticalAlignment(JLabel.CENTER);

        add(myQuestion);
    }

    /**
     *
     * @return myQuestion
     */
    public JLabel getMyQuestion() {
        return myQuestion;
    }

    /**
     * Sets the question to a new question
     * @param theQuestion the new question to be displayed
     */
    public void setMyQuestion(String theQuestion) {
        myQuestion.setText(theQuestion);
    }

    /**
     * clears myQuestion
     */
    public void clear() {
        myQuestion.setText("");
    }
}
