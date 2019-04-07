package com.phongbm.buoi12.views;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.phongbm.buoi12.R;
import com.phongbm.buoi12.databinding.UiDialogBinding;

public class DialogLogout extends Dialog implements View.OnClickListener {
    private UiDialogBinding binding;
    private LogoutCallback callback;

    public DialogLogout(@NonNull Context context) {
        super(context,
                android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar_MinWidth);
        LayoutInflater inflater = LayoutInflater.from(context);
        binding = DataBindingUtil.inflate(inflater,
                R.layout.ui_dialog, null, false);
        setContentView(binding.getRoot());

        binding.btnOk.setOnClickListener(this);
        binding.btnCancel.setOnClickListener(this);
    }

    public void setCallback(LogoutCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_cancel:
                dismiss();
                break;
            case R.id.btn_ok:
                dismiss();
                if (callback != null){
                    callback.onOkClicked();
                }
                break;
        }
    }

    public interface LogoutCallback{
        void onOkClicked();
    }
}
