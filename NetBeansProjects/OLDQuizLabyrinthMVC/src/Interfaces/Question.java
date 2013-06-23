/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author pmagnussen
 */
public interface Question {

    public int getNumberOfTries ();
    
    public void giveMeAQuestion ();

    public void checkAnswer(ScoreBoard scoreBoard);
    
    public void questionGenerator (int randomNumber);   
}
