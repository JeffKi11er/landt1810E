package com.t3h.dahinh;

public abstract class DongVat {
    protected String ten;
    protected int tuoi;
    protected float canNang;
    protected String mauLong;

    public DongVat(String ten, int tuoi, float canNang, String mauLong) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.canNang = canNang;
        this.mauLong = mauLong;
    }

    @Override
    public String toString() {
        return "DongVat{" +
                "ten='" + ten + '\'' +
                ", tuoi=" + tuoi +
                ", canNang=" + canNang +
                ", mauLong='" + mauLong + '\'' +
                '}';
    }
}
