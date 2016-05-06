package com.example.graeme.blockpuzzle;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Statistics extends Activity {

    private Database dbHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        dbHelper = new Database(this);

        db = dbHelper.getReadableDatabase();

        Cursor cursorCount = db.rawQuery("SELECT *, COUNT(name) AS count FROM Scores GROUP BY name;", null);
        Cursor cursor = dbHelper.getAllCursor();

        ListView listViewCount = (ListView) findViewById(R.id.listViewDbCount);
        SimpleCursorAdapter adapterC = new SimpleCursorAdapter(this,
                R.layout.activity_dbcountview,
                cursorCount,
                new String[]{"name", "count"},
                new int[]{R.id.name, R.id.count},
                0);
        listViewCount.setAdapter(adapterC);

        ListView listView = (ListView) findViewById(R.id.listViewDb);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                R.layout.activity_dbview,
                cursor,
                new String[]{"name", "time", "date"},
                new int[]{R.id.name, R.id.time, R.id.date},
                0);
        listView.setAdapter(adapter);
    }
}
