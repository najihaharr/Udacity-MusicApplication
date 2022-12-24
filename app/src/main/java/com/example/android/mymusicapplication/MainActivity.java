package com.example.android.mymusicapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the view that shows the Favourites category
        TextView favourites = (TextView) findViewById(R.id.category_favourites);

        // Set a clicklistener on that View
        favourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent favouritesIntent = new Intent(MainActivity.this, FavouritesActivity.class);
                startActivity(favouritesIntent);
            }
        });

        TextView top10 = (TextView) findViewById(R.id.category_top10);

        // Set a clicklistener on that View
        top10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent top10Intent = new Intent(MainActivity.this, Top10Activity.class);
                startActivity(top10Intent);
            }
        });

        TextView rewindCategory = (TextView) findViewById(R.id.category_rewind);

        // Set a clicklistener on that View
        rewindCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent rewindIntent = new Intent(MainActivity.this, RewindActivity.class);
                startActivity(rewindIntent);
            }
        });
    }
}