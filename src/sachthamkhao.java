
import java.util.Scanner;

public class sachthamkhao extends sach {
    private double thue;

    public sachthamkhao() {
        super();
    }

    @Override
    public void nhap(Scanner sc) {
        nhapThongTinChung(sc);

        System.out.print("Nhap thue: ");
        thue = Double.parseDouble(sc.nextLine());
    }

    @Override
    public double tinhThanhTien() {
        return soluong * dongia + thue;
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("\n--- SACH THAM KHAO ---");
        super.hienThiThongTin();
        System.out.println("Thue: " + thue);
        System.out.println("Thanh tien: " + tinhThanhTien());
    }
}
