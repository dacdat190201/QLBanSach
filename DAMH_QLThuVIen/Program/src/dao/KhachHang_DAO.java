/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect_database.OracleProvider;
import doi_tuong.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class KhachHang_DAO {
    public static void show_DS_KhachHang(DefaultTableModel dtmDSKhachHang, String user, String pass){
        try {
            String sql = "select MAKH, HOTEN, DIACHI, SODT, to_char(NGAYSINH, 'fmDD - MM - YYYY') as NgaySinh from ADMIN_SACH.KHACHHANG";
            Connection conn = OracleProvider.connect_database(user, pass);
            PreparedStatement prepared = conn.prepareStatement(sql);
            ResultSet rs = prepared.executeQuery();
            while (rs.next()) {                
                Vector<Object> vec = new Vector<Object>();
                vec.add(rs.getString("MaKH"));
                vec.add(rs.getString("HoTen"));
                vec.add(rs.getString("DiaChi"));
                vec.add(rs.getString("SoDT"));
                vec.add(rs.getString("NgaySinh"));
                
                dtmDSKhachHang.addRow(vec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static boolean check_KH(String maKH, String user, String pass){
        try {
            String sql = String.format("select *from ADMIN_SACH.KHACHHANG where MaKH = '%s' ", maKH);
            Connection con = OracleProvider.connect_database(user, pass);
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean update_KhachHang(KhachHang kh, String user, String pass){
        try {
            String sql = "update ADMIN_SACH.KHACHHANG\n" +
                        "set HoTen = ?, DiaChi = ?, SoDT = ?, NgaySinh = TO_DATE(?, 'DD/MM/YYYY')\n" +
                        "where MaKH = ?";
            Connection con = OracleProvider.connect_database(user, pass);
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, kh.getHoTen());
            pre.setString(2, kh.getDiaChiKH());
            pre.setString(3, kh.getSdtKH());
            pre.setString(4, kh.getNgaySinh());
            pre.setString(5, kh.getMaKH());
            
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean insert_KhachHang(KhachHang kh, String user, String pass){
        try {
            String sql = "INSERT INTO ADMIN_SACH.KhachHang\n" +
                            "VALUES  (? , ?, ?, ?, TO_DATE(?, 'DD/MM/YYYY'))";
            Connection con = OracleProvider.connect_database(user, pass);
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, kh.getMaKH());
            pre.setString(2, kh.getHoTen());
            pre.setString(3, kh.getDiaChiKH());
            pre.setString(4, kh.getSdtKH());
            pre.setString(5, kh.getNgaySinh());
            
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean delete_KhachHang(String maKH, String user, String pass){
        try {
            String sql = "delete from ADMIN_SACH.KHACHHANG where maKH = ?";
            Connection con = OracleProvider.connect_database(user, pass);
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, maKH);
            
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
