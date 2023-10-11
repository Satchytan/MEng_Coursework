class Vehicle{
	
	int passenger;
	int fuelcap;
	int mpg;
	
	Vehicle(int p, int f, int m){
		this.passenger = p;
		this.fuelcap = f; //gallons
		this.mpg = m; // miles/gallon
	}
	
	int range() {
		return this.fuelcap * this.mpg;
	}
	
}

/**
 * 
 * Represents a distance in miles
 * with methods to convert to kilometers.
 * 
 * @author yves
 *
 */
class Distance{
	int miles;
	
	/**
	 * @param m distance in miles
	 */
	Distance(int m){
		this.miles = m;
	}
	
	/**
	 * @return distance in kilometers
	 */
	int toKilometers() {
		return (int)(this.miles * 1.6);
	}
	
	int toMiles() {
		return this.miles;
	}
	
}


public class VehicleDemo {

	public static void main(String[] args) {
		Vehicle minivan = new Vehicle(7, 16, 21);
		Vehicle sportscar = new Vehicle(2, 14, 12);
		
		int intRange = minivan.range();
		Distance range = new Distance(intRange);
		
		System.out.println("minivan range="+range.toKilometers()+" kilometers");
		System.out.println("minivan range="+range.toMiles()+" miles");
		
	}

}
