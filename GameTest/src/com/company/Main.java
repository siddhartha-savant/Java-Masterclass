package com.company;

import com.example.game.ISaveable;
import com.example.game.Monster;
import com.example.game.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player sid = new Player("Siddhartha",100,"Human");
        System.out.println(sid.toString());
        sid.setHealth(2000);
        saveObject(sid);
        loadObject(sid);
        System.out.println(sid);  //Instead of .toString, we can just write object name.

        System.out.println("=======================");

        ISaveable werewolf = new Monster("Werewolf",200);
        System.out.println();
        //werewolf.getHealth();   //This line shows error. To show the getter we need to do casting.
                                  //We can also circumvent this prob by changing the type of werewolf object from
                                  //ISaveable to Monster.
        System.out.println(((Monster) werewolf).getHealth());
        saveObject(werewolf);
        loadObject(werewolf);
        System.out.println(werewolf);

    }

    public static ArrayList<String> readValues(){     //This method is just to create data. To create a different
        ArrayList<String> values = new ArrayList<>(); //ArrayList<String> which is then loaded by using the method
        Scanner scanner = new Scanner(System.in);     //mentioned below.
        boolean quit = false;
        int index =0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit){
            System.out.println("Enter an option:");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    quit=true;
                    break;

                case 1:
                    System.out.println("Enter a string");
                    String stringInput = scanner.nextLine();
                    values.add(index,stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(ISaveable objectToSave){  //By passing ISaveable interface as a parameter, we can
        for(int i=0;i<objectToSave.write().size();i++){     //use any object that is using this interface.

            //We can be quite generic. With this we can save any type of class that is implementing this interface.
            //As you can .write() method in interface returns a List<String>. We use that capability to actually then
            //retrieve the particular entries we want and cycle through them all.
            //The parameter objectToSave has to be the object of the class which implements the interface
            //'ISaveable'. It depends on the method which we are calling. We are using the method write(),
            //which has returning datatype List<String>,because of which we are able to write .size(), .get(),etc.

            // write() method is executed --> returns List --> size() of List --> get() of List

            //Let us take an example consider two classes ie. Player class ,Monster class implementing ISaveable.
            //If object of Monster class is created and passed in saveObject method, the (write()) from the
            // Monster class will be called and corresponding changes will take place.
            //In summary: All objects implementing the interface can be passed and processed according to need.

            System.out.println("Saving the object " + objectToSave.write().get(i) + " to storage device");
        }
    }

    public static void loadObject(ISaveable objectToLoad){  //The load method is nothing but to save new values
        ArrayList<String> values = readValues();          //for the fields of the object.
        objectToLoad.read(values);

        //The parameter objectToLoad is using the method read() which is of type void. Over here we are calling the
        //method read() from class Player.
    }


    public static void tempObject(ISaveable objectTemp){
        objectTemp.write();
    }
}
