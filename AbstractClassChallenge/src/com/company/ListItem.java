package com.company;

public abstract class ListItem {
   protected ListItem rightLink=null; //These are made protected and not private because they need to be
   protected ListItem leftLink=null;  //accessed from the concrete sub class. Also the class is self referential
   protected Object current;         //i.e. a class that contains an instance variable that has the same class type

    //The key to all its interestingness is that every object constructed from ListItem contains a next(rightLink)
    //and previous(leftLink) instance variables that stores null or a reference to another object from this class
    //ListItem. The data structure that arise from repeatedly constructing objects from this class are similar
    //in content to LinkedList. i.e. they store sequence of values.

    public ListItem(Object current) {
        this.current = current;
    }

    abstract ListItem next();
    abstract ListItem setNext(ListItem item);
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem item);
    abstract int compareTo(ListItem item);


    public Object getCurrent() {
        return current;
    }
}
