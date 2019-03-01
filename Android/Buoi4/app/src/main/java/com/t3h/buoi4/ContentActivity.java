package com.t3h.buoi4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ContentActivity extends AppCompatActivity {
    private TextView tvContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_content);
        initViews();
    }

    private void initViews() {
        tvContent = findViewById(R.id.tv_info);
        Intent intent = getIntent();
        String userName = intent.getStringExtra(RegisterActivity.EXTRA_USER_NAME);
        String password = intent.getStringExtra(RegisterActivity.EXTRA_PASSWORD);
        tvContent.setText("Hi," + userName + "," + password);
    }
}
