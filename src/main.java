import java.util.Scanner;

class sach {
    String masach;
    String tensach;
    String tacgia;
    int namxuatban;
    int dongia;
    int soluong;
}

public class main  {

    // Nhap thong tin sach
    static void nhapsach(sach s, Scanner sc) {
        System.out.println("Nhap ma sach:");
        s.masach = sc.nextLine();

        System.out.println("Nhap ten sach:");
        s.tensach = sc.nextLine();

        System.out.println("Nhap tac gia:");
        s.tacgia = sc.nextLine();

        System.out.println("Nhap nam xuat ban:");
        s.namxuatban = sc.nextInt();

        System.out.println("Nhap don gia:");
        s.dongia = sc.nextInt();

        System.out.println("Nhap so luong:");
        s.soluong = sc.nextInt();
    }

    static void hienthi(sach s) {
        System.out.println("\n===== THONG TIN SACH =====");
        System.out.println("Ma sach: " + s.masach);
        System.out.println("Ten sach: " + s.tensach);
        System.out.println("Tac gia: " + s.tacgia);
        System.out.println("Nam xuat ban: " + s.namxuatban);
        System.out.println("Don gia: " + s.dongia);
        System.out.println("So luong: " + s.soluong);
    }

    static long tinhtien(sach s) {
        return (long) s.soluong * s.dongia;
    }

    static double phivanchuyen(sach s) {
        return tinhtien(s) * 0.05;
    }

    static double tongtien(sach s) {
        return tinhtien(s) + phivanchuyen(s);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sach s = new sach();
        nhapsach(s, sc);
        hienthi(s);

        System.out.println("Tien sach: " + tinhtien(s));
        System.out.println("Phi van chuyen: " + phivanchuyen(s));
        System.out.println("Tong tien: " + tongtien(s));

        sc.close();
    }
}