package com.example.pro_abdo.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlayListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_song);

        final ArrayList<Song> playList = new ArrayList<Song>();

        playList.add(new Song(getString(R.string.playlist_last_added) , getString(R.string.last_added_content) , R.drawable.album_default));
        playList.add(new Song(getString(R.string.playlist_record) , getString(R.string.record_content) , R.drawable.album_default));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the grid.
        // This grid item layout contains a two TextView and two ImageView , which the adapter will set to
        // display a single item for playlist.
        GroupSongAdapter adapter = new GroupSongAdapter(this , playList);

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

                TextView playlistContent = (TextView)view.findViewById(R.id.song_name);

                switch (playlistContent.getText().toString()){
                    // if chose 'Last added' open all songs
                    case "Last added":
                        Intent playListIntent = new Intent(PlayListActivity.this , SongsActivity.class);
                        startActivity(playListIntent);
                        break;
                    // if chose 'Recording' open recording
                    case "Recording":
                        Toast.makeText(PlayListActivity.this, "Show recording if exists", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });
    }
}
