package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class PowerUpMenu extends JMenu implements ActionListener{
    private static final String PERMA_UNLOCK = "PermaUnlock";
    private static final String FREE_QUESTION = "FreeQuestion";
   // private static final String NO_POWERUP = "You don't have any PowerUps";
   
    /**
     * 
     */
    private static final long serialVersionUID = 2859544975052134927L;
    private JMenuItem myPerma;
    private JMenuItem myFree;
        
    /**
     * 
     * @param theMaze
     */
    public PowerUpMenu(final String theName) {
        //setPreferredSize(new Dimension(0, 5));
        //setBackground(new Color(200, 150, 0));
        super(theName);
        //myMaze = theMaze;
        
        setUpPowerUps();
        
        //JLabel unlockLabel = new JLabel(PERMA_UNLOCK);
       // JLabel freeLabel = new JLabel(FREE_QUESTION);
       // new JLabel(NO_POWERUP);
        
        //unlockLabel.setVisible(false);
        //freeLabel.setVisible(false);
        
        //addLabels();
    }
    
    public void enablePermaUnlock() {
        myPerma.setEnabled(true);
    }
    

    public void enableFreeQuestion() {
        myFree.setEnabled(true);
    }
    
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
    
    private class PermaUnlock implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent theEvent) {
            
            
        }
        
    }
    
    private class FreeQuestion implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent theEvent) {
            // TODO Auto-generated method stub
            
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    
//    private ButtonGroup createPowerUpMenu() {
//        final ButtonGroup btngrp = new ButtonGroup();
//        
//        
//        JRadioButtonMenuItem button = new JRadioButtonMenuItem();
//        btngrp.add(myPerma);
//        add(btn);
//        
//        return btngrp;
//    }
    
//    /**
//     * 
//     */
//    public void hasPowerUps(final Player thePlayer) {
////        if (thePlayer.containsFreeQuestion()) {
////            freeLabel.setVisible(true);
////        }
////        if (thePlayer.containsPermaUnlock()) {
////            unlockLabel.setVisible(true);
////        }
////        if (thePlayer.getPowerUps().isEmpty()) {
////            noPowerUpLabel.setVisible(true);
////        }
//        
//    }
    
//    /**
//     * 
//     */
//    private void addLabels() {
////        JLabel unlockLabel = new JLabel(PERMA_UNLOCK);
////        JLabel freeLabel = new JLabel(FREE_QUESTION);
////        JLabel noPowerUpLabel = new JLabel(NO_POWERUP);
////        
////        unlockLabel.setVisible(false);
////        freeLabel.setVisible(false);
//        
//        this.add(noPowerUpLabel, JPanel.CENTER_ALIGNMENT);
//        this.add(unlockLabel, JPanel.TOP_ALIGNMENT);
//        this.add(freeLabel, JPanel.BOTTOM_ALIGNMENT);
//    }
    

    
    
    
    
}
