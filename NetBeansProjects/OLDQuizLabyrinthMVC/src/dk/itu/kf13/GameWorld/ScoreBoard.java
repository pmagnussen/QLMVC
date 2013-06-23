package dk.itu.kf13.GameWorld;

import dk.itu.kf13.GameObjects.GameBoard;
import dk.itu.kf13.GameObjects.Player;
import dk.itu.kf13.GameRunner.Main;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/** Description of ScoreBoard.
 * This class contains different parameters and methods for drawing and changing the score.
 * 
 *  @author Pætur Magnussen
 *  @version 1.0, Build 1 May 15, 2013.
 */
public class ScoreBoard extends JPanel implements Interfaces.ScoreBoard {
    Player player;
    GameBoard gameBoard;
    
    /**
     * How many point a right answer awards the player.
     */
    public int point = 100;
    
    /**
     * The total score is stored here.
     */
    public int totalScore;
    
    /** Draws the score on the gameBoard.
     * 
     * @param g 
     */
    @Override
    public void displayScoreBoard (Graphics g) {

    // This is player rendered graphics.
    Graphics2D score = (Graphics2D) g;
    score.setFont(new Font("Arial", Font.BOLD, 12));
    score.drawString("Score: " + totalScore, Main.WIDTH-85, Main.HEIGHT-28);
    }
    
    /**
     * Method for changing the score - can be used by other classes when the
     * user has answered correctly and deserves points
     * 
     */
    @Override
    public void changeTotalScore () {
        totalScore = totalScore + point;
    }  
}