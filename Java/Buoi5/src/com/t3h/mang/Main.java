package com.t3h.mang;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        MangTinh mangTinh = new MangTinh(10);
//        mangTinh.inMang();
//        mangTinh.sapXepTang();
//        mangTinh.inMang();
//        mangTinh.sapXepGiam();
//        mangTinh.inMang();

        MangDong dong = new MangDong();
        dong.add(10);
        dong.add(20);
        dong.add(12);
        dong.add(15);
        dong.inMang();
        dong.add(2, 100);
        dong.inMang();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(0);
        arr.add(2);
        dong.addAll(1 ,arr);
        dong.inMang();
//        dong.set(1, 1000);
        dong.inMang();
        int index = dong.indexOf(200);
        System.out.println();
        System.out.println(index);
        boolean check = dong.checkContain(arr);
        System.out.println(check);
    }
}
