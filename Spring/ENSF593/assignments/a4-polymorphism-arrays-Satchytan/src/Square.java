
public class Square extends Shape2D{

	/**
     * Default constructor for Square class.
     * Creates a square with default side length.
     */
	public Square() {
		super(1.0,  1.0);
	}
	 /**
     * Constructor for Square class that takes the length of a side as a parameter.
     * @param l The length of a side of the square.
     */
	public Square(double l) {
		super(l, l);
	}
	/**
     * Override of the setWidth method to update both width and height with the same value.
     * @param w The new width (and height) of the square.
     */
	@Override
	public void setWidth(double w) {
		super.setWidth(w);
		super.setHeight(w);
	}
	 /**
     * Override of the setHeight method to update both width and height with the same value.
     * @param h The new height (and width) of the square.
     */
	@Override
	public void setHeight(double h) {
		super.setWidth(h);
		super.setHeight(h);
	}
	/**
     * Override of the getCircumference method to calculate the perimeter of the square.
     * @return The circumference of the square.
     */
	@Override
	public double getCircumference() {
		return 2 * (this.getHeight() + this.getWidth());
	}
	/**
     * Override of the getArea method to calculate the area of the square.
     * @return The area of the square.
     */
	@Override
	public double getArea() {
		return this.getHeight() * this.getWidth();
	}
}

