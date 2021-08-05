package com.company;

public class Main {

    public static void main(String[] args) {

        int myScore = 0;
        boolean gameOver = true;


        if(gameOver){
            int score = 800;
            int levelCompleted =5;
            int bonus = 100;
            int finalScore = score + (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
        }

        if(gameOver){
            int score = 1000;
            int levelCompleted = 8;
            int bonus = 200;
            int finalScore = score + (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
        }
        if(myScore == 2000){
            System.out.println("Your score was less than 2000");
        }else if (myScore == 1000)
        {
            System.out.println("Your score was valid");
        }
        else if(gameOver != false){      //Over here i have used another condition in else if than in previous if
            System.out.println("I don't know if this is possible"); //Still its working and is possible
        }
        else {
            System.out.println("Never mind");
        }
        int score = 800;
        int levelCompleted =5;
        int bonus = 100;
        int finalScore = score + (levelCompleted * bonus);
        System.out.println("Your final score was " + finalScore);

        score = 1000;
        levelCompleted = 8;
        bonus = 200;
        finalScore = score + (levelCompleted * bonus);
        System.out.println("Your final score was " + finalScore);
    }
    int score = 800;
    int levelCompleted =5;
    int bonus = 100;
    int finalScore = score + (levelCompleted * bonus);
    //I cannot print anything outside the main method, However, i am able to assign variables.
    //Also  the main method can only be written once.

    //However, these methods of copy pasting the code, has produced multiple duplicates.
    //The prob with duplicates is once you make a change in 1 place, humans tend to forget the changes in other places
    //Therefore for this methods are used.
}

