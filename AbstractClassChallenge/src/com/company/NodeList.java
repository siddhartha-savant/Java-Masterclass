package com.company;

public interface NodeList {
    ListItem getRoot();             //In case of LinkedList, the root is called the head of the list. It is defined
    boolean addItem(ListItem item);  //so in binary search trees
    boolean removeItem(ListItem item);
    void traverse(ListItem root);
}
