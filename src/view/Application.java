package view;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Application extends JFrame {

    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;

    public Application() throws IOException {
        init();
    }

    private void init() {
        setSize(WIDTH, HEIGHT);
        setTitle("Trivia Maze");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        setJMenuBar(new MyMenuBar());
        add(new MazePanel(), BorderLayout.CENTER);
        add(new AnswerPanel(), BorderLayout.EAST);
        add(new QuestionPanel(), BorderLayout.NORTH);
        add(new DirectionPanel(), BorderLayout.SOUTH);
    }
}
