
public class Line1D extends Object{
	
	private double start;
	private double end;
	
	public Line1D() {
		this.start = 0.0;
		this.end = 1.0;
	}
	
	public Line1D(double s, double e) {
		this.start = s;
		this.end = e;
	}
	
	public void setStart(double s){
		this.start = s;
	}
	
	public double getStart() {
		return this.start;
	}
	
	public String toString() {
		return "starts at "+this.start+" ends at "+this.end;
	}
	
	public double length() {
		return this.end - this.start;
	}
	
	

}
