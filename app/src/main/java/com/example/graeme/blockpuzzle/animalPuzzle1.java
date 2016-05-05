package com.example.graeme.blockpuzzle;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

public class animalPuzzle1 extends ActionBarActivity implements View.OnClickListener {

    private ImageView imageAnimalTLeft;
    private ImageView imageAnimalTRight;
    private ImageView imageAnimalBLeft;
    private ImageView imageAnimalBRight;

    private int count = 1;
    private int count2 = 2;
    private int count3 = 3;
    private int count4 = 0;

    //timing
    private long startTime;
    private long endTime;
    private long elapsed;
    private double duration;

    private SQLiteDatabase db;
    private Database dbHelper;

    private int[] images = {R.drawable.elephant_tleft, R.drawable.elephant_tright,
            R.drawable.elephant_bleft, R.drawable.elephant_bright};

    private ArrayList imageList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_puzzle1);

        dbHelper = new Database(this);

        imageAnimalTLeft = (ImageView) findViewById(R.id.imageAnimalTLeft);
        imageAnimalTRight = (ImageView) findViewById(R.id.imageAnimalTRight);
        imageAnimalBLeft = (ImageView) findViewById(R.id.imageAnimalBLeft);
        imageAnimalBRight = (ImageView) findViewById(R.id.imageAnimalBRight);

        imageAnimalTLeft.setOnClickListener(this);
        imageAnimalTRight.setOnClickListener(this);
        imageAnimalBLeft.setOnClickListener(this);
        imageAnimalBRight.setOnClickListener(this);

        for (int x : images) imageList.add(x);
        Collections.shuffle(imageList);

        imageAnimalTLeft.setImageResource((Integer) imageList.get(0));
        imageAnimalTRight.setImageResource((Integer) imageList.get(1));
        imageAnimalBLeft.setImageResource((Integer) imageList.get(2));
        imageAnimalBRight.setImageResource((Integer) imageList.get(3));
        //starts timer
        startTime = SystemClock.elapsedRealtime();

        System.out.println(startTime);
    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.imageAnimalTLeft:
                imageAnimalTLeft.setImageResource((Integer) imageList.get(count));

                if (count < imageList.size() -1) {
                    ++count;
                } else {
                    count = 0;
                }
                check();
                break;

            case R.id.imageAnimalTRight:
                imageAnimalTRight.setImageResource((Integer) imageList.get(count2));

                if (count2 < imageList.size() -1) {
                    ++count2;
                } else {
                    count2 = 0;
                }
                check();
                break;

            case R.id.imageAnimalBLeft:
                imageAnimalBLeft.setImageResource((Integer) imageList.get(count3));

                if (count3 < imageList.size() -1) {
                    ++count3;
                } else {
                    count3 = 0;
                }
                check();
                break;

            case R.id.imageAnimalBRight:
                imageAnimalBRight.setImageResource((Integer) imageList.get(count4));

                if (count4 < imageList.size() -1) {
                    ++count4;
                } else {
                    count4 = 0;
                }
                check();
                break;
        }

    }

    public void check(){
        
        if (imageAnimalTLeft.getDrawable().getConstantState().equals
                (getResources().getDrawable(R.drawable.elephant_tleft).getConstantState()) &&
                imageAnimalTRight.getDrawable().getConstantState().equals
                        (getResources().getDrawable(R.drawable.elephant_tright).getConstantState()) &&
                imageAnimalBLeft.getDrawable().getConstantState().equals
                        (getResources().getDrawable(R.drawable.elephant_bleft).getConstantState()) &&
                imageAnimalBRight.getDrawable().getConstantState().equals
                        (getResources().getDrawable(R.drawable.elephant_bright).getConstantState())) {


            //stops timer

            endTime = SystemClock.elapsedRealtime();
            System.out.println(endTime);
            elapsed = endTime - startTime;
            duration = elapsed / 1000.0;
            Log.i("GameOver", "Game Over");

            long date = System.currentTimeMillis();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
            String dateString = sdf.format(date);
            System.out.println("Date: " + dateString);

            db = dbHelper.getWritableDatabase();
            db.execSQL("INSERT INTO Scores (name, time, date) VALUES (\"Elephant\", " + duration + ", \"" + dateString + "\");");

            showPopup();
        } else {
            System.out.println("not working");
        }
    }


    public void showPopup() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("You have won!\n You have completed it in "+ duration + " seconds!");
        dialog.setTitle("Game Over");
        dialog.setPositiveButton("Back To Puzzles", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        dialog.setNegativeButton("Retry", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                startActivity(getIntent());
            }
        });
        dialog.setCancelable(false);
        dialog.create();
        dialog.show();

    }


}
