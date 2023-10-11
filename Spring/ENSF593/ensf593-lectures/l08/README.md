# Lecture l08
## Goal: Inheritance and abstract classes
- Introducing inheritance: Extending parent classes
- Overriding methods in child classes -> polymorphism
- Abstract classes are classes with missing implementations -> inherit and implement.

## Reading
Chapter 7 Inheritance:
- 7.1 Inheritance Basics
- 7.2 Member Access and Inheritance
- 7.3 Constructors and Inheritance
- 7.7 Creating a Multilevel Hierarchy
- 7.10 Method Overriding
- 7.11 Overridden Methods Support Polymorphism
- 7.12 Why Overridden Methods?
- 7.12 Using Abstract Classes


## Warm-up
Chapter 6 Self-Test 4.

## What is inheritance?
>Java supports inheritance by allowing one class to incorporate another class into its declaration. This is done by using the extends keyword. Thus, the subclass adds to (extends) the superclass.

```
@startuml
class TwoDShape{
+ width: double
+ height: double
+ showDim(): void
} 

class Triangle{
+ style: String
+ area(): double
+ showStyle(): void
}

class TriangleTwoDShape{
+ width: double
+ height: double
+ style: String
+ showDim(): void
+ area(): double
+ showStyle(): void
}

TwoDShape <|-- Triangle : is-a
@enduml
```

In the above UML, the Triangle (sub-class, child class) that is-a TwoDShape (super class, parent class) is equivalent to the TriangleTwoDShape class (see Fig 7.1 in the textbook)

Note:
- Default constructors are called in order of inheritance
- Specialized constructors are not inherited
- private members are not accessible in child classes

See `Shapes.java`.


## IoT example
In a file `IOTExample.java` Implement the following two classes:

```
@startuml
class IOTDevice{
+address: String

+send(msg: String) : String
}

class TemperatureSensor{
+units: String

+getValue(): double
}

IOTDevice <|-- TemperatureSensor: is-a
@enduml

```

- `send()` simply prints `"sending msg to address using TCP"` and returns an empty string.
- `getValue()` sends a message `"getValue"` and returns a arbitrary double.


## Method overriding and polymorphism
> Method overriding forms the basis for one of Java's most powerful concepts: dynamic method dispatch. Dynamic method dispatch is the mechanism by which a call to an overridden method is resolved at run time rather than compile time. Dynamic method dispatch is important because this is how Java implements run-time polymorphism.

```
@startuml
class TwoDShape{
+ width: double
+ height: double
+ showDim(): void
+ area(): double
} 

class Triangle{
+ style: String
+ showStyle(): void
+ area(): double
}

TwoDShape <|-- Triangle
@enduml
```

See `ShapesOverride.java`

**Activity:** override `send()` in `TemperatureSensor` to print that it is using *UDP*.

## Abstract class
> Sometimes you will want to create a superclass that defines only a generalized form that will be shared by all of its subclasses, leaving it to each subclass to fill in the details. Such a class determines the nature of the methods that the subclasses must implement but does not, itself, provide an implementation of one or more of these methods.

Implementing an abstract method is the second way to obtain polymorphism.

```
@startuml
abstract class TwoDShape{
+ width: double
+ height: double
+ showDim(): void
+ {abstract} area(): double
} 

class Triangle{
+ style: String
+ showStyle(): void
}

TwoDShape <|-- Triangle: is-a
@enduml
```

See `ShapesAbstract.java`

## Code refactoring
Refactor the code in `CodeOriginal.java` to have the following class structure:

```
@startuml
abstract class Student{
~fullName: String
~id: string

~Student(name: String, id: String)
+ {abstract} calculateTuition(): double
}
class UndergraduateStudent{
~numberOfCourses: int
~courseFee: double
~scholarship: double

~UndergraduateStudent(String, String, int, double, double)
+calculateTuition(): double
}
class GraduateStudent{
~programFee: double
~taHours: int
~taHourlyPay: double

~GraduateStudent(String, String, double, int, double)
+calculateTuition(): double
}

Student <|-- UndergraduateStudent : is-a
Student <|-- GraduateStudent: is-a
@enduml
```

Save the resulting code in `CodeRefactor.java`.

## Activity: Advantages and disadvantages of inheritance

Search the web for pros and cons of inheritance.

## Chapter Questions
- Chapter 7 Self-Test 1.
- Chapter 7 Self-Test 3.
- Chapter 7 Self-Test 5.
- Chapter 7 Self-Test 6.
- Chapter 7 Self-Test 7.
- Chapter 7 Self-Test 9.

## Programming Exercises
- Chapter 7 Self-Test 2.


