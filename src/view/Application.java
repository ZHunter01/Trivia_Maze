package view;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;


/**
 *
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

        QuestionPanel questionPanel = new QuestionPanel();

        MazePanel panel = new MazePanel(answerPanel, questionPanel);

        //Menu Bar
        //MyMenuBar.getInstance().setMaze(panel.getMaze());

        MyMenuBar.getInstance().setMazePanel(panel);
        setJMenuBar(MyMenuBar.getInstance());
        MyMenuBar.getInstance().setQuestionPlayerMenuMazePanel(panel);

        //Add panels to the frame
        add(panel, BorderLayout.CENTER);
        add(answerPanel, BorderLayout.EAST);
        add(questionPanel, BorderLayout.NORTH);
        add(new DirectionPanel(panel), BorderLayout.SOUTH);

        //Pass PowerUpMenu to the answer panel
        answerPanel.setPowerUpMenu(MyMenuBar.getInstance().getPowerUpMenu());
    }
}