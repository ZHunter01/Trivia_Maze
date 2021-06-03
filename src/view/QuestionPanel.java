<<<<<<< HEAD


=======
>>>>>>> zach_branch
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

<<<<<<< HEAD
    /** Serial number. */
    private static final long serialVersionUID = -5110775593606022630L;
    
    /** The JLabel will hold the question */
    private JLabel myQuestion;
    
=======
    /**
     * The JLabel will hold the question
     */
    private JLabel myQuestion;

>>>>>>> zach_branch
    /** The id of the question */
    private int myIdForQuestion;

//    /**
//     * Create an instance of the QuestionPanel
//     */
//    private static final QuestionPanel questionPanel = new QuestionPanel();


    /**
     * Constructs the panel as well as initializes myQuestion
     */
    public QuestionPanel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(50, 50));
<<<<<<< HEAD
        setBackground(Color.GREEN);
=======
        setBackground(Color.BLACK);
>>>>>>> zach_branch

        myQuestion = new JLabel("This is where the question will show up");
        myQuestion.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        myQuestion.setHorizontalAlignment(JLabel.CENTER);
        myQuestion.setVerticalAlignment(JLabel.CENTER);
<<<<<<< HEAD
=======
        myQuestion.setForeground(Color.WHITE);
>>>>>>> zach_branch

        add(myQuestion);
    }

//    /**
//     * @return the only QuestionPanel object
//     */
//    public static QuestionPanel getInstance() {
//        return questionPanel;
//    }



    /**
     *
     * @return myQuestion
     */
    public JLabel getMyQuestion() {
        return myQuestion;
    }

<<<<<<< HEAD
=======


>>>>>>> zach_branch
    /**
     * Sets the question to a new question
     * @param theQuestion the new question to be displayed
     */
    public void setMyQuestion(final String theQuestion) {
        myQuestion.setText(theQuestion);
    }
<<<<<<< HEAD
    
=======

>>>>>>> zach_branch
    /**
     * Sets the question id to a new question
     * @param theId the question id
     */
    public void setMyQuestionId(final int theId) {
        myIdForQuestion = theId;
    }
<<<<<<< HEAD
    
    /**
    * Return question id for question which is used right now in the question panel.
    * 
    * @return myIdForQuestion the question id which is used in the question panel
    */
   public int getMyQuestionId() {
       return myIdForQuestion;
   }
=======

    /**
     * Return question id for question which is used right now in the question panel.
     *
     * @return myIdForQuestion the question id which is used in the question panel
     */
    public int getMyQuestionId() {
        return myIdForQuestion;
    }

>>>>>>> zach_branch

    /**
     * clears myQuestion
     */
    public void clear() {
        myQuestion.setText("");
    }
}