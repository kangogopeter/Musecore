package com.epicodus.muscore;

public class Song {
    private String name;
    private String artist;
    private String album;
    private String path;
    private Song nextSong = null;

    public Song(String name, String artist, String album, String path){
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setNext(Song song)
    {
        nextSong = song;
    }

    public Song getNext()
    {
        return nextSong;
    }

    public String toString(){
        return name.split(".mp3")[0];
    }
}

