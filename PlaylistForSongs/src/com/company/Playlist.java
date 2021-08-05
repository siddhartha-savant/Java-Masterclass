package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Playlist {
    private String playlistName;
    private ArrayList<Album> albumList;
    //private LinkedList<Song> playlist;

    public Playlist(String playlistName) {
        this.playlistName = playlistName;
        this.albumList = new ArrayList<Album>();
       // this.playlist = new LinkedList();
    }

//    public LinkedList<Song> getPlaylist() {
//        return playlist;
//    }

    public void addAlbum(String albumName){
        albumList.add(new Album(albumName));
    }

    public Album searchAlbum(String albumName){
        for (Album searchAlbum : albumList) {
            if (searchAlbum.getAlbumName().equals(albumName)) {
                return searchAlbum;
            }
        }
        return null;
    }

    public void addSongToAlbum(String albumName, String songName, int duration){
        Album existingAlbum = searchAlbum(albumName);
        existingAlbum.addSong(songName,duration);
    }

    public Song searchSongInAlbum(String songName){
        for (Album album : albumList) {
            Song searchSong = album.searchSong(songName);
            if (searchSong != null) {
                return searchSong;
            }
        }
        return null;
    }

    public void addSongsToPlaylist(String songName, LinkedList<Song> playlist){
        if(searchSongInAlbum(songName)!=null){
            playlist.add(searchSongInAlbum(songName));
            System.out.println("Song " + songName + " added to playlist");
        }else{
            System.out.println("Song " + songName + " not found");
        }
    }

    public void removeSongFromPlaylist(String songName, LinkedList<Song> playlist){
        if(searchSongInAlbum(songName)!=null){
            playlist.remove(searchSongInAlbum(songName));
            System.out.println("Song " + songName + " removed from playlist");
        }else{
            System.out.println("Song " + songName + " not found");
        }
    }
}
