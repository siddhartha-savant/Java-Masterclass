package com.company;

import java.util.HashMap;
import java.util.Map;

public class Location {

    private final int locationID;
    private final String description;
    private final Map<String,Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits){
        this.locationID = locationID;
        this.description = description;
        if(exits!=null){
            this.exits = new HashMap<>(exits); //This means that new tempExits (from main) are created for every single location
        }else{
            this.exits= new HashMap<>(); //This will just create a new HashMap with no valid data passed into this constructor
        }
        this.exits.put("Q",0);
    }

//    public void addExits(String direction, int location){
//        exits.put(direction,location);

         // We are able to add even after the map is declared final. This is because
        //final marks the reference and not the object. You can't make that reference (in our case exits) point to
        //a different hash Map. But you can do anything to that object, including adding and removing things.
        //When it is a primitive data type then you cannot change the value of the variable, i.e. make the value
        //different. However, with an object reference, you cannot change the value of the reference i.e. which
        // object it points to.

//       }
    //The addExits is commented as we wanted to create an immutable class

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<>(exits);  //a new map is created just like how it is done for list
    }


}
