package com.company;

public class Main {

    public static void main(String[] args) {
        Animal animal = new Animal(10,10,10,10,"Animal");

        Dog dog = new Dog(1,"Doggo",2,4,"Silky","Pitbull","fetch");
        dog.eat();    //This method is inherited from super class.
        animal.print();  //The method print() is declared in both animal and dog classes.
        dog.print();   //If called in main, the method declared in dog class is used and not the method of the
                       // inherited class Animal. It is one type of overriding

        dog.chew();
    }
}
