package view;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;


/**
<<<<<<< HEAD
 * 
=======
 *
>>>>>>> zach_branch
 * @author Alik Balika, Oleksandr Maistruk, Zach Hunter
 *
 */
public class Application extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = -1533040357004060524L;
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;

<<<<<<< HEAD
    //private SqliteDB myDataBase = new SqliteDB(QuestionMenu.getDataBaseName());
=======
    //rivate SqliteDB myDataBase = new SqliteDB(QuestionMenu.getDataBaseName());
>>>>>>> zach_branch

    public Application() throws IOException {
        init();
    }

    /**
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> zach_branch
     */
    private void init() {
        setSize(WIDTH, HEIGHT);
        setTitle("Trivia Maze");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        //myDataBase.setIsUsedToDefault();

        AnswerPanel answerPanel = new AnswerPanel();
<<<<<<< HEAD
        
        QuestionPanel questionPanel = new QuestionPanel();
      
        MazePanel panel = new MazePanel(answerPanel, questionPanel);

        //Menu Bar
        MyMenuBar.getInstance().setMazePanel(panel);
        setJMenuBar(MyMenuBar.getInstance());
        MyMenuBar.getInstance().setQuestionMenuMazePanel(panel);
        
=======

        QuestionPanel questionPanel = new QuestionPanel();

        MazePanel panel = new MazePanel(answerPanel, questionPanel);

        //Menu Bar
        //MyMenuBar.getInstance().setMaze(panel.getMaze());

        MyMenuBar.getInstance().setMazePanel(panel);
        setJMenuBar(MyMenuBar.getInstance());
        MyMenuBar.getInstance().setQuestionMenuMazePanel(panel);

>>>>>>> zach_branch
        //Add panels to the frame
        add(panel, BorderLayout.CENTER);
        add(answerPanel, BorderLayout.EAST);
        add(questionPanel, BorderLayout.NORTH);
        add(new DirectionPanel(panel), BorderLayout.SOUTH);
<<<<<<< HEAD
  
=======

>>>>>>> zach_branch
        //Pass PowerUpMenu to the answer panel
        answerPanel.setPowerUpMenu(MyMenuBar.getInstance().getPowerUpMenu());
    }
}