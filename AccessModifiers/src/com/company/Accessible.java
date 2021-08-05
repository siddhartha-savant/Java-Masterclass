package com.company;

interface Accessible {   //Although package private, the methods or variables in an interface are going to be
    int SOME_CONSTANT = 100;//public. So even if the access modifiers are missing for the the methods, that does not
    public void methodA();//imply that the methods are package private. Also one thing to note is that the access
    void methodB();// modifier of interface effectively determines whether the interface can be implemented or not
    boolean methodC();//Suppose the interface is package private, then classes from different packages cannot implement
}                     //them, effectively cannot implement the public methods in that interface 
