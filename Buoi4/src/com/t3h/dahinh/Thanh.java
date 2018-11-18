package com.t3h.dahinh;

public class Thanh extends ConNguoi{

    public Thanh(String ten, int tuoi, boolean gioiTinh, String diaChi, String soDienThoai, DongVat dongVat) {
        super(ten, tuoi, gioiTinh, diaChi, soDienThoai, dongVat);
    }

    void datChoDiDao(){
        System.out.println("Dat cho di dao o cong vien");
    }

    @Override
    void inThongTin() {
        System.out.println("Day la thong tin cua Thanh");
        super.inThongTin();
    }
}
