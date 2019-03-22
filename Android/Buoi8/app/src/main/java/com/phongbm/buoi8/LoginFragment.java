package com.phongbm.buoi8;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class LoginFragment extends Fragment implements View.OnClickListener {
    private EditText edtUserName;
    private EditText edtPassword;
    private Button btnLogin;
    private Button btnRegister;
    private String userName = "";
    private String passowrd = "";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login,
                container, false);
        Log.e(getClass().getName(), "onCreateView");
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(getClass().getName(), "onActivityCreated");
        edtUserName = getActivity().findViewById(R.id.edt_user_name);
        edtPassword = getActivity().findViewById(R.id.edt_password);
        btnLogin = getActivity().findViewById(R.id.btn_ok);
        btnRegister = getActivity().findViewById(R.id.btn_register);
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        edtUserName.setText(userName);
        edtPassword.setText(passowrd);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(getClass().getName(), "onDestroy");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_ok:
                break;
            case R.id.btn_register:
                MainActivity act = (MainActivity) getActivity();
                act.showFragment(act.getFmRegister());
                break;
        }
    }

    public void setData(String userName, String password){
        Log.e(getClass().getName(),"setData");
//        edtUserName.setText(userName);
//        edtPassword.setText(password);
        this.userName = userName;
        this.passowrd = password;
    }
}
