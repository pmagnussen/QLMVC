/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.GameObjects;

import org.junit.Test;


/**
 *
 * @author pmagnussen
 */
public class PlayerTest {

    /**
     * Test of moveRight method, of class Player.
     */
    @Test
    public void testMoveRight() {
        System.out.println("moveRight test");
        Player instance = new Player();
        int initXLocation = instance.getX();
        instance.moveRight();
        if (instance.getX() == initXLocation + 20) {
            System.out.println("Test to move right was successful");
        }
    }

    /**
     * Test of moveDown method, of class Player.
     */
    @Test
    public void testMoveDown() {
        System.out.println("moveDown test");
        Player instance = new Player();
        int initYLocation = instance.getY();
        instance.moveDown();
        if (instance.getY() == initYLocation + 20) {
            System.out.println("Test to move down was successful");
        }
    }
}
