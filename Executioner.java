package game;

import util.DisplayWord;
import util.HangmanDictionary;

public class Executioner {
	// word that is being guessed
    protected String mySecretWord;
    
   
	 // Returns a secret word.
    public void makeSecretWord (HangmanDictionary dictionary, int wordLength) {
        mySecretWord = dictionary.getRandomWord(wordLength).toLowerCase();
    }

    public String getMySecretWord() {
    	return mySecretWord;
    }
    
 // Returns true only if given guess is in the secret word.
    public boolean checkGuessInSecret (char guess) {
        if (mySecretWord.indexOf(guess) >= 0) {
            
            return true;
        }
        return false;
    }
    
    //blank method that does nothing when not supposed to be a cheating computer.
	public void cheat(char guess, DisplayWord myDisplayWord) {
		// TODO Auto-generated method stub
		
	}
}
