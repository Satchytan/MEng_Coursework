class IOTDevice{
	public String address;
	
	public String send(String msg) {
		System.out.println("sending "+msg+" to "+address+" using TCP");
		return "";
	}
}

class TemperatureSensor extends IOTDevice{
	public String units;
	
	@Override
	public String send(String msg) {
		System.out.println("sending "+msg+" to "+address+" using UDP");
		return "";
	}
	
	public double getValue() {
		String res = this.send("getValue()");
		//some work with res
		return 24.48;
	}
}
public class IOTExample {

	public static void main(String[] args) {
		TemperatureSensor t = new TemperatureSensor();
		t.address = "10.0.0.5";
		t.units = "C";
		
		System.out.println(t.address+": "+t.getValue()+" "+t.units);
		
		IOTDevice d = new IOTDevice();
		d.address = "10.0.1.15";
		d.send("turn on");
		
		d = new TemperatureSensor();
		d.address = "10.0.2.15";
		d.send("turn on");
		
		
		
	}

}
