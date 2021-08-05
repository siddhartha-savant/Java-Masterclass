package com.company;

public class Main {

    public static void main(String[] args) {
        HealthyBurger healthyBurger = new HealthyBurger("chicken",true,false);
        System.out.println(healthyBurger.getPrice());
        System.out.println("Your base price is " + healthyBurger.basePrice());
        healthyBurger.additionalItems(true,false,true,true);
        System.out.println("Your total price is " + healthyBurger.getPrice());

        System.out.println("");

        DeluxeHamburger deluxeHamburger = new DeluxeHamburger("White Bread","Beef","lays","pEPsi");
        System.out.println("Your base price is " + deluxeHamburger.basePrice());
        deluxeHamburger.additionalItems();
        deluxeHamburger.additionalItems(true,true,true,false); //Check comment in DeluxeHamburger class
        System.out.println("Your total price is " + deluxeHamburger.getPrice());

        System.out.println("");

        Hamburger hamburger = new Hamburger("WHITE BREAD","PoRk");
        System.out.println("Your base price is " + hamburger.basePrice());
        hamburger.additionalItems(true,true,true,true);
        System.out.println("Your total price is " + hamburger.getPrice());

    }
}
