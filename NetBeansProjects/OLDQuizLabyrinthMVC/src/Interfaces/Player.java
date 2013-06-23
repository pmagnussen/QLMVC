/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.awt.Graphics;

/**
 * Interface for Player.
 * @author pmagnussen
 */
public interface Player {
    public void displayPlayer(Graphics g);

    public void move(int keyCode);
    
    public void moveLeft();

    public void moveRight();

    public void moveDown();

    public void moveUp();
    
    public int getX();
    
    public int getY();
}