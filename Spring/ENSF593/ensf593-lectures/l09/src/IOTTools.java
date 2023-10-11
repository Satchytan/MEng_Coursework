/**
 * The remote controlled interface for  performing IOT remote control actions.
 * The class that is interested in enabling remote control implements this interface, 
 * 
 * @author yves
 *
 */
interface RemoteControlled{
	/**
	 * Turning up a setting of an IOTDevice
	 */
	public void up();
	/**
	 * Turning down a setting of an IOTDevice
	 */
	public void down();
}


/**
 * Representing an IOT Device that can be accessed with TCP/IP
 * 
 * @author yves
 *
 */
class IOTDevice{
	/**
	 * Direct access to IP address, no getter/setter
	 */
	public String address;
	
	/**
	 * @param a IP address of device
	 */
	IOTDevice(String a) {
		this.address = a;
	}
	
	/**
	 * @param msg sent to device via TCP/IP
	 * @return message received from device
	 */
	public String send(String msg) {
		System.out.println("--- sending "+msg+" to "+address+" using TCP");
		return "";
	}
	
}

/**
 * 
 * Collection of static helper methods to work with
 * IOT Devices and
 * RemoteControlled
 * 
 * @author yves
 *
 */
public class IOTTools {
	
	/**
	 * @param devices list of devices to turn up
	 */
	public static void turnUp(RemoteControlled[] devices) {
		for(RemoteControlled rc: devices) {
			rc.up();
		}
	}
	
	/**
	 * @param devices list of devices to turn down
	 */
	public static void turnDown(RemoteControlled[] devices) {
		for(RemoteControlled rc: devices) {
			rc.down();
		}
	}
}
