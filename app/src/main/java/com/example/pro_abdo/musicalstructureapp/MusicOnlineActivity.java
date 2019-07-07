package com.example.pro_abdo.musicalstructureapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MusicOnlineActivity extends AppCompatActivity {

    /**
     * declare and initialize variable default equal 'Buy Now'
     *
     * [Buy Now] means this song is not free
     */
    private String buyMusicOnline = "Buy Now" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_song);

        final ArrayList<Song> musicOnline = new ArrayList<Song>();

        musicOnline.add(new Song(getString(R.string.amr_kol_hayate_name) , getString(R.string.amr_name) ,getString(R.string.amr_kol_hayate_time) , buyMusicOnline , R.drawable.amr_kol_hayate));
        musicOnline.add(new Song(getString(R.string.cimo_never_give_up_name) , getString(R.string.cimo_name) ,getString(R.string.cimo_never_give_up_time) , buyMusicOnline , R.drawable.cimo_never_give_up));
        musicOnline.add(new Song(getString(R.string.samo_zain_lo_omry_ergah_name) , getString(R.string.samo_zain_name) ,getString(R.string.samo_zain_lo_omry_ergah_time) , buyMusicOnline , R.drawable.samo_zain_lo_omry_ergah));
        musicOnline.add(new Song(getString(R.string.nancy_hassa_beek_name) , getString(R.string.nancy_name) ,getString(R.string.nancy_hassa_beek_time) , buyMusicOnline , R.drawable.nancy_hassa_beek));
        musicOnline.add(new Song(getString(R.string.justin_one_time_name) , getString(R.string.justin_name) ,getString(R.string.justin_one_time_time) , buyMusicOnline , R.drawable.justin_one_time));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the grid.
        // This grid item layout contains a three TextView and two ImageView , which the adapter will set to
        // display a single item for music online.
        GroupSongAdapter adapter = new GroupSongAdapter(this , musicOnline);

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

                Toast.makeText(MusicOnlineActivity.this, "downloading now....", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
