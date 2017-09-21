package com.kellton.canvasandsurfaceview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button btnCanvas=(Button)findViewById(R.id.btn_canvas);
        Button btnSurfaceView=(Button)findViewById(R.id.btn_surface_view);

        btnCanvas.setOnClickListener(this);
        btnSurfaceView.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_canvas:
                startActivity(new Intent(MainActivity.this,CanvasActivity.class));
                break;
            case R.id.btn_surface_view:
                startActivity(new Intent(MainActivity.this,SufaceViewActivity.class));
                break;
            default:
                Log.v(TAG,getString(R.string.wrong_case_selection));
                break;
        }

    }
}
