package view;

import javax.swing.*;
import java.awt.*;

/**
 * @author Alik Balika
 *
 * This class is a panel that will display the question
 * This is a Singleton Class
 */
public class QuestionPanel extends JPanel {

    /**
     * The JLabel will hold the question
     */
    private JLabel myQuestion;

    /** The id of the question */
    private int myIdForQuestion;

    /**
     * Constructs the panel as well as initializes myQuestion
     */
    public QuestionPanel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(50, 50));
        setBackground(Color.BLACK);

        myQuestion = new JLabel("This is where the question will show up");
        myQuestion.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        myQuestion.setHorizontalAlignment(JLabel.CENTER);
        myQuestion.setVerticalAlignment(JLabel.CENTER);
        myQuestion.setForeground(Color.WHITE);

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
    public void setMyQuestion(final String theQuestion) {
        myQuestion.setText(theQuestion);
    }

    /**
     * Sets the question id to a new question
     * @param theId the question id
     */
    public void setMyQuestionId(final int theId) {
        myIdForQuestion = theId;
    }

    /**
     * Return question id for question which is used right now in the question panel.
     *
     * @return myIdForQuestion the question id which is used in the question panel
     */
    public int getMyQuestionId() {
        return myIdForQuestion;
    }

    /**
     * clears myQuestion
     */
    public void clear() {
        myQuestion.setText("");
    }
}