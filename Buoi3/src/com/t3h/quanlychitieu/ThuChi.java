package com.t3h.quanlychitieu;

public class ThuChi extends KhoanTien {
    boolean loai;
    public ThuChi(String thoiGian, String diaDiem, int soTien, String lyDo, NguoiDung nguoiDung, boolean loai) {
        super(thoiGian, diaDiem, soTien, lyDo, nguoiDung);
        this.loai = loai;
    }

    @Override
    void baoCao() {
        if (loai){
            System.out.println("========Khoan thu========");
        }else{
            System.out.println("========Khoan chi========");
        }
        System.out.println(this.toString());
    }
}
