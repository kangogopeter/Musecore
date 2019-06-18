package com.epicodus.muscore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import android.app.ListActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicActivity {

//    // Variables
//    private int currentSong = 0;
//    private int songPosition = 0;
//    private boolean isPlaying = false;
//    ArrayList<Song> songList;
//
//    ImageButton playBtn;
//    ImageButton nextBtn;
//    ImageButton prevBtn;
//    ImageButton stopBtn;
//
//
//    // Created method called when activity is under creation.
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.music_gallery);
//
//        // Init instance of TrackListHelper.
//        SongHelper songListHelper = new SongHelper(this);
//        // Check if storage is available using method in TrackListHelper class.
//        if(songListHelper.checkIfStorageAvailable()){
//            Log.d("MusicActivity", "hello, to doctor love!");
//
//            // Using TrackListHelper to get playlist.
//            songList = songListHelper.get();
//            // Creating an custom array adapter the fast but VERY insufficient way which works with small lists, using android layout and the playlist.
//            ArrayAdapter<Song> musicAdapter = new ArrayAdapter<Song>(this, android.R.layout.simple_list_item_2, android.R.id.text1, songList){
//                @Override
//                public View getView(int position, View convertView, ViewGroup parent) {
//                    View view = super.getView(position, convertView, parent);
//                    TextView text1 = (TextView) view.findViewById(android.R.id.text1);
//                    TextView text2 = (TextView) view.findViewById(android.R.id.text2);
//
//                    text1.setText(songList.get(position).toString());
//                    text2.setText(songList.get(position).getArtist());
//                    return view;
//                };
//
//            };
//            // Sets the adapter created to the listView.
//            setListAdapter(musicAdapter);
//
//            // Getting all buttons
//            playBtn = (ImageButton)findViewById(R.id.playBtn);
//            nextBtn = (ImageButton)findViewById(R.id.nextBtn);
//            prevBtn = (ImageButton)findViewById(R.id.prevBtn);
//            stopBtn = (ImageButton)findViewById(R.id.stopBtn);
//
//            // Setting listeners for each button
//            playBtn.setOnClickListener(this);
//            nextBtn.setOnClickListener(this);
//            prevBtn.setOnClickListener(this);
//            stopBtn.setOnClickListener(this);
//        }
//
//    }
//
//    // Method used to handle onclick events in the listView.
//    @Override
//    protected void onListItemClick(ListView listView, View view, int position, long id) {
//
//        // Creating an intent to start MusicService.
//        Intent intentService = new Intent(this, MusicService.class);
//        // Get track clicked by position.
//        currentSong = position;
//        // Setting click track to play and an which action to use in MusicService using putExtra with chaining.
//        intentService.putExtra(SongHelper.SONG, currentSong).putExtra(SongHelper.ACTION, SongHelper.PLAY_SONG);
//        // Starting the intent using startService method.
//        startService(intentService);
//
//        // Setting the icon from play to pause icon and isPlaying to true.
//        playBtn.setImageResource(R.drawable.pause);
//        isPlaying = true;
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.music, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    // Method used to handle onClick events from the buttons
//    @Override
//    public void onClick(View view) {
//        Intent intentService = new Intent(this, MusicService.class);
//        switch (view.getId()){
//            // Play or pause.
//            case R.id.playBtn:
//                if(isPlaying){
//                    // Pause if it play
//                    intentService.putExtra(SongHelper.ACTION, SongHelper.PAUSE);
//                    playBtn.setImageResource(R.drawable.play);
//                    isPlaying = false;
//                    startService(intentService);
//                }else {
//                    // If it not play then start play
//                    intentService.putExtra(SongHelper.SONG, currentSong);
//                    intentService.putExtra(SongHelper.ACTION, SongHelper.PLAY);
//
//
//                    playBtn.setImageResource(R.drawable.pause);
//                    isPlaying = true;
//                    startService(intentService);
//                }
//                break;
//
//            case R.id.nextBtn:
//                // next track
//                if (currentSong < SongHelper.numberOfSongs) {
//                    currentSong++;
//                    intentService.putExtra(SongHelper.SONG, currentSong);
//                    intentService.putExtra(SongHelper.ACTION, SongHelper.PLAY_SONG);
//                    startService(intentService);
//                }
//                else{
//                    currentSong = 0;
//                    intentService.putExtra( SongHelper.SONG, currentSong);
//                    intentService.putExtra(SongHelper.ACTION, SongHelper.PLAY_SONG);
//                    startService(intentService);
//                }
//                break;
//
//            case R.id.prevBtn:
//
//                if (currentSong != 0) {
//                    currentSong--;
//                    intentService.putExtra(SongHelper.SONG, currentSong);
//                    intentService.putExtra(SongHelper.ACTION, SongHelper.PLAY_SONG);
//                    startService(intentService);
//                }
//                else
//
//                {
//                    currentSong = SongHelper.numberOfSongs -= 1;
//                    intentService.putExtra(SongHelper.SONG, currentSong);
//                    intentService.putExtra(SongHelper.ACTION, SongHelper.PLAY_SONG);
//                    startService(intentService);
//                }
//                break;
//            // stop the service
//            case R.id.stopBtn:
//                stopService(new Intent(this, MusicService.class));
//                playBtn.setImageResource(R.drawable.play);
//                isPlaying = false;
//                break;
//        }
//    }
}