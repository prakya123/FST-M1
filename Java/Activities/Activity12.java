// Step 1: Define the functional interface
@FunctionalInterface
interface Addable {
    int add(int num1, int num2);
}

// Step 2: Create the main class
public class Activity12 {
    public static void main(String[] args) {
        
        // Lambda expression without a body (expression only)
        Addable ad1 = (num1, num2) -> num1 + num2;

        // Lambda expression with a body (using return and braces)
        Addable ad2 = (num1, num2) -> {
            int result = num1 + num2;
            return result;
        };

        // Testing both lambdas
        System.out.println("Result from ad1: " + ad1.add(10, 20));  // Output: 30
        System.out.println("Result from ad2: " + ad2.add(15, 25));  // Output: 40
    }
}
