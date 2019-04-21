package com.phongbm.buoi13;

import android.Manifest;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.phongbm.buoi13.adapter.SongAdapter;
import com.phongbm.buoi13.databinding.ActivityMainBinding;
import com.phongbm.buoi13.model.Song;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SongAdapter.ItemClickListener {

    private final String[] PERMISSION_LIST = {
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    private SystemData systemData;
    private ArrayList<Song> arrSong;
    private ActivityMainBinding binding;
    private SongAdapter adapter;
    private MediaManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);

        adapter = new SongAdapter(this);
        adapter.setListener(this);
        binding.lvSong.setAdapter(adapter);

        if (checkPermission()){
            readData();
        }
    }

    private void readData(){
        systemData = new SystemData(this);
        arrSong = systemData.getData();
        adapter.setData(arrSong);

        manager = new MediaManager(arrSong, this);
    }

    private boolean checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (String p : PERMISSION_LIST) {
                if (checkSelfPermission(p) !=
                        PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(PERMISSION_LIST, 0);
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (checkPermission()){
            readData();
        }else{
            finish();
        }
    }

    @Override
    public void onItemClicked(int position) {
        manager.create(position);
    }
}
