
public class LogicalOpTable {

	public static void main(String[] args) {

		boolean p, q;
		
		System.out.println("P\tQ\tAND");
		
		p=false; q=false;
		System.out.print(p+"\t"+q+"\t");
		System.out.println((p&q));
		
		p=false; q=true;
		System.out.print(p+"\t"+q+"\t");
		System.out.println((p&q));
		
		p=true; q=false;
		System.out.print(p+"\t"+q+"\t");
		System.out.println((p&q));
		
		p=true; q=true;
		System.out.print(p+"\t"+q+"\t");
		System.out.println((p&q));
		
		
		//division by zero
		// a/b -> (b != 0) && (a/b)
	}

}
