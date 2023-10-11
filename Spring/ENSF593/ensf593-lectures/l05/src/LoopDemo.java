import java.util.Scanner;

public class LoopDemo {

	public static void main(String[] args) {
		
		int i = 0;
		for(;;) {
			if(i>=10) {
				break;
			}
			System.out.println(i);
			i++;
		}
		
		System.out.println("************");
		
		for(i=0;i<2;i++) {
			for(int j=0; j<10;j++) {
				System.out.print(j+" ");
			}
			System.out.println("");
		}
		
//		System.out.println("end value is "+j);
		
		System.out.println("************");
		
		// division as repeated subtraction
		int a = 34;
		int b = 3;
		System.out.print(a+"/"+b+" = ");
		int count = 0;
		while(a>=b) {
			a = a-b;
			count++;
		}
		
		System.out.println(count+" remainder "+a);

		System.out.println("************");
		
		//calculate multiple sqrts from user input
		Scanner reader = new Scanner(System.in);
		double value;
		System.out.println("Enter a number and get sqrt (0 to end)");
		// TODO is it better to use a while loop here?
		do {
			value = reader.nextDouble();
			if(value>0)System.out.println(Math.sqrt(value));
		}while(value > 0);
		System.out.println("bye");
		
		// if else if ladder
//		int z = 10;
//		if(z < 2) {
//			
//		}else if(z<5) {
//			
//		}else {
//			
//		}
		
	}

}
