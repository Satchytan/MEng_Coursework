# Lecture l10

## Goal: Exceptions
- Exceptions are a way to handle runtime errors
- Java has checked and unchecked errors
- try-except is the code construct

## Reading
Chapter 9 Exception Handling
- 9.1 The Exception Hierarchy
- 9.2 Exception Handling Fundamentals
- 9.3 The Consequences of an Uncaught Exception
- 9.4 Using Multiple catch Statements
- 9.7 Throwing an Exception
- 9.9 Using finally
- 9.10 Using throws

## Warm-up
Implement the classes and interfaces in the following UML:

```
@startuml

interface Tuition{
+ getTuition() : double
}

class UndergraduateTuition{
- numberOfCourses : int
- courseFee : double

+ UndergraduateTuition(nCourses : int, fee: double)
+ getTuition() : double
}

class Student{
- name : String
- id : String
- tuition : Tuition

+ Student(name : String, id : String, tuition : Tuition)
+ calculateTuition() : double
}

Tuition <|.. UndergraduateTuition
Student o-- Tuition : has-a
@enduml
```

- `StudentUtils.java` contains the `Student` class and `Tuition` interface.
- `TuitionRefactor.java` contains the `UndergraduateTuition` class and a main that instantiates a Student class with UndergraduateTuition.

## Introduction to Exceptions and try-catch
> Errors that result from program activity are represented by subclasses of Exception. For example, divide-by-zero, array boundary, and file errors fall into this category. In general, your program should handle exceptions of these types. An important subclass of Exception is RuntimeException, which is used to represent various common types of run-time errors.

>Java exception handling is managed via five keywords: try, catch, throw, throws, and finally. 

- try block contains the *dangerous* code
- Multiple catch blocks, arranged specific to general
- Checked exceptions: Need to handled or else compile error
- Unchecked exceptions: Are handled by Java with program termination. Add try-catch for custom handling.
- finally block is always executed, used for clean up.

See `ExeceptionIntroduction.java` and `CheckedException.java`.

## Throwing an exception

See `ThrowException.java`.

## Robust user entry

See `UserReadException.java`


## Chapter Questions
- Chapter 9 Self-Test 1.
- Chapter 9 Self-Test 2.
- Chapter 9 Self-Test 3.
- Chapter 9 Self-Test 4.
- Chapter 9 Self-Test 5.

## Programming Exercises
- Chapter 9 Self-Test 10.


