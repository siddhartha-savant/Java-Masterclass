package com.company;

public class Labrador extends Dog {
    public Labrador(String name) {
        super(name);
    }

//    @Override         //Commented out because the equal method in Dog class is final
//    public boolean equals(Object obj) {
//        if(this==obj){          //This will compare the if the object is at the same memory location
//            return true;
//        }
//        if(obj instanceof Labrador){
//            String name = ((Labrador) obj).getName();
//            return getName().equals(name);
//        }
//        return false;
//    }
}
