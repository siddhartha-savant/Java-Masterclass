package com.company;

public class Main {

    public static void main(String[] args) {
	    String varFour = "This is private to main()";

	    ScopeCheck scopeCheck = new ScopeCheck();
        System.out.println("scopeInstance varOne is " + scopeCheck.getVarOne());
        System.out.println(varFour);
        scopeCheck.useInner();


        scopeCheck.timesTwo();
        System.out.println("=====================");
        ScopeCheck.InnerClass innerClass = scopeCheck.new InnerClass();
        innerClass.timesTwo();

    }
}
