
/**
 * Code from Fig. 4.9 p. 159
 * 
 * @author Yves
 *
 */
public class GreeterApp{ 
	private InteractiveCLI cli;
	
	public GreeterApp(){ 
		this.cli = new InteractiveCLI(); 
	}

	public void run() {
		String name = "";
		this.cli.prompt("Please input your name here > ");
		name = this.cli.getKeyboardString();
		this.cli.display(greet(name) + "\n");
	}
	
	//TODO: user greeter class, remove this method.
	public String greet ( String name){ 
		return "Hi " + name + ", nice to meet you."; 
	}

	public static void main(String args[]){ 
		GreeterApp app = new GreeterApp();
		app.run();
	}
}
