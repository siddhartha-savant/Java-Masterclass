package com.company;

public class Main {

    public static void main(String[] args) {

        SearchTree tree = new SearchTree(null);
        tree.traverse(tree.getRoot());

        //String stringData = "5 7 3 9 8 2 1 0 4 6";
        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";

        String[] data = stringData.split(" ");
        for(String s: data){
            tree.addItem(new Node(s));   //Node extends the abstract class ListItem. So its object can be used
        }
        tree.traverse(tree.getRoot());
        System.out.println(tree.getRoot().getCurrent());
//        tree.removeItem(new Node("3"));
//        tree.removeItem(new Node("1"));
//        tree.removeItem(new Node("9"));
//        tree.traverse(tree.getRoot());
    }
}
//Note that in our case for binary search tree, the root of the tree will be the first item that is being added
//to the tree. (So it can be the leftmost item, the rightmost item, the middle item or any item for that matter)
//In our case the root is Darwin