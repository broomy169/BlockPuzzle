package com.example.graeme.blockpuzzle;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Graeme on 19-Apr-16.
 */
public class Database extends SQLiteOpenHelper{

    public Database(Context context) {
        super(context, "PuzzleData", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        setup(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        setup(db);
    }

    private void setup(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS Car_Scores;");
        db.execSQL("CREATE TABLE Car_Scores (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, time DOUBLE);");

        db.execSQL("INSERT INTO Car_Scores (name, time) VALUES (\"Blue Car\", 6.9);");
        db.execSQL("INSERT INTO Car_Scores (name, time) VALUES (\"Blue Car\", 9.6);");
    }

    public Cursor getAllCursor() {
        return getReadableDatabase().rawQuery("SELECT * FROM Car_Scores;", null);
    }


}
