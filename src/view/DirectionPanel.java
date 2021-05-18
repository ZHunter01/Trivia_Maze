package view;

import javax.swing.*;
import java.awt.*;

/**
 * @author Alik Balika
 *
 * Contains the movement buttons that will move the player
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
     * Constructs the panel and initializes buttons
     */
    public DirectionPanel() {
        //setBorder(BorderFactory.createLineBorder(Color.BLUE));
        setLayout(new GridLayout());
        setPreferredSize(new Dimension(0, 50));

        initAndAddButtons();
    }

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
        add(myDownButton);
        add(myLeftButton);
        add(myRightButton);
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

}
