
/**
 * Trivia Maze TCSS 360 Spring 2021
 */

package view;
import java.awt.*;
import java.io.IOException;


/**
 * The main class is to launch GUI
 * 
 * @author Alik Balika 
 * @author Oleksandr Maistruk
 *
 */
public class Main {

    /**
     * The main method to launch GUI.
     * 
     * @param args
     */
    /**
     * @param args
     */
    public static void main(final String[] args) {
        EventQueue.invokeLater(() -> {
            Application execute = null;
            try {
                execute = new Application();
            } catch (final IOException theError) {
                theError.printStackTrace();
            }
            execute.setVisible(true);
        });
    }

}
