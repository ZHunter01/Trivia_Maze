package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Alik Balika
 * @author Oleksandr Maistruk
 *
 * Creates the menu bar of the program
 *
 * This is a Singleton class
 */
public class MyMenuBar extends JMenuBar {

    /**
     * JMenu mySave allows the user to save the game
     */
    private JMenu mySave;
    /**
     * JMenu myLoad allows the user to load a game
     */
    private JMenu myLoad;
    /**
     * JMenu myHelp pops up a help window that explains how the game works
     */
    private JMenu myHelp;
    /**
     * JMenu myCustomizePlayer allows the user to change the icon of their player
     */
    private JMenu myCustomizePlayer;
    /**
     * JMenu myOptions displays JMenuItems which give different options for the user
     */
    private JMenu myOptions;

    private static String myDataBaseName = "SportQuestions";

    /**
     * Create an instance of the DirectionPanel
     */
    private static final MyMenuBar myMenuBar = new MyMenuBar();

    /**
     * constructs the Menu Bar
     */
    private MyMenuBar() {
        super();
        initAndAddJMenus();
    }

    /**
     * @return the only instance of MenuBar
     */
    public static MyMenuBar getInstance() {
        return myMenuBar;
    }

    /**
     * initialize fields and add then to the menu bar
     */
    private void initAndAddJMenus() {
        mySave = new JMenu("SAVE");
        myLoad = new JMenu("LOAD");
        myHelp = new JMenu("HELP");
        myCustomizePlayer = new JMenu("CUSTOMIZE PLAYER");
        myOptions = new JMenu("OPTIONS");
        final JMenuItem myCharacter = new JMenuItem("Character");
        final JMenuItem myColor = new JMenuItem("Color");
        final JMenuItem myQuestionType = new QuestionMenu(); //"Questions type");
        final JMenuItem myAbout = new JMenuItem("About");
        final JMenuItem myRules = new JMenuItem("Rules");

        add(mySave);
        add(myLoad);
        add(myHelp);
        add(myCustomizePlayer);
        add(myOptions);

        myCustomizePlayer.add(myCharacter);
        myCustomizePlayer.add(myColor);
        myCustomizePlayer.add(myQuestionType);

        myHelp.add(myAbout);
        myHelp.add(myRules);

        myAbout.addActionListener(new About());
        myRules.addActionListener(new Rules());
    }

    /**
     *
     * Action Listener to show message by clicking About button from Help menu.
     */
    private class About implements ActionListener {

        /**
         * Opens Message Dialog window with About program information Sets up logo.
         */
        @Override
        public void actionPerformed(ActionEvent theEvent) {
            JPanel labelPanel = new JPanel(new GridBagLayout());
            JPanel textPanel = new JPanel(new GridLayout(3, 1, 5, 7));
//            labelPanel.add(new JLabel("Game Name: "));
            textPanel.add(new JLabel("Trivia Maze"));
            labelPanel.add(new JLabel("Game Authors: "));
            textPanel.add(new JLabel("Alik, Zach, Alex"));

            JPanel panel = new JPanel(new BorderLayout(20, 0));
            panel.add(textPanel);
            panel.add(labelPanel, BorderLayout.WEST);
            JOptionPane.showMessageDialog(null, panel, "About", JOptionPane.DEFAULT_OPTION);

        }

    }

    /**
     *
     * Action Listener to show message by clicking Rules button from Help menu.
     */
    private class Rules implements ActionListener {

        /**
         * Opens Message Dialog window with rules for this game.
         */
        @Override
        public void actionPerformed(final ActionEvent theEvent) {

            final String content1 = "<html>"
                    + "<body style='background-color: white; width: ";
            final String content2 = "'>"
                    + "<h1>Game Rules:</h1>"
                    + "<p>Here we need to describe ";
            final String content3
                    = "ruls of the TriviaMaze game.  "
                    + "ruls of the TriviaMaze game. "
                    + "ruls of the TriviaMaze game. "
                    + " ruls of the TriviaMaze game.</p>";
            final String content = content1 + 300 + "px"
                    + content2 +  content3;
            final Runnable r = () -> {
                JLabel label = new JLabel(content);
                JOptionPane.showMessageDialog(null, label);
            };
            SwingUtilities.invokeLater(r);

        }
    }

    public static String getDataBaseName() {
        return myDataBaseName;
    }

}
