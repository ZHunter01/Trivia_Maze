import view.Window;

import java.awt.*;

/**
 * @author Alik Balika
 *
 * Runs the whole program
 */
public class TriviaMaze {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            view.Window ex;
            ex = new Window();
            ex.setVisible(true);
        });
    }

}
