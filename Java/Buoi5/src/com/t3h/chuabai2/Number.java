package com.t3h.chuabai2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Number {
    private int[] numbers = new int[10];
    private Random random = new Random();

    public Number() {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(90000) + 10000;
        }
        System.out.println(Arrays.toString(numbers));
    }

    public void print() {
        System.out.println("Danh sach so le lon nhat");
        ArrayList<Integer> arr = new ArrayList<>();
        int maxCount = 0;
        for (int v : numbers) {
            int count = count(v);
            if (count == maxCount) {
                arr.add(v);
            } else if (count > maxCount) {
                arr.clear();
                maxCount = count;
                arr.add(v);
            }
        }
        System.out.println(arr);
    }

    private int count(int value) {
        int count = 0;
        while (value != 0) {
            int x = value % 10;
            value = value / 10;
            if (x % 2 == 1) {
                count++;
            }
        }
        return count;
    }

    public void search() {
        int max = 0;
        System.out.println("Tong 3 < 50000");
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                for (int k = j + 1; k < numbers.length; k++) {
                    int sum = numbers[i] + numbers[j] + numbers[k];

                    if (sum <= 80000) {
                        System.out.println(numbers[i] + ", " + numbers[j] + ", " + numbers[k]);
                        if (sum > max){
                            max = sum;
                        }
                    }
                }
            }
        }
        System.out.println("Tong lon nhat: "+ max);
    }
}
