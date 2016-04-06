package com.example.graeme.blockpuzzle;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class boatPuzzle extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boat_puzzle);

        ListView listView = (ListView) findViewById(R.id.listViewBoat);
        String menu[] = {"Blue Boat", "White Boat", "Red Boat"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_menu, menu);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:

                    case 1:

                    case 2:

                }
            }
        });
    }

}
