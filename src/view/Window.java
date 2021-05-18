package view;

import model.Maze;

import javax.swing.*;
import java.awt.*;

/**
 * @author Alik Balika
 *
 * This class creates a window that is displayed on the users screen
 */
public class Window extends JFrame{

    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;

    /**
     * calls a method that constructs the Frame
     */
    public Window() {
        init();
    }

    /**
     * does all the necessary work to construct the frame as well as add all the needed panels
     */
    private void init() {
        setSize(WIDTH, HEIGHT);
        setTitle("Trivia Maze");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        MazePanel mazePanel = new MazePanel();

        setJMenuBar(new MyMenuBar());
        add(mazePanel, BorderLayout.CENTER);
        add(new AnswerPanel(), BorderLayout.EAST);
        add(new QuestionPanel(), BorderLayout.NORTH);
        add(new DirectionPanel(mazePanel.getMyAdapter()), BorderLayout.SOUTH);
    }
}
