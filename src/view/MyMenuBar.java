package view;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Maze;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Alik Balika, Oleksandr Maistruk, Zach Hunter
 *
 * Creates the menu bar of the program
 *
 * This is a Singleton class
 */
public class MyMenuBar extends JMenuBar {

    /**
     * The min value of the JSlider for the volume
     */
    private static final int MIN_VALUE = 0;

    /**
     * The max volume of the JSlider for the volume
     */
    private static final int MAX_VALUE = 10;

    /** The default minor value for slider. */
    private static final int MINOR = 1;

    /** The default major value for slider. */
    private static final int MAJOR = 5;

    /**
     * the reference to the power up menu
     */
    private PowerUpMenu myPowerUps;

    /**
     * the reference to the maze panel
     */
    private MazePanel myMazePanel;

    /**
     * the reference to the question menu
     */
    private QuestionMenu myQuestionMenu;

    /**
     * The reference to the player menu
     */
    private PlayerMenu myPlayerMenu;

    /**
     * The slider controls the volume of the music
     */
    private JSlider myVolumeBar;

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
     * sets the maze panel
     * @param theMazePanel
     */
    public void setMazePanel(final MazePanel theMazePanel) {
        myMazePanel = theMazePanel;
    }

    /**
     * Sets the maze panel for the question panel, player menu and the power up menu
     * @param theMazePanel
     */
    public void setQuestionPlayerMenuMazePanel(final MazePanel theMazePanel) {
        myQuestionMenu.setMazePanel(theMazePanel);
        myPlayerMenu.setMazePanel(theMazePanel);
        myPowerUps.setPanels(theMazePanel);
    }

    /**
     * @return return the reference to the power up menu
     */
    public PowerUpMenu getPowerUpMenu() {
        return myPowerUps;
    }

    /** The Database name by default */
    public static String getDataBaseName() {
        return "SportQuestions";
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

        JMenu myFile = new JMenu("FILE");

        JMenu myHelp = new JMenu("HELP");

        JMenu myOptions = new JMenu("OPTIONS");

        myPowerUps = new PowerUpMenu("PowerUps");
        final JMenuItem exit =  new JMenuItem("Exit");

        myQuestionMenu = new QuestionMenu();
        myPlayerMenu = new PlayerMenu();

        final JMenuItem myAbout = new JMenuItem("About");
        final JMenuItem myRules = new JMenuItem("Rules");
        final JMenuItem mySave = new JMenuItem("Save");
        final JMenuItem myLoad = new JMenuItem("Load");

        final JMenu myVolume = new JMenu("Volume");
        myVolume.add(setUpSlider());

        add(myFile);
        myFile.add(mySave);
        myFile.add(myLoad);
        myFile.add(exit);

        add(myHelp);
        add(myOptions);

        myOptions.add(myPlayerMenu);
        myOptions.add(myQuestionMenu);
        myOptions.add(myVolume);

        myOptions.add(myPowerUps);

        myHelp.add(myAbout);
        myHelp.add(myRules);

        myAbout.addActionListener(new About());
        myRules.addActionListener(new Rules());
        exit.addActionListener(new Exit());
        mySave.addActionListener(new Save());
        myLoad.addActionListener(new Load());
    }

    /**
     * creates the slider object and adds a listener to it
     * @return
     */
    private JSlider setUpSlider() {
        myVolumeBar = new JSlider(MIN_VALUE, MAX_VALUE, JSlider.HORIZONTAL);
        myVolumeBar.setMajorTickSpacing(MAJOR);
        myVolumeBar.setMinorTickSpacing(MINOR);
        myVolumeBar.setPaintTicks(true);
        myVolumeBar.setPaintLabels(true);
        myVolumeBar.setValue(MAJOR);
        myVolumeBar.addChangeListener(new Volume());

        return myVolumeBar;
    }

    /**
     * The load action listener. Loads the previously saved state
     */
    private class Load implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent e) {

            System.out.println("Loading... ");

            Maze m = null;
            try {
                FileInputStream fileIn = new FileInputStream("maze.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                m = (Maze) in.readObject();
                in.close();
                fileIn.close();
            } catch (IOException i) {
                i.printStackTrace();
            } catch (ClassNotFoundException c) {
                System.out.println("Maze class not found");
                c.printStackTrace();
            }

            if (m != null) {
                System.out.println("Load successful!");
                myMazePanel.setMaze(m);
                System.out.println("("+m.getXCount()+","+m.getYCount()+")");
                m.getPlayer().setImage(PlayerMenu.OLD_MAN);
                myMazePanel.repaint();
            }

        }
    }

    /**
     * The save action listener. saves the current state of the game
     */
    private class Save implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent e) {
            System.out.println("Saving... ");
            try {

                //Saving of object in a file
                FileOutputStream fos = new FileOutputStream("maze.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                // Method for serialization of B's class object
                oos.writeObject(myMazePanel.getMaze());

                // closing streams
                oos.close();
                fos.close();

                System.out.println("Object has been serialized");
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
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
        public void actionPerformed(final ActionEvent theEvent) {
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
                    + "<p>OBJECTIVE: Get to the exit of the maze located at the bottom right. ";
            final String content3
                    = "HOW TO: Use navigation buttons to move. "
                    + "Answer trivia question correctly to move to the next spot. "
                    + "If you answer incorrectly, that way will become blocked. "
                    + "If all routes to the exit are blocked, you lose. "
                    + "If you reach the exit located at the bottom right, you win the trivia maze!</p>"
                    + "<h3>PowerUps:</h3> While going through the Trivia Maze you will encounter PowerUps. "
                    + "When you get a PowerUp, a message will tell you which one you got. "
                    + "You can access your PowerUps from the \"Options\" menu under \"PowerUp\""
                    + "There are two PowerUps you can get, FreeQuestion and PermaUnlock. "
                    + "<br />FreeQuestion: The FreeQuestion PowerUp allows you to skip a question and move"
                    + " into the next room\nPermaUnlock: The PermaUnlock PowerUp allows you to retry a question"
                    + " that you had previously answered incorrectly.";
            final String content = content1 + 300 + "px"
                    + content2 + "\n" + content3;
            final Runnable r = () -> {
                UIManager.put("OptionPane.minimumSize",new Dimension(500,500));
                JLabel label = new JLabel(content);
                label.setPreferredSize(new Dimension(500,500));
                JOptionPane.showMessageDialog(null, label);
            };
            SwingUtilities.invokeLater(r);

        }

    }

    /**
     *
     * Exits and closes the game
     * @author Zach Hunter
     *
     */
    private class Exit implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent theEvent) {
            System.exit(0);
        }

    }

    /**
     *
     * adds the volume action listener to the JSlider
     * @author Zach Hunter
     *
     */
    private class Volume implements ChangeListener {

        @Override
        public void stateChanged(final ChangeEvent theEvent) {
            myMazePanel.setVolume(myVolumeBar.getValue());
        }
    }
}