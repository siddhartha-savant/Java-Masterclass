package com.company;

import java.util.Scanner;

public class Main {
private static Scanner scanner = new Scanner(System.in);
private static Button btnPrint = new Button("Print");
    public static void main(String[] args) {
        Gearbox tata = new Gearbox(5);
//        Gearbox.Gear first = tata.new Gear(1,12.2); //We need to create instance for the inner class
//        System.out.println(first.driveSpeed(500)); //by using the new keyword on the object created for the
                                              //outer class. This is done when the inner class is public

//        tata.addGear(1,5.3);           //This is commented because we have added a for loop in the constructor
//        tata.addGear(2,10.6);         //for adding Gear.
//        tata.addGear(3,15.9);

        tata.operateClutch(true);
        tata.changeGear(1);
        tata.operateClutch(false);
        System.out.println(tata.wheelSpeed(1000));
        tata.changeGear(2);
        System.out.println(tata.wheelSpeed(2000));
        tata.operateClutch(true);
        tata.changeGear(3);
        tata.operateClutch(false);
        System.out.println(tata.wheelSpeed(3000));
        System.out.println("============================");

        class ClickListener implements Button.OnClickListener{
            public ClickListener() {
                System.out.println("I have been attached");
            }

            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }
        }
        btnPrint.setOnClickListener(new ClickListener());   //we are creating a new class of ClickListener. This
        //new class of ClickListener becomes the argument for the method setOnClickListener which has parameter
        //OnClickListener. So the question which may arise here is that, is ClickListener() (argument) of the type
        //OnClickListener (parameter)??
        //The answer is Yes, because OnClickListener(parameter) which is implemented as a field in Button class
        //is actually an Interface. And this Interface is implemented by the local class ClickListener(argument).


        btnPrint.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked baby..");
            }
        });

        //In the above code, we are creating an Anonymous class. Like in local class where we had to create a
        //separate class which was called every time a button was pressed, there would be cases where we want
        //a different method to be returned for different button and not the same as given in the local class
        //For this, Anonymous class is used. They have no name and they are declared and instantiated at the
        //same time.
        listen();
    }
    private static void listen(){
        boolean quit = false;
        while (!quit){
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    quit=true;
                    break;

                case 1:
                    btnPrint.onClick();
                    break;
            }
        }
    }
}
