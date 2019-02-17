package com.t3h.hinhhoc;

public abstract class HinhHoc {
    String ten;

    public HinhHoc(String ten) {
        this.ten = ten;
    }

    abstract void chuVi();

    abstract void dienTich();

    void inThongTin() {
        System.out.println("Ten: " + ten);
    }
}
