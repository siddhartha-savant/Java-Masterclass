package com.timbuchalka;

/**
 * Created by dev on 28/08/15.
 */
public class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Contact createContact(String name, String phoneNumber) {   //As this is a static method, it
        return new Contact(name, phoneNumber);   //could be added anywhere in the program. Also could be in main
    }
}
