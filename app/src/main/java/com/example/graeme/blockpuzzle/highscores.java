package com.example.graeme.blockpuzzle;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class highscores extends Activity {

    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscores);

        //database code
        db = new Database(this);
        Cursor cursor = db.getAllCursor();

        ListView listView = (ListView) findViewById(R.id.listViewDb);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                R.layout.activity_dbview,
                cursor,
                new String[]{"name", "time", "date"},
                new int[]{R.id.name, R.id.time, R.id.date},
                0);
        listView.setAdapter(adapter);

        //cursor.close();
    }
}
