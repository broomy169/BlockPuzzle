package com.example.graeme.blockpuzzle;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;

public class carPuzzle1 extends ActionBarActivity implements View.OnClickListener {

    private ImageView imageCarTLeft;
    private ImageView imageCarTRight;
    private ImageView imageCarBLeft;
    private ImageView imageCarBRight;

    private int[] images = {R.drawable.blue_car_tleft, R.drawable.blue_car_tright,
                            R.drawable.blue_car_bleft, R.drawable.blue_car_bright};



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

    }

    public int count = 1;
    public int count2 = 2;
    public int count3 = 3;
    public int count4 = 0;

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.imageCarTLeft:
                imageCarTLeft.setImageResource(images[count]);
                if (count < images.length - 1) {
                    ++count;
                } else {
                    count = 0;
                }
                break;

            case R.id.imageCarTRight:
                imageCarTRight.setImageResource(images[count2]);
                if (count2 < images.length - 1) {
                    ++count2;
                } else {
                    count2 = 0;
                }
                break;

            case R.id.imageCarBLeft:
                imageCarBLeft.setImageResource(images[count3]);
                if (count3 < images.length - 1) {
                    ++count3;
                } else {
                    count3 = 0;
                }
                break;

            case R.id.imageCarBRight:
                imageCarBRight.setImageResource(images[count4]);
                if (count4 < images.length - 1) {
                    ++count4;
                } else {
                    count4 = 0;
                }
                break;
        }

    }




}
