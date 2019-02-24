package com.t3h.buoi3.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.t3h.buoi3.R;

public class ButtonOpacity extends AppCompatButton implements View.OnTouchListener {
    private int colorDown;
    private int colorUp;
    private int colorMove;
    private float x;
    private float y;

    public ButtonOpacity(Context context) {
        super(context);
        init(null);
    }

    public ButtonOpacity(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ButtonOpacity(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs){
        setOnTouchListener(this);
        if (attrs == null) return;
        TypedArray arr = getContext().obtainStyledAttributes(attrs, R.styleable.ButtonOpacity);
        colorDown = arr.getColor(R.styleable.ButtonOpacity_colorDown, 0);
        colorMove = arr.getColor(R.styleable.ButtonOpacity_colorMove, 0);
        colorUp = arr.getColor(R.styleable.ButtonOpacity_colorUp, 0);
        arr.recycle();
        setBackgroundColor(colorUp);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                setBackgroundColor(colorDown);
                x = event.getX();
                y = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                setBackgroundColor(colorMove);
                float dX = event.getX() - x;
                float dY = event.getY() - y;
                setX(getX() + dX);
                setY(getY() + dY);
                break;
            case MotionEvent.ACTION_UP:
                setBackgroundColor(colorUp);
                break;
        }
        return false;
    }
}
