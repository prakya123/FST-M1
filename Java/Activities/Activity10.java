import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        // Create a HashSet of Strings
        HashSet<String> hs = new HashSet<String>();

        // Add 6 objects using add() method
        hs.add("Apple");
        hs.add("Banana");
        hs.add("Cherry");
        hs.add("Date");
        hs.add("Elderberry");
        hs.add("Fig");

        // Print the size of the HashSet
        System.out.println("Initial size of HashSet: " + hs.size());

        // Remove an element that exists
        boolean removed = hs.remove("Cherry");
        System.out.println("Removed 'Cherry': " + removed);

        // Try to remove an element that doesn't exist
        boolean removedNonExisting = hs.remove("Grape");
        System.out.println("Tried to remove 'Grape': " + removedNonExisting);

        // Use contains() method to check for an item
        boolean containsBanana = hs.contains("Banana");
        System.out.println("Does the set contain 'Banana'? " + containsBanana);

        boolean containsMango = hs.contains("Mango");
        System.out.println("Does the set contain 'Mango'? " + containsMango);

        // Print the updated set
        System.out.println("Updated HashSet: " + hs);
    }
}

