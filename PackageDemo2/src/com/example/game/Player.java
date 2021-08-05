package com.example.game;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable{
    private String name;
    private int health;
    private String typeOfCharacter;

    public Player(String name, int health, String typeOfCharacter) {
        this.name = name;
        this.health = health;
        this.typeOfCharacter = typeOfCharacter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getTypeOfCharacter() {
        return typeOfCharacter;
    }

    public void setTypeOfCharacter(String typeOfCharacter) {
        this.typeOfCharacter = typeOfCharacter;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", typeOfCharacter='" + typeOfCharacter + '\'' +
                '}';
    }

    @Override
    public List<String> write() {
        List<String> stringList = new ArrayList<String>();
        stringList.add(0, this.name);
        stringList.add(1,""+this.health);   //One way of converting int into string
        stringList.add(2, this.typeOfCharacter);
        return stringList;
    }

    @Override
    public void read(List<String> savedValues) {
        if(savedValues != null && savedValues.size()>0){
//            System.out.println("The list is empty");               //This code is for printing, However in the
//        }else {                                                     challenge reading was required instead of
//            for (String savedValue : savedValues) {                 printing
//                System.out.println(savedValue);
//            }
            this.name = savedValues.get(0);
            this.health = Integer.parseInt(savedValues.get(1));
            this.typeOfCharacter = savedValues.get(2);
        }
    }
}
