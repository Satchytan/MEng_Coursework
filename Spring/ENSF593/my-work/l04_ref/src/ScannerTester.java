import java.util.Scanner;

public class ScannerTester {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		
		System.out.print("Type some text and hit enter: ");
		String text = reader.nextLine();
		
		System.out.println(text);
		
		System.out.print("Type a number and hit enter: ");
		double number;
		if(reader.hasNextDouble()) {
			
			number = reader.nextDouble();
			
		}
		else {
			number = 0.0;

		}
		
		System.out.println(number);
		
		
	}

}
