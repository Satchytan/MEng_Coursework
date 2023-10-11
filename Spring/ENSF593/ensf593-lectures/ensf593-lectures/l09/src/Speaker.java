
public class Speaker extends IOTDevice implements RemoteControlled{
	public String location;
	public int volume;
	
	public Speaker(String address, String loc) {
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
	public String toString() {
		return this.location+": "+this.volume;
	}
	
	@Override
	public void up() {
		this.volume++;
		send("volume: "+this.volume);
		System.out.println(this);
	}

	@Override
	public void down() {
		this.volume--;
		send("volume: "+this.volume);
		System.out.println(this);
	}
}
