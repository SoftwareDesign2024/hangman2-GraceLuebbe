package game;

import util.ConsoleReader;
import util.DisplayWord;
import util.HangmanDictionary;


/**
 * This class represents the traditional word-guessing game Hangman
 * that plays interactively with the user.
 *
 * @author Robert C. Duvall
 * @author Shannon Duvall
 */
public class HangmanGame {
    
    private Executioner executioner;
    private Guesser guesser;
    
    // how many guesses are remaining
    private int myNumGuessesLeft;
    // what is shown to the user
    private DisplayWord myDisplayWord;
    // tracks letters guessed
    


    /**
     * Create Hangman game with the given dictionary of words to play a game with words 
     * of the given length and giving the user the given number of chances.
     */
    public HangmanGame (HangmanDictionary dictionary, int wordLength, int numGuesses, Guesser guesser, Executioner executioner) {
    	this.guesser = guesser;
    	this.executioner = executioner;
    	executioner.makeSecretWord(dictionary, wordLength);
        myNumGuessesLeft = numGuesses;
        myDisplayWord = new DisplayWord(executioner.getMySecretWord());
    }

    /**
     * Play one complete game.
     */
    public void play () {
        boolean gameOver = false;
        while (!gameOver) {
            printStatus();
            String guess = guesser.getGuess(this);
            executioner.cheat(guess.charAt(0), myDisplayWord);
            guesser.makeGuess(guess.toLowerCase().charAt(0), this);
                if (isGameLost()) {
                    System.out.println("YOU ARE HUNG!!!");
                    gameOver = true;
                }
                else if (isGameWon()) {
                    System.out.println("YOU WIN!!!");
                    gameOver = true;
                }
            
            else {
                System.out.println("Please enter a single letter ...");
            }
        }
        System.out.println("The secret word was " + executioner.getMySecretWord());
    }


    public void interpretMakeGuess(char guess) {
    	if (executioner.checkGuessInSecret(guess)) {
    		myDisplayWord.update(guess, executioner.getMySecretWord());
    		
    	}
    	else {
    		myNumGuessesLeft -= 1;
    	}
    }

    

   
    // Returns true only if the guesser has guessed all letters in the secret word.
    private boolean isGameWon () {
        return myDisplayWord.equals(executioner.getMySecretWord());
    }

    // Returns true only if the guesser has used up all their chances to guess.
    private boolean isGameLost () {
        return myNumGuessesLeft == 0;
    }

    // Print game stats
    private void printStatus () {
        System.out.println(myDisplayWord);
        System.out.println("# misses left = " + myNumGuessesLeft);
        System.out.println("letters not yet guessed = " + guesser.getLettersLeft());
        // NOT PUBLIC, but makes it easier to test
        //System.out.println("*** " + mySecretWord);
        System.out.println();
    }
    
    public DisplayWord getDisplayWord() {
    	 return myDisplayWord;
     }
    
}
