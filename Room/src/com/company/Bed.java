package com.company;

public class Bed {
    private int numberOfBeds;
    private String mattress;

    public Bed(int numberOfBeds, String mattress) {
        this.numberOfBeds = numberOfBeds;
        this.mattress = mattress;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public String getMattress() {
        return mattress;
    }
}
