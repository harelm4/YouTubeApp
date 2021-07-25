package com.HarelMosh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandAloneActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stand_alone);
        Button btnPlayVideo =findViewById(R.id.btnPlayVideo);
        Button btnPlayPlaylist = findViewById(R.id.btnPlayList);
        btnPlayPlaylist.setOnClickListener(this);
        btnPlayVideo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch(v.getId()){
            case R.id.btnPlayVideo:
                intent= YouTubeStandalonePlayer.createVideoIntent(this,youtube.API_KEY,youtube.VIDEO_KEY,0,true,false);
                break;
            case R.id.btnPlayList:
                intent=YouTubeStandalonePlayer.createPlaylistIntent(this,youtube.API_KEY,youtube.PLAYLIST_KEY,0,0,true,false);
                break;
        }
        if(intent!=null){
            startActivity(intent);
        }

    }
}
