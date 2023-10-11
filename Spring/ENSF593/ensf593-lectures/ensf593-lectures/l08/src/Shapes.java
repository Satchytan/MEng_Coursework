class TwoDShape{
	public double width;
	public double height;
	
	public TwoDShape() {
		width = 2.0;
		height = 3.0;
	}

	public void showDim() {
		System.out.println("TwoDShape dim: "+width + " x "+height);

	}
}

class Triangle extends TwoDShape{
	public String style;
	
	public Triangle(String s) {
		//calls super() implicitly
		style = s;
	}
	
	public double area() {
		return (width * height)/2.0;
	}
	
	public void showStyle() {
		System.out.println("Triangle style: "+style);
	}
}

public class Shapes {

	public static void main(String[] args) {
		TwoDShape shape = new TwoDShape();
		System.out.println("*** TwoDShape ***");
		shape.showDim();

		
		Triangle triangle = new Triangle("filled");
		System.out.println("*** Triangle ***");
		triangle.showDim(); //from parent
		triangle.showStyle();
		System.out.println("area: "+triangle.area());
		
		System.out.println("*** TwoDShape holding a Triangle ***");
		shape = new Triangle("filled"); //shape can hold a triangle
		shape.showDim(); //can do shape things
		
		
		
//		triangle = new TwoDShape(); //triangle cannot hold a TwoDShape

	}

}
