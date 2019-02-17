public class Main {
    public static void main(String[] args) {
        SinhVien sv = new SinhVien();
        sv.nhap("01334456", "Nguyen Van A",
                12, true, "Ha Noi",
                "0123456789", 8.5f);
        sv.hoc();
        sv.thi();
        sv.lamBai();
        sv.inThongTin();
    }
}
