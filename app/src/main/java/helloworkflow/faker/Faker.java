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
}
