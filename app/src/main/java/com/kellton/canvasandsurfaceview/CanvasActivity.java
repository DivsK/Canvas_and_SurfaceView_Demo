package com.kellton.canvasandsurfaceview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CanvasActivity extends AppCompatActivity {
    private DrawingBall mDrawingball;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_canvas);

        mDrawingball=new DrawingBall(this);
        setContentView(mDrawingball);
    }
}
