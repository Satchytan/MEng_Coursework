
public class Sound {

	public static void main(String[] args) {
		double dist;
		double distM;
		double lightningTime = 7.2; //seconds
		final double FEET_PER_SECOND = 1100.0;
		final double M_PER_SECOND = 343.0;
		
		//343m/s
		
		dist = lightningTime * FEET_PER_SECOND;
		distM = lightningTime * M_PER_SECOND;
		
		System.out.println("The lightning is " + dist + " feet away and " + distM + " meters away.");
	}

}
