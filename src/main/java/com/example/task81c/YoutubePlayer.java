package com.example.task81c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubePlayer extends YouTubeBaseActivity {

    YouTubePlayerView myYoutubePlayerView;
    YouTubePlayer.OnInitializedListener myOnInitializedListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_player);
        Intent intent = getIntent();
        String link = intent.getStringExtra("LINK");
        String neededLink = link.substring(32, link.length());
        myYoutubePlayerView = (YouTubePlayerView) findViewById(R.id.youTubePlayerView);

        myOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(neededLink);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        myYoutubePlayerView.initialize(YoutubeConfig.getApiKey(), myOnInitializedListener);

    }
}