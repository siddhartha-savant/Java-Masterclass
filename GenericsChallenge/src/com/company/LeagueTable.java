package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeagueTable<T extends Team> {
    public String name;
    List<T> teamList;

    public LeagueTable(String name) {
        this.name = name;
        this.teamList = new ArrayList<>();
    }

    public boolean addTeam(T team){
        if(this.teamList.contains(team)){
            System.out.println("Team is already present in league");
            return false;
        }else {
            this.teamList.add(team);
            System.out.println(team.getName() + " added to league ");
            return true;
        }
    }
    public void showLeagueTable(){
        Collections.sort(teamList);  //The collection.sort works because we have written compareTo in the Team
        for(T t: teamList){ //class which implements the comparable
            System.out.println(t.getName() + ": " + t.ranking());
        }
    }
}
