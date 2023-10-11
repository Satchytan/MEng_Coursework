# Lecture l04

## Goal: Interactive CLI and GUI

- To make assignments more fun, we look at ways for user interaction.
- In interactive command line interface (CLI) implements user interaction in form of a dialog with prompts and displays.
- A custom class `InteractiveCLI` is used as the bases to implement CLI interactions.
- A graphical user interface (GUI) implements user interaction with visual elements and is event-based.
- Java Swing provides classes to implement a GUI.
 

## Reading
- Chapter 10 Using I/O
    - Ask the Expert (Scanner) in 10.15 Try-This 10.2
- Chapter 17 Introducing Swing
    - 17.0 Chapter Preliminaries to 17.6 Use JButton

## Warm-up
In your `my-work` Eclipse workspace create a java project and a class `Line1D` that represents a line in one-dimensional space. The class has:
- a constructor to set all instance variables
- a method `length()` that returns the length of the line
- a method `toString()` that returns a string representation of the object.

Draw the UML, implement and test the class.

Discuss access modifiers `public` and `private`.

## Study command-line interface example
- Study `InteractiveCLI.java` 
- Study `GreeterApp.java`
- Study `Greeter.java`
- Change `GreeterApp` to use the `Greeter` object rather than implementing the `greet()` method directly. 

The `InteractiveCLI` class uses a `Scanner` in the background to read input from the keyboard.

## Create a Command-Line Interface to calculate square-root
Turn `GreeterApp.java` into a program that asks the user for a number and prints the square-root of the number. Save your code in a file `SquareRootApp.java`.

To calculate the square-root, use `Math.sqrt()`. 

## Activity: Primitive vs reference types 

In [pythontutor](https://pythontutor.com/java.html#mode=edit) enter this code and follow code execution.

```java
public class Length {
    int miles;
    int toKilometers(){return (int)(miles*1.6);}
    int toMiles(){return miles;
    }
    
    public static void main(String[] args) {
      //primitive type
      int dist = 1;
      System.out.println(dist);
      int dist2 = dist;
      dist2 = 10;
      System.out.println(dist2);
      
      
      //reference type
      Length length = new Length();
      length.miles = 1;
      System.out.println(length.miles);
      Length length2 = length;
      length2.miles = 10;
      System.out.println(length.miles);
      
      
    }
}
```

What is the difference between primitive and reference type variables?

## Study graphical user interface example
- Study and run `GreeterGUI.java` 
- Implement the call-back function to read the name from the text field and greet the person in the text area.

## Create a Graphical User Interface to calculate square-root
Turn `GreeterGUI.java` into a program that asks user for a number and displays the square-root of the number. Save code in `SquareRootGUI.java`.

To calculate the square-root, use `Math.sqrt()`. 

Compare the UML and code of the GUI and Command-Line programs.

## Chapter Questions
None.


## Programming Exercises
- Implement a CLI of your choice using `GreeterApp.java` as a template
- Implement a GUI of your choice using `GreeterGUI.java` as a template.
