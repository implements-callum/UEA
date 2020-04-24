/*

By: Callum Clegg [100279967]
Last updated: 17/01/2020

 */

package com.CMP_4008Y;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StockProgram {

    public static void main(String[] args) throws FileNotFoundException {
        // Calling 'stockItems()' method to be compiled.
        stockItems();
    }

    private static void stockItems() throws FileNotFoundException {

        // Generate a new instance of class 'inventory'.
        Inventory inventory = new Inventory();

        // Assign 'inventory.txt' to File dataType.
        File inventoryContent = new File("inventory.txt");

        // Create new scanner object to receive input from .txt file above.
        Scanner scan = new Scanner(inventoryContent);

        /*
        While scan object contains a line,
        declare line as String dataType
        and then split line into String[] with regex ', '.
        Create a new instance of class StockItem (called 'item')
        and use data stored in 'fields' to produce instance.
        Add 'item' (object) to the generated inventory class instance.
        Repeat process till all 'items' are stored in a list.
        */
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] fields = line.split(", ");
            StockItem item  = new StockItem(fields);
            inventory.list.add(item);
        }

        // Print out all StockItems in inventory incrementally.
        System.out.println("Inventory:");
        System.out.println(String.format(
                "%-15s %-15s %-15s %-15s %-15s", "Name", "Code",
                "Quantity", "Price", "Description"
        ));

        for (int i = 0; i < inventory.size(); i++)
            System.out.println(inventory.get(i));
        System.out.println("\n");

        // Calling methods in 'inventory.java' to answer queries.
        System.out.println(inventory.resistanceSum(inventory) + " \u2126 (Ohms) \n\n");
        System.out.println(inventory.queryPrice(10, inventory) + "\n");
        System.out.println(inventory.npnTransistors(inventory));
        inventory.sortByPrice();
        System.out.println(inventory + "\n");
        System.out.println(inventory.biggestQuantity(inventory));
    }
}