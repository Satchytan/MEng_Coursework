# Lecture l02

## Goal: Datatypes and operators
- Setup a `my-work` Eclipse workspace and add Java projects and code there.
- Review Java primitive dataypes: int, double, char, boolean
- Review Java operators: Arithmetic, logical and assignment operators
- Talk about scope and lifetime
- Talk about implicit (automatic) and explicit (manual/casting) type conversion.

Summary:
- Java is a strongly typed language (see [strong and weak typing](https://en.wikipedia.org/wiki/Strong_and_weak_typing)).
- `Math` has math functions, e.g. `Math.sqrt()`.
- Java has integer division `16/3->5`
- Floating point accuracy is finite `for(int i = 0; i<=10;i++)System.out.println(i*0.1)`
- Java boolean is either `true` or `false`, `1` and `0` are not treated as booleans
- Java has `char` to represent a single character in unicode, which can be treated as a number as well.

## Reading
Chapter 2, focus on:
- Java's Primitive Types
- The Boolean Type
- The Scope and Lifetime of Variables
- Arithmetic Operators
- Relational and Logic Operators
- Type Conversion in Assignments
- Casting Incompatible Datatypes

## Warm-up
In [jdoodle](https://www.jdoodle.com/online-java-compiler/) starting from a blank page, implement a program to convert inches to centimeters.

## Try This 2-1: How Far Away Is the Lightning?
- Create `Sound.java`, type code, run in Eclipse after setting up a `my-work` workspace.
- Refactor code to have a separate variable for time and a variable for the conversion factor.
- Speed of sound in air is 343 m/s. Change the program to output the distance in meters.
- Item 6. Change program to estimate distance from echo round-trip

## Activity: What is a variable?
1. Open a text editor and write down one sentence explaining what a variable is (30sec).
2. Read the first 2 paragraphs of the https://en.wikipedia.org/wiki/Variable_(computer_science)
3. Discuss with your neighbor how your definition differs from wikipedia and what you do not understand in the wikipedia entry (2x2min).
4. Share with the class (5min).

## Try This 2-2: Display a Truth Table for the Logical Operators
- Create `LogicalOpTable.java`, add code for AND, run code in the `my-work` workspace in Eclipse.
- Item 6. Modify the program to print 1 and 0 instead of `true` and `false`.


## Chapter Questions
- Chapter 2 Self-Test 2. Java's character type
- Chapter 2 Self-Test 9. In general, when is a cast needed?
- Chapter 2 Self-Test 12. Does a block define a scope?


## Programming Exercises

- Chapter 2 Self-Test 4. Single string multi-line print.
- Chapter 2 Self-Test 7. Show how short-circuit AND can be used to prevent division by zero.
- Chapter 2 Self-Test 10. Find all prime numbers between 2 and 100.
