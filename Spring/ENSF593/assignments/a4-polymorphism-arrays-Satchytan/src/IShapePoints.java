
public interface IShapePoints {
	// Interface for shapes that have a reference point
	public Point2D getReferencePoint();
	// Interface for shapes that can set a reference point
	public void setReferencePoint(Point2D p);
	// Interface for shapes that can retrieve all points defining the shape
	public Point2D[] getAllShapePoints();
	
}
