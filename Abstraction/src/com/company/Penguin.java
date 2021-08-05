package com.company;

public class Penguin extends Bird {
    public Penguin(String canHaveDifferentName) {    //the constructor can have different parameter name than the
        super(canHaveDifferentName);                //one mentioned in the inherited class
    }

    @Override
    public void fly() {
        super.fly();
        System.out.println("Can't fly bro, can swim instead");
    }
}

