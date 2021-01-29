package com.example.sliderpager.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.example.sliderpager.R;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

public class MoviePlayerActivity extends AppCompatActivity {

    private SimpleExoPlayer simpleExoPlayer;
    private PlayerView playerView;
    public static final String TEST_URL="https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&cad=rja&uact=8&ved=2ahUKEwiqrdOd4cbrAhUHz4UKHT-fBRUQwqsBMAB6BAgIEAQ&url=https%3A%2F%2Fwww.youtube.com%2Fwatch%3Fv%3DJ9u4Wr8S5Pk&usg=AOvVaw0JYki7JYC20NLlwchtkrhh";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_player);

        initPlayer();

    }

    private void initPlayer() {
        playerView=findViewById(R.id.movie_exo_player);
        simpleExoPlayer= ExoPlayerFactory.newSimpleInstance(this);
        playerView.setPlayer(simpleExoPlayer);

        DataSource.Factory dataSourceFactory= new DefaultDataSourceFactory(this,
                Util.getUserAgent(this,"appName"));

        MediaSource videoSource=new ExtractorMediaSource.Factory(dataSourceFactory)
                .createMediaSource(Uri.parse(TEST_URL));
        simpleExoPlayer.prepare(videoSource);
        simpleExoPlayer.setPlayWhenReady(true);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        simpleExoPlayer.release();
    }
}