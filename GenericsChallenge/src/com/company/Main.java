package com.company;

public class Main {

    public static void main(String[] args) {
	    LeagueTable<Team<FootballPlayer>> footballLeague = new LeagueTable<>("Premier League");

	    //The above line specifies the type of league which we want. The generic we have used is Football Player
        //So it will only add Football Player Teams to the ArrayList in LeagueTable.

	    Team<FootballPlayer> united = new Team<>("Manchester United");
        Team<FootballPlayer> liverpool = new Team<>("Liverpool");
        Team<FootballPlayer> madrid = new Team<>("Real Madrid");
        Team<FootballPlayer> barcelona = new Team<>("Barcelona");
        Team<BaseballPlayer> baseballTeam = new Team<>("Red Sox");

        footballLeague.addTeam(united);
        footballLeague.addTeam(liverpool);
        footballLeague.addTeam(madrid);
        footballLeague.addTeam(barcelona);

      //  footballLeague.addTeam(baseballTeam);        //This is not possible.

        united.matchResult(liverpool,8,2);
        united.matchResult(madrid,2,0);
        liverpool.matchResult(barcelona,5,0);

        footballLeague.showLeagueTable();
    }
}
