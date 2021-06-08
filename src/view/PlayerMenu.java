/*
  Trivia Maze TCSS 360 Spring 2021
 */

package view;


import java.awt.GridLayout;
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
public class PlayerMenu extends JMenu {

    /**
     * The paths to the images
     */
    public final static String OLD_MAN = "src/resources/Oldman.gif";
    public final static String OLD_WOMAN = "src/resources/Oldwoman.gif";
    public final static String BOY1 = "src/resources/Boy.gif";
    public final static String GIRL1 = "src/resources/Girl.gif";
    public final static String GUY = "src/resources/Guy.gif";
    public final static String GIRL2 = "src/resources/Girl2.gif";

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

    private Player myPlayer;

    private MazePanel myMazePanel;

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
        myPlayerActions = new ArrayList<>();

        myPlayerActions.add(new PlayerAction("Oldman", OLD_MAN, new ImageIcon("src/resources/Oldman.gif")));
        myPlayerActions.add(new PlayerAction("Oldwoman", OLD_WOMAN, new ImageIcon("src/resources/Oldwoman.gif")));
        myPlayerActions.add(new PlayerAction("Girl", GIRL1, new ImageIcon("src/resources/Girl.gif")));
        myPlayerActions.add(new PlayerAction("Boy", BOY1, new ImageIcon("src/resources/Boy.gif")));
        myPlayerActions.add(new PlayerAction("Guy", GUY, new ImageIcon("src/resources/Guy.gif")));
        myPlayerActions.add(new PlayerAction("Girl2", GIRL2, new ImageIcon("src/resources/Girl2.gif")));

        createPlayerMenu();
    }

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

//        /** The player menu for player items. */
//        final JMenuItem playerMenu = new JMenuItem(myMenuName);

        /** local variable to create player menu items. */
        final ButtonGroup btngrp = new ButtonGroup();
        setLayout(new GridLayout(3, 2));

        for (final PlayerAction ca : myPlayerActions) {
            final JRadioButtonMenuItem btn = new JRadioButtonMenuItem(ca);
            btngrp.add(btn);
            add(btn);
//            btn.addActionListener(new ChangeIcon(ca.myPath));
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

        private final String myPath;

        //        /** The player to use. */
//        private final Icon mySpecificPlayerIcon;
//
//        /** Icon for a button. */
//        private Icon icon;

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
//            mySpecificPlayerIcon = theIcon;

            setLayout(new GridLayout(3, 2));

            // coordinate button selection
            putValue(Action.SELECTED_KEY, true);

            putValue(Action.NAME, "");

            myPath = thePath;

//            myPlayerName = mySpecificPlayerName;


        }

        /**
         * Sets specific player icon for game
         *
         */
        @Override
        public void actionPerformed(ActionEvent theEvent) {
            myPlayer.setImage(myPath);
            myPlayer.setImagePath(myPath);
            System.out.println(myPath);
            myMazePanel.repaint();
        }
    }
}