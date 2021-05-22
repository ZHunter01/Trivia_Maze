package view;

import model.Maze;
import model.Room;

import javax.swing.*;
import java.awt.*;

public class MazePanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1955289441832917137L;
    private Maze maze;

    public MazePanel() {
        //super(new GridLayout());
        maze = new Maze();
        //addMaze();
        //setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(Color.BLUE);
    }

//    private void addMaze() {
//        for (Room[] rooms : maze.getMyMaze()) {
//            for (Room room : rooms) {
//
//            }
//        }
//    }

    //166
    //110
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int y = 0;
        for (Room[] rooms : maze.getMyMaze()) {
            int x = 0;
            for (Room room : rooms) {
                g.drawImage(room.getImage(), x, y, this);
                x+= 166;
            }
            y += 110;
        }

//        g.drawImage(new Room().getImage(), 0, 0, this);
//        g.drawImage(new Room().getImage(), 166, 110, this);
//        g.drawImage(new Room().getImage(), 332, 220, this);
//        g.drawImage(new Room().getImage(), 498, 330, this);
//        g.fillOval(0, 0, 20, 20);
//        g.fillOval(650, 0, 20, 20);
//        g.fillOval(0, 425, 20, 20);
    }

}
