public class Activity4 {
    public static void main(String[] args) {
        // Initialize an array with random numbers
        int[] numbers = {34, 7, 23, 32, 5, 62};

        // Display the original array
        System.out.println("Before sorting:");
        printArray(numbers);

        // Sort using insertion sort
        insertionSort(numbers);

        // Display the sorted array
        System.out.println("After sorting:");
        printArray(numbers);
    }

    // Insertion sort logic
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;

            // Move elements of array[0..i-1], that are greater than current, to one position ahead
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = current;
        }
    }

    // Utility method to print an array
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
