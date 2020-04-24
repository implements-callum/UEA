package com.Greedy;

// Unused imports are required for test harness.
import java.util.ArrayList;

abstract class Attraction {

    // Final as we don't want the name to ever change (HashMap depends on name as primary key).
    protected final String name;
    protected String baseCost;
    protected final String type;

    Attraction(ArrayList<String> line) {
        name = line.get(0);
        baseCost = line.get(1);
        type = line.get(2);
    }

    //Defining abstract methods
    abstract double offPeakPrice();
    abstract int getAgeRating();

    // Accessor that retrieves name of any attraction. Not used (yet), but maybe useful later on.
    public String getName() { return name; }

    // parse cost as double here as this is optimal (runtime).
    public int getCost() { return Integer.parseInt(baseCost); }

    public String toString() { return name + "@" + baseCost + "@" + type; }

    /* TEST HARNESS
    public static void main(String[] args) throws FileNotFoundException, InsufficientBalanceException, AgeRestrictionException {
        String x = "name@250@type";
        ArrayList<String> y = new ArrayList<>(Arrays.asList(x.split("@")));
        Attraction test = new Attraction(y) {
                @Override
                double offPeakPrice() { return 0; }

                @Override
                public int getAgeRating() { return 0; }
            };
        // TESTS
        System.out.println(test);
        System.out.println(test.getCost());
        System.out.println(test.getName());
        System.out.println(test.getAgeRating());
        System.out.println(test.offPeakPrice());
    }
     */
}

