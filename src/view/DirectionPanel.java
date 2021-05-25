package view;

import javax.swing.*;
import java.awt.*;
import view.MazePanel.*;

/**
 * @author Alik Balika
 *
 * Contains the movement buttons that will move the player
 * This is a Singleton class
 */
public class DirectionPanel extends JPanel {

    /**
     * moves the player up
     */
    private JButton myUpButton;
    /**
     * moves the player down
     */
    private JButton myDownButton;
    /**
     * moves the player left
     */
    private JButton myLeftButton;
    /**
     * moves the player right
     */
    private JButton myRightButton;

    /**
     * The adapter passed in from the mazePanel which controls the player
     */
    private final TAdapter myAdapter;

//    /**
//     * Create an instance of the DirectionPanel
//     */
//    private static final DirectionPanel directionPanel = new DirectionPanel();

    /**
     * Constructs the panel and initializes buttons
     */
    public DirectionPanel(final MazePanel thePanel) {
        //setBorder(BorderFactory.createLineBorder(Color.BLUE));
        setLayout(new GridLayout());
        setPreferredSize(new Dimension(0, 50));

        myAdapter = thePanel.getMyAdapter();


        initAndAddButtons();
    }
//
//    /**
//     * @return the only instance of DirectionPanel
//     */
//    public static DirectionPanel getInstance() {
//        return directionPanel;
//    }

    /**
     * initializes all the buttons and adds them to the panel
     */
    // will replace text with icons
    private void initAndAddButtons() {
        myUpButton = createButton("UP");
        myDownButton = createButton("DOWN");
        myLeftButton = createButton("LEFT");
        myRightButton = createButton("RIGHT");
        add(myUpButton);
        add(myLeftButton);
        add(myRightButton);
        add(myDownButton);

        addActionListeners();
    }

    /**
     * creates the JButton in a method to remove duplicate code
     * @param theName The name of the button
     * @return a JButton object
     */
    private JButton createButton(String theName) {
        JButton button = new JButton(theName);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFocusable(false);
        return button;
    }

    /**
     * adds all of the actionListeners to the buttons
     */
    private void addActionListeners() {
        myLeftButton.addActionListener(e -> myAdapter.keyPressed(37));
        myUpButton.addActionListener(e -> myAdapter.keyPressed(38));
        myRightButton.addActionListener(e -> myAdapter.keyPressed(39));
        myDownButton.addActionListener(e -> myAdapter.keyPressed(40));

    }

}
