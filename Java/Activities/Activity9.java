import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        // Create an ArrayList of Strings
        ArrayList<String> myList = new ArrayList<String>();

        // Add 5 names to the ArrayList
        myList.add("Alice");
        myList.add("Bob");
        myList.add("Charlie");
        myList.add("Diana");
        myList.add("Ethan");

        // Print all names using a for loop
        System.out.println("All names in the list:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        // Retrieve the 3rd name using get() (index 2)
        String thirdName = myList.get(2);
        System.out.println("\nThe 3rd name in the list is: " + thirdName);

        // Check if a name exists using contains()
        String searchName = "Diana";
        boolean containsName = myList.contains(searchName);
        System.out.println("\nDoes the list contain '" + searchName + "'? " + containsName);

        // Print the size of the ArrayList
        System.out.println("\nNumber of names in the list: " + myList.size());

        // Remove a name and print the size again
        myList.remove("Bob");
        System.out.println("Removed 'Bob' from the list.");
        System.out.println("New number of names in the list: " + myList.size());
    }
}
