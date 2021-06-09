package view;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;


/**
 *
 * This class creates the JFrame and adds all of the essential panels inside it.
 *
 * @author Alik Balika, Oleksandr Maistruk, Zach Hunter
 *
 */
public class Application extends JFrame {

    /**
     * The width and height of the JFrame
     */
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;

    /**
     * Constructs an Application object
     * @throws IOException
     */
    public Application() throws IOException {
        init();
    }

    /**
     * Sets all the necessary details for the frame as well as adds all the panels into the JFrame
     */
    private void init() {
        setSize(WIDTH, HEIGHT);
        setTitle("Trivia Maze");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        AnswerPanel answerPanel = new AnswerPanel();

        QuestionPanel questionPanel = new QuestionPanel();

        MazePanel panel = new MazePanel(answerPanel, questionPanel);

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
