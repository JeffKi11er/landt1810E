package com.phongbm.buoi12;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.phongbm.buoi12.databinding.ActivityMainBinding;
import com.phongbm.buoi12.views.DialogLogout;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements View.OnClickListener, DialogLogout.LogoutCallback {
    private SharedHelper helper;
    private DialogLogout dialog;

    @Override
    protected void initAct() {
        helper = new SharedHelper(this);
        String userName = helper.get(SharedHelper.Keys.USERNAME, "");
        String password = helper.get(SharedHelper.Keys.PASSWORD, "");
        binding.tvInfo.setText(userName + "," + password);
        binding.btnLogout.setOnClickListener(this);

        dialog = new DialogLogout(this);
        dialog.setCallback(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View v) {
        dialog.show();
    }

    @Override
    public void onOkClicked() {
        helper.remote(SharedHelper.Keys.USERNAME,
                SharedHelper.Keys.PASSWORD);
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
