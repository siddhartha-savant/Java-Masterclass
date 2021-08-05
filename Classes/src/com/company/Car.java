package com.company;

public class Car {

    private int door;
    private int wheels;
    private String model;
    private String engine;

    public void setModel(String model){
        String validateModel = model.toLowerCase();   //This is possible because String itself is a special class
        if(validateModel.equals("cayenne")||validateModel.equals("harrier")){
            this.model=model;
        }else
        this.model="Unknown car bro!";
    }
    public String getModel(){
        return model;
    }
}

