//Needed for a3

public class StringManipulation {

	public static void main(String[] args) {
		String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCase = "abcdefghijklmnopqrstuvwxyz";
		String letters = "HW";
		String s2 = "HELLO WORLD";
		
		//TODO Use StringBuilder to change the case of the letter 'H' in s2
		StringBuilder builder = new StringBuilder(s2);
		builder.setCharAt(s2.indexOf('H'), 'h');
		String s2New = builder.toString();
		System.out.println(s2New);
		
		for(int i=0; i<builder.length(); i++) {
			builder.setCharAt(i, '-');
		}
		
		System.out.println(builder);
		
		//TODO Use String builder to change all letters in letters
		// in s2 using upperCase and lowerCase strings
		
	}

}
