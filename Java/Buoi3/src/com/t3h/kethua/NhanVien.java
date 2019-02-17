package com.t3h.kethua;

public class NhanVien extends ConNguoi {
    String maNv;
    String phongBan;
    int luong;

    public NhanVien(String ten, int tuoi, String diaChi, boolean gioiTinh,
                    String soDienThoai, String maNv, String phongBan, int luong) {
        super(ten, tuoi, diaChi, gioiTinh, soDienThoai);
        this.maNv = maNv;
        this.phongBan = phongBan;
        this.luong = luong;
    }

    public NhanVien(String ten, int tuoi, String diaChi, boolean gioiTinh,
                    String soDienThoai, String maNv) {
        super(ten, tuoi, diaChi, gioiTinh, soDienThoai);
        this.maNv = maNv;
    }

    @Override
    void inThongTin() {
        super.inThongTin();
        System.out.println("Ma NV: " + maNv);
        System.out.println("Phong Ban: " + phongBan);
        System.out.println("Luong: " + luong);
    }
}
