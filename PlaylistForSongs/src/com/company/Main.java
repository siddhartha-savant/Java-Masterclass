package com.company;

import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Album> albumList = new ArrayList<Album>();


    public static void main(String[] args) {
        Album album = new Album("Rap Album");
        album.addSong("Crazy",120);
        album.addSong("Must be",344);
        album.addSong("Mountain High",230);
        album.addSong("Do you know?",450);
        album.addSong("Mine",150);
        album.addSong("Supernova",222);
        albumList.add(album);

        album=new Album("Country Album");
        album.addSong("Why",122);
        album.addSong("MGod",244);
        album.addSong("Mountain Shit",310);
        album.addSong("Helle",430);
        album.addSong("You are gone",110);
        album.addSong("enufff",234);
        albumList.add(album);

        LinkedList<Song> playlist = new LinkedList<Song>();
        albumList.get(0).addSongsToPlaylist("Crazy",playlist);
        albumList.get(0).addSongsToPlaylist("Mine",playlist);
        albumList.get(0).addSongsToPlaylist("Do you know?",playlist);
        albumList.get(1).addSongsToPlaylist("Mountain Shit",playlist);
        albumList.get(1).addSongsToPlaylist("Helle",playlist);
        albumList.get(1).addSongsToPlaylist("You are gone",playlist);


        play(playlist);



    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\nPress");
        System.out.println("1  - to close application\n" +
                "2  - to skip the song\n" +
                "3  - forward to next song\n" +
                "4  - skip to previous song\n" +
                "5  - replay current song\n" +
                "6  - list songs in playlist\n" +
                "7  - remove song from playlist\n" +
                "8  - to print a list of available actions.");
        System.out.println("Choose your action");
    }

    private static void play(LinkedList<Song> playlist) {
        boolean quit = false;
        boolean forwardSong = true;
        ListIterator<Song> listIterator = playlist.listIterator();
        if(playlist.size()==0){
            System.out.println("No songs in playlist");
            return;
        }else{
            System.out.println("Now playing " + listIterator.next().getSongName());
            printActions();
        }
        while (!quit) {
            System.out.println("\nEnter action: ");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 1:
                    System.out.println("Closing the application...");
                    quit = true;
                    break;

                case 2:

                    //listIterator.next();
                    if(listIterator.hasNext()){
                        System.out.println("Skipped the song to the next song " + listIterator.next().getSongName());
                    }else{
                        System.out.println("You have reached to end of the playlist");
                    }
                    break;

                case 3:
                    if(!forwardSong) {
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forwardSong = true;
                    }if(listIterator.hasNext()){
                    System.out.println("Forwarded the song to the next song " + listIterator.next().getSongName());
                }else{
                    System.out.println("You have reached to end of the playlist");
                    forwardSong = false;
                }
                    break;

                case 4:
                    if(forwardSong) {
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forwardSong = false;
                    }if(listIterator.hasPrevious()){
                    System.out.println("Backward the song to the previous song " + listIterator.previous().getSongName());
                }else{
                    System.out.println("This is the beginning of the playlist");
                    forwardSong = true;
                }
                    break;

                case 5:
                    if(forwardSong){
                        if(listIterator.hasPrevious()){
                            System.out.println("Replay the song " + listIterator.previous().getSongName());
                            forwardSong=false;
                        }else{
                            System.out.println("We are at the start of the list");
                        }
                    }else{
                        if(listIterator.hasNext()){
                            System.out.println("Replay the song " + listIterator.next().getSongName());
                            forwardSong=true;
                        }else{
                            System.out.println("We are at the end of the list");
                        }
                    }
                    break;

                case 6:
                    printSongs(playlist);
                    break;

                case 7:
                    if(playlist.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next().getSongName());
                        }else if( listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous().getSongName());
                        }
                    }
                    break;

                case 8:
                    printActions();
                    break;
            }
        }
    }
    private static void printSongs(LinkedList<Song> playlist){
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("============================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getSongName());
        }
        System.out.println("============================");

    }
}

