package l04;

public class LineTester {

	public static void main(String[] args) {
		
		Line1D l1 = new Line1D();
		
		System.out.println(l1.getStart());
		
		l1.setStart(-10.0);
		System.out.println(l1.getStart());
		
		System.out.println(l1);
		System.out.println(l1.length());
		
		double a = 65.2;
		char b = 'A';
		int c = (int)a;
		int d = b;
		char e = (char)c;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		
		int x = 'c'-'a';
		System.out.println(x);
		int sum = 232421;
		double mean = sum/5.0;
		System.out.println(mean);

		
	}
	
}
