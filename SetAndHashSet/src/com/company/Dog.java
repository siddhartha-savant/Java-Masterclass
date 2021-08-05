package com.company;

public class Dog {
    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public final boolean equals(Object obj) {
        if(this==obj){          //This will compare the if the object is at the same memory location
            return true;
        }
        if(obj instanceof Dog){
            String name = ((Dog) obj).getName();
            return getName().equals(name);
        }
        return false;
    }
}
