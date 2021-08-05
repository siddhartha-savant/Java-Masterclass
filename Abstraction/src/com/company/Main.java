package com.company;

public class Main {

    public static void main(String[] args) {
	    Dog dog = new Dog("Labrador");

	    dog.eat();
	    dog.breathe();

	    Parrot parrot = new Parrot("Indian Parrot");

	    parrot.eat();
	    parrot.breathe();
	    parrot.fly();

		Penguin penguin = new Penguin("Emperor");

		penguin.eat();
		penguin.breathe();
		penguin.fly();
    }
}

//Abstract classes and interfaces together.

interface A{
	void a();
	void b();
	void c();
	void d();
}

abstract class B implements A{		//An abstract class can implement an interface and not provide implementation of
	public void c(){System.out.println("I am c");}//all the interface's methods. However, the class extending the abstract
}													//class must provide implementation for the rest of the methods

class M extends B{
	public void a(){System.out.println("I am a");}
	public void b(){System.out.println("I am b");}
	public void d(){System.out.println("I am d");}
}

class Test5{
	public static void main(String args[]){
		A a=new M();				//This is called as implicit casting. Explicit casting is when (..class name..) brackets
		a.a();						//are used
		a.b();
		a.c();
		a.d();
	}}
