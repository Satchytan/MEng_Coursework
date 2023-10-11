
public class RightTriangle extends Shape2D{


    /**
     * Default constructor for RightTriangle class.
     * Creates a right triangle with default base and height.
     */
	public RightTriangle() {
		this(1.0,  2.0);
	}
	 /**
     * Constructor for RightTriangle class that takes base and height as parameters.
     * @param w The base of the right triangle.
     * @param h The height of the right triangle.
     */
	public RightTriangle(double w, double h) {
		super(w, h);
	}
	/**
     * Override of the getCircumference method to calculate the perimeter of the right triangle.
     * @return The circumference of the right triangle.
     */
	@Override
	public double getCircumference() {
		double hypotenuse = Math.sqrt(getWidth() * getWidth() + getHeight() * getHeight());
		return hypotenuse + (this.getHeight() + this.getWidth());
	}
	/**
     * Override of the getArea method to calculate the area of the right triangle.
     * @return The area of the right triangle.
     */
	@Override
	public double getArea() {
		return (this.getHeight() * this.getWidth()) / 2;
	}
}


