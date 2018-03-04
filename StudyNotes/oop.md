Class
A class is a generic template for a set of objects with similar features. An instance of a class is another word for an actual object.

Object
Reference variable; instance of a class; a concrete representation of a class

Attribute
Attributes are the individual things that differentiate one object from another and determine the appearance, state, or other qualities of that object.

Behavior
A class's behavior determines how an instance of that class operates; for example, how it will "react" if asked to do something by another class or object or if its internal state changes. 

Encapsulation: hiding the attribute and behavior of an object and show the interface.

Constructor: 
A constructor creates an object of the class. Having several constructors provides different ways of initializing class objects. For example, there are two constructors in the BankAccount class.

Invoke: 
To call a method

Getter Methods: 
get the value of an attribute(variable); accessor

Setter methods: 
set the value of an attribute; also called mutator method

fax machine
public class faxMachine{
public String brand;
public double weight;
public String toBePrinted;
public faxMachine(){
 brand = "default brand";
 weight = 10.00;
}
public faxMachine(String brand, double weight){
 this.weight = weight;
 this.brand = brand;
}
public void receiveMessage(String message){
 this.toBePrinted = message;
}
public void printMessage(){
 System.out.print(this.toBePrinted);
}
}

audioSpeaker
public audioSpeaker{
 public String brand;
 public int numberOfSpeakers;
 public audioSpeaker(){
  brand = "default";
  numberOfSpeakers = 1;
 }
 public audioSpeaker(int number, String brand){
  this.numbersOfSpeaker = number;
  this.brand = brand;
 }
 public void connectToAComputer(){
 }
 public void speak(){
 }
}
mouse
public mouse{
public int sensitivity;
public int numbers of buttons;
public String brand;
public mouse(){
 sensitivity = 1;
 numberOfButtons = 3;
 brand = "default";
}
public mouse(int s, int b, String brand){
this.sensitivity = 1;
this.numberOfButtons = 3;
this.brand = brand;
}

public remote{
public static numberOfButtons = 10;
public double length;
int channel;
public remote(){
 length = 20.0;
 channel = 1;
}
public remote(double l){
 this.length = l;
}
public void press(int c){
 channel = c;
}
}
public dice{
public static int[] numbers = {1,2,3,4,5,6};
public int currentNumber;
public dice(){
currentNumber = (int)Math.random(6) + 1;
}
public void change(int i){
currentNumber = i;
}
}
//it's like the whole week of classes was wasted for this stupid meaningless classwork
//why not study for something else on MOOC when the teacher doesn't teach 
