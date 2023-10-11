class TwoDShapeO {
	public double width;
	public double height;
	
	public TwoDShapeO() {
		width = 2.0;
		height = 3.0;
	}

	public void showDim() {
		System.out.println("TwoDShape dim: "+width + " x "+height);

	}
	public double area() {
		System.out.println("Override in sub-classes");
		return 0.0;
	}
}

class TriangleO extends TwoDShapeO{
	public String style;
	
	public TriangleO(String s) {
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

public class ShapesOverride {

	public static void main(String[] args) {
		TwoDShapeO shape = new TwoDShapeO();
		System.out.println("*** TwoDShape ***");
		shape.showDim();
		System.out.println("area: "+shape.area());
		
		TriangleO triangle = new TriangleO("filled");
		System.out.println("*** Triangle ***");
		triangle.showDim(); //from parent
		triangle.showStyle();
		System.out.println("area: "+triangle.area());

		System.out.println("*** Shape holding a Triangle (polymorphism) ***");
		shape = new TriangleO("filled"); //shape can hold a triangle
		shape.showDim(); //can do shape things
		System.out.println("area: "+shape.area()); //triangle's area is called
	}

}
