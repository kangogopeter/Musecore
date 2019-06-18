package com.epicodus.muscore;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MusicService extends Service {

    private MediaPlayer mediaPlayer;
    private Track currentTrack;
    private ArrayList<Track> trackList;


    // Created method called when service is under creation.
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MusicService", "Creating service...");
        // Creating a instance of MediaPlayer
        mediaPlayer = new MediaPlayer();
        // Creating instance of TrackListHelper.
        TrackListHelper trackListHelper = new TrackListHelper(this);
        // Checking if storage is available and getting the playlist.
        if(trackListHelper.checkIfStorageAvailable())
            trackList = trackListHelper.get();
    }

    // Method triggered when calling service with intent. Takes intent with data sent from Activity.
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MusicService", "Service started...");

        // Getting the data sent from MusicActivity
        int track = intent.getIntExtra(TrackListHelper.TRACK, 0);
        int action = intent.getIntExtra(TrackListHelper.ACTION, 1);


        // Switch to handle different actions sent in from MusicActivity
        switch (action) {
            case TrackListHelper.PLAY:
                // Set position in song when last PAUSED
                mediaPlayer.seekTo(TrackListHelper.POSITION);
                //RESET TO Zero, when you change track you start at 0
                TrackListHelper.POSITION = 0;
                mediaPlayer.start();
                break;
            case TrackListHelper.PAUSE:
                // Get the position on track when pause.
                TrackListHelper.POSITION = mediaPlayer.getCurrentPosition();
                mediaPlayer.pause();
                break;
            case TrackListHelper.PLAY_SONG:
                // get selected track en start play
                musicPlayer(trackList.get(track));
                break;
            default:
                break;
        }
        // Setting the notification for the service
        ongoingNotification();

        // If we get killed, after returning from here, restart
        return START_STICKY;
    }

    // Notification method creating a notification for the service
    private void ongoingNotification() {
        // A const custom id.
        final int myID = 1234;

        //The intent to launch when the user clicks the expanded notification
        Intent intent = new Intent(this, MusicActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendIntent = PendingIntent.getActivity(this, 0, intent, 0);

        //This constructor is deprecated. Use Notification.Builder instead
        Notification notice = new Notification(R.drawable.ic_launcher, currentTrack.getName().split(".mp3")[0] + " - " + currentTrack.getArtist(), 3);

        //This method is deprecated. Use Notification.Builder instead.
        notice.setLatestEventInfo(this, "Spinkify", "Click to open", pendIntent);

        // User isn't able to clear this notification from the drawer with Clear button.
        notice.flags |= Notification.FLAG_NO_CLEAR;

        // Setting the service priority to foreground which indicates to the System it shouldn't be removed.
        startForeground(myID, notice);
    }

    // Method responsible to play tracks.
    private void musicPlayer(Track track){
        if (track == null)
            return;
        try {
            if (mediaPlayer.isPlaying())
                mediaPlayer.stop(); // Stop current song.

            mediaPlayer.reset(); // reset resource of player
            mediaPlayer.setDataSource(this, Uri.parse(track.getPath())); // set track to play
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_NOTIFICATION); // select audio stream
            mediaPlayer.prepare(); // prepare resource
            // on completion handler
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
                    // onDone
            {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    musicPlayer(currentTrack.getNext());
                }
            });
            mediaPlayer.start(); // play!
            currentTrack = track;
        } catch (Exception e) {
            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            Log.d("MusicService error", e.toString());
        }
    }

    // Method used when binding services. If not used, return null.
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    // onDestroy method executed when Service is being destroyed.
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(MusicService.class.toString(), "Död!");
        // If music is playing, stop it and release its current object.
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }
}