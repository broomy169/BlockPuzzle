package com.example.graeme.blockpuzzle;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class carPuzzle1 extends ActionBarActivity implements View.OnClickListener {

    private ImageView imageCarTLeft;
    private ImageView imageCarTRight;
    private ImageView imageCarBLeft;
    private ImageView imageCarBRight;

    public int count = 1;
    public int count2 = 2;
    public int count3 = 3;
    public int count4 = 0;

    private int[] images = {R.drawable.blue_car_tleft, R.drawable.blue_car_tright,
            R.drawable.blue_car_bleft, R.drawable.blue_car_bright};

    private int[] secret = {1,2,3,4};


    private ArrayList imageList = new ArrayList();

    private int[] imageCheck = {0, 0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_puzzle1);

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

        //get name to compare with
        System.out.println(getResources().getResourceEntryName(R.drawable.blue_car_bleft));

        imageCarTLeft.setImageResource((Integer) imageList.get(0));
        imageCheck[0] = (Integer) imageList.get(0);
        imageCarTRight.setImageResource((Integer) imageList.get(1));
        imageCheck[1] = (Integer) imageList.get(1);
        imageCarBLeft.setImageResource((Integer) imageList.get(2));
        imageCheck[2] = (Integer) imageList.get(2);
        imageCarBRight.setImageResource((Integer) imageList.get(3));
        imageCheck[3] = (Integer) imageList.get(3);

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

                imageCheck[0] = (Integer) imageList.get(count);

                System.out.println("Image: " + Arrays.toString(images));
                System.out.println("Image Check: " + Arrays.toString(imageCheck));
                check();
                break;

            case R.id.imageCarTRight:
                imageCarTRight.setImageResource((Integer) imageList.get(count2));

                if (count2 < imageList.size() -1) {
                    ++count2;
                } else {
                    count2 = 0;
                }

                imageCheck[1] = (Integer) imageList.get(count2);
                System.out.println("Image:" + Arrays.toString(images));
                System.out.println("Image Check:" + Arrays.toString(imageCheck));
                check();
                break;

            case R.id.imageCarBLeft:
                imageCarBLeft.setImageResource((Integer) imageList.get(count3));

                if (count3 < imageList.size() -1) {
                    ++count3;
                } else {
                    count3 = 0;
                }

                imageCheck[2] = (Integer) imageList.get(count3);
                System.out.println("Image:" + Arrays.toString(images));
                System.out.println("Image Check:" + Arrays.toString(imageCheck));
                check();
                break;

            case R.id.imageCarBRight:
                imageCarBRight.setImageResource((Integer) imageList.get(count4));

                if (count4 < imageList.size() -1) {
                    ++count4;
                } else {
                    count4 = 0;
                }

                imageCheck[3] = (Integer) imageList.get(count4);
                System.out.println("Image:" + Arrays.toString(images));
                System.out.println("Image Check:" + Arrays.toString(imageCheck));
                check();
                break;
        }

    }

    public void check(){
        if (Arrays.equals(imageCheck, images)) {
            Toast toast = Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            System.out.println("Try Again");
        }
    }

}
