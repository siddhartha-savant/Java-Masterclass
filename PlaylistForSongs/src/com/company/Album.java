package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String albumName;
    private ArrayList<Song> songList;

    public Album(String albumName) {
        this.albumName = albumName;
        this.songList = new ArrayList<Song>();
    }

    public String getAlbumName() {
        return albumName;
    }

    public ArrayList<Song> getSongList() {
        return songList;
    }

    public void addSong(String songName, int duration){
        songList.add(new Song(songName,duration));
    }

    public Song searchSong(String songName){
        for (Song song : songList) {     //Usually the enhanced for loop is used in a linkedlist when we want to compare
            if (song.getSongName().equals(songName)) { //names, etc. It is used to obtain that particular object so as
                return song;       //to compare it with parameter value. Same is done in Playlist class.
            }                     //For printing iterator is used. **Note: Enhanced for loop can also be used instead
        }                        //of an iterator to print the values.
        return null;
    }
    public void addSongsToPlaylist(String songName, LinkedList<Song> playlist){
        if(searchSong(songName)!=null){
            playlist.add(searchSong(songName));
            System.out.println("Song " + songName + " added to playlist");
        }else{
            System.out.println("Song " + songName + " not found");
        }
    }

    public void removeSongFromPlaylist(String songName, LinkedList<Song> playlist){
        if(searchSong(songName)!=null){
            playlist.remove(searchSong(songName));
            System.out.println("Song " + songName + " removed from playlist");
        }else{
            System.out.println("Song " + songName + " not found");
        }
    }

}
