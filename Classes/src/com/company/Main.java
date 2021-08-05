package com.company;

public class Main {

    public static void main(String[] args) {
	    Car porsche = new Car();
	    Car tata = new Car();
        System.out.println(porsche.getModel());//Will return null
        porsche.setModel("indica");           //porsche.model = "Cayenne";  Not a correct way to go
        System.out.println(porsche.getModel());//System.out.println(porsche.model);

    }
}