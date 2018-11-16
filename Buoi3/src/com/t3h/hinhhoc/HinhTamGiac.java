package com.t3h.hinhhoc;

public class HinhTamGiac extends HinhHoc {
    float canhA;
    float canhB;
    float canhC;

    public HinhTamGiac(String ten, float canhA, float canhB, float canhC) {
        super(ten);
        this.canhA = canhA;
        this.canhB = canhB;
        this.canhC = canhC;
    }

    @Override
    void chuVi() {
        float chuVi = canhA + canhB + canhC;
        System.out.println("Chu vi: " + chuVi);
    }

    @Override
    void dienTich() {
        float chuVi = (canhA + canhB + canhC) / 2;
        float dienTich = chuVi * (chuVi - canhA)
                * (chuVi - canhB) * (chuVi - canhC);
        dienTich = (float) Math.sqrt(dienTich);
        System.out.println("Dien tich: " + dienTich);
    }
}
