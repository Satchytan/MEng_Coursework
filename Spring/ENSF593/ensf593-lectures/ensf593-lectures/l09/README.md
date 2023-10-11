# Lecture l09
## Goal: More inheritance and interfaces

## Reading
Chapter 7 Inheritance:
- 7.4 Using super to Call Superclass Constructors
- 7.5 Using super to Access Superclass Members
- 7.9 Superclass References and Subclass Objects

Chapter 8 Packages and interfaces
- 8.6 Interfaces
- 8.7 Implementing Interfaces
- 8.8 Using Interface References
- 8.9 Try This 8-1: Creating a Queue Interface

## Warm-up

Accessing parent class members using super

Similar to using `this` to access members of the current class, the keyword `super` can be used to access members of the parent class.

Complete TODOs in `Shapes.java`.

## Interface
> An interface is syntactically similar to an abstract class, in that you can specify one or more methods that have no body. Those methods must be implemented by a class in order for their actions to be defined. Thus, an interface specifies what must be done, but not how to do it. Once an interface is defined, any number of classes can implement it. Also, one class can implement any number of interfaces.

Defining an interface:

```java
interface Series{
	public int getNext();
	public void reset();
	public void setStart(int startValue);
}
```

Implementing an interface:

```java
class ByTwos implements Series{
	int start, val;
	public int getNext(){ int current = val; val += 2; return current;}
	public void reset(){ val = start;}
	public void setStart(int startValue){start = val = startValue;}
}
```

Try out in jshell.

The [ActionListener](https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/java/awt/event/ActionListener.html) used in our GUIs is an interface.


## IoT example - RemoteControlled interface
In a file `Speaker.java` implement the class `Speaker` as defined in the UML diagram:

```
@startuml
interface RemoteControlled
class IOTDevice

class Speaker{
+ location: String
+ volume : int

+ Speaker(ipAddress: String, location: String)
+ toString() : String
+ turnOn() : void
- resetVolume() : void
}

IOTDevice <|-- Speaker : is-a
RemoteControlled <|.. Speaker : realizes
@enduml
```

- `IOTTools.java` contains definitions for `IOTDevice` and `RemoteContolled`.
- `toString()` returns location and volume as a string.
- `turnOn()` sends the command `"turn on"` to the device
- `resetVolume()` sets `volume` to a default value, e.g. 10, and sends the command `"volume:"+volume` to the device.
- When a speaker object is created or turned on, the volume should be reset
- `up()` and `down()` increase/decrease `volume` and send the new value to the devices with the `"volume:"+volume` command.

In a file `IOTExample.java` the main method should create two Speakers, turn these on and used to try out `IOTTools` methods.


## Code refactor - part 1
The file `CodeRefactor.java` contains code for `Student`, `UndergraduateStudent` and `GraduateStudent` classes.

At the stand-up meeting the client informs you that graduate students should be able to hold scholarships too. Not all students hold scholarships.

Refactor the code to allow for this functionality.


## Code refactor - part 2
The file `CodeRefactor.java` contains code for `Student`, `UndergraduateStudent` and `GraduateStudent` classes.

At the stand-up meeting the client informs you that undergraduate students should be able to work TA shifts too. Not all students work TA shifts.

Refactor the code to allow for this functionality.

## Code refactor - part 3
The file `CodeRefactor.java` contains code for `Student`, `UndergraduateStudent` and `GraduateStudent` classes.

At the stand-up meeting the client informs you that:
- Scholarships of 20 or more get a 10 top-up
- Any hour worked after 2h is double pay.

Refactor the code to allow for this functionality.


## Chapter Questions
- Chapter 8 Self-Test 6.
- Chapter 8 Self-Test 7.

## Programming Exercises
- Chapter 8 Self-Test 9.


