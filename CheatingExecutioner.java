package game;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import util.DisplayWord;
import util.HangmanDictionary;

public class CheatingExecutioner extends Executioner {
	private List<String> myRemainingWords;
	
	public void makeSecretWord(HangmanDictionary dictionary, int wordLength) {
		mySecretWord = dictionary.getRandomWord(wordLength).toLowerCase();
		myRemainingWords = dictionary.getWords(wordLength);
	}
	
	@Override
	public void cheat(char guess, DisplayWord myDisplayWord) {
        // create template of guesses and find one with most matching remaining words
        HashMap<DisplayWord, List<String>> templatedWords = new HashMap<DisplayWord, List<String>>();
        for (String w : myRemainingWords) {
            DisplayWord template = new DisplayWord(myDisplayWord);
            template.update(guess, w);
            if (!templatedWords.containsKey(template)) {
                templatedWords.put(template, new ArrayList<>());
            }
            templatedWords.get(template).add(w);
        }
        int max = 0;
        DisplayWord maxKey = new DisplayWord("");
        for (Entry<DisplayWord, List<String>> entry : templatedWords.entrySet()) {
            //System.out.println(entry.getValue());
            if (entry.getValue().size() > max) {
                max = entry.getValue().size();
                maxKey = entry.getKey();
            }
            
        }

}
}
