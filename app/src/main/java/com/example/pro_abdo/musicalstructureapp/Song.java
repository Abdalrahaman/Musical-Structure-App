package com.example.pro_abdo.musicalstructureapp;

public class Song {

    private String mSongName ;
    private String mArtistName ;
    private String mSongTime ;
    private int mImageResourceId ;
    private String mBuyMusic = No_Buy_Provided ;
    private static final String No_Buy_Provided = "free" ;



    public Song() {
    }

    public Song(String songName , String artistName, int imageResourceId) {

        this.mSongName = songName ;
        this.mArtistName = artistName ;
        this.mImageResourceId = imageResourceId ;
    }

    public Song(String songName , String artistName , String songTime , int imageResourceId) {

        this.mSongName = songName ;
        this.mArtistName = artistName ;
        this.mSongTime = songTime ;
        this.mImageResourceId = imageResourceId ;
    }

    public Song(String songName , String artistName , String songTime , String buyMusic , int imageResourceId) {

        this.mSongName = songName ;
        this.mArtistName = artistName ;
        this.mSongTime = songTime ;
        this.mBuyMusic = buyMusic ;
        this.mImageResourceId = imageResourceId ;
    }

    public String getmSongName() {
        return mSongName;
    }

    public String getmArtistName() {
        return mArtistName;
    }

    public String getmSongTime() {
        return mSongTime;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public String getmBuyMusic() {
        return mBuyMusic;
    }

    public boolean isMusicOnline(){

        return !No_Buy_Provided.equals(mBuyMusic) ;
    }

}
