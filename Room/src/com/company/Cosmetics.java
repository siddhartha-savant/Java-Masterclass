package com.company;

public class Cosmetics {
    private String makeupEquipment;
    private int mirrors;

    public Cosmetics(String makeupEquipment, int mirrors) {
        this.makeupEquipment = makeupEquipment;
        this.mirrors = mirrors;
    }

    public String getMakeupEquipment() {
        return makeupEquipment;
    }

    private int getMirrors() {
        return mirrors;
    }

    public int hiding(){
        if(mirrors>5) {
            mirrors=2;
            System.out.println("Too many mirrors..Reduced to " + mirrors);
            return mirrors;
        }
        else
            return mirrors;
    }
}
