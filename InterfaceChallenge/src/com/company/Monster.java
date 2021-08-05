package com.company;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable{
    private String name;
    private int health;

    public Monster(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", health=" + health +
                '}';
    }

    @Override
    public List<String> write() {
        List<String> stringList = new ArrayList<String>();
        stringList.add(0, this.name);
        stringList.add(1,""+this.health);
        return stringList;
    }

    @Override
    public void read(List<String> savedValues) {
        if(savedValues != null && savedValues.size()>0){
            this.name = savedValues.get(0);
            this.health = Integer.parseInt(savedValues.get(1));
        }
    }
}

