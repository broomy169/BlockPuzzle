package com.example.graeme.blockpuzzle;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Graeme on 19-Apr-16.
 */
public class Database extends SQLiteOpenHelper{

    private static int VERSION = 1;

    public Database(Context context) {
        super(context, "Scores", null, VERSION);
    }

    public Cursor getAllCursor() {
        return getReadableDatabase().rawQuery("SELECT * FROM Scores ORDER BY name;", null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Scores (_id INTEGER PRIMARY KEY, name TEXT, time INTEGER, date TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Scores;");
        onCreate(db);
    }


}