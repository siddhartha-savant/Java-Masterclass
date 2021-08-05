package com.company;

public class Main {

    public static void main(String[] args) {
	Tata indica = new Tata(120,5,true,true);

	    //If we don't want the value of speed as 120 during initialization for the instance of class Tata, we can
        // instead initialize the value to 0 or any other value you want instead of 120 in the Tata class constructor.

        //Also if we want some values fixed, it is best not to write a constructor of those values.
        //Consider in this case currentDirection and currentVelocity. Both of them are initialized to 0 in the parent
        //class and not included in the constructor. However, we can still call them in child class instances.
        //This can be done not to alter the instance values of the parent class so that the value is same for all
        //classes throughout.

        System.out.println(indica.getSpeed());
        System.out.println(indica.isBulletProofGlass());
        System.out.println(indica.getChangingGears());
        System.out.println(indica.isHandSteering());
        indica.setSpeed(110);
        indica.setCurrentDirection(100);
        System.out.println(indica.getCurrentDirection());

    }
}
