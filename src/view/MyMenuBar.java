package view;

import javax.swing.*;
import java.awt.*;

public class MyMenuBar extends JMenuBar {

    private JMenuBar myMenuBar;
    private JMenu mySave;
    private JMenu myLoad;
    private JMenu myHelp;
    private JMenu myCustomizePlayer;
    private JMenu myOptions;

    public MyMenuBar() {
        super();
        initAndAddJMenus();
    }

    private void initAndAddJMenus() {
        mySave = new JMenu("SAVE");
        myLoad = new JMenu("LOAD");
        myHelp = new JMenu("HELP");
        myCustomizePlayer = new JMenu("CUSTOMIZE PLAYER");
        myOptions = new JMenu("OPTIONS");
        add(mySave);
        add(myLoad);
        add(myHelp);
        add(myCustomizePlayer);
        add(myOptions);
    }


//    private JButton mySave;
//    private JButton myLoad;
//    private JButton myHelp;
//    private JButton myCustomizePlayer;
//    private JButton myOptions; // or mySetttings
//
//    public MenuPanel() {
//        setBackground(Color.BLACK);
//        setLayout(new GridLayout());
//
//        addButtons();
//    }
//
//    private void addButtons() {
//        mySave = initializeButton("SAVE");
//        myLoad = initializeButton("LOAD");
//        myHelp = initializeButton("HELP");
//        myCustomizePlayer = initializeButton("CUSTOMIZE PLAYER");
//        myOptions = initializeButton("OPTIONS");
//
//        add(mySave);
//        add(myLoad);
//        add(myHelp);
//        add(myCustomizePlayer);
//        add(myOptions);
//    }
//
//    private JButton initializeButton(String name) {
//        JButton button = new JButton(name);
//        button.setFocusable(false);
//        button.setBackground(Color.BLACK);
//        button.setForeground(Color.WHITE);
//        return button;
//    }

}
