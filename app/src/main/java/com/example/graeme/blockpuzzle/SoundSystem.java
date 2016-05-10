package com.example.graeme.blockpuzzle;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Looper;
import android.util.Log;

import java.util.logging.Handler;

/**
 * Created by Graeme on 10-May-16.
 */
public class SoundSystem {
    private SoundPool soundPool;

    private boolean ready;
    private int count;
    private static int MAX_COUNT = 10;

    private Looper looper;
    private android.os.Handler handler;

    public int elephantID;
    public int elkID;
    public int owlID;
    public int bluecarID;
    public int redcarID;
    public int goldcarID;
    public int completedID;

    private class LooperThread extends Thread {
        @Override
        public void run(){
            try {
                Looper.prepare();
                looper = Looper.myLooper();
                Looper.loop();
            } catch (Throwable t) {
                Log.w("SoundSystem", "looper terminated...");
            }
        }
    }

    public SoundSystem(Context context) {
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, MAX_COUNT);

        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                ready = true;
            }
        });

        elephantID = soundPool.load(context, R.raw.elephant_sound,1);
        elkID = soundPool.load(context, R.raw.elk_sound,1);
        owlID = soundPool.load(context, R.raw.owl_sound,1);
        redcarID = soundPool.load(context, R.raw.redcar_sound,1);
        bluecarID = soundPool.load(context, R.raw.bluecar_sound,1);
        goldcarID = soundPool.load(context, R.raw.goldcar_sound,1);
        completedID = soundPool.load(context, R.raw.completed_sound,1);
    }

    public void start(){
        LooperThread thread = new LooperThread();
        thread.start();
    }

    public void stop(){
        looper.quit();
    }

    public void play(final int sampleID){
        if (ready) {
            soundPool.play(sampleID, 1, 1, 1, 0, 1);
        }
    }
}
