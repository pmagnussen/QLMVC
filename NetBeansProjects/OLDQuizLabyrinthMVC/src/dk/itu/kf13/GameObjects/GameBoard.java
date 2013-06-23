package dk.itu.kf13.GameObjects;

import dk.itu.kf13.GameWorld.ScoreBoard;
import dk.itu.kf13.GameWorld.World;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/** Description of GameBoard.
 * This class contains the object gameBoard which is drawn on the frame.
 * It contains a paint method and methods for responding to key events.
 * 
 *  Some parts of this code was written by Rafal Adam Rasztemborski <rras@itu.dk>.
 *  His contributions to this code is credited for every method and variable.
 * 
 *  @author Pætur Magnussen
 *  @author Rafal Adam Rasztemborski
 *  @version 1.0, Build 1 May 15, 2013.
 */

public class GameBoard extends JPanel implements KeyListener, Interfaces.GameBoard {
    World world;
    Player player;
    ScoreBoard scoreBoard;
    Question question;

    /**
     * This is the class constructor that creates an object of world, question, scoreboard, and player.
     * 
     *  @author Pætur Magnussen
     *  @author Rafal Adam Rasztemborski
     * 
     * @param player
     * @param scoreBoard 
     */
    public GameBoard(Player player, ScoreBoard scoreBoard) {
        world = new World(player, scoreBoard);
        question = new Question();
        this.scoreBoard = scoreBoard;
        this.player = player;
        addKeyListener(this);
    }
    
    /**
     * This method paints the game objects.
     * 
     *  @author Pætur Magnussen
     *  @author Rafal Adam Rasztemborski
     * 
     * @param g 
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        world.displayWorld(g);
        scoreBoard.displayScoreBoard(g);
        player.displayPlayer(g);
    }
    
    /**
     * keyTyped is not utilized in the application.
     * @param e 
     */
    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * keyReleased is not utilized the application.
     * @param e 
     */
    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * keyPressed is utilized to move the player if that is a legal action, check for a question, give the player a question is he is on one,
     * and check the players answer.
     * 
     *  @author Pætur Magnussen
     *  @author Rafal Adam Rasztemborski
     * 
     * @param e 
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (world.checkForWallCollision(keyCode)) {
            player.move(keyCode);
                if (world.checkForQuestion(player)) {
                    world.worldArray[player.getY()][player.getX()] = 0;
                    question.giveMeAQuestion();
                    question.checkAnswer(scoreBoard);
            }
        }
    }
    
    @Override
    public boolean isFocusTraversable() {
        return true;
    }
}