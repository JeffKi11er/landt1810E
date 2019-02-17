package com.t3h.dahinh;

public class Hoa extends ConNguoi {
    public Hoa(String ten, int tuoi, boolean gioiTinh, String diaChi, String soDienThoai, DongVat dongVat) {
        super(ten, tuoi, gioiTinh, diaChi, soDienThoai, dongVat);
    }

    void datMeoDiShopping() {
        System.out.println("Dat meo di shopping");
    }
}
