package dk.itu.kf13.GameObjects;

import dk.itu.kf13.GameWorld.ScoreBoard;
import java.util.Random;
import javax.swing.JOptionPane;

/** Description of Question.
 * This class contains methods and parameters relevant to the questions that are set to the user.
 * It contains a randomNumberGenerator to select a random question;
 * Strings for questions, userAnswers, rightAnswers; an int variable to store
 * how many tries the user has had, and some methods.
 * 
 *  @author Pætur Magnussen
 *  @version 1.0, Build 1 May 15, 2013.
 */

public class Question implements Interfaces.Question {
    // Creates and instantiates an object of type random.
    Random randomNumberGenerator = new Random();
    private int randomNumber;
    
    // String array for storing a question and a set of multiple choice answers. 
    private String[] answers = new String[3];
    private String question;
    private String userAnswer;
    private String rightAnswer;
    
    // For keeping track of how many trials the user has had.
    private int numberOfTries = 0;
    
    ScoreBoard score;
    
    /** getnumberOfTries returns how many trials the user has had.
     * 
     * @return numberOfTries
     */
    @Override
    public int getNumberOfTries () {
        return numberOfTries;
    }
    
    /** giveMeAQuestion() gives the user a question.
     * 
     */
    @Override
    public void giveMeAQuestion () {
        numberOfTries++;
        
        randomNumber = randomNumberGenerator.nextInt(10);
        questionGenerator(randomNumber);

        Object questionBox = JOptionPane.showInputDialog(null, question, "Question " + numberOfTries, JOptionPane.QUESTION_MESSAGE, null, answers, answers[0]);
        userAnswer = questionBox.toString();
    }
    
    /** Checks the user's answer.
     * 
     * @param scoreBoard 
     */
    @Override
    public void checkAnswer(Interfaces.ScoreBoard scoreBoard) {
        if (userAnswer.equals(rightAnswer)) {
            JOptionPane.showMessageDialog(null, "Trudat!", "Yeah boyyyy...", JOptionPane.INFORMATION_MESSAGE);
            scoreBoard.changeTotalScore();
        } else {
            JOptionPane.showMessageDialog(null, "You suck!", "Boo....", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Give the user a question based on the number from the random generator.
     * @param randomNumber 
     */
    @Override
    public void questionGenerator (int randomNumber) {
        switch (randomNumber) {
            case 0:
            question = "What is the biggest country in the world?";

            answers[0] = "USA";
            answers[1] = "China";
            answers[2] = "Russia";
            rightAnswer = answers[2].toString();
            break;
        
            case 1:
            question = "How many people have ever lived here on earth?";

            answers[0] = "Approximately 60 bilion people";
            answers[1] = "Approximately 80 bilion people";
            answers[2] = "Approximately 100 bilion people";
            rightAnswer = answers[2].toString();
            break;
                
            case 2:
            question = "How old is Planet Earth?";

            answers[0] = "1,7 Billion years old";
            answers[1] = "2,7 Billion years old";
            answers[2] = "3,7 Billion years old";
            rightAnswer = answers[2].toString();
            break;
                
            case 3:
            question = "When was Søren Kierkegaard born?";

            answers[0] = "Year 1713";
            answers[1] = "Year 1813";
            answers[2] = "Year 1913";
            rightAnswer = answers[1].toString();
            break;
        
            case 4:
            question = "Why are you?";

            answers[0] = "Because I think";
            answers[1] = "Because I play this game";
            answers[2] = "I am for a reason";
            rightAnswer = answers[1].toString();
            break;
                
            case 5:
            question = "I this a funny game so far?";

            answers[0] = "Yes it is";
            answers[1] = "No it is not";
            answers[2] = "I am not sure";
            rightAnswer = answers[0].toString();
            break;
                
            case 6:
            question = "What is spjklrtf spelled from behind" ;

            answers[0] = "ftrlkpjs";
            answers[1] = "ftrlkjpf";
            answers[2] = "ftrlkjps";
            rightAnswer = answers[2].toString();
            break;  
                
            case 7:
            question = "I always lie. Is that a lie?";

            answers[0] = "No";
            answers[1] = "Insolvable";
            answers[2] = "Yes";
            rightAnswer = answers[1].toString();
            break; 
                
            case 8:
            question = "Is jesus spelled with or without a capital letter";

            answers[0] = "With";
            answers[1] = "Without";
            answers[2] = "Both";
            rightAnswer = answers[1].toString();
            break;
                
            case 9:
            question = "How old is the King of Denmark";

            answers[0] = "44 years old";
            answers[1] = "46 years old";
            answers[2] = "There is no King of Denmark, yet";
            rightAnswer = answers[2].toString();
            break;    
        }  
    }
}
