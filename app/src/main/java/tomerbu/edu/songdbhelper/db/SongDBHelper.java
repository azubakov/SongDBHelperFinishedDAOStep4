package tomerbu.edu.songdbhelper.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SongDBHelper extends SQLiteOpenHelper {

    //Constructor
    public SongDBHelper(Context context) {
        super(context, "SongDB", null, 1);
    }

    //Methods that we need to implement:
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createSongTable = "CREATE TABLE " +SongContract.Song.TABLE_NAME + "(" +
                                                        SongContract.Song.COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                                                        SongContract.Song.COL_TITLE + " TEXT NOT NULL, " +
                                                        SongContract.Song.COL_ARTIST + " TEXT, " +
                                                        SongContract.Song.COL_DURATION + " TEXT, " +
                                                        SongContract.Song.COL_IMAGE_URI + " TEXT " +
                                                    "); ";

        db.execSQL(createSongTable);
     }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropSongs = "DROP TABLE " + SongContract.Song.TABLE_NAME + ";";
        db.execSQL(dropSongs);

        onCreate(db);
    }
}