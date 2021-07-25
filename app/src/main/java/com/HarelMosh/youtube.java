package com.HarelMosh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class youtube extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    static final String API_KEY ="AIzaSyD7ECCee0YqPdrRvHpJ6LPc26NURgjI22k";
    static final String VIDEO_KEY = "orJSJGHjBLI";
    static final String PLAYLIST_KEY = "PLMC9KNkIncKseYxDN2niH6glGRWKsLtde";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        ConstraintLayout constraintLayout = findViewById(R.id.activity_youtube);
        YouTubePlayerView playerView = new YouTubePlayerView(this);
        constraintLayout.addView(playerView);
        //setting height and width
        playerView.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        playerView.initialize(API_KEY,this);

    }
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.setPlaybackEventListener(playbackEventListener);
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        if (!b){
            youTubePlayer.cueVideo(VIDEO_KEY);
            youTubePlayer.play();
        }
        else{
            Toast.makeText(this,"ReConstructed",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        final int REQUEST_CODE =1;
        if(youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(this,REQUEST_CODE).show();
        }
        else{
            Toast.makeText(this,String.format("eror type: %s",youTubeInitializationResult.toString()),Toast.LENGTH_LONG).show();
        }
    }
    private YouTubePlayer.PlaybackEventListener playbackEventListener=new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {
            Toast.makeText(youtube.this,"played",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPaused() {
            Toast.makeText(youtube.this,"paused",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStopped() {
            Toast.makeText(youtube.this,"stoped",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onBuffering(boolean b) {
            Toast.makeText(youtube.this,"buffing",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onSeekTo(int i) {
            Toast.makeText(youtube.this,"seek",Toast.LENGTH_SHORT).show();
        }
    };
    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {
            Toast.makeText(youtube.this,"loading",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onLoaded(String s) {
            Toast.makeText(youtube.this,"loaded",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onAdStarted() {
            Toast.makeText(youtube.this,"ad",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onVideoStarted() {
            Toast.makeText(youtube.this,"video started",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onVideoEnded() {
            Toast.makeText(youtube.this,"video ended",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {
            Toast.makeText(youtube.this,"error",Toast.LENGTH_SHORT).show();
        }
    };
}