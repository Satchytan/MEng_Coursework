
/**
 * @author : Satchytan Karalasingham
 *
 * App that gets user inputs for a value and outputs the square root of it using Newton's method.
 * Newton's method is implemented within the NewtonSolver class which NewtonApp will call to compute the square root and return its output.
 * User will also specify the maximum error and the app will also output the number of iterations before it got to the square root approximation that is within this error.
 * 
 * 
 */
public class NewtonApp {
    private InteractiveCLI cli;

    public NewtonApp() {
        cli = new InteractiveCLI();
    }

    public void run() {
    	//prompts for user input on the CLI, gets their inputs
        cli.prompt("Enter a number (N): ");
        double N = cli.getKeyboardDouble();
        cli.prompt("Enter the maximum error: ");
        double maxError = cli.getKeyboardDouble();
        cli.prompt("Enter the initial guess: ");
        double initialGuess = cli.getKeyboardDouble();

        //calls on the NewtonSolver class to perform square root computation to approximate the square root using Newton's method
        NewtonSolver solver = new NewtonSolver(maxError, initialGuess);
        double squareRoot = solver.sqrt(N);
        int iterations = solver.getIterations();

        //displays the output to the user
        //shows the square root approximation along with the number of iterations of the Newton's method equation to get to it
        cli.display("Square root of " + N + " is: " + squareRoot);
        cli.display("Number of iterations: " + iterations);
    }

    public static void main(String[] args) {
        NewtonApp app = new NewtonApp();
        app.run();
    }
}
