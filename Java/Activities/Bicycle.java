public class Bicycle implements BicycleParts, BicycleOperations {
    // Instance variables
    private int gears;
    private int currentSpeed;

    // Constructor
    public Bicycle(int gears, int currentSpeed) {
        this.gears = gears;
        this.currentSpeed = currentSpeed;
    }

    // Implement applyBrake
    public void applyBrake(int decrement) {
        currentSpeed -= decrement;
        if (currentSpeed < 0) currentSpeed = 0;
        System.out.println("Slowed down by " + decrement + ". Current speed: " + currentSpeed);
    }

    // Implement speedUp
    public void speedUp(int increment) {
        currentSpeed += increment;
        int maxSpeed = 0;
		if (currentSpeed > maxSpeed) currentSpeed = maxSpeed;
        System.out.println("Sped up by " + increment + ". Current speed: " + currentSpeed);
    }

    // Description method
    public void bicycleDesc() {
        System.out.println("Number of gears: " + gears);
        String maxSpeed = null;
		System.out.println("Max speed: " + maxSpeed + " km/h");
        String tyres = null;
		System.out.println("Number of tyres: " + tyres);
    }
}
