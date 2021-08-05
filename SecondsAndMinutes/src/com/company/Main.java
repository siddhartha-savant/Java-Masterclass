package com.company;

public class Main {
    public static final String INVALID_MESSAGE = "Invalid value";

    public static void main(String[] args) {

        String testing = getDurationString(3600);
        System.out.println(testing);

        String testing1 = getDurationString(61,9);
        System.out.println(testing1);

        System.out.println(getDurationString(-40));
    }
    public static String getDurationString(int minutes, int seconds){
        if(minutes>=0 && seconds>=0 && seconds<=59){
            int hour = minutes/60;
            int remMinutes = minutes%60;
            String hoursString = hour + "h";
            if(hour<10){
                hoursString = "0" + hoursString;
            }
            String minString = remMinutes + "m";
            if(remMinutes<10){
                minString = "0" + minString;
            }
            String secondString = seconds + "s";
            if(seconds<10){
                secondString = "0" + secondString;
            }
            return hoursString + " " + minString + " " + secondString;
        }else
        {
            return INVALID_MESSAGE;
        }
    }
    public static String getDurationString(int seconds){
        if(seconds>=0){

            int minutes = seconds/60;
            int remSeconds = seconds%60;
            System.out.println(seconds + " = " + minutes + "m and " + remSeconds + "s");
            String test = getDurationString(minutes,remSeconds);
            return test;
        }else
            return INVALID_MESSAGE;
    }
}
