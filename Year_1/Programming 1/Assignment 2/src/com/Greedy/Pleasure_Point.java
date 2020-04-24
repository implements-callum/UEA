
package com.Greedy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;



class Pleasure_Point {

    // Static data types/structure for referencing in multiple methods.
    private static double totalCap;
    private static int totalDistance;
    private static int countGen = 0;
    private static ArrayList<RollerCoaster> rolList = new ArrayList<>();

    // HashMaps to store multiple customer and attraction objects (separately).
    private static HashMap<Integer, Customer> customers = new HashMap<>();
    private static HashMap<String, Attraction> attractions = new HashMap<>();

    // Constructor automatically creates customers and attractions when Pleasure_Point class is created.
    public Pleasure_Point() throws FileNotFoundException {
        genAttractions();
        genCustomers();
    }

    // Generates customer objects and adds them to the 'customers' HashMap.
    public void genCustomers() throws FileNotFoundException {

        Scanner scannerC = new Scanner(new File("customers.txt"));

        /*
        Loop that scans each line in file, stores as string type,
        then splits string based off regex '#'
        into a string[] type (called "fields").
        With this data, we can create a 'new' instance of
        class Customer (called "cus").
        when then add this to CustomerList class (called "customers").
        Repeats till encounters empty line.
        */

        while (scannerC.hasNextLine()) {
            String record = scannerC.nextLine();
            ArrayList<String> objectCus = new ArrayList<>(Arrays.asList(record.split("#")));
            Customer cus = new Customer(objectCus);
            customers.put(cus.getUserID(), cus);
        }
        for (Integer key : customers.keySet()) {
            System.out.println(customers.get(key));
        }
        System.out.println("\n");
    }

    // Generates attraction objects and adds them to the 'Attractions' HashMap.
    public void genAttractions() throws FileNotFoundException {
        Scanner scannerA = new Scanner(new File("attractions.txt"));

        while(scannerA.hasNextLine()) {

            String record = scannerA.nextLine();
            ArrayList<String> objectBase = new ArrayList<>(Arrays.asList(record.split("@")));
            Attraction a = new Attraction(objectBase) {
                @Override
                double offPeakPrice() { return 0; }

                @Override
                public int getAgeRating() { return 0; }
            };

            // Switch checks what type of attraction it is, then builds object accordingly.
            switch(a.type) {
                case "TRA":
                    ArrayList<String> objectT = new ArrayList<>(Arrays.asList(record.split("@")));
                    TransportAttraction tran = new TransportAttraction(objectT);
                    totalDistance +=  tran.getJourney();
                    attractions.put(tran.name.trim(), tran);
                    break;
                case "GEN":
                    ArrayList<String> objectG = new ArrayList<>(Arrays.asList(record.split("@")));
                    GentleAttraction gen = new GentleAttraction(objectG);
                    totalCap += gen.getCapacity();
                    countGen++;
                    attractions.put(gen.name.trim(), gen);
                    break;
                case "ROL":
                    ArrayList<String> objectR = new ArrayList<>(Arrays.asList(record.split("@")));
                    RollerCoaster rol = new RollerCoaster(objectR);
                    attractions.put(rol.name.trim(), rol);
                    rolList.add(rol);
                break;
                default:
                    System.out.println("Invalid attraction detected!");
                    break;
            }
        }
    }

    // Accessors for HashMap(s).
    public HashMap<Integer, Customer> getCustomerHashMap() {
        return customers;
    }
    public HashMap<String, Attraction> getAttractionHashMap() { return attractions; }

    // Method adds new customer (assuming request in transactions format).
    public void addCustomer(String[] line) {
        ArrayList<String> cus = new ArrayList<>(Arrays.asList(line));
        if (cus.contains("ADD_CUSTOMER")) cus.remove(0);
        Customer newCustomer = new Customer(cus);
        customers.put(newCustomer.getUserID(), newCustomer);
    }

    // Shows result of adding all distances from transport attractions.
    public void calculateTotalTransportDistance() {
        System.out.println("The total transport distance of all transport attractions: " + totalDistance);
    }

    // Shows average amount of seats in a gentle attraction.
    public void calculateAverageGentleCapacity() {
        System.out.println("Average gentle attraction capacity (approx): " + Math.round(totalCap/countGen));
    }

    public void calculateMedianCoasterSpeed() {
        // finds median if number of of roller coasters is odd.
        rolList.sort(RollerCoaster::compareTo);
        if(rolList.size()%2 != 0) {
            System.out.println("The median roller coaster speed: " + rolList.get(rolList.size() / 2).maxMPH);
        }
        // finds median if number of of roller coasters is even.
        else {
            double temp = Math.round(Double.parseDouble(String.valueOf(rolList.size()/2)));
            double median = ((temp - 1) + (temp + 2)) / 2;
            System.out.println(median);
        }
    }

    /* TEST HARNESS
    public static void main(String[] args) throws FileNotFoundException {

        genCustomers();
        genAttractions();
        System.out.println(customers.get(585526));
        System.out.println(attractions.get("Tower of Midnight").getCost());
        String[] line = {"999888", "dave", "45", "65.22", null };
        //AddCustomer(line);
        customers.remove(999888);
        System.out.println(customers.get(999888));

        // RETURN TO STATIC TO USE
        //System.out.println(getCustomerHashMap().get(585526));
        //System.out.println(getAttractionHashMap().get("Tower of Midnight"));

        // MAKE STATIC TO WORK IN THIS MAIN!
        //calculateTotalTransportDistance();
        //calculateAverageGentleCapacity();
        //calculateMedianCoasterSpeed();
    }
    */
}
