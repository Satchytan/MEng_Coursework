
/**
 * 
 * Represents a distance in miles.
 * Distance can be set and converted to kilometers.
 * String representation includes units.
 * 
 * @author yves
 *
 */
public class DistanceEnhanced {
	// class level constants
	static final String MILE_STRING = "miles";
	static final String KILOMETER_STRING = "kilometers";
	static final double KILOMETER_PER_MILE = 1.6;
	
	// instance variables
	private double distance; // always in miles
	private String units;
	private boolean isMiles;
	
	public DistanceEnhanced() {
		distance = 0;
		units = MILE_STRING;
		isMiles = true;
	}
	
	void setToMiles() {
		isMiles = true;
		units = MILE_STRING;
		
	}
	
	void setToKilometers() {
		isMiles = false;
		units = KILOMETER_STRING;
	}
	
	double getValue() {
		if(isMiles) {
			return distance;
		}else {
			return distance*KILOMETER_PER_MILE;
		}
	}
	
	void setValueAsMiles(double dist) {
		distance = dist;
	}

	void setValueAsKilometer(double dist) {
		distance = dist/KILOMETER_PER_MILE;
	}
	
	String getUnits() {
		return units;
	}
	
	public String toString() {
		return getValue() + " " + getUnits();
	}
	
	public static void main(String[] args) {
		
		DistanceEnhanced dist = new DistanceEnhanced();
		dist.setValueAsMiles(10); // 10 miles
		System.out.println(dist); // print 10 miles
		dist.setToKilometers();
		System.out.println(dist); // print 16 kilometers
		
		dist.setValueAsKilometer(10); // 10 kilometers
		System.out.println(dist); // print 10 kilometers
		dist.setToMiles();
		System.out.println(dist); // print 6.25 miles
	}

}
