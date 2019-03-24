package com.phongbm.buoi9.utils;

import android.widget.EditText;

public class ValidatorUtils {
    public static boolean isInputEmpty(EditText... edts){
        boolean result = false;
        for (EditText edt: edts) {
            if (edt.getText().toString().isEmpty()){
                result = true;
                edt.setError("Input is empty");
            }
        }
        return result;
    }
}
