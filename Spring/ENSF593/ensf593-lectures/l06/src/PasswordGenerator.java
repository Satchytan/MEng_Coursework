
public class PasswordGenerator {
	
	private char startChar;
	private char endChar;
	
	public PasswordGenerator(char s, char e) {
		startChar = s;
		endChar = e;
	}
	
	public PasswordGenerator() {
		this('A', 'Z');
	}

	public char getStartChar() {
		return startChar;
	}

	public void setStartChar(char startChar) {
		this.startChar = startChar;
	}

	public char getEndChar() {
		return endChar;
	}

	public void setEndChar(char endChar) {
		this.endChar = endChar;
	}

	
	public String generatePassword(int length) {
		
		//TODO add your algorithm here
		
		char randomChar = 'A';
		
		int i = 0;
		
		// Alternate approach
		// String allPossible = "abcde%+...";
		// create a loop for numberOfChars
		// pick one of the allPossible characters with a random number
		// allPossible.charAt(random number);
		
		String password ="";
		
		while(i < length) {
			//Create a random number and convert it to an upper case character
			
			// adding 1 to difference to handle random edge case 1.0 not included.
			randomChar = (char)(startChar + (1+endChar-startChar) * Math.random());
			password += randomChar;
			
			i++;
		}
		return password;
	}

}
