/**
 * Trivia Maze TCSS 360 Spring 2021
 */

package view;


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
import javax.swing.JRadioButtonMenuItem;

import model.Player;

/**
 * This class is to allow users to choose different types of questions.
 * 
 * @author Oleksandr Maistruk
 *
 */
public class PlayerMenu extends JMenu implements ActionListener {

    /**
     * Serial number
     */
    private static final long serialVersionUID = 4885009744733200311L;
    
    /** Width for player bar icons. */
    private static final int TOOL_FOR_BAR_ICON_WIDTH = 5;

    /** Height for player bar icons. */
    private static final int TOOL_FOR_BAR_ICON_HEIGHT = 5;

    /** The name of this menu item */
    private final static String myMenuName = "Player";

    /** A list of players actions. */
    private List<PlayerAction> myPlayerActions;
    
    private String myPlayerName;
    
//    private final MyMenuBar myMenuBar;
    
//    private Player myPlayer;
    
    /**
     * The constructor is to create player menu item.
     */
    public PlayerMenu() {  
        super(myMenuName);
        
//        myMenuBar = theMenuBar;
        
        setupPlayers();
    }
    
    /**
     * Sets up all the Tools for menu and menu bar.
     */
    private void setupPlayers() {
        myPlayerActions = new ArrayList<PlayerAction>();

        myPlayerActions.add(new PlayerAction("Oldman", new ImageIcon("./resources/images/Oldman.gif")));
        myPlayerActions.add(new PlayerAction("player", new ImageIcon("./resources/images/player.gif")));
        createPlayerMenu();
    }


    /**
     * This method creates player menu.
     * 
     * @return a fully-stocked player menu bar.
     */
    private ButtonGroup createPlayerMenu() {
        
//        /** The player menu for player items. */
//        final JMenuItem playerMenu = new JMenuItem(myMenuName);

        /** local variable to create player menu items. */
        final ButtonGroup btngrp = new ButtonGroup();

        for (final PlayerAction ca : myPlayerActions) {
            final JRadioButtonMenuItem btn = new JRadioButtonMenuItem(ca);
            btngrp.add(btn);
            add(btn);
            setIcon(ca.icon);
            if (btn.getText().equals("Oldman"))
                btn.setSelected(true);
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
        
        /** The player to use. */
        private final Icon mySpecificPlayerIcon;
        
        /** Icon for a button. */
        private Icon icon;

        /**
         * Sets up a player and assign name and icon for it.
         * 
         * @param theName player Name
         * @param theIcon player Icon
         */
        PlayerAction(final String theName, final Icon theIcon) {
            super(theName);
            Objects.requireNonNull(theName, "Tool Name must not be null");
            Objects.requireNonNull(theIcon, "Tool Icon must not be null");
            mySpecificPlayerName = theName;
            mySpecificPlayerIcon = theIcon;

            putValue(Action.SMALL_ICON, mySpecificPlayerIcon);
            setIcon(mySpecificPlayerIcon);

            if (theName.equals("Oldman")) {
                myPlayerName = mySpecificPlayerName;
            }

        }

        /**
         * Sets specific player as icon for game
         * 
         */
        @Override
        public void actionPerformed(ActionEvent theEvent) {
            myPlayerName = mySpecificPlayerName;
            Player.setPlayerIcon(myPlayerName);
            
            putValue(Action.SMALL_ICON, icon);
        }
    }
    


    /**
     * Method to get current players name
     * 
     * @return current player name
     */
    public String getPlayerName() {
        return myPlayerName;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

}
