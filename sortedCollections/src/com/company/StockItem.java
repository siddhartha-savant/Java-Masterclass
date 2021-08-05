package com.company;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityStock;    //private int quantityStock =0 ; -->can be initialized later in constructor

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock=0;      //or here, but you wouldn't normally initialize it at both places.
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStock;
    }

    public void setPrice(double price) {
        if (price > 0.0) {
            this.price = price;
        }
    }

    public void adjustStock(int quantity){
        int newQuantity = this.quantityStock + quantity;
        if(newQuantity >=0){
            this.quantityStock = newQuantity;
        }
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItems.equals()");

        if(this==obj){
            return true;
        }

        if((obj==null) || (obj.getClass()!=this.getClass())){
            return false;
        }

        String objName = ((StockItem) obj).getName();
        return this.getName().equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem o) {
        System.out.println("Entering StockItem.compareTo");
        if(this == o){
            return 0;
        }

        if(o!=null){
        return this.name.compareTo(o.getName());
        }
        throw new NullPointerException();      //This is to assure, that if we are using compareTo method, we are not
    }                                           //comparing something to null

    @Override
    public String toString() {
        return this.name + " : price " + this.price;
    }

    //Now we will be creating a StockList class. Map will be used to store the StockItems objects. As we can see
    //the .equals() and .hashCode() methods are using the name of the StockItem class to decide whether two objects
    //are equal or not, therefore we can use the name field as the key of the Map.

    //Note: In the previous project (SetChallenge), we similarly used a user defined Key class as the key for
    //the Map solarSystem. That same Key class was used in the overridden .equals() and .hashCode() methods of
    //HeavenlyBody Class. So in short, the parameter on which we are going to decide whether two objects are equal or
    //not, should be used as the key for the Map. (so that the Map has unique keys)
    //Same mechanism should be followed for a Set. (so that Set has unique elements)
}

