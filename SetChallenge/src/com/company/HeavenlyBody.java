package com.company;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {

    //Cannot create subclasses of this class because it is final. Also we made it abstract. The reason behind it
    //is that now we cannot instantiate the HeavenlyBody class directly. This avoids multiple problems for eg.
    //Consider we created a object 'Pluto' of dwarf planet class. We also created an object 'Sun' of heavenly class
    //Now we can add the Sun object as a satellite to 'Pluto' using the addSatellite method. Thus, to avoid this
    //we make the HeavenlyBody class abstract.

//    private final String name;
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
//    private final BodyTypes bodyType;

//    public static final int STAR = 1;              //Java has a way of grouping constants together called as enum
//    public static final int PLANET = 1;            //as shown below
//    public static final int DWARF_PLANET = 1;
//    public static final int MOON = 1;
//    public static final int COMET = 1;
//    public static final int ASTEROID = 1;

    public enum BodyTypes{              //Nested enum like in this case are automatically static. We can access
        STAR,                           //them without creating an instance of HeavenlyBody class
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
//        this.name = name;
        this.key = new Key(name,bodyType);   //The private constructor of class Key is instantiated
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
//        this.bodyType=bodyType;
    }

//    public String getName() {
//        return name;
//    }

    public Key getKey() {
        return key;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

//    public BodyTypes getBodyType() {
//        return bodyType;
//    }

    public boolean addSatellite(HeavenlyBody body){
        return this.satellites.add(body);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public static Key makeKey(String name, BodyTypes bodyTypes){
        return new Key(name, bodyTypes);
    }

    @Override
    public final boolean equals(Object obj){    //Check the equals method in String class
        if(this == obj){     //The equals method first checks with itself. This will return true if the object that
            return true;     //you are comparing is the same object in memory.
        }
                                                        //We have used instanceof because we are going to subclass
        if(obj instanceof HeavenlyBody){                //HeavenlyBody class. Also to make it symmetric we will make
            HeavenlyBody theObject = (HeavenlyBody) obj;//this method final so that it cannot be overridden

//            if(this.name.equals(theObject.getName())){
//                return this.bodyType == theObject.getBodyType();

                //As per our challenge, we can have bodies with the same name for different
                //Body types. i.e. moon named deimos and comet named deimos is fine
                //but not moon named deimos for both the times. So we first check the
                //name whether they are same or not, then we check whether they
                //have the same body type or not

                //*Update* We have commented out the earlier code after writing the equals() and hashCode() for
                //Key class and adding the Key field instead of the name field

            return this.key.equals(theObject.getKey());

        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }
    //Earlier only the hashCode of this.name was necessary. This was because we were only checking the name of the
    //heavenlybody and deciding whether we need to put both the bodies in the same hash bucket. However, for this
    //challenge, as we can have bodies with the same name but with different bodytypes, (commented above for equals
    //method) we need to have one more factor for us to decide whether we need to put the two bodies in the same
    //hash bucket or not. Therefore, for that, we need to return the hashCode with one more factor being
    //this.bodyType.hashCode(). This will ultimately decide in which hash bucket the body will be placed.


    @Override
    public String toString() {
        return this.key.name + ": " + this.key.bodyTypes + ", " + this.orbitalPeriod;  //The enum prints out the name of bodytype
    }

    public static final class Key{

        //The reason we are creating a static inner class is as follows. As per our solution, the problem that we
        //face is for the Map solarSystem. In the Map solarSystem, we are adding the String name of the Heavenly body
        //as the key and the HeavenlyBody itself as the value. The problem that we face is when two bodies have
        //the same name (i.e. same key) but different values (i.e. Heavenly Body). Consider ex. Pluto which is added
        //twice, one as a Planet and the other time as a DwarfPlanet. Although the values for both the keys are different
        //we have the same Key name. For this we will change the key from type String and create a new key of type
        //Key class. As it is going to constitute the bodytype, name, etc, we will create an static inner class in
        //the HeavenlyBody class itself. The reason we created a static inner class is because if we created a non static
        //inner class then we will need an instance of the outer class to create an instance of the inner class (i.e. Key class)
        //However our outer class is abstract, because of which we cannot instantiate it altogether. Also the reason for inner class
        //is because the constructor is private (which is called by the Heavenly Body constructor) and that standalone Key
        //should is not created (Althought we have written a method which is to retrieve the value for that key in Map)

        private String name;            //As we have created a static class we cannot use the instance variables of
        private BodyTypes bodyTypes;    //class HeavenlyBody. Therefore we need to create separate fields

        private Key(String name, BodyTypes bodyTypes){  //We made the constructor private so that's its only
            this.name = name;                           //accessible in this inner class
            this.bodyTypes = bodyTypes;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyTypes() {
            return bodyTypes;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyTypes.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if(this.name.equals(key.getName())){
                return (this.bodyTypes == key.getBodyTypes());
            }else{
                return false;
            }
        }

        @Override
        public String toString() {
            return this.name + ": " + this.bodyTypes;
        }

        //We are overriding both equals() and hashCode() because we are going to use them as key in the Map.
        //We need to make sure that the key that we are going to input is unique and not duplicate.

        //Now as you know, the solarSystem Map which consists of key String is to be changed to this type which
        //is Class Key. If you check in Main, the Key for solarSystem Map is taken from the String name field of
        //the Heavenly Body class.

        //For ex. HeavenlyBody temp = new Planets("Mercury",88);
        //        solarSystem.put(temp.getName(),temp);

        //As you can see getName() is used, which is the getter of field String name. However, now we need to change
        //the key. As a result, we will need to change the fields of HeavenlyBody class (String name and BodyType
        // bodyType) to that of Class Key.

        //As a result, we will need to make necessary changes where the name of the HeavenlyBody is used (getName)
        //instead use the Key value. Thus, we will change the equals() and the hashCode() overridden methods
        //in HeavenlyBody class as per the new field Key. If you notice similar Key comparison is being carried out
        //in the equals() and the hashCode() methods in the Key class. So we can call their methods instead.
        //(return this.key.equal......)      and     (return this.key.hashCode())

        //We will accordingly need to remove the getter for name and bodyType and add a getter for key.
        //We will also create a new method to make a key. The reason is that the actual implementation of the keys
        //is not something the user of the class should know about. A more important reason is that to retrieve a
        //heavenly body from the map, we need a key where all that we would really have is the name and the bodyType
        //So in other words what we would want is to pass a name and a bodyType and have a method return the valid key
        //which then will be used to look up an entry in our Map. We'll make the method static so that an instance is
        //not required to call the method.
    }
}
