package com.company;

public class MyLinkedList implements NodeList{

    private ListItem root = null;  //If we wrote the code for Node root = null, then we would have needed to
                                    //instantiate it in the constructor. As Abstract class ListItem root is used
                                    //there is no need to instantiate it in constructor. Also in Main
    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) { //The parameter used is of type Abstract class which gives us
                                                //flexibility just as we did in Interface Challenge project.
                                                //When called in Main, the argument is used is of type Node.
        if(this.root==null){
            //The list was empty, so this item becomes the head of the list. When this addItem method is called
            //for the first time, this if statement will be executed.
            this.root=newItem;
            return true;
        }
        ListItem currentItem = this.root;   //This is the head of the list. For every time the addItem is called,
        while(currentItem!=null){           //the currentItem will be the head or the first item of the list
            int comparison = (currentItem.compareTo(newItem));
            if(comparison<0){
                //Means the new item is greater. So we have to move right if possible
                if(currentItem.next()!=null){  //There is an item after current item which is greater
                    currentItem=currentItem.next();//Assign the next item as current item and again loop to check
                }else{
                    //There is no next. This is the end of the list
                    currentItem.setNext(newItem);
                    newItem.setPrevious(currentItem); //if we didn't do this the newItem previous will be set to null
                    return true;
                }
            }else if(comparison>0){
                //Means the new item is less. So we have to move left if possible
                if(currentItem.previous()!=null){   //We do all this just to insert the newItem. After inserting
                    currentItem.previous().setNext(newItem);//we need to specify the position of all the other items
                    newItem.setPrevious(currentItem.previous());//If we don't do this, the newItem previous will be
                    newItem.setNext(currentItem); //set to null, the newItem next will be set to null and the
                    currentItem.setPrevious(newItem);//currentItem previous will be set to null.
                    return true;
                }else{
                    //There is no previous. This is the beginning of the list
                    newItem.setNext(currentItem);
                    currentItem.setPrevious(newItem);
                    this.root= newItem;  //head of the list will now become the newItem
                    return true;
                }
                //return true; //The position of this return is imp. It can implemented in both if and else block
            }else{           //otherwise as shown
                System.out.println(newItem.getCurrent() + " is already present");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if(item!=null){
            System.out.println("Deleting item " + item.getCurrent());
        }
        ListItem currentItem = this.root;
        while (currentItem!=null){
            int comparison = currentItem.compareTo(item);
            if(comparison == 0){
                //We have found the item to delete
                if(currentItem == this.root){  //If the head is the current item to be deleted then
                    this.root=currentItem.next();// we make the root the next item
                }else{
                    currentItem.previous().setNext(currentItem.next());
                    //We are basically bypassing that record i.e. deleting. This is for if the item is found after
                    //the head or the root of the list.
                    if(currentItem.next()!=null){
                        currentItem.next().setPrevious(currentItem.previous());
                        //This is just like the above statement for bypassing. The only difference is that this is
                        //done if we have not yet come to the end of the list. If its the end then
                        //currentItem.next() will point to null
                    }
                }
                return true;
            }else if(comparison<0){
                currentItem=currentItem.next(); //This is incrementing the items for the while loop
            }else{//comparison > 0 which means we have passed the point where we could have actually deleted it
                    //We are at an item greater than the one to be deleted. So the item is not in the list
                return false;
            }
        }
        //We have reached the end of the list without finding the item
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if(root ==null){
            System.out.println("The list is empty");
        }else {
            while (root != null) {
                System.out.println(root.getCurrent());
                root = root.next();
            }
        }

//        if(root!=null){                                //Recursive function. In case of linked list it will
//            System.out.println(this.root.getCurrent());//start to crash, once the number of entries are quite
//            traverse(root.next());                   //substantial. There will be stack overflow. The recursive
//        }                                       //method is actually optimized for the binary tree. Even if there
    }                                         //are around 9 billion records, it will only take 63 levels (depth)
}                                               //to go through all the records. For the linked list it has to go
                                                //through entirely, that's why stack will overflow


