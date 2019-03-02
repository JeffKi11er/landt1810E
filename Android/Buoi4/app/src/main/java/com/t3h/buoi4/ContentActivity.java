package com.t3h.buoi4;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;

public class ContentActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_PICK_IMAGE = 1;
    private TextView tvContent;
    private EditText edtContent;
    private Button btnCall;
    private Button btnBrowser;
    private Button btnPick;
    private ImageView imPick;
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

        edtContent = findViewById(R.id.edt_content);
        btnCall = findViewById(R.id.btn_call);
        btnBrowser = findViewById(R.id.btn_browser);
        btnPick = findViewById(R.id.btn_pick);
        imPick = findViewById(R.id.im_pick);
        btnPick.setOnClickListener(this);
        btnBrowser.setOnClickListener(this);
        btnCall.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String content = edtContent.getText().toString();
        switch (v.getId()){
            case R.id.btn_browser:
                Intent browser = new Intent(Intent.ACTION_VIEW);
                browser.setData(Uri.parse(content));
                startActivity(browser);
                break;
            case R.id.btn_call:
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel:"+content));
                startActivity(call);
                break;
            case R.id.btn_pick:
                Intent pick = new Intent(Intent.ACTION_GET_CONTENT);
                pick.setType("image/*");
                startActivityForResult(
                        pick,
                        REQUEST_PICK_IMAGE
                );
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_PICK_IMAGE && resultCode == RESULT_OK){
            Uri uri = data.getData();
            try {
                Bitmap b = BitmapFactory.decodeStream(getContentResolver()
                        .openInputStream(uri));
                imPick.setImageBitmap(b);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
