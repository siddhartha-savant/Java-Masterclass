package com.company;

import java.util.ArrayList;

public class Gearbox {
    private ArrayList<Gear> gears;
    private int maxGears;
    private int gearNumber = 0;
    private boolean clutchIsIn;

    public Gearbox(int maxGears) {
        this.maxGears = maxGears;
        this.gears = new ArrayList<Gear>();
        Gear neutral = new Gear(0, 0.0);
        this.gears.add(neutral);

        for(int i=0;i<maxGears;i++){
            addGear(i,i*5.3);
        }
    }

    public void operateClutch(boolean in){
        this.clutchIsIn = in;
    }

    public void addGear(int number, double ratio){
        if((number>0) && (number<=maxGears)){
            this.gears.add(new Gear(number,ratio));
        }
    }

    public void changeGear(int newGear){
        if((newGear>0) && (newGear<=maxGears)){
            this.gearNumber = newGear;
            System.out.println("Gear changed to " + this.gearNumber);
        }else{
            System.out.println("Gear not changed... Grind");
            this.gearNumber=0;
        }
    }

    public double wheelSpeed(int revs){
        if(clutchIsIn){
            System.out.println("Scream!..");
            return 0.0;
        }
        return revs*gears.get(this.gearNumber).getRatio();
    }

    private class Gear{    //This was earlier public. By making it private we completely hide it from public access
        private int gearNumber;  // The fields gearNumber are present in both classes. However, when called for
        private double ratio;   // this.gearNumber in a method in Gear class, the gearNumber field in the Gear
                //class is accessed. For the gearNumber field from Gearbox class Gearbox.this.gearNumber is used.
                //This is the example of non static nested classes --> Inner classes

        public Gear(int gearNumber, double ratio) {
            this.gearNumber = gearNumber;
            this.ratio = ratio;
        }

        public double driveSpeed(int revs){
            return revs*(this.ratio*this.gearNumber*Gearbox.this.gearNumber);
        }

        public int getGearNumber() {
            return gearNumber;
        }

        public double getRatio() {
            return ratio;
        }
    }

}
