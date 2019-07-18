package com.nada.psikologiku.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.nada.psikologiku.model.History;

import java.util.LinkedList;
import java.util.List;

public class SQLiteDatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "psikologiku";
    private static final String TABLE_NAME = "riwayat";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "nama";
    private static final String KEY_KLASIFIKASI = "klasifikasi";
    private static final String KEY_METODE = "metode";
    private static final String[] COLUMNS = { KEY_ID, KEY_NAME, KEY_KLASIFIKASI,
            KEY_METODE };

    public SQLiteDatabaseHandler( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATION_TABLE = "CREATE TABLE riwayat ( "
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "nama TEXT, "
                + "klasifikasi TEXT, " + "metode TEXT )";

        db.execSQL(CREATION_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);

    }

    public History getPlayer(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, // a. table
                COLUMNS, // b. column names
                " id = ?", // c. selections
                new String[] { String.valueOf(id) }, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        if (cursor != null)
            cursor.moveToFirst();

        History player = new History();
        player.setId(Integer.parseInt(cursor.getString(0)));
        player.setNama(cursor.getString(1));
        player.setHasilKlasifikasi(cursor.getString(2));
        player.setMetode(cursor.getString(3));

        return player;
    }

    public List<History> allPlayers() {

        List<History> histories = new LinkedList<History>();
        String query = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        History history = null;

        if (cursor.moveToFirst()) {
            do {
                history = new History();
                history.setId(Integer.parseInt(cursor.getString(0)));
                history.setNama(cursor.getString(1));
                history.setHasilKlasifikasi(cursor.getString(2));
                history.setMetode(cursor.getString(3));
                histories.add(history);
            } while (cursor.moveToNext());
        }

        return histories;
    }

    public void addHistory(History history) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, history.getNama());
        values.put(KEY_KLASIFIKASI, history.getHasilKlasifikasi());
        values.put(KEY_METODE, history.getMetode());
        // insert
        db.insert(TABLE_NAME,null, values);
        db.close();
    }
}
