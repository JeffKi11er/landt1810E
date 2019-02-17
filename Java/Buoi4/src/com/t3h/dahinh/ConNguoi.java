package com.t3h.dahinh;

public abstract class ConNguoi {
    String ten;
    int tuoi;
    boolean gioiTinh;
    String diaChi;
    String soDienThoai;
    DongVat dongVat;

    public ConNguoi(String ten, int tuoi, boolean gioiTinh, String diaChi, String soDienThoai, DongVat dongVat) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.dongVat = dongVat;
    }

    void inThongTin(){
        System.out.println("Ho ten: "+ ten);
        System.out.println("Tuoi: " + tuoi);
        System.out.println("Gioi tinh: "+(gioiTinh?"Nam":"Nu"));
        System.out.println("Dia chi: "+ diaChi);
        System.out.println("So dien thoai: "+ soDienThoai);
        System.out.println("Thong dat vat");
        System.out.println(dongVat.toString());
        boolean isDog = dongVat instanceof Cho;
        if (isDog == true){
            Cho cho = (Cho) dongVat;
            cho.sua();
        }else{
            Meo meo = (Meo) dongVat;
            meo.batChuot();
        }
    }
}
