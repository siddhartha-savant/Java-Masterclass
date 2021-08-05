package com.company;

public class Planets extends HeavenlyBody{
    public Planets(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody body) {
        if(body.getKey().getBodyTypes()==BodyTypes.MOON){
            return super.addSatellite(body);        //We couldn't just write--> this.satellite.add(body)
        }                                           //This is because the satellites field is final. Thus, super
        return false;                               //is used.
    }
    //Note final Set<HeavenlyBody> field in HeavenlyBody class means that the reference for that variable in main is
    //going to be final. ie. we won't be able to change the reference pointing to that object in memory.
    //However, we will still be able to add satellites (through the above addSatellite method) to that Set for the
    //fixed reference pointing to that Set in memory.
}
