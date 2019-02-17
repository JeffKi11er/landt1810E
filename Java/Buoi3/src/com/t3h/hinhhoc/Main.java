package com.t3h.hinhhoc;

public class Main {
    public static void main(String[] args) {
        HinhTamGiac tamGiac = new HinhTamGiac("Hinh tam gia",
                3,4,5);
        tamGiac.inThongTin();
        tamGiac.chuVi();
        tamGiac.dienTich();
        System.out.println("==============");
        HinhChuNhat chuNhat = new HinhChuNhat("Hinh Chu Nhat",
                10 ,5);
        chuNhat.inThongTin();
        chuNhat.chuVi();
        chuNhat.dienTich();
    }
}
