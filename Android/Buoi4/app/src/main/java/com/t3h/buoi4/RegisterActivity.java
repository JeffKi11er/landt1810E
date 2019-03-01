package com.t3h.buoi4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_USER_NAME = "extra.user.name";
    public static final String EXTRA_PASSWORD = "extra.password";

    private EditText edtUserName;
    private EditText edtPassword;
    private Button btnOk;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();
    }

    private void initViews() {
        edtUserName = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        btnOk = findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String userName = edtUserName.getText().toString();
        String password = edtPassword.getText().toString();
        if (userName.isEmpty() || password.isEmpty()){
            Toast.makeText(this, R.string.data_empty,
                    Toast.LENGTH_SHORT).show();
            return;
        }
        //set data tra ve cho activity goc
        Intent intent = new Intent();
        intent.putExtra(EXTRA_USER_NAME, userName);
        intent.putExtra(EXTRA_PASSWORD, password);
        setResult(RESULT_OK, intent);
        finish();
    }
}
