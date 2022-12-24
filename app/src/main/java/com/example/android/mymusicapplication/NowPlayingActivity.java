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

        // Get intent that was sent from various activity pages eg. Favourites, Rewind, Top10
        Intent intent = getIntent();

        // Store the Extras sent from the activity pages into variables
        int albumPic = intent.getIntExtra("Album Art", 0);
        String songTitle = intent.getStringExtra("Song Title");
        String singer = intent.getStringExtra("Artiste");

        // Find the Ids on the XML page to display the variables sent from intent
        ImageView albumArt = findViewById(R.id.nowplaying_art);
        TextView song = findViewById(R.id.nowplaying_song);
        TextView artiste = findViewById(R.id.nowplaying_artiste);

        albumArt.setImageResource(albumPic);
        song.setText(songTitle);
        artiste.setText(singer);

    }
}