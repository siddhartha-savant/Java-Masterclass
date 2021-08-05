package com.company;

public class DeluxeHamburger extends Hamburger {
    private String chips;
    private String drinks;

    public DeluxeHamburger(String breadRollType, String meat, String chips, String drinks) {
        super(breadRollType, meat);
        this.chips = chips;
        this.drinks = drinks;
    }
    public double additionalItems(){    //Only overloading is done. The problem here is i can still call the
        String chipsCase = chips.toLowerCase();//additionalItems method from the base class. Therefore overriding
        String drinksCase = drinks.toLowerCase();//is the only solution. As shown below, we can override the method
        double chipsPrice=0;                    //and return sout("Cannot add additional..."); return -1;
        double drinksPrice=0;
        double additionalTotal;
        if(chipsCase.equals("lays") || chipsCase.equals("pringles")){
            chipsPrice=5;
        }
        if(drinksCase.equals("pepsi") || drinksCase.equals("sprite")){
            drinksPrice=5;
        }
        additionalTotal=chipsPrice+drinksPrice;
        System.out.println("Your additional items cost: " + additionalTotal);
        setPrice(additionalTotal);
        return additionalTotal;
    }

    @Override
    public double additionalItems(boolean lettuce, boolean carrot, boolean tomato, boolean cheese) {
        System.out.println("Cannot add additional items to deluxe burger");
        return -1;
    }
}
