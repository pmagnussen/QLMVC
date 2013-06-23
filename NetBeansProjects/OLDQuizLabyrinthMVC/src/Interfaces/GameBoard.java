package Interfaces;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 * Interface for GameBoard.
 * @author pmagnussen
 */

public interface GameBoard {

    public void paint(Graphics g);
    
    public void keyTyped(KeyEvent e);
    
    public void keyReleased(KeyEvent e);
    
    public void keyPressed(KeyEvent e);

    public boolean isFocusTraversable();
}