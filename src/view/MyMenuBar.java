package view;

import javax.swing.*;

import model.Maze;
import model.Question;

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
     *
     */
    private static final long serialVersionUID = -8886354497933935360L;
    /**
     * JMenu mySave allows the user to save the game
     */
    //private JMenuItem mySave;
    /**
     * JMenu myLoad allows the user to load a game
     */
    //private JMenuItem myLoad;
    /**
     * JMenu myHelp pops up a help window that explains how the game works
     */
    private JMenu myHelp;
    /**
     * JMenu myCustomizePlayer allows the user to change the icon of their player
     */
    //private JMenuItem myCustomizePlayer;

    //private JMenu myPowerUps;
    /**
     * JMenu myOptions displays JMenuItems which give different options for the user
     */
    private JMenu myOptions;
    /** */
    private JMenu myFile;
    private PowerUpMenu myPowerUps;
    private Maze myMaze;
    private MazePanel myMazePanel;
    //private JMenuItem myExit;
    /** The Database name by default */
    private static String myDataBaseName = "SportQuestions";

    private QuestionMenu myQuestionMenu;

    private PlayerMenu myPlayerMenu;

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

    private void setMaze() {
        myMaze = myMazePanel.getMaze();
    }

    /**
     * initialize fields and add then to the menu bar
     */
    private void initAndAddJMenus() {
        myFile = new JMenu("FILE");
        //mySave = new JMenu("SAVE");
        //myLoad = new JMenu("LOAD");
        myHelp = new JMenu("HELP");
        //myPowerUps = new JMenu("PowerUps");
        //myCustomizePlayer = new JMenu("CUSTOMIZE PLAYER");
        myOptions = new JMenu("OPTIONS");

        myPowerUps = new PowerUpMenu("PowerUps");
        final JMenuItem exit =  new JMenuItem("Exit");
//        final JMenuItem myColor = new JMenuItem("Color");

        myQuestionMenu = new QuestionMenu();
        myPlayerMenu = new PlayerMenu();

        final JMenuItem myAbout = new JMenuItem("About");
        final JMenuItem myRules = new JMenuItem("Rules");
        final JMenuItem mySave = new JMenuItem("Save");
        final JMenuItem myLoad = new JMenuItem("Load");
        // final JMenuItem myCustomizePlayer = new JMenuItem("Customize Player");

        add(myFile);
        myFile.add(mySave);
        myFile.add(myLoad);
        myFile.add(exit);

        add(myHelp);
        add(myOptions);

        myOptions.add(myPlayerMenu);
        myOptions.add(myQuestionMenu);

        myOptions.add(myPowerUps);

        myHelp.add(myAbout);
        myHelp.add(myRules);

        myAbout.addActionListener(new About());
        myRules.addActionListener(new Rules());
        exit.addActionListener(new Exit());
        mySave.addActionListener(new Save());
        myLoad.addActionListener(new Load());
    }

    public void setQuestionPlayerMenuMazePanel(MazePanel theMazePanel) {
        myQuestionMenu.setMazePanel(theMazePanel);
        myPlayerMenu.setMazePanel(theMazePanel);
        myPowerUps.setPanels(theMazePanel);
    }

//    public void setPlayerMenuMazePanel(PlayerMen)

    /**
     *
     * @return
     */
    public PowerUpMenu getPowerUpMenu() {
        return myPowerUps;
    }

    public void setMazePanel(final MazePanel theMazePanel) {
        System.out.println("called");
        myMazePanel = theMazePanel;
        setMaze();
    }

    private class Load implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            System.out.println("Loading... ");

            Maze m = null;
            try {
                System.out.println("In try");
                FileInputStream fileIn = new FileInputStream("maze.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                m = (Maze) in.readObject();
                //System.out.println(m);
                in.close();
                fileIn.close();
            } catch (IOException i) {
                i.printStackTrace();
            } catch (ClassNotFoundException c) {
                System.out.println("Maze class not found");
                c.printStackTrace();
            }

            if (m != null) {
                myMaze = m;
                System.out.println("Load successful!");
                myMazePanel.setMaze(myMaze);
                System.out.println("("+myMaze.getXCount()+","+myMaze.getYCount()+")");

                String path = myMaze.getPlayer().getImagePath();
                myMaze.getPlayer().setImage(path);

                myPlayerMenu.setMazePanel(myMazePanel);
                myMazePanel.repaint();
            }

            System.out.println("end of action listener");

        }
    }

    private class Save implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Saving... ");
            try {

//                //Create a file chooser
//                final JFileChooser fc = new JFileChooser();
//
//                //In response to a button click:
//                int returnVal = fc.showOpenDialog();

                //Saving of object in a file
                FileOutputStream fos = new FileOutputStream("maze.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                // Method for serialization of B's class object
                oos.writeObject(myMaze);

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
                    + "<p>OBJECTIVE: Get to the exit of the maze located at the bottom right. ";
            final String content3
                    = "HOW TO: Use navigation buttons to move. "
                    + "Answer trivia question correctly to move to the next spot. "
                    + "If you answer incorrectly, that way will become blocked. "
                    + "If all routes to the exit are blocked, you lose. "
                    + "If you reach the exit located at the bottom right, you win the trivia maze!</p>"
                    + "PowerUps: While going through the Trivia Maze you will encounter PowerUps. "
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


    private class Exit implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent theEvent) {
            System.exit(0);
        }

    }

    public static String getDataBaseName() {
        return myDataBaseName;
    }
}

