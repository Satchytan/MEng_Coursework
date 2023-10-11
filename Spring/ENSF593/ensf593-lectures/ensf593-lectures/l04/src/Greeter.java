
/**
 * Represents a Greeter 
 * that can compose a greeting 
 * with a default or custom message
 * 
 * @author yves
 *
 */
public class Greeter {
	public static final String DEFAULT_MESSAGE = "nice to meet you!";
	private String message;
	
	/**
	 * Creates Greeter with default message
	 * {@value #DEFAULT_MESSAGE}
	 */
	public Greeter(){
		this.message=Greeter.DEFAULT_MESSAGE;
	}
	
	/**
	 * Creates a Greeter with custom message
	 * 
	 * @param m message to append to greeting
	 */
	public Greeter(String m){
		this.message = m;
	}
	
	/**
	 * 
	 * Composes greeting of name with 
	 * Greeter message
	 * 
	 * For example:
	 * greet("John") would compose
	 * "Hi John, " + {@value #DEFAULT_MESSAGE}
	 * 
	 * for a default Greeter
	 * 
	 * @param name
	 * @return greeting name with message
	 */
	public String greet(String name){ 
		return "Hi " + name + ", " + this.message; 
	}

}
