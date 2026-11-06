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
    static void nhapsach(sach[] s, int n, Scanner sc) {
        for (int i = 0; i < n; i++) {
            s[i] = new sach();
            System.out.println("Nhap ma sach:");
            s[i].masach = sc.nextLine();
            System.out.println("Nhap ten sach:");
            s[i].tensach = sc.nextLine();
            System.out.println("Nhap tac gia:");
            s[i].tacgia = sc.nextLine();
            System.out.println("Nhap nam xuat ban:");
            s[i].namxuatban = sc.nextInt();
            System.out.println("Nhap don gia:");
            s[i].dongia = sc.nextInt();
            System.out.println("Nhap so luong:");
            s[i].soluong = sc.nextInt();
            sc.nextLine();
        }
    }

    static void hienthisach(sach s) {
        System.out.println("Ma sach: " + s.masach);
        System.out.println("Ten sach: " + s.tensach);
        System.out.println("Tac gia: " + s.tacgia);
        System.out.println("Nam xuat ban: " + s.namxuatban);
        System.out.println("Don gia: " + s.dongia);
        System.out.println("So luong: " + s.soluong);
    }

    static void hienthiDanhSach(sach[] ds, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("\nSACH THU " + (i + 1) + "");
            hienthisach(ds[i]);
        }
    }

    static double tinhTongGiaTri(sach[] ds, int n) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += ds[i].soluong * ds[i].dongia;
        }
        return sum;
    }

    static boolean timSachTheoMa(sach[] ds, int n, String ma) {
        for (int i = 0; i < n; i++) {
            if (ds[i].masach.equalsIgnoreCase(ma)) {
                hienthisach(ds[i]);
                return true;
            }
        }
        return false;
    }

    static void phanloaigia(sach s) {
        if (s.dongia < 50000) {
            System.out.println("Sach gia thap");
        } else if (s.dongia < 100000) {
            System.out.println("Sach gia trung binh");
        } else if (s.dongia <= 200000) {
            System.out.println("Sach gia cao");
        } else {
            System.out.println("Sach dat biet");
        }
    }

    static void phanloaitonkho(sach s) {
        if (s.soluong == 0) {
            System.out.println("Het sach");
        } else if (s.soluong <= 5) {
            System.out.println("Sach sap het");
        } else if (s.soluong <= 20) {
            System.out.println("Sach con it");
        } else {
            System.out.println("Sach con nhieu");
        }
    }

    static int tinhTongSach(sach[] ds, int n) {
        if (n == 0) {
            return 0;
        }
        return ds[n - 1].soluong + tinhTongSach(ds, n - 1);
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
        sach[] ds = null;
        int n = 0;
        int luaChon;
        do {
            System.out.println("1. Nhap sach");
            System.out.println("2. Tinh tong so luong sach");
            System.out.println("3. Tinh tong gia tri sach");
            System.out.println("4. Tim sach theo ma");
            System.out.println("5. Thoat");
            System.out.println("");
            System.out.print("Nhap lua chon: ");

            luaChon = sc.nextInt();
            sc.nextLine();

            switch (luaChon) {
                case 1:
                    System.out.print("Nhap so sach: ");
                    n = sc.nextInt();
                    sc.nextLine();
                    if (n <= 0) {
                        System.out.println("So luong sach khong hop le!");
                        break;
                    } else {
                        ds = new sach[n];
                        nhapsach(ds, n, sc);
                        System.out.println("Nhap sach thanh cong!");
                        break;
                    }
                case 2:
                    if (ds == null) 
                        System.out.println("Vui long nhap sach truoc!");
                    else 
                        System.out.println("Tong so luong sach: "+ tinhTongSach(ds, n));
                    break;
                case 3:
                    if (ds == null) 
                        System.out.println("Vui long nhap sach truoc!");
                    else 
                        System.out.println("Tong gia tri sach: " + tinhTongGiaTri(ds, n));
                    break;
                case 4:
                    if (ds == null)
                        System.out.println("Vui long nhap sach truoc!");
                    else {
                        System.out.print("Nhap ma sach can tim: ");
                        String ma = sc.nextLine();
                        if (timSachTheoMa(ds, n, ma) == true)
                            System.out.println("Tim thay sach!");
                        else
                            System.out.println("Khong tim thay sach!");
                    }
                    break;
                case 5:
                    System.out.println("Ket thuc chuong trinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (luaChon != 5);
        sc.close();
    }
}
