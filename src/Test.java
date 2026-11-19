import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    static void themSach(ArrayList<sach> ds, Scanner sc, int n) {
        if (n <= 0) {
            System.out.println("So luong sach khong hop le!");
            return;
        }
        for (int i = 0; i < n; i++) {
            sach s = new sach();
            System.out.println("Nhap thong tin sach thu " + (i + 1));

            System.out.println("Nhap ma sach: ");
            s.setMasach(sc.nextLine());

            System.out.println("Nhap ten sach: ");
            s.setMasach(sc.nextLine());

            System.out.println("Nhap ten tac gia: ");
            s.setTacgia(sc.nextLine());

            System.out.println("Nhap nam xuat ban");
            s.setnamxuatban(sc.nextInt());

            System.out.println("Nhap so luong:");
            s.setsoluong(sc.nextInt());

        }
        System.out.println("Them sach thanh cong!");
    }

    static void insach(ArrayList<sach> ds) {
        if (ds.isEmpty())
            System.out.println("Danh sach rong!");
        else
            for (int i = 0; i < ds.size(); i++) {
                System.out.println("Sach thu:  " + (i + 1));
                ds.get(i).hienThiThongTin();
            }
    }

    public static int timvitri(ArrayList<sach> ds, String ma) {
        for (int i = 0; i < ds.size(); i++)
            if (ma.equalsIgnoreCase(ds.get(i).getMasach()))
                return i;
        return -1;
    }

    public static boolean timsach(ArrayList<sach> ds, String ma) {
        int vitri = timvitri(ds, ma);
        if (vitri != -1) {
            ds.get(vitri).hienThiThongTin();
            return true;
        }
        return false;
    }

    public static void xoasach(ArrayList<sach> ds, Scanner sc) {
        System.out.print("Nhap ma sach can xoa: ");
        String ma = sc.nextLine();
        int vitri = timvitri(ds, ma);
        if (vitri != -1) {
            ds.remove(vitri);
            System.out.println("Xoa sach thanh cong");
        } else {
            System.out.println("Khong tim thay sach");
        }
    }

    static void suasach(ArrayList<sach> ds, Scanner sc) {
        System.out.print("Nhap ma sach can sua: ");
        String ma = sc.nextLine();

        int viTri = timvitri(ds, ma);

        if (viTri == -1) {
            System.out.println("Khong tim thay sach!");
            return;
        }

        sach s = ds.get(viTri);

        System.out.print("Ten sach moi: ");
        s.setTensach(sc.nextLine());

        System.out.print("Tac gia moi: ");
        s.setTacgia(sc.nextLine());

        System.out.print("Nam xuat ban moi: ");
        s.setnamxuatban(sc.nextInt());

        System.out.print("So luong moi: ");
        s.setsoluong(sc.nextInt());
        sc.nextLine();

        System.out.println("Cap nhat sach thanh cong!");
    }

    public static int tinhTongSoLuong(ArrayList<sach> ds, int n) {
        if (n == 0) {
            return 0;
        } else {
            return ds.get(n-1).getSoluong() + tinhTongSoLuong(ds, n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<sach> ds = new ArrayList<>();
        int luachon, n;
        do {
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi sach");
            System.out.println("3. Tim sach");
            System.out.println("4. Xoa sach");
            System.out.println("5. Sua sach");
            System.out.println("6. Tinh tong so luong");
            System.out.println("7. Thoat");
            System.out.print("Nhap lua chon: ");
            luachon = sc.nextInt();
            sc.nextLine();

            switch (luachon) {
                case 1:
                    System.out.print("Nhap so sach can them:  ");
                    n = sc.nextInt();
                    sc.nextLine();
                    themSach(ds, sc, n);
                    break;

                case 2:
                    insach(ds);
                    break;
                case 3:
                    if (ds.isEmpty()) {
                        System.out.println("Danh sach sach rong!");
                    } else {
                        System.out.print("Nhap ma sach can tim: ");
                        String ma = sc.nextLine();

                        if (timsach(ds, ma))
                            System.out.println("Tim thay sach!");
                        else
                            System.out.println("Khong tim thay sach!");
                    }
                    break;
                case 4:
                    xoasach(ds, sc);
                    break;
                case 5:
                    suasach(ds, sc);
                    break;
                case 6:
                    if (ds.isEmpty())
                        System.out.println("Danh sach sach rong!");
                    else
                        System.out.println("Tong so luong sach: " + tinhTongSoLuong(ds, ds.size()));
                    break;
                case 7:
                    System.out.println("Ket thuc chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (luachon != 7);
        sc.close();
    }
}
