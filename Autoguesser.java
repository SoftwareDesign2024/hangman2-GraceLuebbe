package game;

public class Autoguesser extends Guesser {
	private static final String LETTERS_ORDERED_BY_FREQUENCY = "etaoinshrldcumfpgwybvkxjqz";
	private int myIndex;
	
	public String getGuess(HangmanGame hangmanGame) {
		Character guess = LETTERS_ORDERED_BY_FREQUENCY.charAt(myIndex++);
		return guess.toString();
	}

}
