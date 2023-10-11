
/**
 * We can through an exception in code.
 * 
 * Is declared as part of the method header.
 *
 */
public class ThrowException {

	/**
	 * @param a
	 * @param b
	 * @return sum of a and b
	 * @throws IllegalArgumentException if a and b are non-positive
	 */
	public static int addPositive(int a, int b) throws IllegalArgumentException{
		//TODO implement method
		if(a>0 && b>0) {
			return a + b;
		} else {
			throw new IllegalArgumentException("Both arguments need to be positive");
		}
		
	}

	public static void main(String[] args){
		
		//TODO test addPositive method
		try {
			System.out.println(addPositive(2,-2));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

}
