package com.epicodus.muscore.ui;

import android.content.Intent;
import android.drm.DrmStore;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.epicodus.muscore.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;

public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView youTubeView;
    private MyPlayerStateChangeListener playerStateChangeListener;
    private MyPlaybackEventListener playbackEventListener;
    private YouTubePlayer player;

    private DatabaseReference myDatabase;
    private DatabaseReference myDatabase2;

    @BindView(R.id.songsButton)
    Button mSongsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        mSongsButton.setOnClickListener((View.OnClickListener) this);


        myDatabase = FirebaseDatabase.getInstance().getReference("Message");
        myDatabase2 = FirebaseDatabase.getInstance().getReference("Message2");


        final TextView myText = findViewById(R.id.TextView);
        final TextView myText2 = findViewById(R.id.TextView);

        myDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                myText.setText(dataSnapshot.getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                myText.setText("CANCELLED");

            }
        });

        myDatabase2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                myText2.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                myText2.setText("CANCELLED");
            }
        });


        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubeView.initialize(Config.YOUTUBE_API_KEY, this);

        playerStateChangeListener = new MyPlayerStateChangeListener();
        playbackEventListener = new MyPlaybackEventListener();

         final EditText seekToText = (EditText) findViewById(R.id.seek_to_text);
        Button seekToButton = (Button) findViewById(R.id.songsButton);
        seekToButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == mSongsButton) {
                    Intent intent = new Intent(YoutubeActivity.this, SongsActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

}

//
//    @Override
//    public void onClick(View view) {
//        if (view == mSongsButton) {
//            Intent intent = new Intent(YoutubeActivity.this, SongsActivity.class);
//            startActivity(intent);
//            finish();
//        }
//    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        this.player = player;
        player.setPlayerStateChangeListener(playerStateChangeListener);
        player.setPlaybackEventListener(playbackEventListener);

        if (!wasRestored) {
            player.cueVideo("LembwKDo1Dk"); // Plays https://www.youtube.com/watch?v=LembwKDo1Dk
        }else{
            player.cueVideo("LembwKDo1Dk",56);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error));
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(Config.YOUTUBE_API_KEY, this);
        }
    }

    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return youTubeView;
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private final class MyPlaybackEventListener implements YouTubePlayer.PlaybackEventListener {

        @Override
        public void onPlaying() {
            // Called when playback starts, either due to user action or call to play().
            showMessage("Playing/Chezaring");
        }

        @Override
        public void onPaused() {
            // Called when playback is paused, either due to user action or call to pause().
            showMessage("Paused So Bye");
        }

        @Override
        public void onStopped() {
            // Called when playback stops for a reason other than being paused.
            showMessage("Tuwatch CyberPunk Gaming");
        }

        @Override
        public void onBuffering(boolean b) {
            // Called when buffering starts or ends.
            showMessage("Error occured");
        }

        @Override
        public void onSeekTo(int i) {
            // Called when a jump in playback position occurs, either
            // due to user scrubbing or call to seekRelativeMillis()
            showMessage("Sorry for the inconvenience!");
        }
    }

    private final class MyPlayerStateChangeListener implements YouTubePlayer.PlayerStateChangeListener {

        @Override
        public void onLoading() {
            // Called when the player is loading a video
            // At this point, it's not ready to accept commands affecting playback such as play() or pause()
            showMessage("CyberPunks");
        }

        @Override
        public void onLoaded(String s) {
            // Called when a video is done loading.
            showMessage("Please Wait Loading.....");
        }

        @Override
        public void onAdStarted() {
            // Called when playback of an advertisement starts.
            showMessage("AD session starts");
        }

        @Override
        public void onVideoStarted() {
            // Called when playback of the video starts.
            showMessage("Click on more Videos to view some other videos");
        }

        @Override
        public void onVideoEnded() {
            // Called when the video reaches its end.
            showMessage("The Video is about to end :)");
        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {
            // Called when an error occurs.
            showMessage("Sorry An error occurred try to refresh the application");
        }
    }

    public void sendMessage(){
        EditText myEditText  = findViewById(R.id.editText);
        myDatabase.setValue(myEditText.getText().insert(12, "hello").toString());
        myEditText.setText("");

        EditText myEditText2 = findViewById(R.id.editText);
        myDatabase2.setValue(myEditText2.getText().toString());
        myEditText2.setText("");
    }

}
