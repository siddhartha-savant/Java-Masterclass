package com.company;

public class DeskPhone implements ITelephone {   //If we are implementing an interface we have to use all the
    public void powerOn(){                       //methods defined in that interface
        System.out.println("The power is on!");
    }

    @Override
    public void dial(int phoneNumber) {
        if(phoneNumber==123321)
            System.out.println("Your number was dialed");
    }

    @Override
    public boolean isRinging(int phoneNumber) {
        return phoneNumber == 123321;
    }
}
