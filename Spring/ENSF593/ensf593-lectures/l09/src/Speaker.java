
public class Speaker extends IOTDevice implements RemoteControlled {
	
	public String location;
	public int volume;
	
	public Speaker(String loc) {
		super(address);
		this.location = loc;
		resetVolume();
	}
	
	public void turnOn() {
		send("turn on");
	}
	
	private void resetVolume() {
		this.volume = 10;
		send("volume: "+this.volume);
	}
	
	@Override
	public String to String() {
		return this.location+": "+this.volume;
	}
	
	@Override
	public void up() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
