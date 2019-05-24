package com.t3h.demofirebase;

import android.databinding.BindingAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AppBinding {

    @BindingAdapter("time")
    public static void setTime(TextView tv, long time) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        tv.setText(format.format(new Date(time)));
    }
}
