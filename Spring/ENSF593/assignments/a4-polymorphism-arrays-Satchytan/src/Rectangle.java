
public class Rectangle extends Shape2D implements IShapePoints{
	
	private Point2D referencePoint;

	/**
     * Default constructor for Rectangle class.
     * Creates a rectangle with default width and height.
     */
	public Rectangle() {
		this(1.0,  2.0);
	}

    /**
     * Constructor for Rectangle class that takes width and height as parameters.
     * @param w The width of the rectangle.
     * @param h The height of the rectangle.
     */
	public Rectangle(double w, double h) {
		super(w, h);
		referencePoint = new Point2D();
	}

    /**
     * Override of the getCircumference method to calculate the perimeter of the rectangle.
     * @return The circumference of the rectangle.
     */
	@Override
	public double getCircumference() {
		return 2 * (this.getHeight() + this.getWidth());
	}

    /**
     * Override of the getArea method to calculate the area of the rectangle.
     * @return The area of the rectangle.
     */
	@Override
	public double getArea() {
		return this.getHeight() * this.getWidth();
	}
	
    /**
     * Getter for the reference point of the rectangle.
     * @return The reference point of the rectangle.
     */
	public Point2D getReferencePoint() {
		return new Point2D(referencePoint);
	}
	
    /**
     * Setter for the reference point of the rectangle.
     * @param p The new reference point for the rectangle.
     */
	public void setReferencePoint(Point2D p) {
			this.referencePoint = new Point2D(p);
	}
	
	  /**
     * Get all the points of the rectangle, including the reference point and the other three points.
     * @return An array of Point2D objects representing all the points of the rectangle.
     */
	public Point2D[] getAllShapePoints() {
		double refx = referencePoint.x;
		double refy = referencePoint.y;
		double width = getWidth();
		double height = getHeight();
		Point2D[] points = new Point2D[4];
		points[0] = new Point2D(refx, refy);
		points[1] = new Point2D(refx+width, refy);
		points[2] = new Point2D(refx+width, refy+height);
		points[3] = new Point2D(refx, refy+height);
		
		return points;
	}
	
	
}
