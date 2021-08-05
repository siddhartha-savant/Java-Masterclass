package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        HeavenlyBody temp = new HeavenlyBody("Mercury",88);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        temp = new HeavenlyBody("Mercury",89);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        temp = new HeavenlyBody("Venus",225);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        temp = new HeavenlyBody("Earth",365);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new HeavenlyBody("Moon",27);
        solarSystem.put(tempMoon.getName(),tempMoon);
        temp.addMoon(tempMoon);  //This will get added to Heavenly Body Earth.

        tempMoon = new HeavenlyBody("Artificial Satellites",24);
        solarSystem.put(tempMoon.getName(),tempMoon);
        temp.addMoon(tempMoon);  //This will get added to Heavenly Body Earth.

        temp = new HeavenlyBody("Mars",687);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Deimos",1.3);
        solarSystem.put(tempMoon.getName(),tempMoon);
        temp.addMoon(tempMoon);  //This will get added to Heavenly Body Mars.

        tempMoon = new HeavenlyBody("Phobos",0.3);
        solarSystem.put(tempMoon.getName(),tempMoon);
        temp.addMoon(tempMoon);  //This will get added to Heavenly Body Mars.



        System.out.println("Planets");
        for(HeavenlyBody planet: planets){
            System.out.println("\t" + planet.getName());
        }


        HeavenlyBody body = solarSystem.get("Earth");
        System.out.println("Moons of " + body.getName());
        for(HeavenlyBody moon: body.getSatellites() ){
            System.out.println("\t" + moon.getName());
        }



        Set<HeavenlyBody> moons = new HashSet<>();      //This is to show tha addAll method which gives us the
        for(HeavenlyBody planet : planets){             //union of moons from different sets
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All moons");
        for(HeavenlyBody moon : moons){
            System.out.println("\t" + moon.getName());
        }



        HeavenlyBody earth = new HeavenlyBody("Earth",366 );  //This was added so as to change the
        planets.add(earth);                                                     //equal and hashcode methods

        for(HeavenlyBody planet: planets){
            System.out.println(planet.getName() + ": " + planet.getOrbitalPeriod());
        }

        Object o = new Object();      //the base object that all other objects inherit from
        o.equals(o);
        "earth".equals("");
    }
}
