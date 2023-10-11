
import java.util.Arrays;

public class TestShapes {

	/**
	 * Prints information about a Shape2D object, including its string representation, area, and circumference.
	 */
	public static void printShapeInfo(Shape2D s) {
		System.out.println(s);

		System.out.println("area= " + s.getArea());
		System.out.println("circumference= " + s.getCircumference());
	}
	/**
	 * Prints the reference point and all points of a shape implementing the IShapePoints interface.
	 * @param shape The shape object to print point information about.
	 */	
	public static void printPointInformation(IShapePoints shape) {
		System.out.println("Reference point: "+shape.getReferencePoint());
		System.out.println("All points: "+Arrays.toString(shape.getAllShapePoints()));
	}
	 /**
	  * Tests changing the reference point of a shape by setting a new reference point and printing the updated point information.
	  */
	 public static void printReferencePointChangeTest(IShapePoints shape) {
		printPointInformation(shape);
		Point2D p = new Point2D(5.0, 10.0);
		System.out.println("\nSetting reference point to "+p);
		shape.setReferencePoint(p);
		printPointInformation(shape);
	}
	 	/**
		 * Tests getting and changing the reference point of a shape by printing the initial reference point,
		 * changing the reference point and observing the change, and comparing the changed point with the shape's reference point.
		 */
	 public static void printReferencePointGetTest(IShapePoints shape) {
		Point2D p = shape.getReferencePoint();
		System.out.println("Got point "+p);
		p.x = -10;
		System.out.println("Changed point to "+p);
		System.out.println("Shape reference is "+shape.getReferencePoint());
		System.out.println("Comparing points is "+p.equals(shape.getReferencePoint())+" (should be false)");
	}
	 	/**
		 * Tests setting and changing the reference point of a shape by setting a new reference point, observing the change,
		 * changing the point again, and comparing the changed point with the shape's reference point.
		 */
	public static void printReferencePointSetTest(IShapePoints shape) {
		Point2D p = new Point2D(-1, -1);
		System.out.println("Set reference to point "+p);
		shape.setReferencePoint(p);
		System.out.println("Shape reference is "+shape.getReferencePoint());
		p.x = 1; p.y=1;
		System.out.println("Changed point to "+p);
		System.out.println("Shape reference is "+shape.getReferencePoint());
		System.out.println("Comparing points is "+p.equals(shape.getReferencePoint())+" (should be false)");
	}

	/**
	 * Tests setting the width and height of a Square object and prints the shape before and after the width and height changes.
	 */
	public static void printSquareWidthTest(Shape2D s) {
		System.out.println("prior " + s);
		s.setWidth(5);
		System.out.println("after setWidth(5) " + s);
		s.setHeight(10);
		System.out.println("after setHeight(10) " + s);
	}

	public static void main(String[] args) {

		Shape2D[] shapes = { 
				//TODO uncomment once implemented
				new RightTriangle(1.0, 2.0), 
				new Rectangle(1.0, 2.0), 
				//TODO uncomment once implemented
				new Square(2.0) 
				};

		for(Shape2D shape: shapes) {
			System.out.println("\n*** " + shape.getClass().getSimpleName() + " ***");
			printShapeInfo(shape);
		}
		
		//TODO uncomment once implemented
		System.out.println("\n*** Reference point change ***");
		printReferencePointChangeTest(new Rectangle(1.0, 2.0));
		
		System.out.println("\n*** Change get reference point test ***");
		printReferencePointGetTest(new Rectangle(1.0, 2.0));
		
		System.out.println("\n*** Change set reference point test ***");
		printReferencePointSetTest(new Rectangle(1.0, 2.0));

		System.out.println("\n*** Square set width/height test *** ");
		printSquareWidthTest(new Square());

	}

}
