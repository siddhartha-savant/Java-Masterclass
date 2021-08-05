package com.timbuchalka;

/**
 * Created by dev on 18/09/15.
 */
public class Song {
    private String title;
    private double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {                     //Use this in built java method next time (We are overriding the
        return this.title + ": " + this.duration;  //method from class which internally every class in java extends to.
    }
}
