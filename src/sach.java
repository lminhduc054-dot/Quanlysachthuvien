public class sach {
    private String masach;
    private String tensach;
    private String tacgia;
    private int namxuatban;
    private int soluong;

    public sach() {
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public int getNamxuatban() {
        return namxuatban;
    }

    public void setnamxuatban(int namxuatban) {
        if (namxuatban > 0 && namxuatban <= 2026)
            this.namxuatban = namxuatban;
        else
            System.err.println("Nam xuat ban khong hop le");
    }

    public int getSoluong() {
        return soluong;
    }

    public void setsoluong(int soluong) {
        if (soluong >= 0)
            this.soluong = soluong;
        else
            System.err.println("So luong khong the nho hon 0!");
    }

    //constructor có tham số
    public sach(String masach, String tensach, String tacgia, int namxuatban, int soluong) {
        this.masach = masach;
        this.tensach = tensach;
        this.tacgia = tacgia;
        setnamxuatban(namxuatban);  
        setsoluong(soluong);
    }

    public void hienThiThongTin() {
    System.out.println("Ma sach: " + masach);
    System.out.println("Ten sach: " + tensach);
    System.out.println("Tac gia: " + tacgia);
    System.out.println("Nam xuat ban: " + namxuatban);
    System.out.println("So luong: " + soluong);
}
}
