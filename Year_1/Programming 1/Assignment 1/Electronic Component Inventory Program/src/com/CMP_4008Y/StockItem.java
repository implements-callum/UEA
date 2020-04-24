package com.CMP_4008Y;

public class StockItem implements Comparable<StockItem> {

    String name;
    private String code;
    int quantity;
    double price;
    String description;

    // Make public constructor (accessible even in other packages).
    public StockItem(String[] line) {
        name = line[0];
        code = line[1];
        quantity = Integer.parseInt(line[2]);
        if (Double.parseDouble(line[3]) > 0 ) {
            price = Double.parseDouble(line[3]);
        }
        else throw new IllegalArgumentException
                ("price for items cannot be below or equal to zero!");

        // Check if length of array is greater than 4, if so,
        // generate the fifth field to store defined 'description'.
        if (line.length > 4) description = line[4];
    }

    @Override // Over ride toString() in object class and define manually (below).
    public String toString() {
        if (description == null) description = "";
        return String.format(
                "%-15s %-15s %-15s %-15s %-15s",
                name, code, quantity, "£" + price/100, description
        );
    }

    // method compares instance of price with field price in 'stockItem'
    @Override
    public int compareTo(StockItem stockItem) {
        return Double.compare(stockItem.price, this.price);
    }
}