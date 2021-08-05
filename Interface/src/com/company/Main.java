package com.company;

public class Main {

    public static void main(String[] args) {
        ITelephone myPhone;      //We cannot have ITelephone deskPhone = new ITelephone(); We cannot instantiate
                                 // it using ITelephone class. We have to use an actual class that have overriden
                                //that functionality.
        myPhone = new DeskPhone();         //Check Polymorphism project. A similar way was used to create objects
        myPhone.dial(123321);  //Over there instead of an interface, inheritance class was used for the
        System.out.println(myPhone.isRinging(123321));//variable defining class, e.g ITelephone deskPhone
        myPhone.powerOn();

        myPhone = new MobilePhone(); //The only reason we can do it this ways is because myPhone is declared as
                                    //an a variable of ITelephone class. So we can create a different instance
                                    //using the same variable name as it was declared as a variable of ITelephone
                                   //class from which DeskPhone & MobilePhone 'implement'
        myPhone.powerOn();           //This is method is called so as to set the field variable 'isON' in
        myPhone.dial(123123); //MobilePhone class to true. The below methods depend on the field 'isOn'
        System.out.println(myPhone.isRinging(123123));//so it is must to call that method first.
    }
}
