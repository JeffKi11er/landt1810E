package com.t3h.quanlychitieu;

public class NguoiDung {
    String ten;
    int tuoi;
    boolean gioiTinh;
    String diaChi;
    String soDienThoai;

    public NguoiDung(String ten, int tuoi, boolean gioiTinh, String diaChi, String soDienThoai) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    @Override
    public String toString() {
        return "NguoiDung{" +
                "ten='" + ten + '\'' +
                ", tuoi=" + tuoi +
                ", gioiTinh=" + (gioiTinh == true ? "Nam": "Nu") +
                ", diaChi='" + diaChi + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                '}';
    }
}
