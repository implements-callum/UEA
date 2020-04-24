
package com.Greedy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 BY: CALLUM CLEGG [100279967]

 Data-Structures:
 I decided to make my customer and attraction constructors store data in an ArrayList.
 I felt this was justified as the number of fields varied depending on the type of
 customer or attraction subclass.

 Furthermore, I used hash-maps to store my all customers and all attractions because it is
 capable of faster element access, I can also use hash keys which fits well with unique
 fields provided (i.e. 'userID' is always unique in-addition to attraction names [viable primary key]).

 Testing:
 I have included the txt files I used to test different types of customers/attractions.
 The customers and attractions I used were pre-existing, meaning I could use the original
 'transactions.txt' in order to test if my classes were performing as expected.

 All classes (except those that extend 'exception' or Simulate), have a 'TEST HARNESS' located
 at the bottom of each class. Redundant imports are present due to their need when 'TEST HARNESS'
 is un-commented.

 LAST UPDATED: 08/04/2020
 */

class Simulate {

    // Single double variable that 'accumulates' profit from useAttraction method.
    static double accumulate;

    public static void main(String[] args) throws FileNotFoundException {
        Simulate assignment = new Simulate();
        System.out.println(assignment);
    }

    Simulate() throws FileNotFoundException {

        Pleasure_Point pleasurePoint = new Pleasure_Point(); // Create instance of Pleasure_Point object.
        Scanner transactions = new Scanner(new File("transactions.txt"));

        while (transactions.hasNextLine()) {

            //Break down each line of the transactions file into a number of fields.
            String record = transactions.nextLine();
            String[] fields = record.split(",");

            // Switch checks what type of transaction the line is, acts accordingly (based off index 0).
            switch (fields[0]) {

                case "USE_ATTRACTION":

                    String name = fields[3].trim();

                    double price = pleasurePoint.getAttractionHashMap().get(name).getCost();
                    double priceOffPeak = pleasurePoint.getAttractionHashMap().get(name).offPeakPrice();

                    // Required age for ride (only relevant to roller coasters).
                    int age = pleasurePoint.getAttractionHashMap().get(fields[3]).getAgeRating();

                    // Try catch to see if user has enough in balance to pay for ride referenced in index 3.
                    try {
                        if (pleasurePoint.getAttractionHashMap().get(fields[3]).type.equals("ROL")) {

                            if (fields[1].equals("STANDARD_PRICE")) {
                                System.out.println(pleasurePoint.getCustomerHashMap().
                                        get(Integer.parseInt(fields[2])));
                                pleasurePoint.getCustomerHashMap().
                                        get(Integer.parseInt(fields[2])).useAttraction(age, price);
                                System.out.println(pleasurePoint.getCustomerHashMap().
                                        get(Integer.parseInt(fields[2])) + "\n");
                            } else if (fields[1].equals("OFF_PEAK")) {
                                System.out.println(pleasurePoint.getCustomerHashMap().
                                        get(Integer.parseInt(fields[2])));

                                pleasurePoint.getCustomerHashMap().
                                        get(Integer.parseInt(fields[2])).useAttraction(age, priceOffPeak);
                                System.out.println(pleasurePoint.getCustomerHashMap().
                                        get(Integer.parseInt(fields[2])) + "\n");
                            } else {
                                System.out.println("ERROR: OFF_PEAK or STANDARD_PRICE not found!");
                                System.out.println(pleasurePoint.getCustomerHashMap().
                                        get(Integer.parseInt(fields[2])));
                                break;
                            }
                        }
                    } catch (InsufficientBalanceException | AgeRestrictionException e) {
                        System.out.println(e.toString() + " -> " + fields[2] + "\n");
                    }

                    try {
                        if (!pleasurePoint.getAttractionHashMap().get(fields[3]).type.equals("ROL")) {

                            if (fields[1].equals("STANDARD_PRICE")) {
                                System.out.println(pleasurePoint.getCustomerHashMap().
                                        get(Integer.parseInt(fields[2])));
                                pleasurePoint.getCustomerHashMap().get(Integer.parseInt(fields[2])).
                                        useAttraction(Double.parseDouble(String.valueOf(price)));
                                System.out.println(pleasurePoint.getCustomerHashMap().
                                        get(Integer.parseInt(fields[2])) + "\n");
                            } else if (fields[1].equals("OFF_PEAK")) {
                                System.out.println(pleasurePoint.getCustomerHashMap().
                                        get(Integer.parseInt(fields[2])));
                                pleasurePoint.getCustomerHashMap().
                                        get(Integer.parseInt(fields[2])).useAttraction(priceOffPeak);
                                System.out.println(pleasurePoint.getCustomerHashMap().
                                        get(Integer.parseInt(fields[2])) + "\n");
                            } else {
                                System.out.println("ERROR: OFF_PEAK or STANDARD_PRICE not found!");
                                System.out.println(pleasurePoint.getCustomerHashMap().
                                        get(Integer.parseInt(fields[2])) + "\n");
                                break;
                            }
                        }
                    } catch (InsufficientBalanceException e) {
                        System.out.println(e.toString() + " -> " + fields[2] + "\n");
                    }

                    break;

                case "NEW_CUSTOMER":
                    fields = Arrays.copyOfRange(fields, 1, fields.length);
                    pleasurePoint.addCustomer(fields);
                    System.out.println("NEW CUSTOMER: " + pleasurePoint.getCustomerHashMap().
                            get(Integer.parseInt(fields[0])) + "\n");
                    break;
                case "ADD_FUNDS":
                    System.out.println("Before: " + pleasurePoint.getCustomerHashMap().
                            get(Integer.parseInt(fields[1])));

                    System.out.println(fields[2] + "+");

                    pleasurePoint.getCustomerHashMap().get(Integer.parseInt(fields[1])).addFunds(fields[2]);

                    System.out.println("After: " + pleasurePoint.getCustomerHashMap().
                            get(Integer.parseInt(fields[1])) + "\n");
                    break;

                default:
                    System.out.println("ERROR");
            }
        }

        System.out.println("\n");

        pleasurePoint.calculateAverageGentleCapacity();
        pleasurePoint.calculateMedianCoasterSpeed();
        pleasurePoint.calculateTotalTransportDistance();
        System.out.println(Customer.getAvailableDiscountInfo());
        System.out.println("Total profit: " + accumulate);
    }
    @Override
    public String toString() { return ""; }
}

