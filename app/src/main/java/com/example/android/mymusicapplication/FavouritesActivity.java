package com.example.android.mymusicapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FavouritesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        // Create an array list of songs
        ArrayList<SongChoice> songs = new ArrayList<SongChoice>();

        songs.add(new SongChoice("Gone", "ROSÉ", R.drawable.rose_album));
        songs.add(new SongChoice("Happier Than Ever", "Billie Eilish", R.drawable.billie_eilish_album));
        songs.add(new SongChoice("right here", "keshi", R.drawable.keshi_album));
        songs.add(new SongChoice("Memories", "Conan Gray", R.drawable.conangray_album));
        songs.add(new SongChoice("Mean It", "Lauv, LANY", R.drawable.lauv_album));
        songs.add(new SongChoice("I Like U", "NIKI", R.drawable.niki_album));
        songs.add(new SongChoice("This Is Gospel", "Panic! At The Disco", R.drawable.panic_album));
        songs.add(new SongChoice("Lost In Japan", "Shawn Mendes", R.drawable.shawnmendes_album));

        SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Getting the song object position where user has clicked on
                SongChoice song = songs.get(position);

                // Create an intent to send the position details - song, artiste, image
                Intent nowPlayingIntent = new Intent(FavouritesActivity.this, NowPlayingActivity.class);
                nowPlayingIntent.putExtra("Song Title", song.getSongTitle());
                nowPlayingIntent.putExtra("Artiste", song.getArtiste());
                nowPlayingIntent.putExtra("Album Art", song.getImgResourceId());

                startActivity(nowPlayingIntent);
            }
        });

    }
}