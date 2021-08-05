package com.company;

public class Tata extends Car{
    private boolean bulletProofGlass;

    public boolean isBulletProofGlass() {
        return bulletProofGlass;
    }

    @Override
    public double getSpeed() {
        if(super.getSpeed()>100) {   //Here you cannot write if(getSpeed()>100)   return 0;  This is because then it
            return 50;                //will be a recursive call. Therefore if(super.getSpeed()>100) is used.
        }else{                        //This won't be the actual value of field speed. Therefore it is better not
            return super.getSpeed();  //to change anything in the overridden getter. It is better not to override
        }                            //getter altogether. We can instead override setter values as shown below.
    }

    @Override
    public void setSpeed(double speed) {
        if(speed>100){
            super.setSpeed(50);
            System.out.println(super.getSpeed());
        }
        super.setSpeed(speed);
    }

    public Tata(double speed, int changingGear, boolean handSteering, boolean bulletProofGlass) {
        super(speed, changingGear, handSteering);
        this.bulletProofGlass = bulletProofGlass;

        //As commented in main we can write super(0, changingGear, handSteering) thereby initializing the speed value
        //to any value which we want
    }
}
