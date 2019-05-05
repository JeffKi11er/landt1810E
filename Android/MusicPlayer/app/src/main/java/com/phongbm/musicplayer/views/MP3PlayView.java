package com.phongbm.musicplayer.views;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.phongbm.musicplayer.App;
import com.phongbm.musicplayer.acitivities.MainActivity;
import com.phongbm.musicplayer.databinding.UiPlayViewBinding;

public class MP3PlayView extends FrameLayout {

    private UiPlayViewBinding binding;
    private App app;

    public MP3PlayView(@NonNull Context context) {
        super(context);
        init();
    }

    public MP3PlayView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MP3PlayView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public MP3PlayView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        binding = UiPlayViewBinding.inflate(LayoutInflater.from(getContext()));
        addView(binding.getRoot());
        app = (App) getContext().getApplicationContext();
        setVisibility(GONE);
    }

    public void registerState(){
        MainActivity act = (MainActivity) getContext();
        app.getService().getIsLife().observe(act, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (aBoolean){
                    setVisibility(VISIBLE);
                }else{
                    setVisibility(GONE);
                }
            }
        });

        app.getService().getName().observe(act, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                binding.setName(s);
            }
        });

        app.getService().getIsPlaying().observe(act, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                binding.setIsPlaying(aBoolean);
            }
        });
    }
}
