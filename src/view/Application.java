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

    //rivate SqliteDB myDataBase = new SqliteDB(QuestionMenu.getDataBaseName());

    public Application() throws IOException {
        init();
    }

    /**
     * 
     */
    private void init() {
        setSize(WIDTH, HEIGHT);
        setTitle("Trivia Maze");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        //myDataBase.setIsUsedToDefault();

        AnswerPanel answerPanel = new AnswerPanel();
        //answerPanel.setPowerUpMenu();
        
        QuestionPanel questionPanel = new QuestionPanel();
//
//        PowerUpPanel powerPanel = new PowerUpPanel();
        
        MazePanel panel = new MazePanel(answerPanel, questionPanel);
//
//        JPanel panelHolder = new JPanel();
//        panelHolder.setLayout(new GridLayout(2, 1));
//        panelHolder.add(new AnswerPanel(), BorderLayout.NORTH);
//        panelHolder.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
//        panelHolder.add(new PowerUpPanel(), BorderLayout.SOUTH);
        
        
        setJMenuBar(MyMenuBar.getInstance());
        add(panel, BorderLayout.CENTER);
        add(answerPanel, BorderLayout.EAST);
        //add(powerPanel, BorderLayout.EAST);
        add(questionPanel, BorderLayout.NORTH);
        add(new DirectionPanel(panel), BorderLayout.SOUTH);
  
        answerPanel.setPowerUpMenu(MyMenuBar.getInstance().getPowerUpMenu());
    }
}