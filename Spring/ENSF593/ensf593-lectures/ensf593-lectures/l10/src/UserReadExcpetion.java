
/**
 * Using try-catch to handle user input.
 *
 */
public class UserReadExcpetion {

	/**
	 * 
	 * Uses a while loop and try-catch to
	 * prompt user until a valid integer is entered.
	 * 
	 * @param reader a KeyboardReader
	 * @return valid integer entered by the user
	 */
	public static int getIntFromUser(InteractiveCLI reader) {
		
		//TODO implement this method
		int num = 0;
		//Point2D p = new Point2D(); null;
		boolean validNumber = false;
		while(!validNumber) {
			try {
				reader.prompt("Please enter an integer, e.g. 10: ");
				num = reader.getKeyboardInteger();
				validNumber = true;
			}catch(NumberFormatException e) {
				reader.display("Problem: "+e.getMessage());
				reader.display("Please try again");
			}
		}
		
		return num;
	}
	
	/**
	 * 
	 * Uses a while loop and try-catch to
	 * prompt user until a valid double is entered.
	 * 
	 * @param reader a KeyboardReader
	 * @return valid double entered by the user
	 */
	public static double getDoubleFromUser(InteractiveCLI reader) {
		
		//TODO implement this method
		//TODO Hint Double.NaN exists and can be checked with Double.isNaN()
		double num = Double.NaN;
		while(Double.isNaN(num)) {
			break;
		}
		
		return 0.0;
	}
	
	public static void main(String[] args) {
		
		InteractiveCLI cli = new InteractiveCLI();
		
		System.out.println("You have entered: "+getIntFromUser(cli));
		
//		System.out.println(getDoubleFromUser(cli));
		

	}

}
