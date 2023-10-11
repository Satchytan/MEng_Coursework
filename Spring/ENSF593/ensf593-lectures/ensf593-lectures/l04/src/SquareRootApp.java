/**
 * Code from Fig. 4.9 p. 159
 * 
 * @author Yves
 *
 */
public class SquareRootApp{ 
	private InteractiveCLI cli;
	
	public SquareRootApp(){ 
		this.cli = new InteractiveCLI(); 
	}

	public void run() {
		double number;
		this.cli.prompt("Please a number, e.g 16.0 followed by enter > ");
		number = this.cli.getKeyboardDouble();
		this.cli.display("sqrt("+number+") = " +Math.sqrt(number));
	}
	
	public static void main(String args[]){ 
		SquareRootApp app = new SquareRootApp();
		app.run();
	}
}


