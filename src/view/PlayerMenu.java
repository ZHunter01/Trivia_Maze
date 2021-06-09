/*
  Trivia Maze TCSS 360 Spring 2021
 */

package view;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
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
public class PlayerMenu extends JMenu {

    /** The paths to the images OLD_MAN icon*/
    public final static String OLD_MAN = "resources/Oldman.gif";
    
    /** The paths to the images OLD_WOMAN icon*/
    public final static String OLD_WOMAN = "resources/Oldwoman.gif";
    
    /** The paths to the images BOY1 icon*/
    public final static String BOY1 = "resources/Boy.gif";
    
    /** The paths to the images GIRL1 icon*/
    public final static String GIRL1 = "resources/Girl.gif";
    
    /** The paths to the images GUY icon*/
    public final static String GUY = "resources/Guy.gif";
    
    /** The paths to the images GIRL2 icon*/
    public final static String GIRL2 = "resources/Girl2.gif";


    /** The name of this menu item */
    private final static String myMenuName = "Player";

    /** A list of players actions. */
    private List<PlayerAction> myPlayerActions;

    /** The field to interact with Player class */
    private Player myPlayer;

    /** The field to interact with mazePanel class */
    private MazePanel myMazePanel;

    /**
     * The constructor is to create player menu item.
     */
    public PlayerMenu() {
        super(myMenuName);

        setupPlayers();
    }

    /**
     * Sets up all the Tools for menu and menu bar.
     */
    private void setupPlayers() {
        myPlayerActions = new ArrayList<>();

        myPlayerActions.add(new PlayerAction("Oldman", OLD_MAN, new ImageIcon("resources/Oldman.gif")));
        myPlayerActions.add(new PlayerAction("Oldwoman", OLD_WOMAN, new ImageIcon("resources/Oldwoman.gif")));
        myPlayerActions.add(new PlayerAction("Girl", GIRL1, new ImageIcon("resources/Girl.gif")));
        myPlayerActions.add(new PlayerAction("Boy", BOY1, new ImageIcon("resources/Boy.gif")));
        myPlayerActions.add(new PlayerAction("Guy", GUY, new ImageIcon("resources/Guy.gif")));
        myPlayerActions.add(new PlayerAction("Girl2", GIRL2, new ImageIcon("resources/Girl2.gif")));

        createPlayerMenu();
    }

    /**
     * Setters for mazePanel
     * 
     * @param theMazePanel is the current mazePanel
     */
    public void setMazePanel(MazePanel theMazePanel) {
        myMazePanel = theMazePanel;
        myPlayer = myMazePanel.getMaze().getPlayer();
    }


    /**
     * This method creates player menu.
     *
     * @return a fully-stocked player menu bar.
     */
    private ButtonGroup createPlayerMenu() {
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

        /** The player to use. */
        @SuppressWarnings("unused")
        private final String mySpecificPlayerName;

        /** The path to player icon */
        private final String myPath;

        /**
         * Sets up a player and assign name and icon for it.
         *
         * @param theName player Name
         * @param theIcon player Icon
         */
        PlayerAction(final String theName, final String thePath, final Icon theIcon) {
            super(theName);
            Objects.requireNonNull(theName, "Player Name must not be null");
            Objects.requireNonNull(theIcon, "Player Icon must not be null");

            putValue(Action.SMALL_ICON, theIcon);
            mySpecificPlayerName = theName;

            setLayout(new GridLayout(3, 2));

            // coordinate button selection
            putValue(Action.SELECTED_KEY, true);

            putValue(Action.NAME, "");

            myPath = thePath;

        }

        /**
         * Sets specific player icon for game
         *
         */
        @Override
        public void actionPerformed(ActionEvent theEvent) {
            myPlayer.setImage(myPath);
            myPlayer.setImagePath(myPath);
            myMazePanel.repaint();
        }
    }
}
