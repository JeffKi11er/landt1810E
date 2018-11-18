package com.t3h.quanlychitieu;

public abstract class KhoanTien {
    String thoiGian;
    String diaDiem;
    int soTien;
    String lyDo;
    NguoiDung nguoiDung;

    public KhoanTien(String thoiGian, String diaDiem, int soTien, String lyDo, NguoiDung nguoiDung) {
        this.thoiGian = thoiGian;
        this.diaDiem = diaDiem;
        this.soTien = soTien;
        this.lyDo = lyDo;
        this.nguoiDung = nguoiDung;
    }

    abstract void baoCao();

    @Override
    public String toString() {
        return "KhoanTien{" +
                "thoiGian='" + thoiGian + '\'' +
                ", diaDiem='" + diaDiem + '\'' +
                ", soTien=" + soTien +
                ", lyDo='" + lyDo + '\'' +
                ", nguoiDung=" + nguoiDung +
                '}';
    }
}
