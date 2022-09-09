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
public class CT_HDBan {
    private String maPhieuBan;
    private String maSach;
    private int soLuong;
    private int donGia;
    private int thanhTien;

    public CT_HDBan() {
    }

    public CT_HDBan(String maPhieuBan, String maSach, int soLuong, int donGia, int thanhTien) {
        this.maPhieuBan = maPhieuBan;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public String getMaPhieuBan() {
        return maPhieuBan;
    }

    public void setMaPhieuBan(String maPhieuBan) {
        this.maPhieuBan = maPhieuBan;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }
}
