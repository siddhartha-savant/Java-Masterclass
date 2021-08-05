package com.company;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>> {  //This is to compare teams, here
    private String name;   //Team is the type in this case i.e Team FootballPlayer is also the type.
    int played=0;           //and Team Manchester United is also the type. <Team<T>> ---> <SoccerPlayer<united>>
    int won=0;
    int lost=0;
    int tied=0;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player){    //T is parameterized type
        if(members.contains(player)){
            System.out.println( player.getName() + " is already on the team");
            return false;
        }else{
            members.add(player);
            System.out.println(player.getName() + " picked for team " + this.name);
            return true;
        }
    }

    public int numPlayers(){
        return members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore){
        String message;
        if(ourScore>theirScore){
            won++;
            message=" beat ";
        }else if(ourScore<theirScore){
            lost++;
            message=" lost to ";
        }else{
            tied++;
            message=" drew with ";
        }
        played++;
        if(opponent!=null){
            System.out.println(this.getName() + message + opponent.getName());
            matchResult(null, theirScore, ourScore);   //We are updating the fields for both winning team
        }                                                      //and losing team. Also we interchange the parameters
    }                                                          //so that when called again, int ourScore=theirScore
                                                              //and int theirScore=ourScore.

    public int ranking(){
        return (won*2)+tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if(this.ranking()>team.ranking()){
            return -1;
        }else if(this.ranking()<team.ranking()){
            return 1;
        }else{
            return 0;
        }
    }
}
