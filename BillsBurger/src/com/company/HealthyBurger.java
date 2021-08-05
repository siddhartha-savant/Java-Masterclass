package com.company;

public class HealthyBurger extends Hamburger{
    private boolean corn;
    private boolean spinach;

    public HealthyBurger(String meat, boolean corn, boolean spinach) {
        super("brown rye bread", meat);
        this.corn = corn;
        this.spinach = spinach;
    }


//    One more way of adding corn and spinach would have been in the basePrice method.
//    1. Override the method.

//    @Override
//    public double basePrice() {
//        return super.basePrice();
//

//    2. Now after the super.basePrice(); write code for corn and spinach.
//    This way there would have been no reason to add them in the additionalItems method and there would have been
//    no reason to override the additionalItems method.

    @Override
    public double additionalItems(boolean lettuce, boolean carrot, boolean tomato, boolean cheese){
        int countOfAdditionalItems=0;
        double lettucePrice=0;
        double carrotPrice=0;
        double tomatoPrice=0;
        double cheesePrice=0;
        double cornPrice=0;
        double spinachPrice=0;
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
        if(corn){
            cornPrice=2;
            countOfAdditionalItems++;
        }
        if(spinach){
            spinachPrice=2;
            countOfAdditionalItems++;
        }
        additionalTotal=lettucePrice+carrotPrice+tomatoPrice+cheesePrice+cornPrice+spinachPrice;
        System.out.println("You have additional ordered " + countOfAdditionalItems + " items");
        System.out.println("Your additional items cost: " + additionalTotal);
        setPrice(additionalTotal);
        return additionalTotal;

    }
}
