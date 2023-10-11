
/**
 * @author: Satchytan Karalasingham
 * 
 * Class Name: Temperature
 * 
 * Represents a thermometer with a temperature and
 * allows it to return its measurement in Fahrenheit or in Celsius (after conversion)
 * using the getFahrenheit() or getCelsius() methods
 *
 */


public class Temperature {
	
	double degrees; //always in fahrenheit
	
	
	public double getFahrenheit() {
		return degrees;					//already in fahrenheit, returns temperature
	}
	
	
	public double getCelsius() {
		return (5 *(degrees -32) /9);	//convert to celsius and return this value
	}
	

	public static void main(String[] args) {
		
		Temperature thermometer1 = new Temperature();
		thermometer1.degrees = 20.0;						//set temp of thermometer (in fahrenheit)
		
		Temperature thermometer2 = new Temperature();
		thermometer2.degrees = 98.6;
		
		
		System.out.print("The temperature of thermometer1 is "); 
		System.out.print(thermometer1.getFahrenheit());
		System.out.println(" degrees Fahrenheit."); 
		
		System.out.print("The temperature of thermometer1 is "); 
		System.out.printf("%.2f", thermometer1.getCelsius());		//formatting to round to 2 decimal places
		System.out.println(" degrees Celsius."); 
		
		
		System.out.print("The temperature of thermometer2 is "); 
		System.out.print(thermometer2.getFahrenheit());
		System.out.println(" degrees Fahrenheit."); 
		
		System.out.print("The temperature of thermometer2 is "); 
		System.out.print(thermometer2.getCelsius());
		System.out.println(" degrees Celsius."); 

	}

}
