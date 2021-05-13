package view;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 500;

    public Application() {
        init();
    }

    private void init() {
        //add(new MyMenuBar(), BorderLayout.NORTH);
        setSize(WIDTH, HEIGHT);
        setTitle("Trivia Maze");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(new MyMenuBar());
        setLocationRelativeTo(null);
    }
}
