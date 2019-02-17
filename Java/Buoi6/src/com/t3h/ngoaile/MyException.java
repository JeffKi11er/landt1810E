package com.t3h.ngoaile;

import java.util.ArrayList;

public class MyException {
    private String[] arr = new String[5];

    public MyException() {
        arr[0] = "Hello";
        arr[1] = "World";
        arr[2] = "Hi";
        arr[3] = "Viet Nam";
        arr[4] = "Vo dich";
    }

    public void print(){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toUpperCase());
        }
    }

}
