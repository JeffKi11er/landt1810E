package com.t3h.kethua;

public class SinhVien extends ConNguoi {
    String maSV;
    String lop;
    float diem;


    SinhVien(String maSV, String lop, float diem, String ten,
             int tuoi, String diaChi, boolean gioiTinh,
             String soDienThoai) {
        super(ten, tuoi, diaChi, gioiTinh, soDienThoai);
        this.maSV = maSV;
        this.diem = diem;
        this.lop = lop;
    }

    @Override
    void inThongTin() {
        super.inThongTin();
        System.out.println("Ma Sinh Vien: " + maSV);
        System.out.println("Lop: " + lop);
        System.out.println("Diem: " + diem);
    }
}
