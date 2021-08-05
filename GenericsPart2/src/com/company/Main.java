package com.company;

public class Main {

    public static void main(String[] args) {
        BaseballPlayer babe = new BaseballPlayer("Babe Ruth");
        FootballPlayer brady = new FootballPlayer("Tom Brady");
        SoccerPlayer ronaldo = new SoccerPlayer("Cristiano Ronaldo");

        Team<FootballPlayer> puneKings = new Team<>("Pune Kings");
        // puneKings.addPlayer(babe);
        puneKings.addPlayer(brady);
        // puneKings.addPlayer(ronaldo);

        System.out.println(puneKings.numPlayers());

        Team<BaseballPlayer> baseballTeam = new Team<>("Red Sox");
        baseballTeam.addPlayer(babe);

//        Team<String> brokenTeam = new Team<>("This won't work");  //There is not going to be any compile error
//        brokenTeam.addPlayer("No one");                      //as String is not a primitive data type. However, it
                                                    //will give exception as in Team class we are doing casting.
        Team<SoccerPlayer> juventus = new Team<>("Juventus");
        juventus.addPlayer(ronaldo);

        Team<SoccerPlayer> united = new Team<>("Manchester United");
        Team<SoccerPlayer> liverpool = new Team<>("Liverpool");

        united.matchResult(liverpool,8,2);
        united.matchResult(juventus,2,0);
        liverpool.matchResult(juventus,5,0);

        System.out.println("Rankings");
        System.out.println(united.getName() + ": " + united.ranking());
        System.out.println(liverpool.getName() + ": " + liverpool.ranking());
        System.out.println(juventus.getName() + ": " + juventus.ranking());

        System.out.println(united.compareTo(liverpool));
        System.out.println(liverpool.compareTo(united));

        //These 4 statements were to check our logic behind recursive method for matchResult method in
        //Team class. The logic is wrong
        System.out.println("United played: " + united.getPlayed());
        System.out.println("Liverpool played: " + liverpool.getPlayed());
        System.out.println("Juventus played: " + juventus.getPlayed());
        System.out.println("Juventus lost: " + juventus.getLost());

    }
}
