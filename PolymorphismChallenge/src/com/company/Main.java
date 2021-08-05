package com.company;

class Car{
private boolean engine;
private int cylinders;
private String name;
private int wheels;

    public Car(int cylinders, String name) {
        this.wheels = 4;
        this.engine=true;
        this.cylinders = cylinders;
        this.name = name;
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }
    public boolean startEngine(boolean ignition){
        if(engine && ignition){
            System.out.println("Start the engine");
            return true;
        }else{
            System.out.println("The engine won't start");
            return false;
        }

    }
    public void accelerate(boolean acceleratePedal){
        if(acceleratePedal){
            System.out.println("Accelerating vehicle");
        }else
            System.out.println("Not accelerating vehicle");

    }
    public void brake(){
        System.out.println("Press the brakes");
    }
}
class Mitsubishi extends Car{
    public Mitsubishi(){
        super(5,"Pajero");
    }

    @Override
    public boolean startEngine(boolean ignition) {
        if(ignition){
            System.out.println("Mitsubishi:Start the engine");
            return true;
        }else{
            System.out.println("Mitsubishi:The engine won't start");
            return false;
        }
    }

    @Override
    public void accelerate(boolean acceleratePedal) {
        if(acceleratePedal){
            System.out.println("Accelerating vehicle Pajero");
        }else
            System.out.println("Not accelerating vehicle Pajero");
    }

    @Override
    public void brake() {
        System.out.println("Press the brakes Pajero");
    }
}
class Maruti extends Car{
    public Maruti() {
        super(3, "800");
    }

    @Override
    public void accelerate(boolean acceleratePedal) {
        if(acceleratePedal){
            System.out.println("Accelerating vehicle maruti 800");
        }else
            System.out.println("Not accelerating vehicle maruti 800");
    }

    @Override
    public void brake() {
        System.out.println("Braking maruti 800");
    }
}
class Suzuki extends Car{
    public Suzuki() {
        super(1, "Dzire");
    }

    @Override
    public void brake() {
        System.out.println("Brake the Dzire");
    }
}

public class Main {

    public static void main(String[] args) {

        Mitsubishi car1 = new Mitsubishi();
        car1.accelerate(true);
        car1.brake();
        car1.startEngine(true);

        Maruti car2 = new Maruti();
        car2.startEngine(true);
        car2.accelerate(true);
        car2.brake();

        Suzuki car3 = new Suzuki();
        car3.accelerate(true);
        car3.brake();
        car3.startEngine(true);

        Car car4 = new Maruti();
        System.out.println(car4.getCylinders());
        System.out.println(car4.getName());

        Car car5 = new Mitsubishi();
        System.out.println(car5.getName());
        System.out.println(car5.getCylinders());
    }
}
