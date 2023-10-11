public class Point2D{
	protected double x, y;
	// Default constructor that creates a Point2D at the origin (0, 0)
	Point2D(){
		this(0.0, 0.0);
	}
	// Copy constructor that creates a Point2D from another Point2D
	Point2D(Point2D p){
		this(p.x, p.y);
	}
	// Constructor that creates a Point2D with given coordinates
	Point2D(double x, double y){
		this.x = x;
		this.y = y;
	}
	// Override the toString method to provide a string representation of the Point2D
	@Override
	public String toString() {
		return "("+x+", "+y+")";
	}
	// Override the equals method to compare two Point2D objects for equality
	@Override
	public boolean equals(Object o) {
		if(o == null)return false;
		if(!(o instanceof Point2D)) return false;
		
		Point2D that = (Point2D)o;
		return (this.x == that.x) && (this.y == that.y);
	}
}