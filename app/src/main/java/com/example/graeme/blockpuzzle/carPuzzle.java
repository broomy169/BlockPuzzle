package com.example.graeme.blockpuzzle;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Random;

public class carPuzzle extends ActionBarActivity {

    Intent intent = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_puzzle);

        ListView listView = (ListView) findViewById(R.id.listViewCar);
        String menu[] = {"Blue Car", "Gold Car", "Red Car"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_menu, menu);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        intent = new Intent(getApplicationContext(), carPuzzle1.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getApplicationContext(), carPuzzle2.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getApplicationContext(), carPuzzle3.class);
                        startActivity(intent);
                        break;
                }
            }
        });


    }
}
