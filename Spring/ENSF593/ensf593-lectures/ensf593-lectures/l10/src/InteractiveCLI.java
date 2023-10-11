import java.util.Scanner;

/**
 * Enables reading from stdin using a Scanner and
 * writing to stdout using print/println
 * 
 * @author 
 */
public class InteractiveCLI {

	private Scanner reader;
	
	public InteractiveCLI() {
		reader = new Scanner(System.in);
	}

	/**
	 * Reads from stdin.
	 * 
	 * @return integer entered
	 * @throws NumberFormatException
	 */
	public int getKeyboardInteger() throws NumberFormatException{ 
		return Integer.parseInt(getKeyboardString());
	}
	
	/**
	 * Reads from stdin.
	 * 
	 * @return double entered
	 * @throws NumberFormatException
	 */
	public double getKeyboardDouble() throws NumberFormatException{ 
		return Double.parseDouble(getKeyboardString());
	}
	
	/**
	 * Reads a line from stdin.
	 * 
	 * @return line as String from stdin
	 */
	public String getKeyboardString(){ 
		return reader.nextLine();
	}	
	/**
	 * Print string s as a prompt without a newline.
	 * @param s
	 */
	public void prompt(String s){ 
		System.out.print(s);
	}
	
	
	/**
	 * Print string s as a message with newline.
	 * @param s
	 */
	public void display(String s){ 
		System.out.println(s);
	}
	
}

