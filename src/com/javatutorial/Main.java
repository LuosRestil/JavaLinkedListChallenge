package com.javatutorial;

import java.util.*;

public class Main {
//    Make record collection and playlist
    private static RecordCollection recordCollection = new RecordCollection();
    private static LinkedList<Song> playlist = new LinkedList<>();


    public static void main(String[] args) {
//        Add records to collection
        recordCollection.addAlbumToCollection(new Album("Big Fun", new ArrayList<>(Arrays.asList(new Song("Hello", 135), new Song("Goodbye", 158), new Song("Garbage", 141)))));
        recordCollection.addAlbumToCollection(new Album("Ooh, Boy", new ArrayList<>(Arrays.asList(new Song("The Biowave", 146), new Song("Dinner Bell", 129), new Song("Stevie Said So", 150)))));
        recordCollection.addAlbumToCollection(new Album("No You Didn't", new ArrayList<>(Arrays.asList(new Song("Booger Hook", 95), new Song("My New Slinky", 126), new Song("Doot Doot Doo", 134)))));

//        Add songs to playlist
        addSongToPlaylist(recordCollection.getAlbums().get(0).getSongs().get(0));
        addSongToPlaylist(recordCollection.getAlbums().get(1).getSongs().get(1));
        addSongToPlaylist(recordCollection.getAlbums().get(2).getSongs().get(2));
        addSongToPlaylist(recordCollection.getAlbums().get(1).getSongs().get(0));

        play(playlist);
    }

    public static void play(LinkedList<Song> playlist) {
        ListIterator<Song> i = playlist.listIterator();
        Scanner scanner = new Scanner(System.in);
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
        } else {
            System.out.println("*****************************");
            System.out.println("Now playing: " + i.next().getTitle());
            System.out.println("*****************************");
            boolean quit = false;
            while (!quit) {
                System.out.println("- MENU -");
                System.out.println("1 - Play next song");
                System.out.println("2 - Play previous song");
                System.out.println("3 - Replay current song");
                System.out.println("4 - Remove current song from playlist");
                System.out.println("5 - View playlist");
                System.out.println("6 - Quit");

                System.out.print("Option: ");
                int option = scanner.nextInt();
                scanner.nextLine();
                switch(option) {
                    case 1:
                        if (i.hasNext()) {
                            System.out.println("*****************************");
                            System.out.println("Now playing: " + i.next().getTitle());
                            System.out.println("*****************************");
                        } else {
                            i.previous();
                            System.out.println("*****************************");
                            System.out.println("End of playlist.");
                            System.out.println("Now playing: " + i.next().getTitle());
                            System.out.println("*****************************");
                        }
                        break;
                    case 2:
                        if (i.hasPrevious()) {
                            i.previous();
                            if(i.hasPrevious()){
                                i.previous();
                                System.out.println("*****************************");
                                System.out.println("Now playing: " + i.next().getTitle());
                                System.out.println("*****************************");
                            } else {
                                System.out.println("*****************************");
                                System.out.println("Beginning of playlist.");
                                System.out.println("Now playing: " + i.next().getTitle());
                                System.out.println("*****************************");
                            }
                        } else {
                            System.out.println("*****************************");
                            System.out.println("Beginning of playlist.");
                            System.out.println("Now playing: " + i.next().getTitle());
                            System.out.println("*****************************");
                        }
                        break;
                    case 3:
                        if(i.hasPrevious()){
                            i.previous();
                            System.out.println("*****************************");
                            System.out.println("Now playing " + i.next().getTitle());
                            System.out.println("*****************************");
                        } else {
                            System.out.println("*****************************");
                            System.out.println("Beginning of playlist.");
                            System.out.println("Now playing: " + i.next().getTitle());
                            System.out.println("*****************************");
                        }
                        break;
                    case 4:
                        if (!playlist.isEmpty()) {
                            i.remove();
                            System.out.println("*****************************");
                            System.out.println("Current song removed.");
                            if (!i.hasNext()) {
                                i.previous();
                            }
                            System.out.println("Now playing: " + i.next().getTitle());
                            System.out.println("*****************************");
                        }
                        break;
                    case 5:
                        System.out.println("*****************************");
                        System.out.println("Current playlist:");
                        for (Song song : playlist) {
                            System.out.println(String.format("Title: %s, Duration: %ds", song.getTitle(), song.getDurationInSeconds()));
                        }
                        System.out.println("*****************************");
                        break;
                    case 6:
                        quit = true;
                        break;
                    default:
                        System.out.println("Invalid input. Please enter a number 1 - 6.");
                        break;
                }
            }
        }

    }

    private static void addSongToPlaylist(Song song) {
        if (isInCollection(song, recordCollection)) {
            playlist.add(song);
        } else {
            System.out.println("You do not own this song.");
        }
    }

    private static boolean isInCollection(Song song, RecordCollection collection) {
        for (Album album : collection.getAlbums()) {
            for (Song track : album.getSongs()){
                if (track.getTitle().equals(song.getTitle()) && track.getDurationInSeconds() == song.getDurationInSeconds()) {
                    return true;
                }
            }
        }
        return false;
    }

}
