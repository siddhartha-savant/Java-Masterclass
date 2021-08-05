package com.company;

public class Dog extends Animal{
    private static String game;
    private int eyes;
    private int legs;
    private String coat;
    private String breed;

    public Dog(int weight, String name, int eyes, int legs, String coat, String breed, String game) {
        super(1, 1, 1, weight, name);
        this.eyes=eyes;
        this.legs=legs;
        this.coat=coat;
        this.breed=breed; //This line cannot be written as the below line because breed is non static.
       Dog.game =game; //This is because game is a static variable. We need to initialize it over here


    }
    public void print(){   //When calling this method, the value of brain given in parameter of this class is printed.
        System.out.println(getBrain());//The value of brain passed in the main as parameter is rejected.
        super.print();                //However, if the same method is declared in Animal class, and called in main
        System.out.println(getBrain()); //the value of brain passed in main as parameter is printed.
                                 //It is basically a overridden method. The super.print() calls the superclass method
    }


    public void chew(){
        System.out.println("Chewing");
        System.out.println(getBrain());
        System.out.println(Dog.game);
    }

    @Override
    public void eat() {
        System.out.println("Have to eat..How it is done ?");
        chew();
        //super.eat();
    }
}
