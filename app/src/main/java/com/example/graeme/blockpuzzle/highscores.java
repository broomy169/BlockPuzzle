package com.example.graeme.blockpuzzle;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
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
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.activity_dbview,
                cursor, new String[]{"name, time"}, new int[]{R.id.name, R.id.time}, 0);
        listView.setAdapter(adapter);

        int count = cursor.getCount();

        System.out.println("Count: " + count);
        while (cursor.moveToNext()) {
            String name = cursor.getString(0);
            Double time = cursor.getDouble(1);
            System.out.println(String.format("%s %f", name, time));
        }
        cursor.close();

    }


}
