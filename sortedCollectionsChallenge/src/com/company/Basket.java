package com.company;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public int addToBasket(StockItem item, int quantity){
        if((item!=null) && (quantity>0)){
            int inBasket = list.getOrDefault(item,0);
            list.put(item,inBasket + quantity);
            return inBasket;

            //The int inBasket will give value 0 or the already existing value. So the value of inBasket + quantity
            //will be only quantity if the item to be added is new or it will be inBasket + quantity i.e. the updated
            //value of the existing item
        }
        return 0;
    }

    public int removeFromBasket(StockItem item, int quantity){
        if((item!=null) && (quantity>0)){
            //check if we have that item in basket
            int inBasket = list.getOrDefault(item,0);
            //We used .getOrDefault because we want it to return the quantity of existing item or we wanted it to
            //return 0
            int newQuantity = inBasket - quantity;
            if(newQuantity>0){
                list.put(item,newQuantity);
                return quantity;
            }else if(newQuantity==0){   //This is when we have no quantity for the item. The quantity is subtracted to 0
                list.remove(item);
                return quantity;
            }
        }
        return 0;
    }

    public void clearBasket(){
        this.list.clear();
    }

    public Map<StockItem, Integer> Items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + list.size() + ((list.size()==1) ? " item " : " items") + "\n";
        double totalCost = 0.0;
        for(Map.Entry<StockItem,Integer> item:list.entrySet()){
            s = s + item.getKey() + ", " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost " + totalCost;
    }

    //The item.getKey() method calls the toString of the Key which is StockItem.
}
