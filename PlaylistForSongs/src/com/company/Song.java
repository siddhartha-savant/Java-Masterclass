package com.company;

public class Song {
    private String songName;
    private int songDuration;

    public Song(String songName, int songDuration) {
        this.songName = songName;
        this.songDuration = songDuration;
    }

    public String getSongName() {
        return songName;
    }

    public int getSongDuration() {
        return songDuration;
    }
}
