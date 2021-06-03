/**
 * Trivia Maze TCSS 360 Spring 2021
 */

package view;

<<<<<<< HEAD
=======
import model.Question;

>>>>>>> zach_branch
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;

<<<<<<< HEAD
import model.Question;

/**
 * This class is to allow users to choose different types of questions.
 * 
=======
/**
 * This class is to allow users to choose different types of questions.
 *
>>>>>>> zach_branch
 * @author Oleksandr Maistruk
 *
 */
public class QuestionMenu extends JMenu implements ActionListener {
<<<<<<< HEAD
    
=======

>>>>>>> zach_branch
    /**
     *  Serial number.
     */
    private static final long serialVersionUID = 991351390607951847L;
<<<<<<< HEAD
    
    /** The name of this menu item */
    private final static String myName = "Questions type ";
    
    /** The Database name by default */
    private static String myDataBaseName = "SportQuestions";
    
    /** The button to chose sport questions */
    private transient final JRadioButtonMenuItem mySport;
    
    /** The button to chose geography questions */
    private transient final JRadioButtonMenuItem myGeography;

    private MazePanel myMazePanel;
    
=======

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

>>>>>>> zach_branch

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
<<<<<<< HEAD
        
    }
    
//    /**
//     * The method to return database name to work with needed type of questions.
//     * 
=======

    }

//    /**
//     * The method to return database name to work with needed type of questions.
//     *
>>>>>>> zach_branch
//     * @return name of database.
//     */
//    public static String getDataBaseName() {
//        return myDataBaseName;
//    }
<<<<<<< HEAD
    
    /**
     * 
=======

    public void setMazePanel(MazePanel theMazePanel) {
        myMazePanel = theMazePanel;
    }

    /**
     *
>>>>>>> zach_branch
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
<<<<<<< HEAD
            Question.getQuestionInstance().setDataBaseName(myDataBaseName);
            myMazePanel.setBackgroundImage(MazePanel.SPORT_BACKGROUND);
            myMazePanel.repaint();
        }
    }
    
    /**
     * 
=======

            Question.getQuestionInstance().setDataBaseName(myDataBaseName);

            myMazePanel.setBackgroundImage(MazePanel.SPORT_BACKGROUND);
            myMazePanel.repaint();

            //myMazePanel = new MazePanel();

        }
    }

    /**
     *
>>>>>>> zach_branch
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
<<<<<<< HEAD
            Question.getQuestionInstance().setDataBaseName(myDataBaseName);
            myMazePanel.setBackgroundImage(MazePanel.WORLD_BACKGROUND);
            myMazePanel.repaint();
=======

            Question.getQuestionInstance().setDataBaseName(myDataBaseName);

            myMazePanel.setBackgroundImage(MazePanel.WORLD_BACKGROUND);
            myMazePanel.repaint();
            //myMazePanel = new MazePanel();

>>>>>>> zach_branch
        }
    }

    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        // TODO Auto-generated method stub
<<<<<<< HEAD
        
    }

    public void setMazePanel(final MazePanel theMazePanel) {
        myMazePanel = theMazePanel;       
=======

>>>>>>> zach_branch
    }

}