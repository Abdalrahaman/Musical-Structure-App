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

public class GroupSongAdapter extends ArrayAdapter<Song> {

    public GroupSongAdapter(Activity context, ArrayList<Song> songs) {

        super(context,0, songs);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View gridItemView = convertView;

        if(gridItemView == null) {
            gridItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.grid_item, parent, false);
        }

        Song currentGroupView = getItem(position);

        TextView songNameTextView = (TextView) gridItemView.findViewById(R.id.song_name);

        songNameTextView.setText(currentGroupView.getmSongName());


        TextView artistNameTextView = (TextView) gridItemView.findViewById(R.id.artist_name);

        artistNameTextView.setText(currentGroupView.getmArtistName());


        TextView buyMusicTextView = (TextView) gridItemView.findViewById(R.id.buy_music_online);
        /*
         * if current Group View (playlist , albums or music online item) is not free
         * : show 'Buy Now' TextView
         * else
         * : don't show 'Buy Now' TextView
         */
        if(currentGroupView.isMusicOnline()) {

            buyMusicTextView.setText(currentGroupView.getmBuyMusic());

            buyMusicTextView.setVisibility(View.VISIBLE);

        }else{

            buyMusicTextView.setVisibility(View.GONE);
        }


        // Find the ImageView in the grid_item.xml layout with the ID album_image
        ImageView albumView = (ImageView) gridItemView.findViewById(R.id.album_image);

        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to albumView
        albumView.setImageResource(currentGroupView.getmImageResourceId());


        return gridItemView;
    }

}
