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

        temp = new StockItem("Chair", 62.0,10);
        stockList.addStock(temp);

        temp = new StockItem("Cup", 0.50,200);
        stockList.addStock(temp);
        temp = new StockItem("Cup",0.45,7);
        stockList.addStock(temp);

        temp = new StockItem("Door", 72.95,4);
        stockList.addStock(temp);

        temp = new StockItem("Juice", 2.50,36);
        stockList.addStock(temp);

        temp = new StockItem("Phone", 96.99,35);
        stockList.addStock(temp);

        temp = new StockItem("Towel", 2.40,80);
        stockList.addStock(temp);

        temp = new StockItem("Vase", 8.76,40);
        stockList.addStock(temp);

        System.out.println(stockList);

        for(String s: stockList.Items().keySet()){   //This is to print the unmodifiable map stocklist
            System.out.println(s);
        }

        Basket sidsBasket = new Basket("Sid");

        sellItem(sidsBasket,"Car",1);
        System.out.println(sidsBasket);

        sellItem(sidsBasket,"Car",1);
        System.out.println(sidsBasket);

        if(sellItem(sidsBasket,"Car",1)!=1){
            System.out.println("We don't have cars to reserve");
        }
        sellItem(sidsBasket,"Mobile",2);
        //System.out.println(sidsBasket);

        sellItem(sidsBasket,"Juice",4);
        sellItem(sidsBasket,"Cup",12);
        sellItem(sidsBasket,"Bread",1);
        //System.out.println(sidsBasket);

        //System.out.println(stockList);

        Basket basket = new Basket("Customer");
        sellItem(basket,"Cup",100);
        sellItem(basket, "Juice",5);
        removeItem(basket,"Cup",1);
        System.out.println(basket);

        removeItem(sidsBasket,"Car",1);
        removeItem(sidsBasket,"Cup",9);
        removeItem(sidsBasket,"Car",1);
        System.out.println("Cars removed: " + removeItem(sidsBasket,"Car",1)); // should not work

        System.out.println(sidsBasket);

        //Remove items from Sids basket
        removeItem(sidsBasket,"Bread",1);
        removeItem(sidsBasket,"Cup",3);
        removeItem(sidsBasket,"Juice",4);
        removeItem(sidsBasket,"Cup",3);
        System.out.println(sidsBasket);

        System.out.println("\nDisplay stock list before and after checkout");
        System.out.println(basket);
        System.out.println(stockList);
        checkOut(basket);
        System.out.println(basket);
        System.out.println(stockList);

//        temp = new StockItem("Pen",12);                 //Here we are adding an item to the unmodifiable map
//        stockList.Items().put(temp.getName(),temp);     //That's why we get an error
        StockItem car = stockList.Items().get("Car");
        if(car != null){
            car.adjustStock(2000);
        }
        if(car != null){
            car.adjustStock(-1000);
        }
        System.out.println(stockList);

            //Unmodifiable means we can't change Map by adding new items or removing items from the Map.
            //However, that doesn't mean that we can't modify the items itself. As shown above we were able to modify
            //the Car item by adjusting the stock to 2000.
            //Its the collection itself that is unmodifiable and not the objects within it.

//        for(Map.Entry<String,Double> price: stockList.PriceList().entrySet()){
//            System.out.println(price.getKey() + " costs " + price.getValue());

            //To avoid the modification of individual objects in .get and .Item methods, we can instead use the
            //above for loop which calls the PriceList() method from the StockList class.
//        }

        checkOut(sidsBasket);
        System.out.println(sidsBasket);
    }

    public static int sellItem(Basket basket, String item, int quantity){
        //This method is used to reduce the quantity from the StockList and add the item and the quantity to the
        //basket. We retrieve the item from the stock list first
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(stockList.reserveStock(item,quantity)!=0){  //This reserveStock method not only reserves the quantity from stock
            return basket.addToBasket(stockItem,quantity); //but also helps in checking the if condition
        }
        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity){
        //This method is used to remove the quantity from the Basket and also call the unreservedStock method
        //to subtract the quantity from the reserved field. We retrieve the item from the stock list first
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(basket.removeFromBasket(stockItem,quantity)==quantity){  //When we don't want it in our basket, we will
            return stockList.unreservedStock(item,quantity);  //remove it, and call the unreserved method
        }
        return 0;
    }

    public static void checkOut(Basket basket){
        //This method is used when the customer finally decides to checkOut the basket i.e. when he buys the
        //items of the basket. As a result, we need to call the sellStock method over here
        //It loops through all the items of the basket using the unmodifiable Map that is returned from the
        //Items() method in Basket Class. Each item from this method then calls the sellStock method of the
        //StockList class and once they are all being sold, it clears the basket.

        for(Map.Entry<StockItem,Integer> items : basket.Items().entrySet()){
            stockList.sellStock(items.getKey().getName(),items.getValue());
        }
        basket.clearBasket();
    }
}
