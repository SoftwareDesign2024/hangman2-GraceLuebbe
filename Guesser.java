package game;

import util.ConsoleReader;

public class Guesser {
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	private StringBuilder myLettersLeftToGuess;
	
	public Guesser() {
		myLettersLeftToGuess = new StringBuilder(ALPHABET);
	}
	
	public String getGuess(HangmanGame hangmanGame) {
		String guess = ConsoleReader.promptString("Make a guess: ");
        if (guess.length() == 1 && Character.isAlphabetic(guess.charAt(0))) {
            return guess;
        }
        return null;
	}
	
	 // Process a guess by updating the necessary internal state.
    public void makeGuess (char guess, HangmanGame hangmanGame) {
        // do not count repeated guess as a miss
        int index = myLettersLeftToGuess.indexOf("" + guess);
        if (index >= 0) {
            recordGuess(index);
            hangmanGame.interpretMakeGuess(guess);
        }
    }
    
    
 // Record that a specific letter was guessed
    private void recordGuess (int index) {
        myLettersLeftToGuess.deleteCharAt(index);
    }
    
    public StringBuilder getLettersLeft() {
    	return myLettersLeftToGuess;
    }
}
