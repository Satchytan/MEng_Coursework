
/**
 * @author: Satchytan Karalasingham 
 *
 * NewtonSolver class which performs the computations for calculating the square root of a given number using Newton's method.
 * Works with NewtonApp and InteractiveCLI classes to get user inputs to perform the calculation.
 *
 */
public class NewtonSolver {
    private double maxError;
    private double initialGuess;
    private int iterations;

    //constructor initializing variables required for computation
    public NewtonSolver(double maxError, double initialGuess) {
        this.maxError = maxError;
        this.initialGuess = initialGuess;
        this.iterations = 0;
    }
    
    //returns the number of iterations through Newton's method to get to the approximation within error specified by user
    public int getIterations() {
        return iterations;
    }

    //square root computation using Newton's method
    public double sqrt(double N) {
        double guess = initialGuess;
        double previousGuess;

        do {
            iterations++;
            previousGuess = guess;
            guess = (N / guess + guess) / 2;
        } while (Math.abs(guess - previousGuess) > maxError);

        return guess;
    }
}