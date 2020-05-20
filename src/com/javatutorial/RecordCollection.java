package com.javatutorial;

import java.util.ArrayList;

public class RecordCollection {
    private ArrayList<Album> albums = new ArrayList<>();

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public void addAlbumToCollection(Album album) {
        albums.add(album);
    }


}
