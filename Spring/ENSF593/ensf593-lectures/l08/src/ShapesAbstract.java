abstract class TwoDShapeA {
	public double width;
	public double height;
	
	public TwoDShapeA() {
		width = 2.0;
		height = 3.0;
	}

	public void showDim() {
		System.out.println("TwoDShape dim: "+width + " x "+height);

	}
	
	public abstract double area();
}

class TriangleA extends TwoDShapeA{
	public String style;
	
	public TriangleA(String s) {
		//calls super() implicitly
		style = s;
	}
	
	@Override
	public double area() {
		return (width * height)/2.0;
	}
	
	public void showStyle() {
		System.out.println("Triangle style: "+style);
	}
}

public class ShapesAbstract {

	public static void main(String[] args) {
		//cannot instantiate an abstract class
//		TwoDShapeA shape = new TwoDShapeA(); 
//		System.out.println("*** TwoDShape ***");
//		shape.showDim();
//		System.out.println("area: "+shape.area());
		
		TriangleA triangle = new TriangleA("filled");
		System.out.println("*** Triangle ***");
		triangle.showDim(); //from parent
		triangle.showStyle();
		System.out.println("area: "+triangle.area());

		System.out.println("*** Shape holding a Triangle (polymorphism) ***");
		TwoDShapeA shape = new TriangleA("filled"); //shape can hold a triangle
		shape.showDim(); //can do shape things
		System.out.println("area: "+shape.area()); //triangle's area is called


	}

}
