/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doi_tuong;

import java.io.InputStream;
import java.sql.Blob;



public class NhanVien {
    private String maNV;
    private String tenNV;
    private String ngaySinh;
    private String gioiTinh;
    private String emailNV;
    private String sdtNV;
    private InputStream anhNV;

    public NhanVien(String maNV, String tenNV, String ngaySinh, String gioiTinh, String emailNV, String sdtNV, InputStream anhNV) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.emailNV = emailNV;
        this.sdtNV = sdtNV;
        this.anhNV = anhNV;
    }

    public NhanVien() {
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getEmailNV() {
        return emailNV;
    }

    public void setEmailNV(String emailNV) {
        this.emailNV = emailNV;
    }

    public String getSdtNV() {
        return sdtNV;
    }

    public void setSdtNV(String sdtNV) {
        this.sdtNV = sdtNV;
    }

    public InputStream getAnhNV() {
        return anhNV;
    }

    public void setAnhNV(InputStream anhNV) {
        this.anhNV = anhNV;
    }
}
