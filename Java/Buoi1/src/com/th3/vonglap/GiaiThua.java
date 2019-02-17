package com.th3.vonglap;

public class GiaiThua {
    int n;

    void nhap(int giaTriN){
        n = giaTriN;
    }

    void tinh(){
        int giaiThua = 1;
        for (int i = 2; i <= n; i++) {
            giaiThua *= i;
        }
        System.out.println("Gia tri giai thua la: "+ giaiThua);
    }

}
