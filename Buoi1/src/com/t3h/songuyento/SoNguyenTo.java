package com.t3h.songuyento;

public class SoNguyenTo {
    int n;

    void nhap(int giaTriN) {
        n = giaTriN;
    }

    boolean kiemTra(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    void kiemTra(){
        boolean check = kiemTra(n);
        if (check == true){
            System.out.println(n + " la so nguyen to");
        }else{
            System.out.println(n + " khong la so nguyen to");
        }
    }

    void lietKe(){
        for (int i = 2; i <= n; i++) {
            boolean check = kiemTra(i);
            if (check == true){
                System.out.print(i +"\t");
            }
        }
    }
}
