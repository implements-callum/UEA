package com.Greedy;

import java.util.ArrayList;

// Subclass of baseclass (Attraction) specific too transportation attractions.
final class TransportAttraction extends Attraction {

    protected String journey;

    TransportAttraction(ArrayList<String> line) {
        super(line);
        journey = line.get(3);
    }

    @Override
    double offPeakPrice() { return Double.parseDouble(baseCost) * 0.5; }

    public String toString() {
        return name + "@" + baseCost + "@" + type + "@" + journey;
    }

    // Double because client may wish for higher degree of accuracy in future.
    public double getJourney() { return Double.parseDouble(journey); }

    @Override
    public int getAgeRating() {
        return 0;
    }

    /* TEST HARNESS
    public static void main(String[] args) {
        String x = "name@250@type@20.3";
        ArrayList<String> y = new ArrayList<>(Arrays.asList(x.split("@")));
        TransportAttraction test = new TransportAttraction(y);
        System.out.println(test);
        System.out.println(test.getJourney());
        System.out.println(test.offPeakPrice());
        System.out.println(test.getAgeRating());
    }
     */
}
