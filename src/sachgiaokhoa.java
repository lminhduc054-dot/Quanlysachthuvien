
import java.util.Scanner;

public class sachgiaokhoa extends sach {
    private String tinhtrang;

    public sachgiaokhoa() {
        super();
    }

    @Override
    public void nhap(Scanner sc) {
        nhapThongTinChung(sc);

        do {
            System.out.print("Nhap tinh trang (moi/cu): ");
            tinhtrang = sc.nextLine();
        } while (!tinhtrang.equalsIgnoreCase("moi")
                && !tinhtrang.equalsIgnoreCase("cu"));
    }

    @Override
    public double tinhThanhTien() {
        if (tinhtrang.equalsIgnoreCase("moi")) {
            return soluong * dongia;
        }

        return soluong * dongia * 0.5;
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("\n--- SACH GIAO KHOA ---");
        super.hienThiThongTin();
        System.out.println("Tinh trang: " + tinhtrang);
        System.out.println("Thanh tien: " + tinhThanhTien());
    }
}
