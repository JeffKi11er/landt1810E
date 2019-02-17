package com.t3h.dahinh;

public class Main {
    public static void main(String[] args) {
        Cho cho = new Cho("Cucu", 2, 10.4f, "Xam");
        Meo meo = new Meo("Kiki", 2, 2.4f, "Trang");
        //-----------
//        Thanh thanh = new Thanh("Thanh", 10, true,
//                "Ha noi", "01245342312", cho);
//        thanh.datChoDiDao();
//        thanh.inThongTin();
//        System.out.println("================");
//        Hoa hoa = new Hoa("Hoa", 11, false, "Ha noi",
//                "09843121", meo);
//        hoa.datMeoDiShopping();
//        hoa.inThongTin();

        ConNguoi conNguoi = new Thanh("Thanh", 12, true,
                "Ha noi", "0123441", cho);
        conNguoi.inThongTin();
    }
}
