package com.company;

public class EnhancedPlayer {
    private String name;
    private int hitPoints =100;
    private String weapon;

    public EnhancedPlayer(String name, int health, String weapon) {
        this.name = name;
        if(health>0 && health<=100){
            hitPoints = health;   //Here no need for 'this' because different parameter named health is used.
        }
        this.weapon = weapon;
    }
    public void loseHealth(int damage){
        hitPoints = hitPoints -damage;  //No need to write this.hitPoints because it belongs to the same class
        if(hitPoints <=0){              // and additionally no other parameter has name hitPoints.
            System.out.println("Player knocked out");
        }//Reduce no. of lives remaining for the player
    }

    public int getHealth() {
        return hitPoints;
    }
}
