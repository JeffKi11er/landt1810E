package com.phongbm.buoi12;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedHelper {

    enum Keys {
        USERNAME,
        PASSWORD
    }

    private SharedPreferences shared;

    public SharedHelper(Context context) {
        shared = context.getSharedPreferences("SharedHelper",
                Context.MODE_PRIVATE);
    }

    public void set(Keys k, String value) {
        SharedPreferences.Editor editor = shared.edit();
        editor.putString(k.toString(), value);
        editor.commit();
    }

    public String get(Keys k, String defaultValue) {
        return shared.getString(k.toString(), defaultValue);
    }

    public void remote(Keys... keys) {
        SharedPreferences.Editor editor = shared.edit();
        for (Keys k : keys) {
            editor.remove(k.toString());
        }
        editor.commit();
    }
}
