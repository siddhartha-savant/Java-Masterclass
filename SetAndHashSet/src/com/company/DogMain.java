package com.company;

public class DogMain {
    public static void main(String[] args) {

        Labrador tom = new Labrador("Tom");
        Dog tom2 = new Dog("Tom");

        System.out.println(tom.equals(tom2));   //This will give false because Dog is not an instance of Labrador
        System.out.println(tom2.equals(tom));   //This will give true because Labrador is an instance of Dog which
        // returns the condition true and further type casts it to Dog class and checks whether they are equal.
        //To avoid this we can instead make the equal method in Dog class as final so that it is not overridden.
    }
}