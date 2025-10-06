
public class Activity3 {
    // Earth year in seconds
    static final double EARTH_YEAR_SECONDS = 31557600;

    public static void main(String[] args) {
        // Given age in seconds
        double ageInSeconds = 1000000000;

        System.out.printf("Age on Earth: %.2f years%n", calculateAge(ageInSeconds, 1.0));
        System.out.printf("Age on Mercury: %.2f years%n", calculateAge(ageInSeconds, 0.2408467));
        System.out.printf("Age on Venus: %.2f years%n", calculateAge(ageInSeconds, 0.61519726));
        System.out.printf("Age on Mars: %.2f years%n", calculateAge(ageInSeconds, 1.8808158));
        System.out.printf("Age on Jupiter: %.2f years%n", calculateAge(ageInSeconds, 11.862615));
        System.out.printf("Age on Saturn: %.2f years%n", calculateAge(ageInSeconds, 29.447498));
        System.out.printf("Age on Uranus: %.2f years%n", calculateAge(ageInSeconds, 84.016846));
        System.out.printf("Age on Neptune: %.2f years%n", calculateAge(ageInSeconds, 164.79132));
    }

    // Method to calculate age on a planet
    public static double calculateAge(double seconds, double orbitalPeriod) {
        double earthYears = seconds / EARTH_YEAR_SECONDS;
        return earthYears / orbitalPeriod;
    }
}
