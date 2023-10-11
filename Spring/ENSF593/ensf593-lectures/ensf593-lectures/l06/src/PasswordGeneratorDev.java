public class PasswordGeneratorDev {

	public static void main(String[] args) {
		
		
		
		//IDEA 1:
		// create a loop for numberOfChars
		//   Create a random number between 'A' and 'Z'
		//     use char to represent letters, can use arithmetic
		//   Add to this convert this number to char and add to password
		
		// IDEA 2 (once we know strings):
		// String allPossible = "abcde%+...";
		// create a loop for numberOfChars
		// pick one of the allPossible characters with a random number
		// allPossible.charAt(random number);
		
		String password ="";
		int numberOfChars = 10;
		//TODO: Implement idea 1 or idea 2
		for(int i=0; i<numberOfChars; i++) {
			//get into correct range
			// range is 'A' to 'Z' add 1 to cover 'Z'
			char c = (char)(('Z'-'A'+1)*Math.random()+'A');
			password = password + c;
		}
		
		
		
		System.out.println(password);

		
	}

}
