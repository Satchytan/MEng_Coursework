# Lecture l06
## Goal: Arrays and String
- Learn about 1D and 2D arrays in Java
- Practice creating and manipulating arrays
- Learn about Strings in Java
- Practice Strings methods


## Reading
Chapter 5 More data types and operators 
- 5.1 Arrays
- 5.2 Try This 5-1: Sorting an Array
- 5.3 Multidimensional Arrays
- 5.4 Alternative Array Declaration Syntax
- 5.5 Assigning Array References
- 5.6 Using the length Member
- 5.7 Try This 5-2: A Queue Class
- 5.8 The For-Each Style for Loop
- 5.9 Strings


## Warm-up
We would like to write a GUI that:
- Generates a password (String) of random characters
- Allows the user to choose the length of the password
- Characters are randomly chosen from `'A'` to `'Z'`.

We anticipate that our password generator might be used in other contexts. Therefore, we create two classes: `PasswordGenerator` and `RandomPasswordGUI`.

We created the UI last week, now we will create the `PasswordGenerator` class. 

Using `PasswordGeneratorDev.java`, implement *Idea 1* using `char` and `Math.random()` to generate random passwords. Subsequently, transfer this algorithm to the `PasswordGenerator` class and add it to `RandomPasswordGUI`.


## Introduction to arrays
An array is a collection of a fixed number of variables of the same type.

Some examples

```java
int[] a = new int[10]; //Initialized to 0
int[] b = {1, 2, 3, 4, 5};
String[] words = {"Hello", "World"}
```

Access elements with loops

```java
// regular for loop
for(int i=0; i<a.length;i++)
	a[i] = i;

// for-each loop	, cannot change elements
for(int x: b)
	System.out.print(x+" "); 
```


## Practice working with arrays
Implement TODOs in `ArraysTest.java`

## Introduction to String
Strings are defined using `"` and are objects (reference types), however, they are immutable, i.e. characters cannot be changed in-place.

In `StringComparison.java` we see why we need to use `equal()` and not `==` to compare Strings. The former checks for equal content, the latter checks for equal reference (to the same memory location).

## Changing strings with StringBuilder
This is needed for a3. Passing a String to a `StringBuilder` object allows to change individual characters using the `setCharAt()` method:
```java
StringBuilder builder = new StringBuilder("Hello");
builder.setCharAt(0, 'h');
String result = builder.toString() //"hello"
```

Implement TODOs in `StringManipulation.java`

## Practice working with String
Strings come with many handy methods, including 
- `trim()` to remove starting and trailing whitespace
- `split(token)` to split Strings into arrays of sub-strings separated by `token`, e.g. `","`.
- `token` can be a regular expression: 
     - `"\\s+"` one or more whitespaces
     - `"[.!?]"` any of a group of characters
     
 Practice by implementing TODOs in `TextAnalysis.java`


## Chapter Questions
- Chapter 5 Self-Test 1. Two ways to create a one-dimensional arrays of double
- Chapter 5 Self-Test 2. Initialize a one-dimensional array to int 1-5.
- Chapter 5 Self-Test 5. Difference between String `indexOf()` and `lastIndexOf()`.
- What is the difference between mutable and immutable variable types?Show an example for each.

## Programming Exercises
- Implement Idea 2 in `PasswordGeneratorDev`.
- Chapter 5 Self-Test 3. Calculate average of 10 doubles. 
- Chapter 5 Self-Test 4. Change sort in Try-this 5.1 to sort Strings
- Chapter 5 Self-Test 6. Demonstrate `charAt()` and `length()` using the literal `"I like Java"`.

