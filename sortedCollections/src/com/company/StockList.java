package com.company;

import java.util.*;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new TreeMap<>();
    }

    public int addStock(StockItem item){
        if(item!=null){
            //Check if already have quantities of this item, so we use the getOrDefault method
            StockItem inStock = list.getOrDefault(item.getName(),item);
            //The getOrDefault will get the item if it exists in the Map, or it will return the default value i.e.
            //the item which is passed in the method (StockItem item). It will check the key (i.e. the name of item)
            //to decide whether this item already present or not.

            //If there are already stocks of this item, adjust the quantity. Below condition checks whether the
            //item is new or is in stock.
            //The below condition will not satisfy only when the two objects are equal to each other
            // And when will inStock == item, when the .getOrDefault will give us the default value (i.e. the new value
            //passed to the method and not the existing one). So when a new object (item) is to be added to the Map (list)
            //the below condition will not be satisfied. However, for an existing item, the below condition will be satisfied
            //even if both the items have same values for StockItem (name, price, quantityStock). This is because they both
            //are different objects at different memory locations
            if(inStock!=item){
                inStock.adjustStock(item.quantityInStock());
            }
            list.put(inStock.getName(),inStock);
            return inStock.quantityInStock();
        }
        return 0;
    }

    public int sellStock(String item, int quantity){
        StockItem inStock = list.getOrDefault(item,null);
        //This will check for the item in the list. As we are selling stock, the item has to exist in the list.
        //As mentioned in the commented section above, the name of the item is used to check whether an item of the
        //same name already exists in the list or not. Therefore, even if we give the defaultValue = "null" it won't
        //make a difference.

        if((inStock!=null) && (inStock.quantityInStock() >= quantity) && (quantity>0)){
            inStock.adjustStock(-quantity);
            return quantity;
        }
        return 0;
    }

    public StockItem get(String item){
        return list.get(item);
    }

    public Map<String,Double> PriceList(){
        Map<String, Double> prices = new LinkedHashMap<>();
        for(Map.Entry<String, StockItem> item : list.entrySet()){
            prices.put(item.getKey(),item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);  //this method is used to return read only version of the map so that
    }                                               //they are unmodifiable

    public Map<String, StockItem> Items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for(Map.Entry<String,StockItem> items: list.entrySet()){
            StockItem stockItem = items.getValue();

            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();

            s = s + stockItem + ". There are " + stockItem.quantityInStock() + " in stock. Value of items: ";
            s = s + String.format("%.2f",itemValue) + "\n";
            totalCost += itemValue;
        }
        return s + "Total stock value " + totalCost;
    }
}
