class IOTDevice{
	public String address;
	
	public String send(String msg) {
		System.out.println("sending"+msg+" to "+address+" using TCP");
		return "";
		
	}
}

class TemperatureSensor extends IOTDevice{
	public String units;
	
	public double getValue() {
		String res = this.send("getValue()");
		return 24.48;
	}
}
public class IOTExample {
	
	public static void main(String[] args) {
		TemperatureSensor t = new TemperatureSensor();
		t.address = "10.0.0.5";
		t.units = "C";
		
		System.out.println(t.address+": "+t.getValue()+" "+t.units);
		
	}

}
