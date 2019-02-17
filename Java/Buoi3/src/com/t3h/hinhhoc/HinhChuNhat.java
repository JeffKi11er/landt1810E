package com.t3h.hinhhoc;

public class HinhChuNhat extends HinhHoc {
    float chieuDai;
    float chieuRong;

    public HinhChuNhat(String ten, float chieuDai, float chieuRong) {
        super(ten);
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    @Override
    void chuVi() {
        float chuVi = (chieuDai + chieuRong) * 2;
        System.out.println("Chu vi: " + chuVi);
    }

    @Override
    void dienTich() {
        float dienTich = chieuDai * chieuRong;
        System.out.println("Dien tich: " + dienTich);
    }
}
