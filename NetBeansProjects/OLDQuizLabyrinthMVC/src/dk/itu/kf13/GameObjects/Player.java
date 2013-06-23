package dk.itu.kf13.GameObjects;

import dk.itu.kf13.GameRunner.Main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/** Description of Player.
 * This class contains different parameters and methods to create and move the player on the gameBoard.
 * 
 *  Some parts of this code was written by Rafal Adam Rasztemborski <rras@itu.dk>.
 *  His contributions to this code is credited for every method and variable.
 * 
 *  @author Pætur Magnussen
 *  @author Rafal Adam Rasztemborski
 *  @version 1.0, Build 1 May 15, 2013.
 */

public class Player implements Interfaces.Player {
    // The player's parameters are set.
    private int x = 20;
    private int y = 20;
    private int width = 19;
    private int height = 19;
    private Color color = Color.blue;
    
    /**
     * displayPlayer draws the player on the gameBoard
     * 
     *  @author Pætur Magnussen
     *  @author Rafal Adam Rasztemborski
     * 
     * @param g 
     */
    @Override
    public void displayPlayer(Graphics g) {
    Graphics2D player = (Graphics2D) g;
    player.setColor(color);
    player.drawOval(x, y, width, height);
    player.fillOval(x, y, width, height);
    }

    /**
     * move() moves player by 20 pixels.
     * 
     *  @author Pætur Magnussen
     *  @author Rafal Adam Rasztemborski
     * 
     */
    @Override
    public void move(int keyCode) {
        switch (keyCode) {
            
            case KeyEvent.VK_LEFT:
                this.moveLeft();
                break;
                
            case KeyEvent.VK_RIGHT:
                this.moveRight();
                break;
                
            case KeyEvent.VK_DOWN:
                this.moveDown();
                break;
             
            case KeyEvent.VK_UP:
                this.moveUp();
                break;
        }
    }
    
    /** Moves the player to the left.
     * 
     *  @author Pætur Magnussen
     *  @author Rafal Adam Rasztemborski
     * 
     */
    @Override
    public void moveLeft(){
        x = x - Main.WORLDPIXEL;
    }
    
    /** Moves player to the right.
     * 
     *  @author Pætur Magnussen
     *  @author Rafal Adam Rasztemborski
     * 
     */
    @Override
    public void moveRight(){
        x = x + Main.WORLDPIXEL;
    }
    
    /** Moves player down.
     * 
     *  @author Pætur Magnussen
     *  @author Rafal Adam Rasztemborski
     *
     */
    @Override
    public void moveDown(){
        y = y + Main.WORLDPIXEL;
    }
    
    /**
     * Moves the player up.
     * 
     *  @author Pætur Magnussen
     *  @author Rafal Adam Rasztemborski
     * 
     */
    @Override
    public void moveUp(){
        y = y - Main.WORLDPIXEL;
    }
    
    /** A getter for the player's 'x-coordinate' in the two-dimensional array.
     * 
     * 
     * @return x/Main.WORLDPIXEL
     */
    @Override
    public int getX() {
        return x / Main.WORLDPIXEL;
    }
    
    /** A setter for the player's 'y-coordinate' in the two-dimensional array.
     * 
     * 
     * @return y/Main.WORLDPIXEL
     */
    @Override
    public int getY() {
        return y / Main.WORLDPIXEL;
    }
}