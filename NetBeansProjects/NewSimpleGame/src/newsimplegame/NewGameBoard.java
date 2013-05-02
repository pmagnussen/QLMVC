/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newsimplegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;


    //@Override
/**
 *
 * @author pmagnussen
 */
public class NewGameBoard extends JPanel implements KeyListener{
    FirstWorld firstWorld;
    
    public NewGameBoard() {
        firstWorld = new FirstWorld();
        addKeyListener(this);
    }
    
    @Override
        public void paint(Graphics g) {
        super.paint(g); // Call it's parent for proper rendering.
        firstWorld.displayWorld(g);
        
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

