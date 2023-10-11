
public class SquareRootApp {
private InteractiveCLI cli;
	
	public SquareRootApp(){ 
		this.cli = new InteractiveCLI(); 
	}

	public void run() {
		double number;
		this.cli.prompt("Please input a number, e.g. 16.0 follower by enter here > ");
		number = this.cli.getKeyboardDouble();
		this.cli.display("sqrt("+number+") =" + Math.sqrt(number));
	}
	
	//TODO: user greeter class, remove this method.
	public String greet ( String name){ 
		return "Hi " + name + ", nice to meet you."; 
	}
	
	
	

	public static void main(String[] args) {
		SquareRootApp app = new SquareRootApp();
		app.run();
	}

}
