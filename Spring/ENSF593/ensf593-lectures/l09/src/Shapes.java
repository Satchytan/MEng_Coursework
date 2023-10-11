class TwoDShape {
	public double width;
	public double height;

	//TODO: add a default constructor (use this())
	
	
	public TwoDShape(double w, double h) {
		this.width = w;
		this.height = h;
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
	
	//TODO: add a constructor double, double, String (use super())
	
	
	public double area() {
		return (width * height)/2.0;
	}
	
	//TODO: override showDim(), print "Triangle-" then call super.showDim()
	
	
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
		triangle.showDim(); //from parent - overridden
		triangle.showStyle();
		System.out.println("area: "+triangle.area());
		
		System.out.println("*** TwoDShape holding a Triangle ***");
		shape = new Triangle("filled"); //shape can hold a triangle
		shape.showDim();
		
//		triangle = new TwoDShape(); //triangle cannot hold a TwoDShape

	}

}
