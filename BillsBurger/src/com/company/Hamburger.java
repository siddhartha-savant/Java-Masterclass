package com.company;

public class Hamburger {

    private String breadRollType;
    private String meat;
    private double price;

    public Hamburger(String breadRollType, String meat){
        this.breadRollType = breadRollType;
        this.meat = meat;
    }

    public String getBreadRollType() {
        return breadRollType;
    }

    public String getMeat() {
        return meat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = this.price + price;
    }

    public double basePrice(){
        String breadRollTypeCase = breadRollType.toLowerCase();
        String meatCase = meat.toLowerCase();
        double breadPrice=0;
        double meatPrice=0;
        if(breadRollTypeCase.equals("white bread") || breadRollTypeCase.equals("white rye bread")){
            breadPrice=5;
        }
        if(breadRollTypeCase.equals("brown rye bread")){
            breadPrice=9;
        }
        switch (meatCase) {
            case "chicken":
                meatPrice = 6;
                break;
            case "pork":
                meatPrice = 7;
                break;
            case "beef":
                meatPrice = 8;
                break;
        }
        setPrice(breadPrice+meatPrice);
        return breadPrice+meatPrice;
    }

    public double additionalItems(boolean lettuce, boolean carrot, boolean tomato, boolean cheese){
        double lettucePrice=0;
        double carrotPrice=0;
        double tomatoPrice=0;
        double cheesePrice=0;
        int countOfAdditionalItems=0;
        double additionalTotal;
        if(lettuce){
            lettucePrice=1;
            countOfAdditionalItems++;
        }
        if(carrot){
            carrotPrice=1;
            countOfAdditionalItems++;
        }
        if(tomato){
            tomatoPrice=1;
            countOfAdditionalItems++;
        }
        if(cheese){
            cheesePrice=2;
            countOfAdditionalItems++;
        }
        additionalTotal=lettucePrice+carrotPrice+tomatoPrice+cheesePrice;
        System.out.println("You have additional ordered " + countOfAdditionalItems + " items");
        System.out.println("Your additional items cost: " + additionalTotal);
        setPrice(additionalTotal);
        return additionalTotal;
    }

}
