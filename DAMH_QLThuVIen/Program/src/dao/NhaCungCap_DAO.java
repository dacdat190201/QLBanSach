/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect_database.OracleProvider;
import doi_tuong.NhaCungCap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class NhaCungCap_DAO {
    public static void show_DSNhaCUngCap(DefaultTableModel dtmDSNhaCungCap, String user, String pass){
        try {
            String sql = "select *from ADMIN_SACH.NHACUNGCAP";
            Connection conn = OracleProvider.connect_database(user, pass);
            PreparedStatement prepared = conn.prepareStatement(sql);
            ResultSet rs = prepared.executeQuery();
            while (rs.next()) {                
                Vector<Object> vec = new Vector<Object>();
                vec.add(rs.getString("MaNCC"));
                vec.add(rs.getString("TenNCC"));
                vec.add(rs.getString("DiaChi"));
                vec.add(rs.getString("DienThoai"));
                
                dtmDSNhaCungCap.addRow(vec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static boolean check_NCC(String mancc, String user, String pass){
        try {
            String sql = "select *from ADMIN_SACH.NHACUNGCAP where MaNCC = ?";
            Connection conn = OracleProvider.connect_database(user, pass);
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, mancc);
            ResultSet rs = preparedStatement.executeQuery();
            
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean update_NCC(NhaCungCap ncc, String user, String pass){
        try {
            String sql = "update ADMIN_SACH.NHACUNGCAP\n" +
                        "set TENNCC = ?, DIACHI = ?, DIENTHOAI = ?\n" +
                        "where MANCC = ?";
            Connection conn = OracleProvider.connect_database(user, pass);
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, ncc.getTenNCC());
            preparedStatement.setString(2, ncc.getDiaChiNCC());
            preparedStatement.setString(3, ncc.getSdtNCC());
            preparedStatement.setString(4, ncc.getMaNCC());
            
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean insert_NCC(NhaCungCap ncc, String user, String pass){
        try {
            String sql = "INSERT INTO ADMIN_SACH.NhaCungCap\n" +
                        "VALUES(?, ?, ?, ?)";
            Connection conn = OracleProvider.connect_database(user, pass);
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, ncc.getMaNCC());
            preparedStatement.setString(2, ncc.getTenNCC());
            preparedStatement.setString(3, ncc.getDiaChiNCC());
            preparedStatement.setString(4, ncc.getSdtNCC());
            
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  false;
    }
    
    public static boolean delete_NCC(String mancc, String user, String pass){
        try {
            String sql = "delete from ADMIN_SACH.NHACUNGCAP where MANCC = ?";
            Connection connection = OracleProvider.connect_database(user, pass);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, mancc);
            
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
