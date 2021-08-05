package com.company;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contacts> contacts = new ArrayList<Contacts>();


    private Contacts setContacts(String name, String number) { //Can't justify how important this statement is.
        Contacts contactsMain = new Contacts(name, number);
        return contactsMain;                     //Can also be written as return new Contacts(name,number)
    }

    //Instead of above method, what we could have done is created a similar method in Contacts class
    //returning Contact. We would make it public static so that it is available elsewhere.
    //eg:
    //  public static Contacts createContact(String name, String number){
    //  return new Contacts(name, number);
    //
    //After doing this we could then have every other method in this class to have parameter Contact.
    //eg:
    //  public void storeContact(Contacts contact){
    //  contacts.add(contact);
    //}
    //  public void modifyContact(Contacts oldContact, Contacts newContact){
    //  ...}


    public void storeContact(String name, String number){
        contacts.add(setContacts(name,number));  //could have done with contact.add(new Contacts(name,number))
        System.out.println("Contact is stored");
    }
    public void printContact(){
        for(int i=0;i<contacts.size();i++){
            System.out.println("Contact name: " + contacts.get(i).getName() +
                    " Phone number: " + contacts.get(i).getPhoneNumber());
        }
    }

    public void modifyContact(String name, String newName, String newNumber){
        if(contactFinder(name)>=0){
            System.out.println("The contact is present");
            contacts.set(contactFinder(name),setContacts(newName,newNumber));
            System.out.println("The contact is modified");
        }
        else{
            System.out.println("The contact is not present");
        }
    }
    public void removeContact(String name){
        if(contactFinder(name)>=0){
            System.out.println("The contact is present");
            contacts.remove(contactFinder(name));
            System.out.println("The contact is removed");
        }else{
            System.out.println("Contact not present");
        }
    }

//    public int contactFinder(String name, String number){
//        int index = contacts.indexOf(setContacts(name,number));
//        if(index>=0){
//            return index;
//        }else{
//            return -1;
//        }
//    }
    public int contactFinder(String name){
        for(int i=0;i<contacts.size();i++){
            if(contacts.get(i).getName().equals(name)){
                //System.out.println("The contact is present");
                return i;
            }
        }
        //System.out.println("The contact is not present");
        return -1;
    }
}
