import java.util.ArrayList;
import java.util.Scanner;

class sach {
    String masach;
    String tensach;
    String tacgia;
    int namxuatban;
    int dongia;
    int soluong;
}

public class QuanLySach {
    static void themSach(ArrayList<sach> ds, Scanner sc) {
        System.out.print("Nhap so sach can them: ");
        int n = sc.nextInt();
        sc.nextLine();
        if (n <= 0) {
            System.out.println("So luong sach khong hop le!");
            return;
        }
        for (int i = 0; i < n; i++) {
            sach s = new sach();
            System.out.println("\nNhap thong tin sach thu " + (i + 1));

            System.out.print("Ma sach: ");
            s.masach = sc.nextLine();

            System.out.print("Ten sach: ");
            s.tensach = sc.nextLine();

            System.out.print("Tac gia: ");
            s.tacgia = sc.nextLine();

            System.out.print("Nam xuat ban: ");
            s.namxuatban = sc.nextInt();

            System.out.print("Don gia: ");
            s.dongia = sc.nextInt();

            System.out.print("So luong: ");
            s.soluong = sc.nextInt();
            sc.nextLine();

            ds.add(s);
        }

        System.out.println("Them sach thanh cong!");
    }

    static void hienthisach(sach s) {
        System.out.println("Ma sach: " + s.masach);
        System.out.println("Ten sach: " + s.tensach);
        System.out.println("Tac gia: " + s.tacgia);
        System.out.println("Nam xuat ban: " + s.namxuatban);
        System.out.println("Don gia: " + s.dongia);
        System.out.println("So luong: " + s.soluong);
    }

    static void hienthiDanhSach(ArrayList<sach> ds) {
        if (ds.isEmpty()) {
            System.out.println("Danh sach sach rong!");
            return;
        }
        for (int i = 0; i < ds.size(); i++) {
            System.out.println("\nSACH THU " + (i + 1) + ":");
            hienthisach(ds.get(i));
        }
    }

    static int timViTriSach(ArrayList<sach> ds, String ma) {
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).masach.equalsIgnoreCase(ma))
                return i;
        }
        return -1;
    }

    static boolean timSachTheoMa(ArrayList<sach> ds, String ma) {
        int viTri = timViTriSach(ds, ma);
        if (viTri != -1) {
            hienthisach(ds.get(viTri));
            return true;
        }
        return false;
    }

    static void xoaSach(ArrayList<sach> ds, Scanner sc) {
        if (ds.isEmpty()) {
            System.out.println("Danh sach sach rong!");
            return;
        }
        System.out.print("Nhap ma sach can xoa: ");
        String ma = sc.nextLine();
        int viTri = timViTriSach(ds, ma);
        if (viTri != -1) {
            ds.remove(viTri);
            System.out.println("Xoa sach thanh cong!");
        } else {
            System.out.println("Khong tim thay sach!");
        }
    }

    static void suaSach(ArrayList<sach> ds, Scanner sc) {
        if (ds.isEmpty()) {
            System.out.println("Danh sach sach rong!");
            return;
        }
        System.out.print("Nhap ma sach can sua: ");
        String ma = sc.nextLine();
        int viTri = timViTriSach(ds, ma);
        if (viTri == -1) {
            System.out.println("Khong tim thay sach!");
            return;
        }
        sach s = ds.get(viTri);
        System.out.println("\nNhap thong tin moi:");
        System.out.print("Ten sach: ");
        s.tensach = sc.nextLine();

        System.out.print("Tac gia: ");
        s.tacgia = sc.nextLine();

        System.out.print("Nam xuat ban: ");
        s.namxuatban = sc.nextInt();

        System.out.print("Don gia: ");
        s.dongia = sc.nextInt();

        System.out.print("So luong: ");
        s.soluong = sc.nextInt();
        sc.nextLine();

        System.out.println("Cap nhat sach thanh cong!");
    }

    static int tinhTongSach(ArrayList<sach> ds, int n) {
        if (n == 0)
            return 0;
        return ds.get(n - 1).soluong
                + tinhTongSach(ds, n - 1);
    }

    static long tinhTongGiaTri(ArrayList<sach> ds) {
        long sum = 0;
        for (int i = 0; i < ds.size(); i++)
            sum += ds.get(i).soluong*ds.get(i).dongia;
        return sum;
    }

    static void phanloaigia(sach s) {
        if (s.dongia < 50000)
            System.out.println("Sach gia thap");
        else if (s.dongia < 100000)
            System.out.println("Sach gia trung binh");
        else if (s.dongia <= 200000)
            System.out.println("Sach gia cao");
        else
            System.out.println("Sach dat biet");

    }

    static void phanloaitonkho(sach s) {
        if (s.soluong == 0)
            System.out.println("Het sach");
        else if (s.soluong <= 5)
            System.out.println("Sach sap het");
        else if (s.soluong <= 20)
            System.out.println("Sach con it");
        else
            System.out.println("Sach con nhieu");
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

    static int timSoLuongLonNhat(ArrayList<sach> ds) {
        if (ds.isEmpty())
            return 0;
        int max = ds.get(0).soluong;
        for (int i = 1; i < ds.size(); i++)
            if (ds.get(i).soluong > max)
                max = ds.get(i).soluong;
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<sach> ds = new ArrayList<>();
        int luaChon;
        do {
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi sach");
            System.out.println("3. Tim sach");
            System.out.println("4. Xoa sach");
            System.out.println("5. Sua sach");
            System.out.println("6. Tinh tong so luong");
            System.out.println("7. Tinh tong gia tri");
            System.out.println("8. Thoat");
            System.out.print("Nhap lua chon: ");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon) {
                case 1:
                    themSach(ds, sc);
                    break;

                case 2:
                    hienthiDanhSach(ds);
                    break;

                case 3:
                    if (ds.isEmpty())
                        System.out.println("Danh sach sach rong!");
                    else {
                        System.out.print("Nhap ma sach can tim: ");
                        String ma = sc.nextLine();

                        if (timSachTheoMa(ds, ma))
                            System.out.println("Tim thay sach!");
                        else
                            System.out.println("Khong tim thay sach!");
                    }
                    break;
                case 4:
                    xoaSach(ds, sc);
                    break;
                case 5:
                    suaSach(ds, sc);
                    break;
                case 6:
                    if (ds.isEmpty())
                        System.out.println("Danh sach sach rong!");
                    else
                        System.out.println("Tong so luong sach: " + tinhTongSach(ds, ds.size()));
                    break;
                case 7:
                    if (ds.isEmpty())
                        System.out.println("Danh sach sach rong!");
                    else
                        System.out.println("Tong gia tri sach: " + tinhTongGiaTri(ds));
                    break;
                case 8:
                    System.out.println("Ket thuc chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (luaChon != 8);
        sc.close();
    }
}
