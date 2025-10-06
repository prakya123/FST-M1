public class Activity7 {
    public static void main(String[] args) {
        // Create a Bicycle object
        Bicycle myBike = new Bicycle(5, 10);

        // Show bike description
        myBike.bicycleDesc();

        // Speed up and brake
        myBike.speedUp(15);
        myBike.applyBrake(5);
        myBike.applyBrake(25);  // Should not go below 0
    }
}
 
