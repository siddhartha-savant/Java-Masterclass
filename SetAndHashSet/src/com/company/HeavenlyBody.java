package com.company;

import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {           //Cannot create subclasses of this class because it is final
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addMoon(HeavenlyBody moon){
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    @Override
    public boolean equals(Object obj){    //Check the equals method in String class
        if(this == obj){     //The equals method first checks with itself. This will return true if the object that you
            return true;     //are comparing is the same object in memory.
        }

        System.out.println("obj.getClass() is " + obj.getClass()); //This test is similar to the instanceof test in the
        System.out.println("this.getClass() is " + this.getClass());//equals method of class String. This is to make sure
        if((obj == null) || (obj.getClass()!=this.getClass())){//that the sub classes do not compare equal, what we do is
            return false;//check the actual class of the object being compared against the class of the object the method is in
        }               //The first condition is to test null pointer exception when we try to call the getClass method of null

        String objName = ((HeavenlyBody) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        System.out.println("Hash Code called");
        return this.name.hashCode() + 57;
    }
}
