package com.example.android.mymusicapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Top10Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        // Create an array list of songs
        ArrayList<SongChoice> songs = new ArrayList<SongChoice>();

        songs.add(new SongChoice("Kill Bill", "SZA", R.drawable.sza_album));
        songs.add(new SongChoice("Made You Look", "Meghan Trainor", R.drawable.meghantrainor_album));
        songs.add(new SongChoice("Anti-Hero", "Taylor Swift", R.drawable.taylorswift_album));
        songs.add(new SongChoice("ANTIFRAGILE", "LE SSERAFIM", R.drawable.lesserafim_album));
        songs.add(new SongChoice("I Aint Worried", "OneRepublic", R.drawable.onerepublic_album));
        songs.add(new SongChoice("As It Was", "Harry Styles", R.drawable.harrystyles_album));
        songs.add(new SongChoice("Glimpse Of Us", "Joji", R.drawable.joji_album));
        songs.add(new SongChoice("Dandelions", "Ruth B.", R.drawable.ruthb_album));
        songs.add(new SongChoice("Ghost", "Justin Bieber", R.drawable.justinbieber_album));
        songs.add(new SongChoice("Left and Right", "Charlie Puth, Jung Kook BTS", R.drawable.charlieputh_album));

        SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Getting the song object position where user has clicked on
                SongChoice song = songs.get(position);

                // Create an intent to send the position details - song, artiste, image

                Intent nowPlayingIntent = new Intent(Top10Activity.this, NowPlayingActivity.class);
                nowPlayingIntent.putExtra("Song Title", song.getSongTitle());
                nowPlayingIntent.putExtra("Artiste", song.getArtiste());
                nowPlayingIntent.putExtra("Album Art", song.getImgResourceId());

                startActivity(nowPlayingIntent);
            }
        });
    }
}