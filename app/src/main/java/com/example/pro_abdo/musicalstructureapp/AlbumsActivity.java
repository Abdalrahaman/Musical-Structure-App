package com.example.pro_abdo.musicalstructureapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class AlbumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_song);

        final ArrayList<Song> albums = new ArrayList<Song>();

        albums.add(new Song(getString(R.string.tamer_album_name) , getString(R.string.tamer_name) , R.drawable.tamer_album));
        albums.add(new Song(getString(R.string.fazz_album_name) , getString(R.string.unknown_name) , R.drawable.fazz_album));
        albums.add(new Song(getString(R.string.brand_album_name) , getString(R.string.unknown_name) , R.drawable.album_default));
        albums.add(new Song(getString(R.string.sherine_album_name) , getString(R.string.sherine_name) , R.drawable.sherine_album));
        albums.add(new Song(getString(R.string.relax_album_name) , getString(R.string.unknown_name) , R.drawable.relax_album));
        albums.add(new Song(getString(R.string.audios_album_name) , getString(R.string.unknown_name) , R.drawable.album_default));
        albums.add(new Song(getString(R.string.brand_album_name) , getString(R.string.unknown_name) , R.drawable.album_default));


        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the grid.
        // This grid item layout contains a two TextView and two ImageView , which the adapter will set to
        // display a single item for album.
        GroupSongAdapter adapter = new GroupSongAdapter(this , albums);

        // Find the {@link GridView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link GridView} with the view ID called grid, which is declared in the
        // group_song file.
        GridView gridView = (GridView) findViewById(R.id.grid);

        // Make the {@link GridView} use the {@link ArrayAdapter} we created above, so that the
        // {@link GridView} will display grid items for each album in the list of albums.
        // Do this by calling the setAdapter method on the {@link GridView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter (adapter).
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Song song = albums.get(position);

                Intent nowPlayingIntent = new Intent(AlbumsActivity.this , NowPlayingActivity.class);
                nowPlayingIntent.putExtra("songName" , song.getmSongName());
                nowPlayingIntent.putExtra("artistName" , song.getmArtistName());
                //  converting resource image into Android Bitmap
                Bitmap bitmap = BitmapFactory.decodeResource(getResources() , song.getmImageResourceId()) ;
                // this value to send song image to show in NowPlayingActivity
                nowPlayingIntent.putExtra("songImage" , convertBitmapToByteArray(bitmap));

                startActivity(nowPlayingIntent);
            }
        });
    }

    public byte[] convertBitmapToByteArray(Bitmap bitmap){

        ByteArrayOutputStream bStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bStream);
        byte[] byteArray = bStream.toByteArray();
        return byteArray ;
    }
}
