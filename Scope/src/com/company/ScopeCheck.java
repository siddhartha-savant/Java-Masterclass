package com.company;

public class ScopeCheck {
    public int publicVar=0;
    private int varOne =1;

    public ScopeCheck() {
        System.out.println("ScopeCheck created, publicVar = " + publicVar + ": varOne = " + varOne);
    }

    public int getVarOne() {
        return varOne;
    }

    public void timesTwo(){
        int varTwo=2;    //By creating the privateVar again inside the two times method we created a new variable
        for(int i=0;i<10;i++){ //whose scope is the current variable. This means that the variable with the most local
            System.out.println(i + " times two: " + i*varTwo);//scope is used.
        }
    }

    public void useInner(){
        InnerClass innerClass = new InnerClass();
        System.out.println("varThree from outer class " + innerClass.varThree);
    }

    public class InnerClass{        //Inner class has access to all the member variables or fields of its containing
        private int varThree =3;     //inner class. The same is true other way around

        public InnerClass() {
            System.out.println("InnerClass created, varOne is " + varOne + " and varThree is " + varThree);
        }
        public void timesTwo(){
            System.out.println("varOne is still available here " + varOne );
            for(int i=0;i<10;i++){//The public int privateVar = 3 overrides the private int privateVar which is in our
                System.out.println(i + " times three: " + i* varThree);//ScopeCheck class
            }
        }
    }
}
