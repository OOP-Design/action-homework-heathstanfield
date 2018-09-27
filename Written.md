## Exercise \#1
What is the difference between a ```KeyListener``` and a ```KeyAdapter```?
The difference between a KeyListener and a KeyAdapter is that a KeyAdapter is an abstract class that is used to replace a KeyListener because it can be used to extend and overide the abstract methods. A KeyListener is not abstract and can thus not be used to do such actions.

## Exercise \#2
What is the difference between a ```MouseListener``` and a ```MouseMotionListener```.
A MouseListner is used to get the input from the buttons whereas a MouseMotionListener is used in order to find the movement of the mouse. 

## Exercise \#3
Given a ```MouseEvent```, Java has the ```getButton``` and ```getModifiersEx``` methods for determining which mouse buttons are pressed. Are both methods really needed, that is, do they differ in any way?
The getButton method is mainly used in order to get the int representaion of the button that is pressed on the mouse but the getModifiersEx method is used in order to get the string representaion of the modifier's mask for the mouse event.

## Exercise \#4
What is meant by an event source, event listener, and event object?
The event source is what the user does with the mouse or keyboard or other device in order to cause something to happen, the event listener is the part of the code that is supposed to listen for this event and then this listener is the object that performs some sort of action when the event occurs.

## Exercise \#5
What is the purpose of an anonymous inner class? What would one use an anonymous inner class for?
An anonymous inner class is used when one needs to make an instance of an object that needs certain things like overloading methods of a class interface without needing to subclass the orginal class.
