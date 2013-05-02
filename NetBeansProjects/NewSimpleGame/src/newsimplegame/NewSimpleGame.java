/**
 * @author Rasztemberg
 */

package newsimplegame;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *  
 *  This is the main logic of the game. 
 *  Class loads game objects and sets up the main window.
 *  
 *  
 */

public class NewSimpleGame  {

    
    // GAME PARAMETERS 
    
    /**
     * Defines frame title 
     */
    public final String TITLE = "Snake Game";
    /**
     * Sets width of the frame
     */
    public static final int WIDTH = 600; 
    /**
     * Sets height of the frame
     */
    public static final int HEIGHT = 623; 
  
   
    // Main window ( frame )  This where the game is creted. 
    // To the window u can add components. Like a gameBoard
    
    JFrame jframe;            
     
    // This is player component, drawn on the frame
    NewGameBoard gameBoard;
    //Player player2;
    
    public static final int WINDOW_TOP_BAR_HEIGHT = 23;
    
    public static final int WORLD_BAR_WIDTH = 50;
   
    public static final int WORLD_HEIGHT = HEIGHT-WINDOW_TOP_BAR_HEIGHT;
    
    public static final int WORLD_WIDTH = WIDTH;
    
    public static final int WORLDPIXEL = 20;

   
//    public int getWorldBarWidth() {
//        return WORLD_BAR_WIDTH;
//    }
    
    public NewSimpleGame() throws InterruptedException{
          setupGame();
          runGame();
     }
    
    /**
     *  
     * Setup the main objects of the game like frame or {@link Player} player
     *
     */
    public void setupGame() throws InterruptedException{
        
        
        // SETUP THE MAIN FRAME 
        jframe = new JFrame(TITLE);
       
        jframe.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        
        //jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // When window 'x' pressed quit.
        
        gameBoard = new NewGameBoard();
       
        // Add gameBoard (JPanel) component to the Frame
        jframe.add(gameBoard);
        
        jframe.pack();
       
        jframe.setVisible(true);   // Set visible after adding component. Otherwise wont display.
       
    }
    
     /* ---------------------------------
     *  
     *  Creates main objects of the game. 
     * 
     * ---------------------------------
     */
    
    /**
     *
     * @throws InterruptedException
     */
    public void runGame() throws InterruptedException {
        
        
        while(true){
            //gameBoard.repaint();
            Thread.sleep(10);
        }
    }

     /**
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
       
        // Instantiate the game.
        NewSimpleGame snakeGame = new NewSimpleGame();
     } 
}
