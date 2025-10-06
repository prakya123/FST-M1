import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Plane {
    // Private fields
    private int maxPassengers;
    private List<String> passengers;
    private LocalDateTime lastTimeTakenOff;
    private LocalDateTime lastTimeLanded;

    // Constructor initializing maxPassengers and empty passengers list
    public Plane(int maxPassengers) {
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<String>();
    }

    // Method to onboard passengers (adds passengers to the list)
    public void onboard(String passenger) {
        if (passengers.size() < maxPassengers) {
            passengers.add(passenger);
            System.out.println(passenger + " onboarded.");
        } else {
            System.out.println("Cannot onboard " + passenger + ": plane is full.");
        }
    }

    // Method to take off - returns the current date and time
    public LocalDateTime takeOff() {
        lastTimeTakenOff = LocalDateTime.now();
        System.out.println("Plane took off at " + lastTimeTakenOff);
        return lastTimeTakenOff;
    }

    // Method to land - sets lastTimeLanded to current date/time and clears passengers
    public void land() {
        lastTimeLanded = LocalDateTime.now();
        passengers.clear();
        System.out.println("Plane landed at " + lastTimeLanded + ". Passengers cleared.");
    }

    // Getter for lastTimeLanded
    public LocalDateTime getLastTimeLanded() {
        return lastTimeLanded;
    }

    // Getter for passengers list
    public List<String> getPassengers() {
        // Return a copy to maintain encapsulation
        return new ArrayList<String>(passengers);
    }
}
