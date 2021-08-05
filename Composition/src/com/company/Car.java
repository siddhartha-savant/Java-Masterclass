package com.company;

public class Car extends Vehicle {
    private int doors;
    private int numberOfWheels;

    public Car(String name, int doors, int numberOfWheels) {
        super(name);
        this.doors = doors;
        this.numberOfWheels = numberOfWheels;
    }
}
