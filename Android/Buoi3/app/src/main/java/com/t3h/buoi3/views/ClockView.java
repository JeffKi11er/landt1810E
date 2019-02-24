package com.t3h.buoi3.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.t3h.buoi3.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ClockView extends View implements Runnable {
    private Paint p;

    {
        p = new Paint();
        p.setColor(Color.RED);
        p.setTextSize(30);
        p.setAntiAlias(true);
    }

    private SimpleDateFormat fomat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
    private String time;

    public ClockView(Context context) {
        super(context);
        init(null);
    }

    public ClockView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attrs){
        if (attrs != null){
            TypedArray arr = getContext().obtainStyledAttributes(attrs, R.styleable.ClockView);
            int color = arr.getColor(R.styleable.ClockView_color, Color.BLACK);
            int size = arr.getDimensionPixelSize(R.styleable.ClockView_size, 30);
            arr.recycle();
            p.setColor(color);
            p.setTextSize(size);
        }
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(time, 100, 100, p);
    }

    @Override
    public void run() {
        while (true) {
            Calendar c = Calendar.getInstance();
            time = fomat.format(c.getTime());
            postInvalidate();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
