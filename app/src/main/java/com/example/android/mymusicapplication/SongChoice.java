package com.example.android.mymusicapplication;

public class SongChoice {

    private String mArtiste;
    private String mSongTitle;
    private int mImgResourceId = NO_IMAGE_PROVIDED;

    // -1 because its out of the range of all the possible valid resource ID
    private static final int NO_IMAGE_PROVIDED = -1;

    public SongChoice (String songTitle, String artiste, int imageId) {
        mArtiste = artiste;
        mSongTitle = songTitle;
        mImgResourceId = imageId;
    }

    public String getSongTitle() {
        return mSongTitle;
    }

    public String getArtiste() {
        return mArtiste;
    }

    public int getImgResourceId() {
        return mImgResourceId;
    }
}
