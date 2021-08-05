package com.timbuchalka;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dev on 18/09/15.
 */
public class Album {
    private String name;
    private String artist;
    private SongList list;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.list = new SongList();
    }

    public boolean addSong(String title, double duration) {
        if(this.list.findSong(title) == null) {
            this.list.addSong(title,duration);
            return true;
        }
        return false;
    }


    public boolean addToPlayList(int trackNumber, List<Song> playList) {  //The parameter was a linkedlist
        int index = trackNumber -1;
        if((index >=0) && (index < this.list.songList.size())) {
            playList.add(this.list.songList.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);  //The parameter was a linkedlist
        return false;
    }

    public boolean addToPlayList(String title, List<Song> playList) {
        Song checkedSong = this.list.findSong(title);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }

    private class SongList{
        private ArrayList<Song> songList;

        public SongList() {
            this.songList = new ArrayList<Song>();
        }

        private Song findSong(String title){
            for(Song checkSong: songList){
                if(checkSong.getTitle().equals(title)){
                    return checkSong;
                }
            }
            return null;
        }

        private void addSong(String title, double duration){
            if(findSong(title)==null){
                this.songList.add(new Song(title,duration));
            }
        }
    }

















}
