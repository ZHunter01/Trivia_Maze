/**
 * Trivia Maze TCSS 360 Spring 2021
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import model.Door;
import model.PowerUp;
import model.Question;

/** Class for setting up PowerUp JMenu
 * 
 * @author Zach Hunter
 *
 */
public class PowerUpMenu extends JMenu implements ActionListener {
    /**Serializable generated number */
    private static final long serialVersionUID = 2859544975052134927L;
    /**String name for PowerUp Perma-Unlock */
    private static final String PERMA_UNLOCK = "PermaUnlock";
    /**String name for PowerUp Free Question */
    private static final String FREE_QUESTION = "FreeQuestion";
    /** */
    private static final String MENU_NAME = "PowerUps";
    /**JMenuItem for PermaUnlock PowerUp */
    private JMenuItem myPerma;
    /**JMenuItem for FreeQuestion PowerUp */
    private JMenuItem myFree;
    /**MazePanel reference */
    private MazePanel myMazePanel;
    /**AnswerPanel reference */
    private AnswerPanel myAnswerPanel;
    
    /** Creates a JMenu with PowerUps name and sets up the menu
     * 
     * @param theMaze
     */
    public PowerUpMenu() {
        super(MENU_NAME);
          
        //Set Up menu
        setUpPowerUps();
    }
    
    /** Set myAnswerPanel and myMazePanel
     * 
     * @param theMazePanel
     */
    public void setPanels(final MazePanel theMazePanel) {
        myMazePanel = theMazePanel;
        myAnswerPanel = theMazePanel.getAnswerPanel();
    }
    
    /**Enable MenuItem myPerma
     * 
     */
    public void enablePermaUnlock() {
        myPerma.setEnabled(true);
    }
    

    /** Enable MenuItem myFree
     * 
     */
    public void enableFreeQuestion() {
        myFree.setEnabled(true);
    }
    
    /**Sets up JMenu Items
     * 
     */
    private void setUpPowerUps() {
        myPerma = new JMenuItem(PERMA_UNLOCK);
        myFree = new JMenuItem(FREE_QUESTION);
        
        myPerma.addActionListener(new PermaUnlock());
        myFree.addActionListener(new FreeQuestion());
        
        //By Default the MenuItems aren't enabled
        myPerma.setEnabled(false);
        myFree.setEnabled(false);
        
        //Add JMenuItems to the Menu
        add(myPerma);
        add(myFree);
    }
    
    /** Action Listener for myPerma
     * 
     * @author Zach Hunter
     *
     */
    private class PermaUnlock implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent theEvent) {
            //Get current user direction
            final int currentDir = myMazePanel.getMaze().getDirection();
            //If the door isn't Perma-Locked then do nothing
            if (!myMazePanel.getMaze().getCurrentRoom().getUserDoor(currentDir).isPermaLocked()) {
                return;
            } else {
                myMazePanel.getMaze().getCurrentRoom().getUserDoor(currentDir).setPermaLock(false);
                //Remove PowerUp from Player object
                myMazePanel.getMaze().getPlayer().removePowerUp(PowerUp.createPermaUnlock());
                //Once used MenuItem becomes disabled
                myPerma.setEnabled(false);
            }
            
        }
        
    }
    
    /** Action Listener for myFree
     * 
     * @author Zach Hunter
     *
     */
    private class FreeQuestion implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent theEvent) {
            //Get current userDir
            final int currentDir = myMazePanel.getMaze().getDirection();
            //Get current Door
            final Door theDoor = myMazePanel.getMaze().getCurrentRoom().getUserDoor(currentDir);
            //Input correct solution and move the player forward
            final String solution = Question.getQuestionInstance().getSolution(theDoor.getId());
            myAnswerPanel.getAnswerField().setText(solution);
            myAnswerPanel.buttonListener();
            
            //Remove PowerUP from Player object
            myMazePanel.getMaze().getPlayer().removePowerUp(PowerUp.createFreeQuestion());
            
            //Disable MenuItem after use
            myFree.setEnabled(false);
        }
        
    }

    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        //Eclipse wants this here
        return;
    }


}
