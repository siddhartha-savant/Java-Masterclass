package com.company;

public class Vehicle {
    private double speed;
    private int changingGears;
    private int currentVelocity;
    private int currentDirection;

    public Vehicle(double speed, int changingGears){
        this.currentDirection=0;
        this.currentVelocity=0;
       this.speed=speed;                     //Constructors can also be created by not using the 'this' keyword
        this.changingGears=changingGears;   //For that the parameters of the constructor must be different
    }                                       //therefore public Vehicle(double speed1, int changingGears1)
                                           //speed=speed1;    changingGears=changingGears1;
    public double getSpeed() {
        return speed;
    }

    public int getChangingGears() {
        return changingGears;
    }

    public void setSpeed(double speed){
        this.speed=speed;
    }

    public void setCurrentVelocity(int currentVelocity) {
        this.currentVelocity = currentVelocity;
    }

    public void setCurrentDirection(int currentDirection) {
        this.currentDirection = currentDirection;
    }

    public int getCurrentVelocity() {
        return currentVelocity;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }
}
