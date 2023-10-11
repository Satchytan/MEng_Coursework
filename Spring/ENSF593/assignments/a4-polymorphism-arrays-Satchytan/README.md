# a4-polymorphism-arrays
Playing with polymorphism and arrays.

This assignment has two mandatory parts:
- [1. Shapes](#1-shapes)
- [2. Stats GUI](#2-stats-gui)

and two optional part (not graded):
- [Standard Deviation](#optional-standard-deviation)
- [Coding Trees](#optional-coding-trees)


# 1. Shapes

**Objectives**

The objectives of this assignment are
1. To reinforce the concepts of inheritance and polymorphism
2. To give practice extending classes and implementing interfaces


**Problem Statement**

There are two sub-parts:
1. Implement `RightTriangle` and `Square` classes that inherit from `Shape2D` and implement all abstract methods. The class `Rectangle` serves as an example.
2. Implement the `IShapePoints` interface in the class `Rectangle`.

The main in `TestShapes.java` implements tests for the work in this lab. 

Note how the static methods in `TestShapes.java` use parameters of `Shape2D` and `IShapePOints` only. Hence, this code will work with any class that inherits from the abstract class or implements the interface.

Once all elements are implemented, the corresponding lines in main can be uncommented and the output should be:

```
*** RightTriangle ***
1.0 x 2.0
area= 1.0
circumference= 5.23606797749979

*** Rectangle ***
1.0 x 2.0
area= 2.0
circumference= 6.0

*** Square ***
2.0 x 2.0
area= 4.0
circumference= 8.0

*** Reference point change ***
Reference point: (0.0, 0.0)
All points: [(0.0, 0.0), (1.0, 0.0), (0.0, 2.0), (1.0, 2.0)]

Setting reference point to (5.0, 10.0)
Reference point: (5.0, 10.0)
All points: [(5.0, 10.0), (6.0, 10.0), (5.0, 12.0), (6.0, 12.0)]

*** Change get reference point test ***
Got point (0.0, 0.0)
Changed point to (-10.0, 0.0)
Shape reference is (0.0, 0.0)
Comparing points is false (should be false)

*** Change set reference point test ***
Set reference to point (-1.0, -1.0)
Shape reference is (-1.0, -1.0)
Changed point to (1.0, 1.0)
Shape reference is (-1.0, -1.0)
Comparing points is false (should be false)

*** Square set width/height test ***
prior 1.0 x 1.0
after setWidth(5) 5.0 x 5.0
after setHeight(10) 10.0 x 10.0
```

**Implementation: Inheritance**

Study `Shape2D.java` and `Rectangle.java`.

Create a class `RightTriangle` in `RightTriangle.java` that represents a [right triangle](https://en.wikipedia.org/wiki/Right_triangle). It inherits from `Shape2D` and implements both abstract methods, a default constructor and a constructor taking width and height as arguments. Use `Rectangle.java` as an example.

Uncomment the corresponding line in `TestShapes.java` main to test the class.

Create a class `Square` in `Square.java` that represents a square. It inherits from `Shape2D` and implements both abstract methods, a default constructor and a constructor taking length as argument. Use `Rectangle.java` as an example. Since a square does not have an independent width and height, override `setWidth()` and `setHeight()` from the parent class so that both width and height are always the same.

Uncomment the corresponding line in `TestShapes.java` main to test the class.


**Implementation: Interface**

In the `Rectangle` class add `implements IShapePoints` to the class definition.

To implement the three methods of the interface, add an instance variable of type `Point2D` to the `Rectangle` class that will represent the reference point. Adapt any constructor to initialize this instance variable.

Implement `getReferencePoint()` and `setReferencePoint()` making sure you create a copy of the `Point2D` object.

Implement `getAllShapePoints()` to return the four points of the rectangle. Use the reference point as the lower-left point of the rectangle, e.g. the upper-right point of the rectangle would be `(reference-x + width, reference-y + height)`.

Uncomment the corresponding lines in `TestShapes.java` main to test your implementation.


**Reporting**

In the markdown file `Shapes.md` add the UML class diagram including `Shape2D`, `Rectanlge`, `RightTriangle`, `Square`, `IShapePoints`, as an embedded image. Add JavaDoc and comments to all your class additions, classes and interfaces. Include a screenshot demonstrating successful execution of `TestShapes.java`.

# 2. Stats GUI
**Objectives**

The objectives of this lab is: To practice using arrays.

**Problem Statement**

Write a JFrame based GUI that enables the user to input a sequence of exam grades and then computes the average and the median of the grades entered. 

To compute the median of a list of numbers, you must find the middle value -- i.e., that value for which there are the same number of smaller and larger. If there are an odd number of elements in the list, the median is the middle element. So, for the list

```
  10 20 45 65 76 78 88
```

the median would be 65. For a list with an even number of elements, you must take the average of the two middle numbers. So, for the list

```
  10 20 45 65 75 78 88 90
```

the median would be (65 + 75)/2 = 70. To solve this problem, it is necessary to store the individual grades in an array and then sort the array.

**GUI Specifications**

Elements and layouts of the GUI are implemented in `src/StatsGUI.java`.

The GUI contains an input JTextField, an output JTextArea, and two JButtons, one to show stats and one to clear the GUI (and start over). The user is prompted to enter grades into the JTextField. Pressing ENTER will add the grade. When the STATS button is clicked, the program sorts and displays the grades that were entered, plus their mean (average) and median. When the RESET button is clicked, the GUI should be cleared so that a new set of stats may be calculated.

**Design Specifications**

You need two Java classes for this project.

`StatsGUI` defines the graphical user interface. It should implement the `ActionListener` interface and should handle the following three actions:
* JTextField input: Pass the number in the text field to the Stats object
* STATS Button	: Get the results from the Stats object and display them in the JTextArea.
* RESET Button: Clear the interface and create a new Stats object.

A partial implementation of this class is available at `src/StatsGUI.java`.

`Stats` should keep track of the grades that are typed in and should do the calculation of the mean and the median. It should contain the following elements:
- Instance variables. An `int` array is needed to store the individual grades. This should be declared `private`. Also, a `private` integer variable should be used to count the number of grades that have been stored in the array.
- Constructor Method. The public constructor method should instantiate the array to 100 elements and set the count to 0.
- The `add(int)` Method. This `public` method takes an `int` parameter, a grade, and inserts it into the next location in the array. It uses the counter variable to determine where the next element goes. Don't forget to increment the count after each insertion.
- The `getMean()` Method calculates the average of the numbers that have been inserted into the array. Use a for loop. What should the bound be for the loop?
- The `sort()` Method sorts the array into ascending order. This method is implement with code adapted from Try-This 5.1 in Java a beginner's guide.
- The `getMedian()` Method first sorts the first N elements of the array, where N is the number of grades that have been stored in the array. It then returns the median value as a double. You need to identify whether there are an even or odd number of elements in the array; and the center element.
- The `toString()` Method returns the list of sorted grades plus their average and their median. It uses string concatenation plus escape sequences, such as `"\n"` to format the output. This method will be called from the GUI.

You are provided a partial implementation of the `src/Stats.java`.


**Reporting**

In the markdown file `Stats.md` add the UML class diagram of `StatsGUI` and `Stats`, their dependencies and their relationships. Add JavaDoc and comments (where necessary) to all your class additions. Include a screenshot demonstrating successful execution and outputs of a computing stats of even and odd number of grades. 

Reflection - Include a sentence or two about:
- what you liked or disliked,
- found interesting, confusing, challenging, motivating

while working on this assignment.

# Optional: Standard Deviation
In the `StatsGUI` and `Stats` classes add functionality to compute the standard deviation.

Determine the Standard Deviation of the exam grades using the following method.

Raw score method for calculating standard deviation 
Consider the exam scores `8,25,7,5,8,3,10,12,9`:
 
```
Determine N, which is the number of scores.
 
Compute the sum of X and the sum of Xsquared.
 
Then, calculate the standard deviation as illustrated below.
 
      score(X)   Xsquared

         8           64

        25          625

         7           49                  N = 9

         5           25

         8           64                  sum of X = 87

         3            9

        10          100                  sum of Xsquared = 1161

        12          144 
   
         9           81

       ---         ----

        87         1161



Standard Deviation 	= square root of((sum of Xsquared -((sum of X)*(sum of X)/N))/(N-1))

   			= square root((1161-(87*87)/9)/(9-1))
 
   			= square root((1161-(7569/9))/8)

   			= square root((1161-841)/8)

   			= square root(320/8)

   			= square root(40)

 Standard Deviation =  6.32 
```

# Optional: Coding Trees
In [this video](https://www.youtube.com/watch?v=7tCNu4CnjVc) Professor Altenkirch presents an object-oriented approach to represent equations. He uses Python. Implement the class hierarchy in Java.


