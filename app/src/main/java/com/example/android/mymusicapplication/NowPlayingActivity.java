package com.example.android.mymusicapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        Intent intent = getIntent();
        int albumPic = intent.getIntExtra("Album Art", 0);
        String songTitle = intent.getStringExtra("Song Title");
        String singer = intent.getStringExtra("Artiste");

        ImageView albumArt = findViewById(R.id.nowplaying_art);
        TextView song = findViewById(R.id.nowplaying_song);
        TextView artiste = findViewById(R.id.nowplaying_artiste);

        albumArt.setImageResource(albumPic);
        song.setText(songTitle);
        artiste.setText(singer);

    }
}