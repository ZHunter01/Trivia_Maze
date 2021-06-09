/**
 * Trivia Maze TCSS 360 Spring 2021
 */
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
    /**Serializable generated number */
    private static final long serialVersionUID = -8886354497933935360L;
    /**Min value for the JSlider */
    private static final int MIN_VALUE = 0;
    /**Max value for the JSlider */
    private static final int MAX_VALUE = 10;
    /** The default minor value for slider. */
    private static final int MINOR = 1;
    /** The default major value for slider. */
    private static final int MAJOR = 5;
    /**Default volume */
    private static final int DEFAULT_VOLUME = 2;
    /** JMenu myHelp pops up a help window that explains how the game works*/
    private JMenu myHelp;
    /**JMenu myOptions displays JMenuItems which give different options for the user*/
    private JMenu myOptions;
    /**JMenu File menu for allowing user to save, load, and exit the game */
    private JMenu myFile;
    /**PowerUpMenu reference */
    private PowerUpMenu myPowerUps;
    /**Maze object to keep track of current state of the maze */
    public Maze myMaze;
    /**MazePanel object to keep track of current state of the MazePanel */
    private MazePanel myMazePanel;
    /** The Database name by default */
    private static String myDataBaseName = "SportQuestions";
    /**QuestionMenu reference */
    private QuestionMenu myQuestionMenu;
    /**PlayerMenu reference */
    private PlayerMenu myPlayerMenu;
    /**JSlider for controlling in game music volume */
    public static JSlider myVolumeBar;

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

    /**Set myMaze to MazePanel's Maze
     * 
     */
    private void setMaze() {
        myMaze = myMazePanel.getMaze();
    }

    /**
     * initialize fields and add then to the menu bar
     */
    private void initAndAddJMenus() {
        //Set Up JMenus
        myFile = new JMenu("FILE");

        myHelp = new JMenu("HELP");

        myOptions = new JMenu("OPTIONS");

        
        //myFile Components
        final JMenuItem mySave = new JMenuItem("Save");
        final JMenuItem myLoad = new JMenuItem("Load");
        final JMenuItem exit =  new JMenuItem("Exit");


        
        //myHelp Components
        final JMenuItem myAbout = new JMenuItem("About");
        final JMenuItem myRules = new JMenuItem("Rules");
        
        //myOptions Components
        myPowerUps = new PowerUpMenu();
        final JMenu myVolume = new JMenu("Volume");
        myQuestionMenu = new QuestionMenu();
        myPlayerMenu = new PlayerMenu();
        
        //Set up JSlider for myVolume JMenu
        myVolume.add(setUpSlider());

        //Add components to myFile and add myFile to the MenuBar
        add(myFile);
        myFile.add(mySave);
        myFile.add(myLoad);
        myFile.add(exit);
        
        //Add components to myHelp and add myHelp to the MenuBar
        add(myHelp);
        myHelp.add(myAbout);
        myHelp.add(myRules);
        
        //Add components to myOption and add myOptions to the MenuBar
        add(myOptions);
        myOptions.add(myPlayerMenu);
        myOptions.add(myQuestionMenu);
        myOptions.add(myPowerUps);
        myOptions.add(myVolume);


        //Add action Listeners to the menu items
        myAbout.addActionListener(new About());
        myRules.addActionListener(new Rules());
        exit.addActionListener(new Exit());
        mySave.addActionListener(new Save());
        myLoad.addActionListener(new Load());
    }
    
    /** Sets up myVolumeBar JSlider
     * 
     * @return myVolumeBar
     */
    private JSlider setUpSlider() {
        myVolumeBar = new JSlider(MIN_VALUE, MAX_VALUE, JSlider.HORIZONTAL);
        myVolumeBar.setMajorTickSpacing(MAJOR);
        myVolumeBar.setMinorTickSpacing(MINOR);
        myVolumeBar.setPaintTicks(true);
        myVolumeBar.setPaintLabels(true);
        myVolumeBar.setValue(DEFAULT_VOLUME);
        //Add change listener
        myVolumeBar.addChangeListener(new Volume());
        
       return myVolumeBar;
    }

    /** Sets the MazePanels for QuestionMenu, PlayerMenu, and PowerUpMenu 
     * 
     * @param theMazePanel
     */
    public void setQuestionPlayerMenuMazePanel(final MazePanel theMazePanel) {
        myQuestionMenu.setMazePanel(theMazePanel);
        myPlayerMenu.setMazePanel(theMazePanel);
        myPowerUps.setPanels(theMazePanel);
    }


    /** Get current PowerUpMenu
     *
     * @return myPowerUps
     */
    public PowerUpMenu getPowerUpMenu() {
        return myPowerUps;
    }

    /** Get current DataBase name
     * 
     * @return myDataBaseName
     */
    public static String getDataBaseName() {
        return myDataBaseName;
    }
    
    /** Set MenuBar's MazePanel
     * 
     * @param theMazePanel
     */
    public void setMazePanel(final MazePanel theMazePanel) {
        myMazePanel = theMazePanel;
        setMaze();
    }
    
    /** Action Listener for myLoad JMenuItem
     * 
     * @author Alik Balika
     *
     */
    private class Load implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent theEvent) {


            Maze m = null;
            //DeSerialization
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
                myMazePanel.setMaze(m);
                m.getPlayer().setImage(m.getPlayer().getImagePath());
                myMazePanel.repaint();
            }
        }
    }

    /** Action Listener for mySave JMenuItem
     * 
     * @author Alik Balika
     *
     */
    private class Save implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent theEvent) {
            //Serialization
            try {
                //Saving of object in a file
                FileOutputStream fos = new FileOutputStream("maze.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                // Method for serialization of B's class object
                oos.writeObject(myMaze);

                // closing streams
                oos.close();
                fos.close();

            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }


    /**Action Listener to show message by clicking About button from Help menu.
     * 
     * @author Oleksandr Maistruk
     *
     */
    private class About implements ActionListener {

        /** Opens Message Dialog window with About program information Sets up logo.*/
        @Override
        public void actionPerformed(ActionEvent theEvent) {
            JPanel labelPanel = new JPanel(new GridBagLayout());
            JPanel textPanel = new JPanel(new GridLayout(3, 1, 5, 7));
            //Title of game
            textPanel.add(new JLabel("Trivia Maze"));
            //Authors
            labelPanel.add(new JLabel("Game Authors: "));
            textPanel.add(new JLabel("Alik, Zach, Alex"));

            JPanel panel = new JPanel(new BorderLayout(20, 0));
            panel.add(textPanel);
            panel.add(labelPanel, BorderLayout.WEST);
            JOptionPane.showMessageDialog(null, panel, "About", JOptionPane.DEFAULT_OPTION);
        }

    }

    
    /**Action Listener to show message by clicking Rules button from Help menu.
     * 
     * @author Oleksandr Maistruk
     *
     */
    private class Rules implements ActionListener {
  
        /**
         * Opens Message Dialog window with rules for this game.
         */
        @Override
        public void actionPerformed(final ActionEvent theEvent) {
            //String of rules for the game
            final String content1 = "<html>"
                    + "<body style='background-color: white; width: ";
            final String content2 = "'>"
                    + "<h1>Game Rules:</h1>"
                    + "<p>OBJECTIVE: Get to the exit of the maze located at the bottom right. ";
            final String content3
                    = "HOW TO: Use navigation buttons to move. "
                    + "Answer trivia question correctly to move to the next spot, but be aware, "
                    + "the door will permanently lock behind you! "
                    + "If you answer incorrectly, that way will become blocked. "
                    + "If all routes to the exit are blocked, you lose! "
                    + "If you reach the exit located at the bottom right, you win the trivia maze!</p>"
                    + "POWERUPS: While going through the Trivia Maze you will encounter PowerUps. "
                    + "When you get a PowerUp, a message will tell you which one you got. "
                    + "You can access your PowerUps from the \"Options\" menu under \"PowerUp\""
                    + "There are two PowerUps you can get, FreeQuestion and PermaUnlock. "
                    + "<br />FREEQUESTION: The FreeQuestion PowerUp allows you to skip a question and move"
                    + " into the next room.<br />PERMAUNLOCK: The PermaUnlock PowerUp allows you to retry a question" 
                    + " that you had previously answered incorrectly.";
            final String content = content1 + 300 + "px"
                    + content2 + "\n" + content3;
            //Add string to pane 
            final Runnable r = () -> {
                UIManager.put("OptionPane.minimumSize",new Dimension(500,500)); 
                JLabel label = new JLabel(content);
                label.setPreferredSize(new Dimension(500,500));
                JOptionPane.showMessageDialog(null, label);
            };
            SwingUtilities.invokeLater(r);
        }
    }

  /** Action Listener for myExit JMenuItem
   * 
   * @author Zach Hunter
   *
   */
    private class Exit implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent theEvent) {
            //Simply system exit when clicked
            System.exit(0);
        }
    }
    
    /** Change Listener for myVolumeBar
     * 
     * @author Zach Hunter
     *
     */
    private class Volume implements ChangeListener {

        @Override
        public void stateChanged(final ChangeEvent theEvent) {
            //Set new volume to value of myVolumeBar
            myMazePanel.setVolume(myVolumeBar.getValue());
        }  
    }
}