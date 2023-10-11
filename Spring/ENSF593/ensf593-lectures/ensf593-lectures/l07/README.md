# Lecture l07
## Goal: A closer look at methods and classes
- Access modifiers: private vs. public
- The static keyword
- Method overloading
- Passing objects to methods

## Reading
Chapter 6 More data types and operators 
- 6.1 Controlling Access to Class Members
- 6.3 Pass Objects to Methods
- 6.4 Returning Objects
- 6.5 Method Overloading
- 6.6 Overloading Constructors
- 6.9 Understanding static


## Warm-up
Implement the following Student class:

```
@startuml
class Student{
+ name: String
+ numberOfCourses: int

+ Student(name: String, nCourses: int)
+ toString(): String
+ getTuition(courseFee: double): double 
}
@enduml
```


In the main method, create an array of 3 Students with zero courses.
Using a loop, add a course to each student. Print the array of students.

## Access modifiers
In the Student class above, the number of courses instance variable is public. To set the number of courses, we can directly access the property.

Problem: If the number of courses is set to a negative value, the tuition becomes negative (see `TotalTuition.java`).

What could we do about this? Options:
- (external) When computing total tuition, check that student tuition is positive OR number of courses is positive.
- (internal) Make number of courses private.
    - Use getter and setter methods, clip negative values to 0 in setter.
    - Initialize courses to 0, have getter, add and remove methods. Check that value cannot be negative.

Create `StudentAccess.java` and `TotalTuitionAccess.java` to test your ideas.
    
## Static
In the Student class which elements could be made static? How does calculating total tuition change? 

Create `StudentStatic.java` to test your ideas.


## Method overloading
In `Student.java` add a: 
- method `getTuition()` without parameters, that uses a course fee of `10.0`
- method `getTuition(double courseFee, double rebate)` 
- bonus: make the default course fee a class constant, i.e. `static final`.

Call the different methods and follow control flow with the debugger.

## Passing and returning objects
Objects are passed by reference, hence a method receiving an object, can make changes that persist outside of the method. Objects can be create in a method and returned (by reference).

In a file `PassReturnObjects.java`, 
- create a static method that gets an int representing the number of courses and sets it to zero.
- create a static method that gets a Student object and sets the number of courses of a Student to zero.
- create a static method that gets a Student object, creates a copy, sets the number of courses to zero in the copy, and returns the copy.

In the main, compare the three methods and demonstrate that object changes persist outside the method.


## Chapter Questions
- Chapter 6 Self-Test 1.
- Chapter 6 Self-Test 2.
- Chapter 6 Self-Test 5.
- Chapter 6 Self-Test 7. 
- Chapter 6 Self-Test 10. 
- Chapter 6 Self-Test 11. 
- Chapter 6 Self-Test 12. 

## Programming Exercises
- Chapter 6 Self-Test 4.


