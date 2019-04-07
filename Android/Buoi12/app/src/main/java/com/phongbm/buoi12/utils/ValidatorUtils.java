package com.phongbm.buoi12.utils;

import android.widget.EditText;

public class ValidatorUtils {
    public static boolean isEmpty(EditText...edts){
        boolean isEmpty = false;
        for (EditText e:edts) {
            if (e.getText().toString().isEmpty()){
                isEmpty = true;
                e.setError("Input empty");
            }
        }
        return isEmpty;
    }
}
