package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//We are creating a new class to map the actual locations or each one of the locations we got for this.
//We are doing it this way because we want to encapsulate the location data. What we have done is basically created
//a class that behaves exactly like a Map but which we can customize to load its contents from an external source
//file.

//The main class really doesn't care that it is now using the Locations class instead of the Hash Map that it used
//to use because we have implemented the map interface and all the required methods.

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) throws IOException{
        //Here in the main method we have specified that it throws an exception. So the caller knows that the
        //exception can be thrown from this method instead of catching it as given below. So we can remove the
        //catch block part. We can also remove the 2nd catch block as well (along with the try) (//// part)
        //The below code is written as try...finally. However, we can make the below code more precise by using
        //try...resources

//        FileWriter locFile = null;
//        try{
//            locFile = new FileWriter("locations.txt");
//            for(Location location: locations.values()){
//                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
////                throw new IOException("test exception thrown while writing");  //just for testing
//            }
////        }catch (IOException e){//However the prob here is that if an exception is caught, then the program skips the
////            System.out.println("In catch block");//.close method leaving the file open, which is problematic.
////            e.printStackTrace();//So for this "finally" is used.
//        }finally {
//            System.out.println("In finally block");
////            try {
//                if(locFile!=null){   //Very imp. Avoids other exceptions that could occur
//                    locFile.close();   //closing the stream (String/Character Data) is very imp as it avoids resource leaks
//                    System.out.println("Attempting to close locfile");
//                }
////            }catch (IOException e){
////                e.printStackTrace();
////            }
//        }

       //As we can see the by using the try resources, there is no need for finally block (and the locFile.close())
        //method. This is because it automatically ensures that the file writer stream is closed whether the code
        //executes normally or an exception occurs.
        try(FileWriter locFile = new FileWriter("locations.txt")){
            for(Location location: locations.values()){
                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
            }
        }
    }

    //Making the data static (not creating multiple instances) and ensuring that it is only initialized once
    //is the reason for the data to be put in the static initialization block
    static {
        Map<String, Integer> tempExits = new HashMap<>();
        locations.put(0, new Location(0, "You are sitting in front of the computer learning Java",null));
        //The map argument is passed null which is actually the right way. However, for that an if statement is added in the
        //constructor to avoid null pointer exception

        tempExits = new HashMap<>();
        tempExits.put("W",2);
        tempExits.put("E", 3);
        tempExits.put("S", 4);
        tempExits.put("N", 5);
        locations.put(1, new Location(1, "You are sitting at the end of the road before a small building",tempExits));

        tempExits = new HashMap<>();
        tempExits.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill",tempExits));

        tempExits = new HashMap<>();
        tempExits.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building",tempExits));

        tempExits = new HashMap<>();
        tempExits.put("N", 1);
        tempExits.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream",tempExits));

        tempExits = new HashMap<>();
        tempExits.put("S", 1);
        tempExits.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest",tempExits));

    }
    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
