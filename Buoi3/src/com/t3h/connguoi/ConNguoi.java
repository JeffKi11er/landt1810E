package com.t3h.connguoi;

public class ConNguoi {
    String ten;
    DongVat dongVat;

    ConNguoi(String ten) {
        this.ten = ten;
        dongVat = new DongVat("Cu cu");
    }

    void sayHello() {
        System.out.println(ten + " Xin chao");
    }

    class DongVat {
        String ten;

        DongVat(String ten) {
            this.ten = ten;
        }

        void inTen() {
            System.out.println("Ten dong vat la: " + ten);
            System.out.println("Ten con nguoi la: " + ConNguoi.this.ten);
        }
    }
}
