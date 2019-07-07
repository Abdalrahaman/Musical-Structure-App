package com.example.pro_abdo.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout playList = (LinearLayout) findViewById(R.id.ly_playlist);

        // Set a click listener on that view group
        playList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent playListIntent = new Intent(MainActivity.this , PlayListActivity.class);

                startActivity(playListIntent);
            }
        });


        LinearLayout albums = (LinearLayout) findViewById(R.id.ly_albums);

        // Set a click listener on that view group
        albums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent albumsIntent = new Intent(MainActivity.this , AlbumsActivity.class);

                startActivity(albumsIntent);

            }
        });


        LinearLayout songs = (LinearLayout) findViewById(R.id.ly_songs);

        // Set a click listener on that view group
        songs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent songsIntent = new Intent(MainActivity.this , SongsActivity.class);

                startActivity(songsIntent);

            }
        });


        LinearLayout musicOnline = (LinearLayout) findViewById(R.id.ly_music_online);

        // Set a click listener on that view group
        musicOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent musicOnlineIntent = new Intent(MainActivity.this , MusicOnlineActivity.class);

                startActivity(musicOnlineIntent);

            }
        });
    }
}
