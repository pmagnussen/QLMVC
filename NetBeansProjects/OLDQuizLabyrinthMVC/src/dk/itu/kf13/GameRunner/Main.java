package dk.itu.kf13.GameRunner;

import dk.itu.kf13.GameObjects.GameBoard;
import dk.itu.kf13.GameObjects.Player;
import dk.itu.kf13.GameObjects.Question;
import dk.itu.kf13.GameWorld.ScoreBoard;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/** Description of Main.
 *  This class contains the main method used to run the program,
 *  along with variables and parameters that determine the size and title of the
 *  window. Furthermore, it hold two methods setupGame() and runGame() that
 *  setups and runs the game.
 * 
 *  Some parts of this code was written by Rafal Adam Rasztemborski <rras@itu.dk>.
 *  His contributions to this code is credited for every method and variable.
 * 
 *  @author Pætur Magnussen
 *  @author Rafal Adam Rasztemborski
 *  @version 1.0, Build 1 May 15, 2013.
 */

public class Main  {
    
        /**
     * Main() is the class constructor with methods setupGame() and runGame().
     * @throws InterruptedException
     * 
     * @author Rafal Adam Rasztemborski
     */
    public Main() throws InterruptedException{
          setupGame();
          runGame();
     }
    
    // These are the game parameters.
    
    /**
     * TITLE defines frame title.
     * @author Rafal Adam Rasztemborski
     */
    public final String TITLE = "Quiz Game";
    
    /**
     * WIDTH sets width of the frame.
     * @author Rafal Adam Rasztemborski
     */
    public static final int WIDTH = 600;
    
    /**
     * HEIGHT sets height of the frame.
     * @author Rafal Adam Rasztemborski
     */
    public static final int HEIGHT = 643;
    
    /**
     * WINDOW_TOP_BAR_HEIGHT is an internal reference for height of the system bar on top of the frame.
     */
    public static final int WINDOW_TOP_BAR_HEIGHT = 23;
    
    /**
     * SCORE_BOARD_HEIGHT is an internal definition for height of the score board bar below the frame.
     */
    public static final int SCORE_BOARD_HEIGHT = 20;
    
    /**
     * WORLD_HEIGHT is an internal definition for height of the world excluding the system bar on top of
     * the frame and the score board below it.
     */
    public static final int WORLD_HEIGHT = HEIGHT-WINDOW_TOP_BAR_HEIGHT-SCORE_BOARD_HEIGHT;
    
    /**
     * WORLD_WIDTH is a reference for width of the frame and world - only written in respect to consistency.
     */
    public static final int WORLD_WIDTH = WIDTH;
    
    /**
     * WORLDPIXEL defines the minimum size of objects drawn in the application.
     */ 
    public static final int WORLDPIXEL = 20;
    
    /**
     * gameOver stores the status of the game - whether it has reached termination or not.
     */
    boolean gameOver = false;

    // Creates a new JFrame - @author Rafal Adam Rasztemborski
    JFrame jframe;
     
    // These are the components that are drawn on the frame.
    GameBoard gameBoard; // @author Rafal Adam Rasztemborski
    ScoreBoard scoreBoard;
    Player player; // @author Rafal Adam Rasztemborski
    
    /**
     * setupGame() set up the main objects of the game such as the frame,
     * the player, the gameBoard and scoreBoard.
     * 
     * @author Rafal Adam Rasztemborski
     * @author Pætur Magnussen
     */
    public void setupGame() throws InterruptedException{
        // Instantiates the JFrame to variable jframe.
        jframe = new JFrame(TITLE);
       
        // Sets its dimensions to the specified width and height.
        jframe.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        
        // The window closes when the 'X' in the system bar is pressed.
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Instantiates the objects player, scoreBoard, and gameBoard.
        player = new Player();
        scoreBoard = new ScoreBoard();
        gameBoard = new GameBoard(player, scoreBoard);
       
        // Adds gameBoard (JPanel) component to the frame.
        jframe.add(gameBoard);
        jframe.pack();
        jframe.setVisible(true);   // Set visible after adding component. Otherwise wont display.
    }
    
    /**
     * runGame() runs the application until termination.
     * @throws InterruptedException
     * 
     * @author Rafal Adam Rasztemborski
     * @author Pætur Magnussen
     */
    public void runGame() throws InterruptedException {
        // As long as game is not over, the gameBoard is repainted.
        while(!gameOver){
            gameBoard.repaint();
            Thread.sleep(10);
            
            // If the users manages to answer three questions correctly - that is to earn 300 points - the user has won.
            if (scoreBoard.totalScore == 300) {
                gameOver = true;
                JOptionPane.showMessageDialog(null, "You got " + scoreBoard.totalScore + " points - You win", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}