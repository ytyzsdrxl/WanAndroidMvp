package com.example.xl.wanandroidmvp.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class RoundLoadingView extends View {
    private double cosX;

    private Paint ball_paint;

    private int ball_color = Color.parseColor("#ffffff");

    private float[] radius = {(float)0.01,(float)0.02,(float)0.03,(float)0.04,(float)0.03,(float)0.002,(float)0.001,(float)0.000};

    private int state = 2;

    private int speed = 100;

    public enum speeds{
        slow,
        normal,
        fast
    }

    private speeds speedss = speeds.normal;

    public RoundLoadingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        if (state == 1){
            speed = 200;
            speedss = speeds.slow;
        }else if (state == 2){
            speed = 100;
            speedss = speeds.normal;
        }else{
            speed = 50;
            speedss = speeds.fast;
        }
        initView();
    }

    private void initView(){
        ball_paint = new Paint();
        ball_paint.setColor(ball_color);
        ball_paint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        int len = Math.min(width,height);

//        rectF = new RectF(len * (float)0.1,len * (float)0.1,len * (float) 0.9,len * (float)0.9);

        cosX = Math.sqrt(Math.pow(len * 0.3,2)/2);

        setMeasuredDimension(len,len);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawRoundBall(canvas);
    }

    private void drawRoundBall(Canvas canvas){

        canvas.drawCircle(getWidth()/2,getHeight() * (float)0.2,getWidth() * radius[0],ball_paint);

        canvas.drawCircle(getWidth()/2 + (float)cosX,getHeight()/2-(float)cosX,getWidth() * radius[1],ball_paint);

        canvas.drawCircle(getWidth()/2 + getWidth() * (float)0.3,getHeight()/2,getWidth() * radius[2],ball_paint);

        canvas.drawCircle(getWidth()/2 + (float)cosX,getHeight()/2 + (float)cosX,getWidth() * radius[3],ball_paint);

        canvas.drawCircle(getWidth()/2,getHeight()/2 + getHeight() * (float)0.3,getWidth() * radius[4],ball_paint);

        canvas.drawCircle(getWidth()/2 - (float)cosX,getHeight()/2 + (float)cosX,getWidth() * radius[5],ball_paint);

        canvas.drawCircle(getWidth()/2 - getWidth() * (float)0.3,getHeight()/2,getWidth() * radius[6],ball_paint);

        canvas.drawCircle(getWidth()/2 - (float)cosX,getWidth()/2 - (float)cosX,getWidth() * radius[7],ball_paint);

        canvas.save();
    }

    public void setSpeed(speeds speed1){
        speedss = speed1;
        if (speedss == speeds.fast){
            speed = 50;
            state = 3;
        }else if (speedss == speeds.normal){
            speed = 100;
            state = 2;
        }else{
            speed = 200;
            state = 1;
        }
        postInvalidate();
    }

    public void startLoading(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                changeFloat();
                postInvalidate();
            }
        },300,speed);
    }

    private void changeFloat(){
        float temp = radius[radius.length - 1];
        for (int i = radius.length - 1;i > 0 ; i --){
            radius[i] = radius[i - 1];
        }
        radius[0] = temp;
    }

}
