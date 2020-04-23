package com.Greedy;

import java.util.ArrayList;

public class Customer {

    protected final String userID;
    protected String name;
    protected String age;
    protected String balance;
    protected String personalDiscount;
    protected Double temp;


    // Defines 'Customer' object. Used ArrayList as size of Customer does change.
    Customer(ArrayList<String> line) {
        userID = line.get(0);
        name = line.get(1);
        age = line.get(2);
        balance = line.get(3);
        if (line.size() > 4)
            personalDiscount = line.get(4);
        else
            personalDiscount = null;
    }

    // Accessors
    public int getUserID() { return Integer.parseInt(userID); }
    public String getName() { return name; }
    public int getAge() { return Integer.parseInt(age); }
    public double getBalance() { return Double.parseDouble(balance); }
    public String getPersonalDiscount() { return personalDiscount; }

    // Method that adds 'amount' to the customers balance.
    public void addFunds(String amount) {
        double temp = getBalance() + Integer.parseInt(amount);
        balance = String.valueOf(temp);
    }

    // Method that reduced balance when using attraction (if customer has enough).
    public void useAttraction(double attractionPrice) throws InsufficientBalanceException {

        double price;

        if (personalDiscount == null) {
            if (getBalance() - attractionPrice < 0) {
                throw new InsufficientBalanceException
                        ("Not enough funds (" + -(getBalance() - attractionPrice) + "p) difference");
            }
            balance = Double.toString(getBalance() - attractionPrice);
            System.out.println(attractionPrice);
            Simulate.accumulate += attractionPrice;

        }
        else {
            switch (personalDiscount) {
                case "FAMILY":
                    price = attractionPrice * 0.85;
                    temp = getBalance() - price;
                    if (temp < 0) {
                        throw new InsufficientBalanceException("Not enough funds (" + -temp + "p) difference");
                    }
                    else {
                        Simulate.accumulate += price;
                        System.out.println(price);
                        balance = temp.toString();
                    }
                    break;

                case "STUDENT":
                    price = attractionPrice * 0.9;
                    temp = getBalance() - price;
                    if (temp < 0) {
                        throw new InsufficientBalanceException("Not enough funds (" + -temp + "p) difference");
                    }
                    else {
                        Simulate.accumulate += price;
                        System.out.println(price);
                        balance = temp.toString();
                    }
                    break;

                default:
                    //balance = Double.toString(getBalance() - attractionPrice);
                    System.out.println("error");
                    break;
            }
        }
    }

    public void useAttraction(double limit, double attractionPrice) throws
            AgeRestrictionException, InsufficientBalanceException {
        if (getAge() < limit) {
            throw new AgeRestrictionException("Sorry, you are not old enough to use this attraction.");
        }
        else
            useAttraction(attractionPrice);
    }

    // Displays Discount information
    protected static String getAvailableDiscountInfo() {
        String infoTit = String.format(
                "%-25s %-25s %-25s", "Family Discount",
                "Student Discount", "Park Employees");
        String info = String.format
                ("%-25s %-25s %-25s", "15% deduction",
                        "10% deduction", "15% deduction");
        return "\n" + infoTit + "\n" + info;
    }

    @Override
    public String toString() {
        String outPut = userID + "#" + name + "#" + age + "#" + balance;
        if (personalDiscount == null || personalDiscount.equals("")) return outPut;
        else outPut = outPut + "#" + personalDiscount;
        return outPut;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(userID);
    }

    /* TEST HARNESS
    public static void main(String[] args) throws InsufficientBalanceException {

        // TEST 1 - Customer object with 5 fields:
        String record = "123456,name,23,54.2,STUDENT";
        ArrayList<String> objectBase = new ArrayList<>(Arrays.asList(record.split(",")));
        Customer test = new Customer(objectBase);
        System.out.println(test);

        // TEST 2 - Customer object with 4 fields:
        String record2 = "654321,name,23,23.1";
        ArrayList<String> objectBase2 = new ArrayList<>(Arrays.asList(record2.split(",")));
        Customer test2 = new Customer(objectBase2);
        System.out.println(test2);

        System.out.println(getAvailableDiscountInfo());

        // WORKS
        test2.useAttraction(4444);
        test.useAttraction(4444);
    }
     */
}
