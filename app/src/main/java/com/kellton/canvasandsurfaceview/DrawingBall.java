package com.kellton.canvasandsurfaceview;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;

public class DrawingBall extends View{

    private final OvalShape oval;
    private final Path path;
    private Rect rectangle;
    private Paint paint;
    private Bitmap bitmap;
    private int x;
    private int y;

    public DrawingBall(Context context) {
        super(context);
        rectangle=new Rect();
        oval=new OvalShape();
        paint=new Paint();
        bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.iv);
        path=new Path();
        x=y=0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        rectangle.set(2,2,canvas.getWidth()-2,canvas.getHeight()-2);

        paint.setColor(Color.DKGRAY);
        paint.setStyle(Paint.Style.FILL);

        canvas.drawRect(rectangle,paint);

        if(x<canvas.getWidth()){
            x+=10;
        }
        else {
                x=0;
        }
        if (y<canvas.getHeight()){
            y+=10;
        }
        else{
            y=0;
        }
        canvas.drawBitmap(bitmap,x,y,new Paint());

        invalidate();
    }
}
