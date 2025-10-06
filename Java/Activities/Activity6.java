public class Activity6 {
    public static void main(String[] args) throws InterruptedException {
        Plane plane = new Plane(3);

        // Onboard passengers
        plane.onboard("Alice");
        plane.onboard("Bob");
        plane.onboard("Charlie");
        plane.onboard("Dave"); // Should print plane is full

        // Take off
        plane.takeOff();

        // Print passengers
        System.out.println("Passengers onboard: " + plane.getPassengers());

        // Wait for 2 seconds (simulate flight duration)
        Thread.sleep(2000);

        // Land
        plane.land();

        // Get last landing time
        System.out.println("Last landing time: " + plane.getLastTimeLanded());

        // Passengers should be cleared after landing
        System.out.println("Passengers onboard after landing: " + plane.getPassengers());
    }
}
