/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doi_tuong;

/**
 *
 * @author Admin
 */
public class HDBan {
    private String maPhieuBan;
    private String maNV;
    private String maKH;
    private String ngayLap;
    private int tongSL;
    private int tongTien;

    public HDBan() {
    }

    public HDBan(String maPhieuNhap, String maNV, String maKH, String ngayLap, int tongSL, int tongTien) {
        this.maPhieuBan = maPhieuNhap;
        this.maNV = maNV;
        this.maKH = maKH;
        this.ngayLap = ngayLap;
        this.tongSL = tongSL;
        this.tongTien = tongTien;
    }

    public String getMaPhieuBan() {
        return maPhieuBan;
    }

    public void setMaPhieuBan(String maPhieuNhap) {
        this.maPhieuBan = maPhieuNhap;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public int getTongSL() {
        return tongSL;
    }

    public void setTongSL(int tongSL) {
        this.tongSL = tongSL;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
    
}
