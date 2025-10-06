// Car.java
public class Car {
    int make;
    String color;
    String transmission;

    public void displayCharacteristics() {
        System.out.println("Car Make: " + make);
        System.out.println("Car Color: " + color);
        System.out.println("Car Transmission: " + transmission);
    }

    public void accelerate() {
        System.out.println("Car is accelerating...");
    }

    public void brake() {
        System.out.println("Car is slowing down...");
    }
}


