package com.example.android.mymusicapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<SongChoice> {

    public SongAdapter(Activity context, ArrayList<SongChoice> songs) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        SongChoice currentSong = getItem(position);

        // Check if the existing view is being reused, otherwise inflate the view
        // null is when a screen was first loaded (never cached)
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.playlist, parent, false); // Inflater translates XML files to actual view objects
        }

        TextView songTextView = (TextView) listItemView.findViewById(R.id.song_title);
        songTextView.setText(currentSong.getSongTitle());

        TextView artisteTextView = (TextView) listItemView.findViewById(R.id.artiste);
        artisteTextView.setText(currentSong.getArtiste());

        ImageView albumImage = (ImageView) listItemView.findViewById(R.id.album_image);
        albumImage.setImageResource(currentSong.getImgResourceId());

        /*if (currentSong.hasImage()) {
            // Set the ImageView to the image resource specified in the current Word
            albumImage.setImageResource(currentSong.getImgResourceId());
            albumImage.setVisibility(View.VISIBLE);
        }

        else {
            // GONE = Image is hidden and doesn't take up any space on the View
            miwokImage.setVisibility(View.GONE);
        }*/
        return listItemView;
    }
}
