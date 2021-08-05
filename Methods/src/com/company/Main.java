package com.company;

public class Main {

    public static void main(String[] args) {

        boolean gameOver = true;
        int score = 800;
        int levelComplete = 5;
        int bonus = 100;

        calculateScore(gameOver, score, levelComplete, bonus);

        levelComplete = 6;
        calculateScore(true, 1000, levelComplete,bonus);

        calculateScore(true, 1200, 7,200);

        int highScore = calculateScore1(gameOver, score, levelComplete, bonus); //Here the value for levelComplete
        System.out.println("Your high score was " + highScore); //is the previously defined value i.e. 6

        int playerPosition = calculateHighScorePosition(1500);
        displayHighScorePosition("Siddhu",playerPosition);

        playerPosition = calculateHighScorePosition(900);
        displayHighScorePosition("Piddhu",playerPosition);

        playerPosition = calculateHighScorePosition(400);
        displayHighScorePosition("Riddhu",playerPosition);

        playerPosition = calculateHighScorePosition(50);
        displayHighScorePosition("Kiddhu",playerPosition);

    }
    public static void calculateScore(boolean gameOver, int score, int levelComplete , int bonus){

        if(gameOver){
            int finalScore = score + (levelComplete * bonus);
            System.out.println("Your final score was " + finalScore);
        }
    }
    public static int calculateScore1(boolean gameOver, int score, int levelComplete , int bonus){
        if(gameOver){
            int finalScore = score + (levelComplete * bonus);
            System.out.println("Your final score was " + finalScore);
            return finalScore;
        }
        return -1;   //here the other return type could have been as an else statement
    }
    public static void displayHighScorePosition(String playerName, int playerPosition){
        System.out.println(playerName + " managed to get into position " + playerPosition +
                " on the high score table");
    }
    public static int calculateHighScorePosition(int playerScore){
//        if(playerScore >= 1000){
//            return 1;
//        }else if(playerScore >= 500){
//            return 2;
//        }else if (playerScore >= 100){
//            return 3;
//        }
//        return 4;

        int position =4;
        if(playerScore >= 1000){
            position = 1;
        }else if(playerScore >= 500){
            position = 2;
        }else if (playerScore >= 100){
            position = 3;
        }
        return position;
        }
    }

