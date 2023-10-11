# a1-classes-objects
Practice designing and implemented classes, using objects in Java.

This assignment has two mandatory parts:
- [1. Temperature](#1-temperature)
- [2. Tile](#2-tile)

and two optional parts (not graded):
- [Enhanced Temperature](#optional-enhanced-temperature)
- [Rational](#optional-rational)

# 1. Temperature
**Problem Statement**

Design and implement a class for a Temperature object that is capable of reporting its temperature in either Fahrenheit or Celsius. This class should have one instance variable called `degrees`, which contains the Fahrenheit temperature, and two public methods, one called `getFahrenheit()`, which returns the temperature in Fahrenheit, and one called `getCelsius()`, which returns the temperature in Celsius. This method has to convert the stored temperature to Celsius before returning it. An expression for converting Fahrenheit to Celsius is `(5 *(F -32) /9)`, where `F` is the temperature in Fahrenheit.
Test your class definition by implementing a `main()` method that creates Temperature instances and displays their temperature values.

Your program should produce the following output in the Java console:

```
 The temperature of thermometer1 is 20.0 degrees Fahrenheit.
 The temperature of thermometer1 is -6.67 degrees Celsius.
 The temperature of thermometer2 is 98.6 degrees Fahrenheit.
 The temperature of thermometer2 is 37.0 degrees Celsius.
```

**Problem Decomposition**

This problem can be divided into one class, the `Temperature` class, which will implement the temperature conversion. It will contain a `main()` method in which Temperature instances will be created and used.

**Design**

1. Draw a UML class diagram to describe the design of the Temperature class. Your design should identify the name of the class, its attributes (instance variables) and behaviors (methods). Designate which elements will be hidden and which parts of the class will make up its public interface.

2. Create a written specification for the Temperature class based on your UML diagram. The specification captures in words what the class represents (attributes) and which actions can be performed (methods). For example a class `Circle` might be specified with:

   *The class Circle represents a circle with a radius and allows computation of its area and circumference.*
	
   This description will become a comment block at the beginning of your source file.

3. Type the specification you developed in Step 2 into a Java comment block in `src/Temperature.java`. This file will be the file you use for defining the Temperature class. The comment will serve as documentation for the class. A comment block in Java begins with either `/*` or `/**`  and ends with `*/`. It can extend over multiple lines. Comments that begin with `/**` are JavaDoc elements which can be converted to documentation using the Java Development Kit (JDK). Here's an example format that you can use: 

```java
/** 
* Class Name: Circle 
* 
* Represents a circle with a radius and 
* allows computation of area and circumference
* 
*/
```
You find more Java documentation examples in JavaDocumentationGuidelines.pdf on D2L.

**Implementation**

Use a stepwise refinement approach to code and test the  Temperature class. Here's a sequence of appropriate steps, after each of which you should compile and run your program. Step 4, step 5 and step 6 are good points to commit to git.

1. Code the initial comment block (purpose of your program, author name, etc) and the basic class definition.

2. Code the declarations for the class's instance variables as well as the constructor method.

3. Code the definition for each method, one at a time.

4. Code a stub version of the `main()` method.

5. Add code to the main method to create and use one Temperature object. Write one access method at a time, as well as a method call in `main()` that tests the method. Here is where you would use method calls embedded within `println()` expressions to display the temperature values. For example, here are several statements that will output thermometer1's temperature: 

```java
System.out.print("The temperature of  thermometer1 is  "); 
System.out.print(thermometer1.getFahrenheit());
System.out.println(" degrees Fahrenheit."); 
```

6. Add code to the main method to create and use a second Temperature object.

**Reporting**

In the markdown file `Temperature.md` add the UML class diagram you drew as an embedded image. Add the class specification. Include a screenshot demonstrating successful execution and outputs. 

# 2. Tile
**Problem Statement**

In the board game Scrabble, each tile contains a letter, which is used to spell words in rows and columns, and a score, which is used to determine the value of words.

Design and implement a class for a Tile object that represents Scrabble tiles. The instance variables should include a character named `letter` and an integer named `value`. A character can be defined with `char letter = 'A';` in Java. Character variables can be compared with `==`, similar to other primitive types.

In addition to the default constructor that initializes `letter` to `'A'` and `value` to 1, add a constructor that takes two arguments to initialize instance variables.

The `Tile` class implements two methods `toString()` and `equals()`. The method `toString()` returns a string representation `"<letter>[<value>]"`, e.g. `"A[1]"`. The method `equals()` returns a boolean if to tile objects have the same letter and value. To compare two objects use `tile1.equals(tile2)`.

Test your class definition by implementing a main() method that creates Tile instances and displays their letter and value. Include an example where two tiles are equal, and two tiles are not equal.

Your program should produce the following output in the Java console:

```
Tile 0: A[1]
Tile 1: A[1]
Tile 2: Z[10]
Tile 0 is equal to Tile 1 is true
Tile 0 is equal to Tile 2 is false
```

**Problem Decomposition**

This problem can be divided into one class, the `Tile` class, which will implement the Tile representation and comparison logic. It will contain a `main()` method in which Tile instances will be created and used.

**Design**

1. Draw a UML class diagram to describe the design of the Tile class. Your design should identify the name of the class, its attributes (instance variables) and behaviors (methods). Designate which elements will be hidden and which parts of the class will make up its public interface.

2. Develop a written specification for the Tile class based on your UML diagram. This will become a comment block at the beginning of your source file.

3. Type the specification you developed in Step 2 into a Java comment block in `src/Tile.java`. This file will be the file you use for defining the Tile class. The comment will serve as documentation for the program. 

**Implementation**

Use a stepwise refinement approach to code and test the Tile class. Here's a sequence of appropriate steps, after each of which you should compile and run your program. Step 4, step 5, step 6 and step 7 are good points to commit to git.

1. Code the initial comment block (purpose of your program, author name, etc) and the basic class definition.

2. Code the declarations for the class's instance variables as well as the constructor method.

3. Code the definition for each method, one at a time.

4. Code a stub version of the `main()` method.

5. Add code to the main method to create and use one Tile object. Write constructors one at a time, as well as a corresponding instantiation in main() that tests the constructor. 

6. Write `toString()` and add code to `main()` to test it.

7. Write `equals()` and add to `main()` to test it.

**Reporting**

In the markdown file `Tile.md` add the UML class diagram you drew as an embedded image. Add the class specification. Include a screenshot demonstrating successful execution and outputs. 

Reflection - Include a sentence or two about:
- what you liked or disliked,
- found interesting, confusing, challenging, motivating

while working on this assignment.

# Optional: Enhanced Temperature
Copy `src/Temperature.java` to `src/EnhancedTemperature.java` and adapt the code to run with the new class name.

Add two mutator methods `setFahrenheit()` and `setCelsius()` to set the Temperature instance variable. Each method has a parameter representing temperature in the corresponding unit, Fahrenheit or Celsius. 

Add code to main() that asks the user to enter a temperature and prints the conversion. The user should be able to define the units first, then enters the temperature, finally, the program prints the corresponding temperature in the other unit. Use the `Scanner` class introduced at the end of Chapter 10 in *Java a Beginner's Guide*.

As a further extension, the main() could continue asking for conversions until the user enters 'q' for quit.

# Optional: Rational

Solve Exercise 4 in Section 11.10 in ThinkJava 2e available https://books.trinket.io/thinkjava2/chapter11.html 
