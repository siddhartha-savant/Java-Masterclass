package com.company;

public class SearchTree implements NodeList {

    private ListItem root = null;

    public SearchTree(ListItem root) {  //We can remove this parameter here and argument in main as just above it
        this.root = root;               // is mentioned null.
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if(this.root==null){
            //The tree was empty, so our item becomes the head of the tree
            this.root=newItem;
            return true;
        }
        //Otherwise, start comparing from the head of the tree
        ListItem currentItem = this.root;
        while (currentItem!=null){
            int comparison = (currentItem.compareTo(newItem));
            if(comparison<0){
                //new item is greater, move right if possible
                if(currentItem.next()!=null){
                    currentItem=currentItem.next();
                }else{
                    //there is no node to the right. So add at this point
                    currentItem.setNext(newItem);  //There are no links back from the child to the parent in Binary
                    return true;                   //Search Tree
                }
            }else if(comparison>0){
                //new item is less, move left if possible
                if(currentItem.previous()!=null){
                    currentItem=currentItem.previous();
                }else{
                    //there is no node the left. So add at this point
                    currentItem.setPrevious(newItem); //There are no links back from the child to the parent in
                    return true;                      //Binary Search Tree
                }
            }else{
                //equal so don't add
                System.out.println(newItem.getCurrent() + " is already present");
                return false;
            }
        }
        //We can't actually get here, but java complains if there's no return. Technically the loop will never
        //terminate naturally. The condition currentItem!=null can never actually be false because we are always
        //checking for null before moving left or right. So we could have written while(true) and deleted this
        //last return statement.
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        //recursive method
        if(root!=null){
            traverse(root.previous());
            System.out.println(root.getCurrent());
            traverse(root.next()); //traverse is called one more time. This time it will be Adelaide.next which is
            //actually null. There are no further instructions and so this invocation of
            //traverse returns to the point after traversal which is Brisbane.previous
        }
    }
}
