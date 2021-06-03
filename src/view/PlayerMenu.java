<<<<<<< HEAD
=======

>>>>>>> zach_branch
/**
 * Trivia Maze TCSS 360 Spring 2021
 */

package view;


import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;

import model.Player;

/**
 * This class is to allow users to choose different types of questions.
<<<<<<< HEAD
 * 
=======
 *
>>>>>>> zach_branch
 * @author Oleksandr Maistruk
 *
 */
public class PlayerMenu extends JMenu implements ActionListener {

    /**
     * Serial number
     */
    private static final long serialVersionUID = 4885009744733200311L;
<<<<<<< HEAD
    
=======

>>>>>>> zach_branch
    /** Width for player bar icons. */
    private static final int TOOL_FOR_BAR_ICON_WIDTH = 5;

    /** Height for player bar icons. */
    private static final int TOOL_FOR_BAR_ICON_HEIGHT = 5;

    /** The name of this menu item */
    private final static String myMenuName = "Player";

    /** A list of players actions. */
    private List<PlayerAction> myPlayerActions;
<<<<<<< HEAD
    
    private String myPlayerName;
    
//    private final MyMenuBar myMenuBar;
    
    private Player myPlayer;
    
    private MazePanel myMazePane;
    
    /**
     * The constructor is to create player menu item.
     */
    public PlayerMenu() {  
        super(myMenuName);
        
//        myMenuBar = theMenuBar;
        
        setupPlayers();
    }
    
=======

    private String myPlayerName;

//    private final MyMenuBar myMenuBar;

    private Player myPlayer;

    private MazePanel myMazePane;

    /**
     * The constructor is to create player menu item.
     */
    public PlayerMenu() {
        super(myMenuName);

//        myMenuBar = theMenuBar;

        setupPlayers();
    }

>>>>>>> zach_branch
    /**
     * Sets up all the Tools for menu and menu bar.
     */
    private void setupPlayers() {
        myPlayerActions = new ArrayList<PlayerAction>();

<<<<<<< HEAD
        myPlayerActions.add(new PlayerAction("Oldman", new ImageIcon("./resources/Oldman.gif")));
        myPlayerActions.add(new PlayerAction("Oldwoman", new ImageIcon("./resources/Oldwoman.gif")));
        myPlayerActions.add(new PlayerAction("Girl", new ImageIcon("./resources/Girl.gif")));
        myPlayerActions.add(new PlayerAction("Boy", new ImageIcon("./resources/Boy.gif")));
        myPlayerActions.add(new PlayerAction("Guy", new ImageIcon("./resources/Guy.gif")));
        myPlayerActions.add(new PlayerAction("Girl2", new ImageIcon("./resources/Girl2.gif")));
        
=======
        myPlayerActions.add(new PlayerAction("Oldman", new ImageIcon("src/resources/Oldman.gif")));
        myPlayerActions.add(new PlayerAction("Oldwoman", new ImageIcon("src/resources/Oldwoman.gif")));
        myPlayerActions.add(new PlayerAction("Girl", new ImageIcon("src/resources/Girl.gif")));
        myPlayerActions.add(new PlayerAction("Boy", new ImageIcon("src/resources/Boy.gif")));
        myPlayerActions.add(new PlayerAction("Guy", new ImageIcon("src/resources/Guy.gif")));
        myPlayerActions.add(new PlayerAction("Girl2", new ImageIcon("src/resources/Girl2.gif")));

>>>>>>> zach_branch
        createPlayerMenu();
    }


    /**
     * This method creates player menu.
<<<<<<< HEAD
     * 
     * @return a fully-stocked player menu bar.
     */
    private ButtonGroup createPlayerMenu() {
        
=======
     *
     * @return a fully-stocked player menu bar.
     */
    private ButtonGroup createPlayerMenu() {

>>>>>>> zach_branch
//        /** The player menu for player items. */
//        final JMenuItem playerMenu = new JMenuItem(myMenuName);

        /** local variable to create player menu items. */
        final ButtonGroup btngrp = new ButtonGroup();
        setLayout(new GridLayout(3, 2));

        for (final PlayerAction ca : myPlayerActions) {
            final JRadioButtonMenuItem btn = new JRadioButtonMenuItem(ca);
            btngrp.add(btn);
            add(btn);
            if (btn.getText().equals("Oldman")) {
                btn.setSelected(true);
            }
        }
        return btngrp; //playerMenu;
    }

    /**
     * Abstract Action to use selected player
     *
     */
    private class PlayerAction extends AbstractAction {

        /** A generated serialization ID. */
        private static final long serialVersionUID = 5378597716905801474L;

        /** The player to use. */
        private final String mySpecificPlayerName;
<<<<<<< HEAD
        
=======

>>>>>>> zach_branch
//        /** The player to use. */
//        private final Icon mySpecificPlayerIcon;
//        
//        /** Icon for a button. */
//        private Icon icon;

        /**
         * Sets up a player and assign name and icon for it.
<<<<<<< HEAD
         * 
=======
         *
>>>>>>> zach_branch
         * @param theName player Name
         * @param theIcon player Icon
         */
        PlayerAction(final String theName, final Icon theIcon) {
            super(theName);
            Objects.requireNonNull(theName, "Player Name must not be null");
            Objects.requireNonNull(theIcon, "Player Icon must not be null");
<<<<<<< HEAD
            
=======

>>>>>>> zach_branch
            putValue(Action.SMALL_ICON, theIcon);
            mySpecificPlayerName = theName;
//            mySpecificPlayerIcon = theIcon;

            setLayout(new GridLayout(3, 2));
<<<<<<< HEAD
            
            // coordinate button selection
            putValue(Action.SELECTED_KEY, true);
            
=======

            // coordinate button selection
            putValue(Action.SELECTED_KEY, true);

>>>>>>> zach_branch
            putValue(Action.NAME, "");

//            myPlayerName = mySpecificPlayerName;


        }

        /**
         * Sets specific player icon for game
<<<<<<< HEAD
         * 
=======
         *
>>>>>>> zach_branch
         */
        @Override
        public void actionPerformed(ActionEvent theEvent) {
            myPlayerName = mySpecificPlayerName;
//            myPlayer.setPlayerIcon(myPlayerName);
//            myMazePane.repaint();

        }
    }
<<<<<<< HEAD
    
=======

>>>>>>> zach_branch


    /**
     * Method to get current players name
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> zach_branch
     * @return current player name
     */
    public String getPlayerName() {
        return myPlayerName;
    }
<<<<<<< HEAD
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

}
=======

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
>>>>>>> zach_branch
