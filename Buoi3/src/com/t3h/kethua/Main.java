package com.t3h.kethua;

public class Main {
    public static void main(String[] args) {
        SinhVien sinhVien = new SinhVien(
                "12134121",
                "LanDT1810",
                10.0f,
                "Nguyen Van A",
                12,
                "Ha noi",
                true,
                "012345677890"
        );
        sinhVien.inThongTin();
        System.out.println("-=======================");
        NhanVien nhanVien = new NhanVien(
                "Nguyen Thi B",
                30, "Ha Noi",
                false, "012354534",
                "2bds12","Nhan Su",12131211
        );
        nhanVien.inThongTin();

        ConNguoi conNguoi = new ConNguoi("Nguyen Van C",
                12, "hA noi", true, "012121");
        conNguoi.inThongTin();
    }
}
