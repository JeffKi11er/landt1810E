package com.phongbm.buoi7;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FileAdapter.ItemFileClick, View.OnClickListener, DownloadAsync.DownloadCallback {
    private FileAdapter adapter;
    private RecyclerView lvFile;
    private FileManager manager;
    private List<File> arr;
    private String currentPath;
    private EditText edtLink;
    private ProgressBar pbDownload;
    private Button btnDownload;

    private final String[] PERMISSION_LIST = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = new FileManager();
        initViews();
        if (checkPermission()) {
            readFile(manager.path);
        } else {
            requestPermissions(PERMISSION_LIST, 0);
        }
    }

    private void initViews() {
        adapter = new FileAdapter(this);
        adapter.setItemFileClick(this);
        lvFile = findViewById(R.id.lv_file);
        lvFile.setAdapter(adapter);

        edtLink = findViewById(R.id.edt_link);
        pbDownload = findViewById(R.id.pb_download);
        btnDownload = findViewById(R.id.btn_download);
        btnDownload.setOnClickListener(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (checkPermission()) {
            readFile(manager.path);
        } else {
            finish();
        }
    }

    private boolean checkPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        for (String p : PERMISSION_LIST) {
            // PackageManager.PERMISSION_GRANTED = accept
            // PackageManager.PERMISSION_DENIED = Denied
            int accept = checkSelfPermission(p);
            if (accept == PackageManager.PERMISSION_DENIED) {
                return false;
            }
        }
        return true;
    }

    private void readFile(String path) {
        currentPath = path;
        arr = manager.getFile(path);
        adapter.setData(arr);
    }

    @Override
    public void onBackPressed() {
        if (currentPath.equals(manager.path)) {
            super.onBackPressed();
        } else {
            File f = new File(currentPath);
            String parent = f.getParent();
            readFile(parent);
        }
    }

    @Override
    public void onItemFileClick(File f) {
        if (f.isDirectory()) {
            readFile(f.getPath());
        }
    }

    @Override
    public void onClick(View v) {
        String link = edtLink.getText().toString();
        if (link.isEmpty()) {
            Toast.makeText(this, "Link is empty",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        String path = currentPath + "/" + System.currentTimeMillis() + ".mp4";
        DownloadAsync download = new DownloadAsync(this);
        download.execute(link, path);
    }

    @Override
    public void updatePercent(int percent) {
        pbDownload.setProgress(percent);
    }

    @Override
    public void downloadFinish(String path) {
        readFile(currentPath);
    }
}
