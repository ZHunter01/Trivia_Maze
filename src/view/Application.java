
package view;

import javax.swing.*;

import db.SqliteDB;

import java.awt.*;
import java.io.IOException;

public class Application extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = -1533040357004060524L;
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    
    private SqliteDB myDataBase = new SqliteDB(QuestionMenu.getDataBaseName());

    public Application() throws IOException {

        init();
    }

    private void init() {

        //add(new MyMenuBar(), BorderLayout.NORTH);
        setSize(WIDTH, HEIGHT);
        setTitle("Trivia Maze");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(new MyMenuBar());
        setLocationRelativeTo(null);
    


        setSize(WIDTH, HEIGHT);
        setTitle("Trivia Maze");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        myDataBase.setIsUsedToDefault();

        AnswerPanel answerP = new AnswerPanel();
        QuestionPanel questionP = new QuestionPanel();
        MazePanel panel = new MazePanel(answerP, questionP);
        
        setJMenuBar(MyMenuBar.getInstance());
        add(panel, BorderLayout.CENTER);
        add(answerP, BorderLayout.EAST);
        add(questionP, BorderLayout.NORTH);
        add(new DirectionPanel(panel), BorderLayout.SOUTH);
    }
}

