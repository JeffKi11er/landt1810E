package com.t3h.quanlychitieu;

public class VayNo extends KhoanTien{
    float loaiXuat;
    String thoiHan;
    String ngayTra;
    boolean xacNhanTra;
    boolean loai;

    public VayNo(String thoiGian, String diaDiem, int soTien, String lyDo, NguoiDung nguoiDung, float loaiXuat, String thoiHan, String ngayTra, boolean xacNhanTra, boolean loai) {
        super(thoiGian, diaDiem, soTien, lyDo, nguoiDung);
        this.loaiXuat = loaiXuat;
        this.thoiHan = thoiHan;
        this.ngayTra = ngayTra;
        this.xacNhanTra = xacNhanTra;
        this.loai = loai;
    }

    @Override
    void baoCao() {
        if (loai){
            System.out.println("========Khoan vay=========");
        }else{
            System.out.println("========Khoan no=========");
        }
        System.out.println(toString());
    }

    @Override
    public String toString() {
        String result = super.toString();
        return result + " VayNo{" +
                "loaiXuat=" + loaiXuat +
                ", thoiHan='" + thoiHan + '\'' +
                ", ngayTra='" + ngayTra + '\'' +
                ", xacNhanTra=" + (xacNhanTra? "Da tra": "Chua tra") +
                '}';
    }
}
