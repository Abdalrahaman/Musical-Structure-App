package com.example.pro_abdo.musicalstructureapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {

    /**
     * declare and initialize variable default equal -1
     *
     * [-1] means No song is playing now
     *
     * This variable knows me what song is currently playing now by the position value
     *
     */

    int songNowPlaying = -1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        // get intent with position song value
        Intent intent = getIntent();

        if(intent != null){
            songNowPlaying = intent.getIntExtra("songNowPlaying" , -1);
        }

        final ArrayList<Song> songs = new ArrayList<Song>();

        songs.add(new Song(getString(R.string.tamer_omry_ebtada_name) , getString(R.string.tamer_name) , getString(R.string.tamer_omry_ebtada_time) , R.drawable.tamer_omry_ebtada));
        songs.add(new Song(getString(R.string.sherine_forsa_ahera_name) , getString(R.string.sherine_name) , getString(R.string.sherine_forsa_ahera_time) , R.drawable.sherine_forsa_ahera));
        songs.add(new Song(getString(R.string.delacey_dream_it_possible_name) , getString(R.string.delacey_name) , getString(R.string.delacey_dream_it_possible_time) , R.drawable.delacey_dream_it_possible));
        songs.add(new Song(getString(R.string.tamer_hes_bsoak_name) , getString(R.string.tamer_name) , getString(R.string.tamer_hes_bsoak_time) , R.drawable.tamer_hes_bsoak));
        songs.add(new Song(getString(R.string.unknown_relax_name) , getString(R.string.unknown_name) , getString(R.string.unknown_relax_time) , R.drawable.relax_album));
        songs.add(new Song(getString(R.string.sherine_mashair_name) , getString(R.string.sherine_name) , getString(R.string.sherine_mashair_time) , R.drawable.sherine_mashair));
        songs.add(new Song(getString(R.string.pimms_brighter_day_name) , getString(R.string.pimms_name) , getString(R.string.pimms_brighter_day_time) , R.drawable.pimms_brighter_day));
        songs.add(new Song(getString(R.string.cimo_never_give_up_name) , getString(R.string.cimo_name) , getString(R.string.cimo_never_give_up_time) , R.drawable.cimo_never_give_up));
        songs.add(new Song(getString(R.string.tamer_tman_ehtear_name) , getString(R.string.tamer_name) , getString(R.string.tamer_tman_ehtear_time) , R.drawable.tamer_tman_ekhtiar));
        songs.add(new Song(getString(R.string.sherine_taira_men_elfarha_name) , getString(R.string.sherine_name) , getString(R.string.sherine_taira_men_elfarha_time) , R.drawable.sherine_taira_men_elfarha));
        songs.add(new Song(getString(R.string.cimo_armin_van_buuren_name) , getString(R.string.cimo_name) , getString(R.string.cimo_armin_van_buuren_time) , R.drawable.cimo_armin_van_buuren));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list.
        // This list item layout contains a three TextView and two ImageView , which the adapter will set to
        // display a single item for song.
        SongAdapter adapter = new SongAdapter(this , songs , songNowPlaying);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_songs file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each song in the list of songs.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter (adapter).
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Song song = songs.get(position);

                Intent nowPlayingIntent = new Intent(SongsActivity.this , NowPlayingActivity.class);
                nowPlayingIntent.putExtra("songName" , song.getmSongName());
                nowPlayingIntent.putExtra("artistName" , song.getmArtistName());
                nowPlayingIntent.putExtra("songTime" , song.getmSongTime());
                //  converting resource image into Android Bitmap
                Bitmap bitmap = BitmapFactory.decodeResource(getResources() , song.getmImageResourceId()) ;
                // this value to send song image to show in NowPlayingActivity
                nowPlayingIntent.putExtra("songImage" , convertBitmapToByteArray(bitmap));
                // this value to know what song playing now
                nowPlayingIntent.putExtra("nowPlaying" , position);
                // this value to know that this intent sent from this Activity (SongActivity)
                nowPlayingIntent.putExtra("songNowPlaying" , "fromSongActivity");

                startActivity(nowPlayingIntent);

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);
    }

    public byte[] convertBitmapToByteArray(Bitmap bitmap){

        ByteArrayOutputStream bStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bStream);
        byte[] byteArray = bStream.toByteArray();
        return byteArray ;
    }
}
