package view;

import javax.swing.*;
import java.awt.*;

public class DirectionPanel extends JPanel {

    private JButton myUpButton;
    private JButton myDownButton;
    private JButton myLeftButton;
    private JButton myRightButton;

    public DirectionPanel() {
        //setBorder(BorderFactory.createLineBorder(Color.BLUE));
        setLayout(new GridLayout());
        setPreferredSize(new Dimension(0, 50));

        initAndAddButtons();
    }

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

    private JButton createButton(String theName) {
        JButton button = new JButton(theName);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFocusable(false);
        return button;
    }

}
