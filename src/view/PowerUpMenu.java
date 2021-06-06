package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import model.Door;
import model.Maze;
import model.PowerUp;
import model.Question;

/**
 * 
 * @author Zach Hunter
 *
 */
public class PowerUpMenu extends JMenu implements ActionListener {
    /**String name for PowerUp Perma-Unlock */
    private static final String PERMA_UNLOCK = "PermaUnlock";
    /**String name for PowerUp Free Question */
    private static final String FREE_QUESTION = "FreeQuestion";
   
    /**
     * 
     */
    private static final long serialVersionUID = 2859544975052134927L;
    private JMenuItem myPerma;
    private JMenuItem myFree;
    private MazePanel myMazePanel;
    
    /**
     * 
     * @param theMaze
     */
    public PowerUpMenu(final String theName) {
        super(theName);
                
        setUpPowerUps();
    }
    
    /**
     * 
     */
    public void enablePermaUnlock() {
        myPerma.setEnabled(true);
    }
    

    /**
     * 
     */
    public void enableFreeQuestion() {
        myFree.setEnabled(true);
    }
    
    /**
     * 
     */
    private void setUpPowerUps() {
        myPerma = new JMenuItem(PERMA_UNLOCK);
        myFree = new JMenuItem(FREE_QUESTION);
        
        myPerma.addActionListener(new PermaUnlock());
        myFree.addActionListener(new FreeQuestion());
        
        myPerma.setEnabled(false);
        myFree.setEnabled(false);
        
        add(myPerma);
        add(myFree);
    }
    
    /**
     * 
     * @author Zach Hunter
     *
     */
    private class PermaUnlock implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent theEvent) {
            final int currentDir = myMazePanel.getMaze().getDirection();
            //int currentDir = 4;
            if (!myMazePanel.getMaze().getCurrentRoom().getUserDoor(currentDir).isPermaLocked()) {
                return;
            } else {
                myMazePanel.getMaze().getCurrentRoom().getUserDoor(currentDir).setPermaLock(false);
                myMazePanel.getMaze().getPlayer().removePowerUp(PowerUp.createPermaUnlock());
                
                myPerma.setEnabled(false);
            }
            
        }
        
    }
    
    /**
     * 
     * @author Zach Hunter
     *
     */
    private class FreeQuestion implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent theEvent) {
            final int currentDir = myMazePanel.getMaze().getDirection();
            //int currentDir = 2;
            Door theDoor = myMazePanel.getMaze().getCurrentRoom().getUserDoor(currentDir);
            String solution = Question.getQuestionInstance().getSolution(theDoor.getId());
            
//            MazePanel.getMaze();
            
            myMazePanel.getMaze().doorSolution(solution, currentDir);
            myMazePanel.repaint();
            
            myMazePanel.getMaze().getPlayer().removePowerUp(PowerUp.createFreeQuestion());
            
            myFree.setEnabled(false);
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

    public void setMazePanel(MazePanel theMazePanel) {
        myMazePanel = theMazePanel;
    }
}
