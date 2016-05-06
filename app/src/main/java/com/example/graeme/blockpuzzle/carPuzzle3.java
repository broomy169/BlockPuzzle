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

public class carPuzzle3 extends ActionBarActivity implements View.OnClickListener {

    private ImageView imageCarTLeft;
    private ImageView imageCarTRight;
    private ImageView imageCarBLeft;
    private ImageView imageCarBRight;

    private int count = 1;
    private int count2 = 2;
    private int count3 = 3;
    private int count4 = 0;

    private long startTime;
    private long endTime;
    private long elapsed;
    private double duration;

    private SQLiteDatabase db;
    private Database dbHelper;

    private int[] images = {R.drawable.red_car_tleft, R.drawable.red_car_tright,
            R.drawable.red_car_bleft, R.drawable.red_car_bright};

    private ArrayList imageList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_puzzle3);

        dbHelper = new Database(this);

        imageCarTLeft = (ImageView) findViewById(R.id.imageCarTLeft);
        imageCarTRight = (ImageView) findViewById(R.id.imageCarTRight);
        imageCarBLeft = (ImageView) findViewById(R.id.imageCarBLeft);
        imageCarBRight = (ImageView) findViewById(R.id.imageCarBRight);

        imageCarTLeft.setOnClickListener(this);
        imageCarTRight.setOnClickListener(this);
        imageCarBLeft.setOnClickListener(this);
        imageCarBRight.setOnClickListener(this);

        for (int x : images) imageList.add(x);
        Collections.shuffle(imageList);

        imageCarTLeft.setImageResource((Integer) imageList.get(0));
        imageCarTRight.setImageResource((Integer) imageList.get(1));
        imageCarBLeft.setImageResource((Integer) imageList.get(2));
        imageCarBRight.setImageResource((Integer) imageList.get(3));

        startTime = SystemClock.elapsedRealtime();

        System.out.println(startTime);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageCarTLeft:
                imageCarTLeft.setImageResource((Integer) imageList.get(count));

                if (count < imageList.size() -1) {
                    ++count;
                } else {
                    count = 0;
                }
                check();
                break;

            case R.id.imageCarTRight:
                imageCarTRight.setImageResource((Integer) imageList.get(count2));

                if (count2 < imageList.size() -1) {
                    ++count2;
                } else {
                    count2 = 0;
                }
                check();
                break;

            case R.id.imageCarBLeft:
                imageCarBLeft.setImageResource((Integer) imageList.get(count3));

                if (count3 < imageList.size() -1) {
                    ++count3;
                } else {
                    count3 = 0;
                }
                check();
                break;

            case R.id.imageCarBRight:
                imageCarBRight.setImageResource((Integer) imageList.get(count4));

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

        System.out.println("Comparing: " + (imageCarTLeft.getDrawable() ==
                getResources().getDrawable(R.drawable.red_car_tleft)));
        if (imageCarTLeft.getDrawable().getConstantState().equals
                (getResources().getDrawable(R.drawable.red_car_tleft).getConstantState()) &&
                imageCarTRight.getDrawable().getConstantState().equals
                        (getResources().getDrawable(R.drawable.red_car_tright).getConstantState()) &&
                imageCarBLeft.getDrawable().getConstantState().equals
                        (getResources().getDrawable(R.drawable.red_car_bleft).getConstantState()) &&
                imageCarBRight.getDrawable().getConstantState().equals
                        (getResources().getDrawable(R.drawable.red_car_bright).getConstantState())) {

            endTime = SystemClock.elapsedRealtime();
            System.out.println(endTime);
            elapsed = endTime - startTime;
            duration = elapsed / 1000.0;
            Log.i("GameOver", "Game Over");

            long date = System.currentTimeMillis();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy k:m a");
            String dateString = sdf.format(date);
            System.out.println("Date: " + dateString);

            db = dbHelper.getWritableDatabase();
            db.execSQL("INSERT INTO Scores (name, time, date) VALUES (\"Red Car\", " + duration + ", \"" + dateString + "\");");

            showPopup();
        } else {
            System.out.println("not working");
        }
    }

    public void showPopup() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("You have won!\n You have completed it in " + duration + " seconds!");
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