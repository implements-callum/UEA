package com.Greedy;

import java.util.ArrayList;

// RollerCoaster is an extension on what has been defined in Attraction.
final class RollerCoaster extends Attraction implements Comparable<RollerCoaster> {

    // Protected fields for roller coaster.
    protected String age;
    protected String maxMPH;

    // ArrayList to extend definition of subclass.
    RollerCoaster(ArrayList<String> line) {
        super(line);
        age = line.get(3);
        maxMPH = line.get(4);
    }

    // returns double for maximum MPH of roller-coaster.
    public Double getMaxMPH() {
        return Double.parseDouble(maxMPH);
    }

    // offPeakPrice
    @Override
    double offPeakPrice() {
        return Double.parseDouble(baseCost);
    }

    //returns integer of the rides age-rating (e.g. 12).
    @Override
    public int getAgeRating() {
        return Integer.parseInt(age);
    }

    @Override
    public String toString() {
        return name + "@" + baseCost + "@" + type + "@" + age + "@" + maxMPH;
    }

    // Compares previous and current maxMPH to sort into list later (refer to Pleasure_Point class).
    @Override
    public int compareTo(RollerCoaster rollerCoaster) {
        return Double.compare(rollerCoaster.getMaxMPH(), this.getMaxMPH());
    }

    /* TEST HARNESS
    public static void main(String[] args) {
        String x = "name@250@type@20@55.2";
        ArrayList<String> y = new ArrayList<>(Arrays.asList(x.split("@")));
        RollerCoaster test = new RollerCoaster(y);
        System.out.println(test);
        System.out.println(test.getMaxMPH());
        System.out.println(test.offPeakPrice());
        System.out.println(test.getAgeRating());
    }
    */
}
