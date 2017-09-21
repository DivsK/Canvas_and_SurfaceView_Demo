package com.kellton.canvasandsurfaceview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class SufaceViewActivity extends AppCompatActivity implements View.OnTouchListener {

    private OurView mOurView;
    private String TAG = SufaceViewActivity.class.getSimpleName();
    private Bitmap mBitmap;
    private float x;
    private float y;
    private boolean play=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_suface_view);

        mOurView = new OurView(this);
        mOurView.setOnTouchListener(this);

        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.iv);
        x = y = 0;

        setContentView(mOurView);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        try {
            Thread.sleep(50);
            Log.e(TAG, "Thread put to sleep in OnTouch------");
        } catch (InterruptedException e) {
            Log.e(TAG, "thread sleep error", e);
        }
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x = motionEvent.getX();
                y = motionEvent.getY();
                Log.e(TAG, "MotionEvent.ACTION_DOWN-----");
                break;
            case MotionEvent.ACTION_UP:
                x = motionEvent.getX();
                y = motionEvent.getY();
                Log.e(TAG, "MotionEvent.ACTION_UP----");
                break;
            case MotionEvent.ACTION_MOVE:
                x = motionEvent.getX();
                y = motionEvent.getY();
                Log.e(TAG, "MotionEvent.ACTION_MOVE-----");
                break;
        }
        return true;
    }

    public class OurView extends SurfaceView implements Runnable {
        Thread thread;
        SurfaceHolder surfaceHolder;

        public OurView(Context context) {
            super(context);
            surfaceHolder = getHolder();
            Log.e(TAG, "OurView Constructor");
        }

        @Override
        public void run() {
            while (play) {
                //perform canvas drawing
                if (!surfaceHolder.getSurface().isValid()) {
                    continue;
                }
//                      x+=5;
//                    y+=5;
                Canvas canvas = surfaceHolder.lockCanvas();
                Log.e(TAG, "Canvas locked");
                canvas.drawARGB(10, 10, 10, 10);
//                    canvas.drawBitmap(mBitmap, x - (mBitmap.getWidth()/2), y - (mBitmap.getHeight()/2),null);
//                    canvas.drawBitmap(mBitmap, x + (mBitmap.getWidth()/2), y + (mBitmap.getHeight()/2),null);
//                    canvas.drawBitmap(mBitmap, x + getWidth()/2, y + getHeight()/2,null);
                canvas.drawBitmap(mBitmap, x, y, null);
                surfaceHolder.unlockCanvasAndPost(canvas);
            }

        }

        public void pause() {
            play = false;
            while (true) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    Log.e(TAG, "pause error", e);
                }
                break;
            }
            thread = null;
        }

        public void resume() {
            play = true;
            thread = new Thread(this);
            thread.start();
            Log.e(TAG, "thread started i.e run()");

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
        mOurView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
        mOurView.resume();
    }
}
