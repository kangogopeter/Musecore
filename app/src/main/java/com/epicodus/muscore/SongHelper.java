package com.epicodus.muscore;

import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

import java.util.ArrayList;

public class SongHelper {
    private Context context;

    public final static int PLAY = 1;
    public final static int PAUSE = 2;
    public final static int PLAY_SONG = 3;

    public final static String SONG = "song";
    public final static String ACTION = "action";
    public static int POSITION = 0;



    public static int numberOfSongs;


    public SongHelper(Context context){
        this.context = context;
    }


    public ArrayList<Song> get(){
        Cursor musicResult = context.getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                new String[] {
                        MediaStore.Audio.Media._ID,
                        MediaStore.Audio.Media.DISPLAY_NAME,
                        MediaStore.Audio.Media.ALBUM,
                        MediaStore.Audio.Media.ARTIST,
                        MediaStore.Audio.Media.DATA },
                MediaStore.Audio.Media.IS_MUSIC + " > 0 ",
                null,
                null
        );

        ArrayList<Song> songList = new ArrayList<Song>();

        if (musicResult.getCount() > 0) {
            musicResult.moveToFirst();
            Song prev = null;
            do {
                Song song = new Song(
                        musicResult.getString(musicResult.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME)),
                        musicResult.getString(musicResult.getColumnIndex(MediaStore.Audio.Media.ARTIST)),
                        musicResult.getString(musicResult.getColumnIndex(MediaStore.Audio.Media.ALBUM)),
                        musicResult.getString(musicResult.getColumnIndex(MediaStore.Audio.Media.DATA))
                );

                if (prev != null)
                    prev.setNext(song);

                prev = song;
                songList.add(song);
            }
            while (musicResult.moveToNext());

            prev.setNext(songList.get(0));

            numberOfSongs = musicResult.getCount();
        }
        Log.d("MusicActivity", "" + musicResult.getCount());

        musicResult.close();

        return songList;
    }


    public boolean checkIfStorageAvailable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }
}