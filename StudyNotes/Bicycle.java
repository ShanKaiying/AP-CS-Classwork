public class Bicycle{
public static int NumberOfWheels = 2;
public String brand;
public double weight;
boolean isRunning;

public Bicycle(){
 this.brand = "";
 this.weight = 10.0;
 isRunning = false;
}

public Bicycle(String brand, double weight, double speed, double position, boolean isRunning){
 this.brand = brand;
 this.weight = weight;
 this.isRunning = isRunning;
}

public boolean ride(){
 return isRunning;
}

}
