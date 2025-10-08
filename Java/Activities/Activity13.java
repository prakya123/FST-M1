import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {
    public static void main(String[] args) {
        // Create required objects
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        Random indexGen = new Random();

        System.out.println("Enter integers (type a non-integer to stop):");

        // Use hasNextInt() to accept only integer inputs
        while (scan.hasNextInt()) {
            list.add(scan.nextInt());
        }

        // Convert ArrayList to an array
        Integer nums[] = list.toArray(new Integer[0]);

        // Ensure the array is not empty before accessing it
        if (nums.length > 0) {
            // Generate a random index within the bounds of the array
            int randomIndex = indexGen.nextInt(nums.length);

            // Print the index and the value at that index
            System.out.println("Random index generated: " + randomIndex);
            System.out.println("Value at that index: " + nums[randomIndex]);
        } else {
            System.out.println("No valid integers were entered.");
        }

        // Close the scanner
        scan.close();
    }
}
