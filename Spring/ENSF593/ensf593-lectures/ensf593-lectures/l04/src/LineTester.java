
public class LineTester {

	public static void main(String[] args) {
		
		Line1D l1 = new Line1D();
		System.out.println(l1.getStart());
		l1.setStart(-10.0);
		System.out.println(l1.getStart());
		
		System.out.println(l1); //l1.toString()
		System.out.println(l1.length());

	}

}
