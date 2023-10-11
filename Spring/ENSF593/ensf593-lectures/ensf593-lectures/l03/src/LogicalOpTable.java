
public class LogicalOpTable {
	
	public static void printAND(boolean x, boolean y) {
		System.out.print(x+"\t"+y+"\t");
		System.out.println((x&&y));
	}

	public static void main(String[] args) {
		boolean p, q;
		
		System.out.println("P\tQ\tAND");
		
		p=false; q=false;
		printAND(p, q);
	
		p=false; q=true;
		printAND(p, q);
		
		p=true; q=false;
		printAND(p, q);
		
		p=true; q=true;
		printAND(p, q);
		
//		System.out.println("someverylongtexthatislonger\tcontinue");
		//division by zero
		// a/b  -> (b != 0) && (a/b)
	
	}

}
