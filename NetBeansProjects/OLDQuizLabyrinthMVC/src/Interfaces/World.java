package Interfaces;

import java.awt.Graphics;

/**
 * Interface for World.
 * @author pmagnussen
 */
public interface World {
    
    public int[][] getWorldArray();

    public void setWorldArray(int x, int y, int value);
    
    public boolean checkForQuestion(Player player);
    
    public boolean checkForWallCollision(int keyCode);

    public void displayWorld(Graphics g);
}