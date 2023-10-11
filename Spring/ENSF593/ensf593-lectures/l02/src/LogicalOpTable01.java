
/*
 * Try This 2-2
 */
public class LogicalOpTable01 {

	public static void main(String[] args) {
		
		boolean p, q;
		int x, y, result;
		
		System.out.println("P\tQ\tAND");
		
		p=false; q=false;
		x = 0; y=0;
		result = 0;
		if(p&q)result = 1;
		System.out.print(x + "\t" + y+ "\t");
		System.out.println((result));

		p=false; q=true;
		x = 0; y=1;
		result = 0;
		if(p&q)result = 1;
		System.out.print(x + "\t" + y+ "\t");
		System.out.println((result));
		
		p=true; q=false;
		x = 1; y=0;
		result = 0;
		if(p&q)result = 1;
		System.out.print(x + "\t" + y+ "\t");
		System.out.println((result));
		
		p=true; q=true;
		x = 1; y=1;
		result = 0;
		if(p&q)result = 1;
		System.out.print(x + "\t" + y+ "\t");
		System.out.println((result));
	}

}
