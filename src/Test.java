import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    static void nhapDanhSach(ArrayList<sach> ds, Scanner sc) {
        System.out.print("Nhap so luong sach can them: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap sach thu " + (i + 1));
            System.out.println("1. Sach giao khoa");
            System.out.println("2. Sach tham khao");
            System.out.print("Chon loai sach: ");

            int loai = sc.nextInt();

            sach s;

            if (loai == 1)
                s = new sachgiaokhoa();
            else if (loai == 2)
                s = new sachthamkhao();
            else {
                System.out.println("Loai sach khong hop le!");
                i--;
                continue;
            }
            s.nhap(sc);
            ds.add(s);
        }
    }

    static void xuatDanhSach(ArrayList<sach> ds) {
        if (ds.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }

        for (int i = 0; i < ds.size(); i++) {
            sach s = ds.get(i);
            s.hienThiThongTin();
        }
    }

    static double tongThanhTienSGK(ArrayList<sach> ds) {
        double tong = 0;

        for (int i = 0; i < ds.size(); i++) {
            sach s = ds.get(i);

            if (s instanceof sachgiaokhoa) {
                tong += s.tinhThanhTien();
            }
        }

        return tong;
    }

    static double tongThanhTienSTK(ArrayList<sach> ds) {
        double tong = 0;

        for (int i = 0; i < ds.size(); i++) {
            sach s = ds.get(i);

            if (s instanceof sachthamkhao) {
                tong += s.tinhThanhTien();
            }
        }

        return tong;
    }

    static void trungBinhDonGiaSTK(ArrayList<sach> ds) {
        double tongDonGia = 0;
        int dem = 0;

        for (int i = 0; i < ds.size(); i++) {
            sach s = ds.get(i);

            if (s instanceof sachthamkhao) {
                tongDonGia += s.getDongia();
                dem++;
            }
        }

        if (dem == 0)
            System.out.println("Khong co sach tham khao!");
        else
            System.out.println("Trung binh don gia sach tham khao: "
                    + tongDonGia / dem);

    }

    static void xuatSGKTheoNXB(ArrayList<sach> ds, Scanner sc) {
        System.out.print("Nhap nha xuat ban can tim: ");
        String nxb = sc.nextLine();

        boolean timThay = false;

        for (int i = 0; i < ds.size(); i++) {
            sach s = ds.get(i);

            if (s instanceof sachgiaokhoa
                    && s.getNhaxuatban().equalsIgnoreCase(nxb)) {

                s.hienThiThongTin();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay sach giao khoa cua NXB nay!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<sach> ds = new ArrayList<>();

        int luaChon;

        do {
            System.out.println("1. Nhap danh sach sach");
            System.out.println("2. Xuat danh sach sach");
            System.out.println("3. Tong thanh tien sach giao khoa");
            System.out.println("4. Tong thanh tien sach tham khao");
            System.out.println("5. Trung binh don gia sach tham khao");
            System.out.println("6. Xuat sach giao khoa theo NXB");
            System.out.println("7. Thoat");
            System.out.print("Nhap lua chon: ");
            luaChon = sc.nextInt();
            switch (luaChon) {
                case 1:
                    nhapDanhSach(ds, sc);
                    break;

                case 2:
                    xuatDanhSach(ds);
                    break;

                case 3:
                    System.out.println("Tong thanh tien sach giao khoa: "
                            + tongThanhTienSGK(ds));
                    break;

                case 4:
                    System.out.println("Tong thanh tien sach tham khao: "
                            + tongThanhTienSTK(ds));
                    break;

                case 5:
                    trungBinhDonGiaSTK(ds);
                    break;

                case 6:
                    xuatSGKTheoNXB(ds, sc);
                    break;

                case 7:
                    System.out.println("Ket thuc chuong trinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (luaChon != 7);

        sc.close();
    }
}
