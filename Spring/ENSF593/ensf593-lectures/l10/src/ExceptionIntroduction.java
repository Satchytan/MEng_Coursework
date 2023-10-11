/**
 * 
 * Unchecked exceptions.
 * 
 * Multiple catch block, specific to general.
 * 
 * Finally always executed, used for cleaning up resources.
 * 
 */
public class ExceptionIntroduction {


	public static void main(String[] args) {
		String input = "26";
		int num = 0;
		int div = 0;
		try{
			num = Integer.parseInt(input);
			num = num / div;
		}
		//TODO add a catch block to catch NumberFormatException
		catch(NumberFormatException e) {
			System.out.println("first catch block");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		//TODO add second block to catch all exceptions
		catch(Exception e) {
			System.out.println("second catch block");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		//TODO add finally block printing the number
		finally {
			System.out.println("the number is: " +num);
		}
	} 
}


