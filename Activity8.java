public class Activity8 {

    // Method that throws CustomException if value is null
    public static void exceptionTest(String value) throws CustomException {
        if (value == null) {
            throw new CustomException("Error: The input string is null!");
        } else {
            System.out.println("Input string: " + value);
        }
    }

    public static void main(String[] args) {
        // Test with a non-null string
        try {
            exceptionTest("This is a valid string.");
        } catch (CustomException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // Test with a null string
        try {
            exceptionTest(null);
        } catch (CustomException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}