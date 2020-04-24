package com.Greedy;
import java.util.ArrayList;

// GentleAttraction is another subclass of Attraction, therefore, extends Attraction definition as specified
final class GentleAttraction extends Attraction {

    protected String capacity;

    GentleAttraction(ArrayList<String> line) {
        super(line);
        capacity = line.get(3);
    }

    // Return capacity of gentle attraction as an integer.
    public int getCapacity() { return Integer.parseInt(capacity); }

    // Method that returns off peak price of ride.
    @Override
    double offPeakPrice() { return Double.parseDouble(baseCost) * 0.2; }

    @Override
    public String toString() {
        return name + "@" + baseCost + "@" + type + "@" + capacity;
    }

    @Override
    public int getAgeRating() { return 0; }

    /* TEST HARNESS
    public static void main(String[] args) {
        String x = "name@250@type@4";
        ArrayList<String> y = new ArrayList<>(Arrays.asList(x.split("@")));
        GentleAttraction test = new GentleAttraction(y);
        System.out.println(test);
        System.out.println(test.getCapacity());
        System.out.println(test.getAgeRating());
        System.out.println(test.offPeakPrice());
    }
    */
}
