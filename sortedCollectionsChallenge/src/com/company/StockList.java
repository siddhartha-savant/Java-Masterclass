package com.company;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
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
            //We have to write the below condition for the passed StockItem item. We cannot write
            //------------>   inStock.adjustStock(item.availableQuantity()).
            // This is because the passed parameter StockItem item might not just have different quantity
            // but also different PRICE... If we write according to the above statement, then we are only changing
            //the quantity of the existing inStock item... We won't be changing the Price.
            //After writing -----> item.adjustStock(inStock.availableQuantity()); we'll create a new item and
            //make adjustments in its quantity accordingly. When this item will be added, it will overwrite the
            //existing inStock item of the same name after the equal() and hashCode() methods are called.
            //(These methods only compare StockItems names)

            if(inStock!=item){
                item.adjustStock(inStock.availableQuantity());
            }
            list.put(item.getName(),item);
            return item.availableQuantity();
        }
        return 0;
    }

    public int sellStock(String item, int quantity){
        StockItem inStock = list.get(item);
        //This will check for the item in the list. As we are selling stock, the item has to exist in the list.
        //We only use .get() which guarantees that we have an item of that name

        if((inStock!=null) && (quantity>0)){
            return inStock.finalizeStock(quantity);
        }
        return 0;
    }

    public int reserveStock(String item, int quantity){
        StockItem inStock = list.get(item);
        if((inStock!=null) && (quantity>0)){
           return inStock.reserveStock(quantity);
        }
        return 0;
    }

    public int unreservedStock(String item, int quantity){
        StockItem inStock = list.get(item);
        if((inStock!=null) && (quantity>0)){
            return inStock.unreservedStock(quantity);
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
        return Collections.unmodifiableMap(prices);
    }

    public Map<String, StockItem> Items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for(Map.Entry<String,StockItem> items: list.entrySet()){
            StockItem stockItem = items.getValue();

            double itemValue = stockItem.getPrice() * stockItem.availableQuantity();

            s = s + stockItem + ". There are " + stockItem.availableQuantity() + " in stock. Value of items: ";
            s = s + String.format("%.2f",itemValue) + "\n";
            totalCost += itemValue;
        }
        return s + "Total stock value " + totalCost;
    }
}
