package com.t3h.chuabai2;

import java.util.Arrays;

public class Tong {
    private String str;

    public Tong(String str) {
        this.str = str;
    }

    public void chuanHoa() {
        str = str.replace("++", "+0+");
        str = str.replace("-+", "-");
        str = str.replace("+-", "-");
        str = str.replace("--", "-0-");
        System.out.println(str);
    }

    public void tinhTong() {
        String[] arr = str.split("\\+");
        int sum = 0;
        for (String s : arr) {
            String[] arr1 = s.split("\\-");
            int sum1 = Integer.parseInt(arr1[0]);
            for (int i = 1; i < arr1.length; i++) {
                sum1 -= Integer.parseInt(arr1[i]);
            }
            sum += sum1;
        }
        System.out.println("Tong la: " + sum);
    }
}
