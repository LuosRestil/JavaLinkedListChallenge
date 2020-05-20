package com.javatutorial;

import java.util.ArrayList;

public class Album {
    private ArrayList<Song> songs;
    private String name;

    public Album(String name, ArrayList<Song> songs) {
        this.name = name;
        this.songs = songs;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }



}
