/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect_database.OracleProvider;
import doi_tuong.NhanVien;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class NhanVien_DAO {
    
    public boolean check_dn(String user, String pass){
        try {
            Connection conn = OracleProvider.connect_database(user, pass);
            
            if (conn == null)
                return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public String get_lan_dn_cuoi(String user, String pass){
        String s = "";
        try {
            Connection con = OracleProvider.connect_database(user.toUpperCase(), pass);
            String sql = "select * from dba_users where username = ? ";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, user.toUpperCase());
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {                
                s += rs.getString("LAST_LOGIN");
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void show_DSNhanVien(DefaultTableModel dtmDSNhanVien, String user, String pass){
        try {
            String sql = "select MANV, TENNV, to_char(NgaySinh, 'fmDD - MM - YYYY') as NgaySinh, GIOITINH, EMAIL, SODT from ADMIN_SACH.NHANVIEN";
            Connection conn = OracleProvider.connect_database(user, pass);
            PreparedStatement prepared = conn.prepareStatement(sql);
            ResultSet rs = prepared.executeQuery();
            
            while (rs.next()) {                
                Vector<Object> vec = new Vector<Object>();
                vec.add(rs.getString("MaNV"));
                vec.add(rs.getString("TenNV"));
                vec.add(rs.getString("NgaySinh"));
                vec.add(rs.getString("GioiTinh"));
                vec.add(rs.getString("Email"));
                vec.add(rs.getString("SoDT"));
                
                dtmDSNhanVien.addRow(vec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static boolean check_NhanVien_TonTai(String maNV, String user, String pass){
        try {
            String sql = "select *from ADMIN_SACH.NHANVIEN where MaNV = ?";
            Connection conn  = OracleProvider.connect_database(user, pass);
            PreparedStatement prepared = conn.prepareStatement(sql);
            prepared.setString(1, maNV);
            ResultSet rs = prepared.executeQuery();
            
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean update_NhanVien(NhanVien nv, String user, String pass){
        try {
            String update_NV = "update ADMIN_SACH.NHANVIEN\n" +
                            "set TenNV = ?, NgaySinh = TO_DATE(?, 'DD/MM/YYYY'), GioiTinh = ?, Email = ?, SoDT = ?\n" +
                            "where MaNV = ?";
            Connection conn = OracleProvider.connect_database(user, pass);
            PreparedStatement preparedStatement = conn.prepareStatement(update_NV);
            preparedStatement.setString(1, nv.getTenNV());
            preparedStatement.setString(2, nv.getNgaySinh());
            preparedStatement.setString(3, nv.getGioiTinh());
            preparedStatement.setString(4, nv.getEmailNV());
            preparedStatement.setString(5, nv.getSdtNV());
            preparedStatement.setString(6, nv.getMaNV());         
                       
            int kq = preparedStatement.executeUpdate();
            return kq > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean update_NhanVien_Anh(NhanVien nv, String user, String pass){
        try {
            String update_NV = "update ADMIN_SACH.NHANVIEN\n" +
                            "set HinhAnh = ?\n" +
                            "where MaNV = ?";
            Connection conn = OracleProvider.connect_database(user, pass);
            PreparedStatement preparedStatement = conn.prepareStatement(update_NV);
            preparedStatement.setBlob(1, nv.getAnhNV());
            preparedStatement.setString(2, nv.getMaNV());
            
            int kq = preparedStatement.executeUpdate();
            return kq > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }    
    
    public static boolean insert_NhanVien(NhanVien nv, String user, String pass){
        try {
            String insert = "INSERT INTO ADMIN_SACH.NHANVIEN\n" +
                            "VALUES (?, ?,TO_DATE(?, 'DD/MM/YYYY'), ?, ?, ?, ?)";
            Connection connec = OracleProvider.connect_database(user, pass);
            PreparedStatement prepared = connec.prepareStatement(insert);
            prepared.setString(1, nv.getMaNV());
            prepared.setString(2, nv.getTenNV());
            prepared.setString(3, nv.getNgaySinh());
            prepared.setString(4, nv.getGioiTinh());
            prepared.setString(5, nv.getEmailNV());
            prepared.setString(6, nv.getSdtNV());
            prepared.setBlob(7, nv.getAnhNV());

            
            return prepared.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static InputStream getNV(String manv){
        try {
            String sql = String.format("select HinhAnh from ADMIN_SACH.NhanVien where MaNV = '%s'", manv);
            Connection con = OracleProvider.connect_database("Admin_Sach", "admin123");
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                return rs.getBinaryStream(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static boolean delete_NhanVien(String manv, String user, String pass){
        try {
            String sql = "delete from ADMIN_SACH.NHANVIEN where MaNV = ?";
            Connection conn = OracleProvider.connect_database(user, pass);
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, manv);
            
            return preparedStatement.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
