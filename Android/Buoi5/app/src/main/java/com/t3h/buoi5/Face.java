package com.t3h.buoi5;

import android.support.annotation.DrawableRes;

public class Face {
    private @DrawableRes int face;
    private String name;

    public Face(@DrawableRes int face, String name) {
        this.face = face;
        this.name = name;
    }

    public int getFace() {
        return face;
    }

    public String getName() {
        return name;
    }
}
