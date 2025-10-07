import java.util.HashMap;
import java.util.Map;

public class Activity11 {
    public static void main(String[] args) {
        // Create a Map with Integer keys and String values
        Map<Integer, String> colours = new HashMap<Integer, String>();

        // Add 5 random colours to the Map
        colours.put(1, "Red");
        colours.put(2, "Blue");
        colours.put(3, "Green");
        colours.put(4, "Yellow");
        colours.put(5, "Purple");

        // Print the Map
        System.out.println("Original Map: " + colours);

        // Remove one colour using remove() method
        colours.remove(4); // removes "Yellow"
        System.out.println("Map after removing key 4: " + colours);

        // Check if the colour "Green" exists using containsValue()
        boolean hasGreen = colours.containsValue("Green");
        System.out.println("Does the map contain 'Green'? " + hasGreen);

        // Print the size of the Map
        System.out.println("Size of the Map: " + colours.size());
    }
}
