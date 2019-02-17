package com.t3h.quanlychitieu;

public class Main {
    public static void main(String[] args) {
        NguoiDung nguoiDung = new NguoiDung(
                "Nguyen van A",
                34,
                true,
                "Ha noi",
                "012346687");
        ThuChi thuChi = new ThuChi(
                "20/10/2018",
                "Ho tung mau",
                1000000,
                "Vay mua xe",
                nguoiDung,
                true);
        thuChi.baoCao();
        System.out.println("========");
        VayNo vayNo = new VayNo(
                "10/2/2019",
                "Ha noi",
                1000000,
                "Vay mua nha",
                nguoiDung, 10.5f,
                "2 nam",
                "Chua",
                false,
                true
        );
        vayNo.baoCao();
    }
}
