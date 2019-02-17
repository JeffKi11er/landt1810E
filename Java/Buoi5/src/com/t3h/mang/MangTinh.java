package com.t3h.mang;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class MangTinh {
    // <KDL>[] tenMang = new <KDL> [size]
    private Integer[] arr;
    private Random random = new Random();

    public MangTinh(int size) {
        arr = new Integer[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(91) + 10;
        }
    }

    public void inMang() {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    public void sapXepTang(){
        Arrays.sort(arr);
    }

    public void sapXepGiam(){
        Arrays.sort(arr, comparator);
    }

    private Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 > o2){
                return -1;
            }
            return 1;
        }
    };
}
