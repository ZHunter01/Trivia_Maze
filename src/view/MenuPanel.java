package view;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    private JButton mySave;
    private JButton myLoad;
    private JButton myHelp;
    private JButton myCustomizePlayer;
    private JButton myOptions; // or mySetttings

    public MenuPanel() {
        setBackground(Color.BLACK);
        setLayout(new GridLayout());

        addButtons();
    }

    private void addButtons() {
        mySave = initializeButton("SAVE");
        myLoad = initializeButton("LOAD");
        myHelp = initializeButton("HELP");
        myCustomizePlayer = initializeButton("CUSTOMIZE PLAYER");
        myOptions = initializeButton("OPTIONS");

        add(mySave);
        add(myLoad);
        add(myHelp);
        add(myCustomizePlayer);
        add(myOptions);
    }

    private JButton initializeButton(String name) {
        JButton button = new JButton(name);
        button.setFocusable(false);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        return button;
    }

}
