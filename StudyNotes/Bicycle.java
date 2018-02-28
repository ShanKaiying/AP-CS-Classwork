public class Bicycle{
public static int NumberOfWheels = 2;
public String brand;
public double weight;
public double speed;
boolean isRunning;

public Bicycle(){
 this.brand = "";
 this.weight = 10.0;
 isRunning = false;
 this.speed = 10.;
}

public Bicycle(String brand, double weight, double speed, double position, boolean isRunning, double speed){
 this.brand = brand;
 this.weight = weight;
 this.isRunning = isRunning;
 this.speed = speed;
}

public boolean ride(){
 return isRunning;
}
 
public void accelerate(){
 speed +=3;
}

}
