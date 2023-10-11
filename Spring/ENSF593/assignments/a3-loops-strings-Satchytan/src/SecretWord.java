
/**
 * @author : Satchytan Karalasingham
 *
 * The SecretWord class manages the string processing for a GUI that allows users to make repeated guesses at the letters contained in a secret word.
 * The secret word is initially hidden, and each correct guess reveals the position(s) of the guessed letter in the displayed word.
 *
 */
public class SecretWord {
	
	private String secretWord;
	private String displayedWord;
    // Constructor: Initializes the secretWord and displayedWord variables
	public SecretWord() {
		secretWord = "spontaneous";
		displayedWord = replaceChars(secretWord, '*');	
	}
	
	public String getDisplayedWord() {
        // Returns the current displayedWord
		return displayedWord;	
	}
	
	public String getSecretWord() {
        // Returns the secretWord
		return secretWord;
	}
	
	public String replaceChars(String s, char ch) {
        // Replaces every character in s with ch and returns the resulting string
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			sb.append(ch);
		}
		
		return sb.toString();
	}
	
	public String replaceChars(String s1, String s2, char ch) {
        // Finds indices of ch in s1 and replaces characters at these locations with ch in s2
		StringBuilder sb = new StringBuilder(s2);
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == ch) {
				sb.setCharAt(i, ch);
			}
		}
		return sb.toString();
	}
	
	public boolean makeGuess(char ch) {
        // Tests if ch is present in the secretWord
		boolean isCorrectGuess = false;
		String updatedWord = replaceChars(secretWord, displayedWord, ch);
		if (!updatedWord.equals(displayedWord)) {
			isCorrectGuess = true;
			// If the updatedWord is different from the displayedWord, it means the guess is correct
            // Update the displayedWord and set isCorrectGuess to true
			displayedWord = updatedWord;
		}
		return isCorrectGuess;
	}
	
}
