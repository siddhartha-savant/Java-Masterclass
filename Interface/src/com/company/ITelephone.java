package com.company;

public interface ITelephone {

    void powerOn();                        //All these are signatures
    void dial(int phoneNumber);          //As you can see the modifier public here is redundant. It is better to
    boolean isRinging(int phoneNumber); //remove so that in DeskPhone class we can give these methods any access
                                       // modifiers we want. Also we can't have private modifiers in interface
}
