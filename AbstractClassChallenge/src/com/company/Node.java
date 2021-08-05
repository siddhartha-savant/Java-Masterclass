package com.company;

public class Node extends ListItem {
    public Node(Object current) {  //As you can see the use of a constructor abstraction class is necessary even
        super(current);           //though the abstraction class is not instantiated. This is because, now we are
    }                             //able to initialize the instance variable 'current' when objects of class Node
                                //will be created.
    @Override
    ListItem next() {               //This method will return the next value/reference of rightLink variable of
        return this.rightLink;      //object1 which is in fact the whole object2. And so on..
    }

    @Override
    ListItem setNext(ListItem item) { //As shown in diagram, this method will set the rightLink variable of object1
        this.rightLink = item;        //to point the whole object2. And so on..
        return this.rightLink;        //Thus creating a sequence.
    }

    @Override
    ListItem previous() {
        return this.leftLink;
    }

    @Override
    ListItem setPrevious(ListItem item) {
        this.leftLink = item;
        return this.leftLink;
    }

    @Override
    int compareTo(ListItem item) {   //This method will compare the current object's, i.e. object1's current value
        if(item!=null){             //"Adelaide" to the passed parameter object's current value i.e. "Brisbane"
            return ((String) super.getCurrent()).compareTo((String) item.getCurrent());
        }else{
            return -1;
        }
    }
}
