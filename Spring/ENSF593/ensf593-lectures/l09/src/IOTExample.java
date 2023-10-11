public class IOTExample {

	public static void main(String[] args) {
		
		Speaker[] devices = {
				new Speaker("10.0.1.14", "kitchen"),
				new Speaker("10.0.2.2", "living room"),
				};
		
		for(Speaker s: devices) {
			s.turnOn();
		}
		
		IOTTools.turnUp(devices);
		
		
	}

}
