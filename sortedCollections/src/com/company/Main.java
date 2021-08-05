package com.company;

import java.util.Map;

public class Main {
private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("Bread",0.86,100);
        stockList.addStock(temp);

        temp = new StockItem("Cake", 1.10,7);
        stockList.addStock(temp);

        temp = new StockItem("Car", 12.50,2);
        stockList.addStock(temp);

        temp = new StockItem("Chair", 0.50,10);
        stockList.addStock(temp);

        temp = new StockItem("Cup", 0.99,55);
        stockList.addStock(temp);
        temp = new StockItem("Cup",0.45,7);
        stockList.addStock(temp);

        temp = new StockItem("Table", 19.99,22);
        stockList.addStock(temp);

        temp = new StockItem("Door", 10.99,15);
        stockList.addStock(temp);

        temp = new StockItem("Book", 0.50,50);
        stockList.addStock(temp);

        temp = new StockItem("Computer", 250,20);
        stockList.addStock(temp);

        System.out.println(stockList);

        for(String s: stockList.Items().keySet()){   //This is to print the unmodifiable map stocklist
            System.out.println(s);
        }

        Basket sidsBasket = new Basket("Sid");
        sellItem(sidsBasket,"Computer",2);
        System.out.println(sidsBasket);

        sellItem(sidsBasket,"Car",1);
        System.out.println(sidsBasket);

        sellItem(sidsBasket,"Car",1);
        sellItem(sidsBasket,"Mobile",2);
        System.out.println(sidsBasket);

        sellItem(sidsBasket,"Chair",5);
        sellItem(sidsBasket,"Table",4);
        sellItem(sidsBasket,"Cup",20);
        sellItem(sidsBasket,"Book",10);
        System.out.println(sidsBasket);

        System.out.println(stockList);

//        temp = new StockItem("Pen",12);                 //Here we are adding an item to the unmodifiable map
//        stockList.Items().put(temp.getName(),temp);     //That's why we get an error
        stockList.Items().get("Car").adjustStock(2000);
        stockList.get("Car").adjustStock(2000);
        System.out.println(stockList);

            //Unmodifiable means we can't change Map by adding new items or removing items from the Map.
            //However, that doesn't mean that we can't modify the items itself. As shown above we were able to modify
            //the Car item by adjusting the stock to 2000.
            //Its the collection itself that is unmodifiable and not the objects within it.

        for(Map.Entry<String,Double> price: stockList.PriceList().entrySet()){
            System.out.println(price.getKey() + " costs " + price.getValue());

            //To avoid the modification of individual objects in .get and .Item methods, we can instead used the
            //above for loop which calls the PriceList() method from the StockList class.
        }
    }

    public static int sellItem(Basket basket, String item, int quantity){
        //This method is used to reduce the quantity from the StockList and add the item and the quantity to the
        //basket. We retrieve the item from the stock list first
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(stockList.sellStock(item,quantity)!=0){  //This sellStock method not only deducts the quantity from stock
            basket.addToBasket(stockItem,quantity); //but also helps in checking the if condition
            return quantity;
        }
        return 0;
    }
}
