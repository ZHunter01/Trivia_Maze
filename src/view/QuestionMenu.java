/**
 * Trivia Maze TCSS 360 Spring 2021
 */

package view;

import model.Question;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;

/**
 * This class is to allow users to choose different types of questions.
 *
 * @author Oleksandr Maistruk
 *
 */
public class QuestionMenu extends JMenu implements ActionListener {

    /**
     *  Serial number.
     */
    private static final long serialVersionUID = 991351390607951847L;

    /** The name of this menu item */
    private final static String myName = "Questions type ";

    /** The Database name by default */
    private static String myDataBaseName = "SportQuestions";

    /** The button to chose sport questions */
    private transient final JRadioButtonMenuItem mySport;

    /** The button to chose geography questions */
    private transient final JRadioButtonMenuItem myGeography;

    /** The field is to repaint maze with new questions type */
    private MazePanel myMazePanel;


    /**
     * The constructor is to create menu item.
     */
    public QuestionMenu() {  //final String theName) {
        super(myName);
        mySport = new JRadioButtonMenuItem("Sport Questions");
        myGeography = new JRadioButtonMenuItem("Geography Questions");
        ButtonCreator();
    }

    /**
     * The method to create needed buttons for Question menu.
     */
    private void ButtonCreator() {
        mySport.setSelected(true);
        mySport.addActionListener(new SportButton());
        myGeography.addActionListener(new GeographyButton());
        add(mySport);
        add(myGeography);

    }

//    /**
//     * The method to return database name to work with needed type of questions.
//     *
//     * @return name of database.
//     */
//    public static String getDataBaseName() {
//        return myDataBaseName;
//    }

    public void setMazePanel(MazePanel theMazePanel) {
        myMazePanel = theMazePanel;
    }

    /**
     *
     * Action Listener to change question type by clicking Sport button.
     */
    private class SportButton implements ActionListener {

        /**
         * Change question type to Sport Questions.
         */
        @Override
        public void actionPerformed(final ActionEvent theEvent) {
            mySport.setSelected(true);
            myGeography.setSelected(false);
            myDataBaseName = "SportQuestions";

            Question.getQuestionInstance().setDataBaseName(myDataBaseName);

            myMazePanel.setBackgroundImage(MazePanel.SPORT_BACKGROUND);
            myMazePanel.repaint();

            //myMazePanel = new MazePanel();

        }
    }

    /**
     *
     * Action Listener to change question type by clicking Geography button.
     */
    private class GeographyButton implements ActionListener {

        /**
         * Change question type to Geography Questions.
         */
        @Override
        public void actionPerformed(final ActionEvent theEvent) {
            mySport.setSelected(false);
            myGeography.setSelected(true);
            myDataBaseName = "GeographyQuestions";

            Question.getQuestionInstance().setDataBaseName(myDataBaseName);

            myMazePanel.setBackgroundImage(MazePanel.WORLD_BACKGROUND);
            myMazePanel.repaint();
            //myMazePanel = new MazePanel();

        }
    }

    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        // TODO Auto-generated method stub

    }

}