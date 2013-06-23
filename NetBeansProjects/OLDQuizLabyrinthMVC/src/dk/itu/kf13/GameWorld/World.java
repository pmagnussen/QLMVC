package dk.itu.kf13.GameWorld;

import dk.itu.kf13.GameObjects.Player;
import dk.itu.kf13.GameRunner.Main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/** Description of World.
 * This class contains the properties of the world which is drawn on the gameBoard.
 * It also contains method for determining if the player is about to collide with
 * with walls or not and if he is allowed to move,
 * it checks if the player is on a question object,
 * it contains a setter and getter for other classes to modify the world.
 * 
 *  Some parts of this code was written by Rafal Adam Rasztemborski <rras@itu.dk>.
 *  His contributions to this code is credited for every method and variable.
 * 
 *  @author Pætur Magnussen
 *  @author Rafal Adam Rasztemborski
 *  @version 1.0, Build 1 May 15, 2013.
 */

public class World implements Interfaces.World{
    public int[][] worldArray;
    Player player;
    ScoreBoard scoreBoard;
    
    /**
     * World is the class constructor that creates the world based on a
     * two-dimensional array with 0s, 1s, and 2s. The 0s represent space in which
     * the player can move; the 1s represent walls; and the 2s represent question
     * symbols.
     * 
     * @param player
     * @param scoreBoard 
     */
    public World (Player player, ScoreBoard scoreBoard) {
        this.player = player;
        this.scoreBoard = scoreBoard;
        this.worldArray = new int [][] {
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,1,1,1,1,2,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,0,0,0,0,1,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,1,1,1,1,1,0,1,0,2,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1},
        {1,0,0,0,0,0,1,0,1,1,1,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,1,1,1,1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,0,0,0,0,1,0,1,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,1,1,1,1,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,1,1,0,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,0,0,1,0,1,0,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,0,0,1},
        {1,0,1,0,1,0,1,0,1,0,1,0,1,1,2,1,0,1,0,1,0,1,1,1,0,1,1,1,0,1},
        {1,0,1,0,1,0,1,0,1,0,2,0,1,0,0,1,0,1,0,1,0,0,0,0,0,0,0,1,0,1},
        {1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,1,0,1,0,0,0,1,1,1,1,1,0,1,0,1},
        {1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,1,0,1},
        {1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,1,1,1,0,1,0,1},
        {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,2,1,0,1,0,1},
        {1,0,1,0,1,0,1,0,1,0,1,0,1,0,2,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1},
        {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1},
        {1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1},
        {1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1},
        {1,0,0,0,2,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1},
        {1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,1},
        {1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,0,1,0,1,1,1,1,1,1,1,1,0,1,1,1},
        {1,0,0,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,0,0,0,0,1,0,0,0,1},
        {1,2,1,1,1,1,1,0,1,0,1,0,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,2,1},
        {1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
        };
    }
    
    /**
     * getWorld returns worldArray for other classes to use.
     * @return 
     */
    @Override
    public int[][] getWorldArray() {
        return worldArray;
    }

    /**
     * setWorldArray allows other classes to make changes to WorldArray.
     * 
     * 
     * @param x
     * @param y
     * @param value 
     */
    @Override
    public void setWorldArray(int x, int y, int value) {
        worldArray[y][x] = value;
    }
    
    /**
     * checkForQuestion returns true if the player object is on a question object.
     * @param player
     * @return 
     */
    @Override
    public boolean checkForQuestion (Interfaces.Player player) {
        if (worldArray[player.getY()][player.getX()] == 2) {
            return true;
        }
        return false;
    }
    
    /**
     * checkForWallCollision returns true if the player is standing next to a wall
     * in which case he is either allowed to or not to move.
     * 
     * @param keyCode
     * @return 
     */
    @Override
    public boolean checkForWallCollision(int keyCode) {
        
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                if (worldArray[player.getY()][player.getX()-1] != 1) {
                    return true;
                }
            break;
                
            case KeyEvent.VK_RIGHT:
                if (worldArray[player.getY()][player.getX()+1] != 1) {
                    return true;
                }
            break;
                
            case KeyEvent.VK_DOWN:
                if (worldArray[player.getY()+1][player.getX()] != 1) {
                    return true;
                }
            break;
                
            case KeyEvent.VK_UP:
                if (worldArray[player.getY()-1][player.getX()] != 1) {
                    return true;
                }
            break;
        }
        return false;
    }

    /**
     * displayWorld renders the world on the gameBoard.
     * @param g
     * 
     * @author Pætur Magnussen
     * @author Rafal Adam Rasztemborski
     */
    @Override
    public void displayWorld(Graphics g) {

    // This is player rendered graphics.
    Graphics2D world = (Graphics2D) g;    // Graphical library to render shapes.

    for (int x = 0; x < (Main.WORLD_WIDTH / Main.WORLDPIXEL); x++) {
        for (int y = 0; y < (Main.WORLD_HEIGHT / Main.WORLDPIXEL); y++) {

            if (worldArray[y][x] == 1) {
                world.setColor(Color.darkGray);
            }

            if (worldArray[y][x] == 0) { 
                world.setColor(Color.white);
                }
            
            if(worldArray[y][x] == 2) {
                world.setColor(Color.CYAN);
            }
            
            world.drawRect(x*Main.WORLDPIXEL, y*Main.WORLDPIXEL, Main.WORLDPIXEL, Main.WORLDPIXEL);
            world.fillRect(x*Main.WORLDPIXEL, y*Main.WORLDPIXEL, Main.WORLDPIXEL, Main.WORLDPIXEL);
            }
        }
    }
}