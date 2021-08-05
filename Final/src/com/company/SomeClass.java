package com.company;

public class SomeClass {

    private static int classCounter = 0;
    public final int instanceNumber;
    private final String name;

    public SomeClass(String name){
        classCounter++;
        instanceNumber=classCounter;
        this.name = name;
        System.out.println(this.name + " created, instance is " + instanceNumber);
    }

    public int getInstanceNumber() {
        return instanceNumber;
    }

}
