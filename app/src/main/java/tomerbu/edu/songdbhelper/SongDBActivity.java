package tomerbu.edu.songdbhelper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import tomerbu.edu.songdbhelper.db.SongContract;
import tomerbu.edu.songdbhelper.db.SongDAO;
import tomerbu.edu.songdbhelper.db.SongDBHelper;
import tomerbu.edu.songdbhelper.models.Song;

public class SongDBActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    SongDAO dao;
    private EditText etTitle;
    private EditText etArtist;
    private EditText etDuration;
    private EditText etImageURI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_db);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dao = new SongDAO(this);
        findViews();

    }

    private void findViews() {
        etTitle = (EditText) findViewById(R.id.etSongName);
        etArtist = (EditText) findViewById(R.id.etArtist);
        etDuration = (EditText) findViewById(R.id.etDuration);
        etImageURI = (EditText) findViewById(R.id.etImageURI);
        fab = (FloatingActionButton) findViewById(R.id.fab);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_song_db, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void insert(View view) {
        if (!isValidInput())
            return;
        Song song = new Song(getSongTitle(),getArtist(), getDuration(), getImageURI());
        long insertedID = dao.insert(song);
        Toast.makeText(SongDBActivity.this, "" + insertedID, Toast.LENGTH_SHORT).show();
        clearEditexts();
    }

    private void clearEditexts() {
        etImageURI.setText("");
        etDuration.setText("");
        etArtist.setText("");
        etTitle.setText(null);
    }


    public String getSongTitle(){
        return etTitle.getText().toString();
    }

    public String getArtist(){
        return etArtist.getText().toString();
    }

    public String getDuration(){
        return etDuration.getText().toString();
    }

    public String getImageURI(){
        return etImageURI.getText().toString();
    }

    public void query(View view) {
        ArrayList<Song> songs = dao.queryByTitle(getSongTitle());
        for (Song s : songs) {
            Toast.makeText(SongDBActivity.this, s.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void update(View view) {
        Song song = new Song(getSongTitle(),getArtist(), getDuration(), getImageURI());
        int rowsAffected = dao.update("5", song);
        Toast.makeText(SongDBActivity.this, ""  + rowsAffected, Toast.LENGTH_SHORT).show();
        clearEditexts();
    }

    public void delete(View view) {
        int rowsAffected = dao.delete("6");
        Toast.makeText(SongDBActivity.this, "" + rowsAffected, Toast.LENGTH_SHORT).show();
    }

    public boolean isValidInput() {
        boolean etTitleValid = getSongTitle().length() >= 2;

        if (!etTitleValid){
            etTitle.setError("Title Must be at least 2 characters Long");
        }

        return etTitleValid;
    }
}
