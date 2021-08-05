package com.company;

public class Car extends Vehicle {
    private boolean handSteering;

    public boolean isHandSteering() {
        return handSteering;
    }

    public Car(double speed, int changingGear, boolean handSteering){ //While calling constructor of parent class
        super(speed, changingGear);                          //We can use different parameter names altogether
                this.handSteering=handSteering;     //public Car(double speed2, int changingGear2, boolean handSteering)
                                                   // super(speed2, changingGear2);     this.handSteering=handSteering;






    }
}
