1. inheritance
Inheritance establishes a relationship between one or more classes, making it possible to share the structure and/or behavior common 
to the classes.
The subclass inherit all the public variable and behaviors in a superclass.

2. Superclass
The class that is inherited by a subclass. All of its attributes and behaviors are inherited
3. Subclass
A class that extends the superclass. Contains all of the attributes and behaviors of the superclass and possibly has other attributes and
behaviors

4. extends
a keyword that makes a class subclass of another class
for example
public gradStudent extends student{ }

5. super()
A subclass constructor can be implemented with a call to the super method, which invokes the superclass constructor. 
For example, the default constructor in the UnderGrad class is identical to that of the Student class. This is 
implemented with the statement


6. what is the difference between superclass and subclass, give at least one example
A subclass has all the public variables and methods, but a superclass doesn't have all the methods and variables in the subclass
superclass: employee; subclass: teacher

7. Which is bigger? a superclass or a subclass?
subclass is bigger.