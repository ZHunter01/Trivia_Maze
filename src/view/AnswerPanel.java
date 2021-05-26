/**
 * Trivia Maze TCSS 360 Spring 2021
 */

package view;

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
    
    /** The player's answer */
    private transient String myAnswer;

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
        myAnswer = "no answer";
//        initAndAddAnswerPrompt();
//        initAndAddAnswer();
//        initAndAddSubmit();
    }
    
    public void setAnswerPanel() {
        
        initAndAddAnswerPrompt();
        initAndAddAnswer();
        initAndAddSubmit();
    }
  

//    /**
//     * @return the only instance of AnswerPanel
//     */
//    public static AnswerPanel getInstance() {
//        return answerPanel;
//    }

    /**
     * initializes the submit button and adds it to the panel
     */
    private void initAndAddSubmit() {
        if(mySubmit == null) {
            mySubmit = new JButton("SUBMIT");
            mySubmit.setBackground(Color.BLACK);
            mySubmit.setForeground(Color.WHITE);
            mySubmit.setFocusable(false);
            mySubmit.setPreferredSize(new Dimension(205, 30));
            add(mySubmit);
            mySubmit.addActionListener(new GrabText());
        } 
        
    }

    /**
     * initializes the JTextField and adds it to the panel
     */
    private void initAndAddAnswer() {
        if(myAnswerField == null) {
            myAnswerField = new JTextField(20);
    
            add(myAnswerField);
            myAnswerField.setFocusable(true);
            myAnswerField.addActionListener(new GrabText());
        } else {
            myAnswerField.setText("");
        }
    }

    /**
     * initializes the JLabel prompt and adds it to the panel
     */
    private void initAndAddAnswerPrompt() {
        if(myAnswerPrompt == null) {
            myAnswerPrompt = new JLabel("Please enter your answer: ");
            myAnswerPrompt.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
    
            add(myAnswerPrompt);
        }
    }

    /**
     * @return the answer that the user inputed
     */
    public String getMyAnswer() {
        return myAnswer;
    }
    
    /**
     * 
     * Action Listener to adopt text from myAnswerField text field
     * if user presses the enter key or click the submit button
     */
   private class GrabText implements ActionListener {

       /**
        * Grabs string from myAnswerField for processing
        * 
        */
       @Override
       public void actionPerformed(final ActionEvent theEvent) {
           Objects.requireNonNull(theEvent, " must not be null");
           myAnswer = new String(myAnswerField.getText());
           System.out.println("Answer: " + myAnswer);
       }
   }

}
