import view.Application;

import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Application ex = null;
            try {
                ex = new Application();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ex.setVisible(true);
        });
    }

}
