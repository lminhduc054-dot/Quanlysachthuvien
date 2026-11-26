
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public abstract class sach {
    protected String masach;
    protected LocalDate ngaynhap;
    protected double dongia;
    protected int soluong;
    protected String nhaxuatban;

    protected static final DateTimeFormatter DINH_DANG_NGAY =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public sach() {
    }

    public sach(String masach, LocalDate ngaynhap, double dongia,
                int soluong, String nhaxuatban) {
        this.masach = masach;
        this.ngaynhap = ngaynhap;
        this.dongia = dongia;
        this.soluong = soluong;
        this.nhaxuatban = nhaxuatban;
    }

    protected void nhapThongTinChung(Scanner sc) {
        System.out.print("Nhap ma sach: ");
        masach = sc.nextLine();

        System.out.print("Nhap ngay nhap (dd/MM/yyyy): ");
        ngaynhap = LocalDate.parse(sc.nextLine(), DINH_DANG_NGAY);

        System.out.print("Nhap don gia: ");
        dongia = Double.parseDouble(sc.nextLine());

        System.out.print("Nhap so luong: ");
        soluong = Integer.parseInt(sc.nextLine());

        System.out.print("Nhap nha xuat ban: ");
        nhaxuatban = sc.nextLine();
    }

    public void hienThiThongTin() {
        System.out.println("Ma sach: " + masach);
        System.out.println("Ngay nhap: " + ngaynhap.format(DINH_DANG_NGAY));
        System.out.println("Don gia: " + dongia);
        System.out.println("So luong: " + soluong);
        System.out.println("Nha xuat ban: " + nhaxuatban);
    }

    public String getNhaxuatban() {
        return nhaxuatban;
    }

    public double getDongia() {
        return dongia;
    }

    public abstract void nhap(Scanner sc);

    public abstract double tinhThanhTien();
}
