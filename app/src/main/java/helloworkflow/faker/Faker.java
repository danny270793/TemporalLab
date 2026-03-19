package helloworkflow.faker;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Utility class for generating fake/random data.
 */
public final class Faker {

    private Faker() {
    }

    /**
     * Returns a random integer between min and max (inclusive).
     *
     * @param min the minimum value (inclusive)
     * @param max the maximum value (inclusive)
     * @return a random number between min and max
     */
    public static int numberBetween(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    /**
     * Returns true or false based on the given probability.
     *
     * @param probability a value between 0.0 (always false) and 1.0 (always true)
     * @return true with the given probability, false otherwise
     */
    public static boolean chance(double probability) {
        return ThreadLocalRandom.current().nextDouble() < probability;
    }

    /**
     * Returns true or false with a 50% chance.
     *
     * @return true with a 50% chance, false otherwise
     */
    public static boolean chance() {
        return ThreadLocalRandom.current().nextDouble() < 0.5;
    }
}
