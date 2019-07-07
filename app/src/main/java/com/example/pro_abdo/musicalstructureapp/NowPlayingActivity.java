package com.example.pro_abdo.musicalstructureapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    private LinearLayout albums ;

    private TextView songNameTextView ;
    private TextView artistNameTextView ;
    private TextView songTimeTextView ;
    private ImageView songImageView ;
    private ImageView songListImageView ;

    int nowPlayingPosition = -1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        albums = (LinearLayout)findViewById(R.id.ly_album);

        songNameTextView = (TextView)findViewById(R.id.song_name);
        artistNameTextView = (TextView)findViewById(R.id.artist_name);
        songTimeTextView = (TextView)findViewById(R.id.song_time);
        songImageView = (ImageView)findViewById(R.id.song_image);
        songListImageView = (ImageView)findViewById(R.id.iv_songs);

        Intent songInfo = getIntent();

        if(songInfo != null) {

            if("fromSongActivity".equals(songInfo.getStringExtra("songNowPlaying"))) {

                songNameTextView.setText(songInfo.getStringExtra("songName"));
                artistNameTextView.setText(songInfo.getStringExtra("artistName"));
                songTimeTextView.setText(songInfo.getStringExtra("songTime"));
                nowPlayingPosition = songInfo.getIntExtra("nowPlaying" , -1);

                Bitmap bmp;

                byte[] byteArray = songInfo.getByteArrayExtra("songImage");
                bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

                songImageView.setImageBitmap(bmp);

                // LinearLayout images invisible
                albums.setVisibility(View.INVISIBLE);

            }else{

                songNameTextView.setText(songInfo.getStringExtra("songName"));
                artistNameTextView.setText(songInfo.getStringExtra("artistName"));

                Bitmap bmp;

                byte[] byteArray = songInfo.getByteArrayExtra("songImage");
                bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

                songImageView.setImageBitmap(bmp);

                // LinearLayout images visible
                albums.setVisibility(View.VISIBLE);

            }

        }

        songListImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent songsIntent = new Intent(NowPlayingActivity.this , SongsActivity.class);
                songsIntent.putExtra("songNowPlaying" , nowPlayingPosition);
                startActivity(songsIntent);

            }
        });


    }

}
