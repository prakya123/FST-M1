
public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        // Initialize the array
        int[] numbers = {10, 77, 10, 54, -11, 10};

        // Target number to sum
        int target = 10;
        // Expected total
        int expectedSum = 30;

        // Call the method and print the result
        System.out.println(checkSum(numbers, target, expectedSum));
    }

    // Method to check if the sum of all 10's equals 30
    public static boolean checkSum(int[] numbers, int target, int expectedSum) {
        int sum = 0;

        for (int num : numbers) {
            if (num == target) {
                sum += num;
            }
        }

        // Return true if sum equals expected
        return sum == expectedSum;
    }
}