package com.example.android.mymusicapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class RewindActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        // Create an array list of songs
        ArrayList<SongChoice> songs = new ArrayList<SongChoice>();

        songs.add(new SongChoice("Dilemma", "Nelly ft. Kelly Roland", R.drawable.nelly_album));
        songs.add(new SongChoice("My Boo", "Usher ft. Alicia Keys", R.drawable.usher_album));
        songs.add(new SongChoice("U Make Me Wanna", "Blue", R.drawable.blue_album));
        songs.add(new SongChoice("End Of The Road", "Boyz II Men", R.drawable.boyz2men_album));

        SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Getting the song object position where user has clicked on
                SongChoice song = songs.get(position);

                // Create an intent to send the position details - song, artiste, image
                Intent nowPlayingIntent = new Intent(RewindActivity.this, NowPlayingActivity.class);
                nowPlayingIntent.putExtra("Song Title", song.getSongTitle());
                nowPlayingIntent.putExtra("Artiste", song.getArtiste());
                nowPlayingIntent.putExtra("Album Art", song.getImgResourceId());

                startActivity(nowPlayingIntent);
            }
        });
    }
}