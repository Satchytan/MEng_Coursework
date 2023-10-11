/**
 * 
 * This abstract class
 * represents a shape in two-dimensional space
 * using its width and height
 * 
 * requires implementing two abstract methods:
 *   - getCircumference()
 *   - getArea()
 * 
 * @author Satchytan Karalasingham
 *
 */
public abstract class Shape2D {
	
	private double width;
	private double height;
	
	public Shape2D() {
		this(1.0, 1.0);
	}
	
	public Shape2D(double w, double h) {
		this.width = w;
		this.height = h;
	}
	
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double w) {
		this.width = w;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double h) {
		this.height = h;
	}
	
	@Override
	public String toString() {
		return width+" x "+height;
	}
	
	public abstract double getCircumference();
	
	public abstract double getArea();
	
}
