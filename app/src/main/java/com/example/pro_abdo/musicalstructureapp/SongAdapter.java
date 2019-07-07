package com.example.pro_abdo.musicalstructureapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    // position value for the song playing now to show music wave image
    private int mSongNowPlaying ;

    public SongAdapter(Activity context, ArrayList<Song> songs , int songNowPlaying) {

        super(context,0, songs);

        mSongNowPlaying = songNowPlaying ;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Song currentSongView = getItem(position);

        TextView songNameTextView = (TextView) listItemView.findViewById(R.id.song_name);

        songNameTextView.setText(currentSongView.getmSongName());


        TextView artistNameTextView = (TextView) listItemView.findViewById(R.id.artist_name);

        artistNameTextView.setText(currentSongView.getmArtistName());


        TextView songTimeTextView = (TextView) listItemView.findViewById(R.id.song_time);

        songTimeTextView.setText(currentSongView.getmSongTime());


        // Find the ImageView in the list_item.xml layout with the ID song_image
        ImageView songImageView = (ImageView) listItemView.findViewById(R.id.song_image);

        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to songImageView
        songImageView.setImageResource(currentSongView.getmImageResourceId());


        ImageView audioWave = (ImageView)listItemView.findViewById(R.id.audio_wave);
        /*
         * if song playing now and position value for view is equal position value for song playing now
         * : show 'audio Wave' ImageView
         * else
         * : don't show 'audio Wave' ImageView
         */
        if (mSongNowPlaying != -1 && mSongNowPlaying == position) {
            audioWave.setVisibility(View.VISIBLE);
        }else{
            audioWave.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
