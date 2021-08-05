package com.company;

import java.util.ArrayList;

public class GroceryList {

    private ArrayList<String> groceryList = new ArrayList<String>();

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }

    public void addGroceryItem(String item){
        groceryList.add(item) ;        //This is a method of arraylist class similar to .size() , .get(), etc
    }
    public void printGroceryList(){
        System.out.println("You have " + groceryList.size() + " items in your list");
        for (int i=0;i<groceryList.size();i++){
            System.out.println((i+1) + ". " + groceryList.get(i));
        }
    }
    public void modifyGroceryItem(String currentItem, String newItem){
        int position = findItem(currentItem);
        if(position>=0){
            modifyGroceryItem(position,newItem);
            System.out.println("Item " + currentItem + " has been modified to " + newItem);
        }
    }
    private void modifyGroceryItem(int position, String newItem){
        groceryList.set(position, newItem);
       // System.out.println("Grocery Item " + (position+1) + " has been modified");
    }
    public void removeItem(String item){
        int position = findItem(item);
        if(position>=0){
           removeItem(position);
            System.out.println("Item " + item + " has been successfully removed");
        }
    }
    private void removeItem(int position){      //This method is called in overloaded method. We are doing this
        groceryList.remove(position);         //because the person won't need to know the position of the item
    }                                         //Only the name is needed. Same is done for modifyGroceryItem
                                              //We have also made the method private as it is dealing with
                                              //positions and should not be accessible elsewhere.

    private int findItem(String searchItem){    //Similar to above we have made it private
        return  groceryList.indexOf(searchItem);   //index of returns the position of the matched string
    }

    public boolean onFile(String searchItem){
        int position = findItem(searchItem);
        if(position>=0){
            return true;
        }else{
            return false;
        }
    }
}
