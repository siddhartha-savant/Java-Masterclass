package com.company;

public class MobilePhone implements ITelephone {
    private boolean isOn = false;

    @Override
    public void powerOn() {
        isOn = true;
        System.out.println("Mobile Phone powered up");
    }

    @Override
    public void dial(int phoneNumber) {
        if(phoneNumber==123123 && isOn)
            System.out.println("Your number was dialed");
        else
            System.out.println("Phone is switched off or is not available");
    }

    @Override
    public boolean isRinging(int phoneNumber) {
        if (isOn){
            return phoneNumber == 123123;
        }
        return false;
    }
}
