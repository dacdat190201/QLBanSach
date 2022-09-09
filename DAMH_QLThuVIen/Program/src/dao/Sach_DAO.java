/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect_database.OracleProvider;
import doi_tuong.Sach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class Sach_DAO {
    public static void show_DS_Sach(DefaultTableModel dtmDSSach, String user, String pass){
        try {
            String sql = "SELECT * FROM TABLE (ADMIN_SACH.return_table())";
            Connection conn = OracleProvider.connect_database(user, pass);
            PreparedStatement prepared = conn.prepareStatement(sql);
            ResultSet rs = prepared.executeQuery();
            while (rs.next()) {                
                Vector<Object> vec = new Vector<Object>();
                vec.add(rs.getString(1));
                vec.add(rs.getString(2));
                vec.add(rs.getString(3));
                vec.add(rs.getString(4));
                vec.add(rs.getString(5));
                vec.add(rs.getString(6));
                vec.add(rs.getString(7));
                vec.add(rs.getString(8));
                vec.add(rs.getString(9));
                
                dtmDSSach.addRow(vec);                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void load_cboTheLoai(JComboBox cboTheLoai, String user, String pass){
        try {
            String sql ="select *from ADMIN_SACH.THELOAI";
            Connection conn = OracleProvider.connect_database(user, pass);
            PreparedStatement preaPreparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preaPreparedStatement.executeQuery();
            while (rs.next()) {                
                cboTheLoai.addItem(rs.getString("TenLoai"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static int get_theLoai(String theLoai, String user, String pass){
        try {
            String sql = "select MaLoai from ADMIN_SACH.THELOAI where TenLoai = ?";
            Connection connection = OracleProvider.connect_database(user, pass);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, theLoai);
            ResultSet rs = preparedStatement.executeQuery();
            int tl = -1;
            while (rs.next()) {                
                tl = rs.getInt("MaLoai");
            }
            return tl;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    public static void show_DS_Sach_TrangChu(DefaultTableModel dtmDSSach, String user, String pass){
        try {
            String sql = "select v_MaSach, v_TenSach, v_TacGia, v_NhaXB, v_NamXB, v_TenLoai, v_GiamGia, v_GiaBan\n" +
                            "from table (ADMIN_SACH.return_table())";
            Connection conn = OracleProvider.connect_database(user, pass);
            PreparedStatement prepared = conn.prepareStatement(sql);
            ResultSet rs = prepared.executeQuery();
            while (rs.next()) {                
                Vector<Object> vec = new Vector<Object>();
                vec.add(rs.getString(1));
                vec.add(rs.getString(2));
                vec.add(rs.getString(3));
                vec.add(rs.getString(4));
                vec.add(rs.getString(5));
                vec.add(rs.getString(6));
                vec.add(rs.getString(7));
                vec.add(rs.getString(8));
                
                dtmDSSach.addRow(vec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static boolean check_Sach(String mas, String user, String pass){
        try {
            String sql = "select *from ADMIN_SACH.THONGTINSACH where MaSach = ?";
            Connection conn = OracleProvider.connect_database(user, pass);
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, mas);
            
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean update_sach(Sach s, String user, String pass){
        try {
            String sql = "update ADMIN_SACH.THONGTINSACH\n" +
                        "set TenSach = ?, TacGia = ?, NhaXB = ?, NamXB = ?, MaLoai = ?, GiamGia = ?, GiaBan = ?\n" +
                        "where MaSach = ?";
            Connection con = OracleProvider.connect_database(user, pass);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, s.getTenSach());
            preparedStatement.setString(2, s.getTacGia());
            preparedStatement.setString(3, s.getNhaXB());
            preparedStatement.setInt(4, s.getNamXB());
            preparedStatement.setInt(5, s.getMaLoai());
            preparedStatement.setFloat(6, s.getGiamGia());
            preparedStatement.setInt(7, s.getGiaBan());
            preparedStatement.setString(8, s.getMaSach());
            up_TK(s.getTonKho(), s.getMaSach(), con);
            
            return preparedStatement.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean up_TK(int soluongton, String masach, Connection con){
        try {
            String sql = "update ADMIN_SACH.SachTonKho set SOLUONGTON = ? where MASACH = ?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, soluongton);
            pre.setString(2, masach);
            
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean insert_Sach(Sach s, int tonKho, String user, String pass){
        try {
            String sql = "INSERT INTO ADMIN_SACH.ThongTinSach\n" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            Connection connection  = OracleProvider.connect_database(user, pass);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, s.getMaSach());
            preparedStatement.setString(2, s.getTenSach());
            preparedStatement.setString(3, s.getTacGia());
            preparedStatement.setString(4, s.getNhaXB());
            preparedStatement.setInt(5, s.getNamXB());
            preparedStatement.setInt(6, s.getMaLoai());
            preparedStatement.setFloat(7, s.getGiamGia());
            preparedStatement.setInt(8, s.getGiaBan());
            
            insert_TonKho(s.getMaSach(), tonKho, connection);
            
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static void insert_TonKho(String masach, int tonkho, Connection conn){
        try {
            String sql = "INSERT INTO ADMIN_SACH.SachTonKho\n" +
                        "VALUES	(?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, masach);
            preparedStatement.setInt(2, tonkho);
            
            int kq = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static boolean delete_Sach(String mas, String user, String pass){
        try {
            String sql = "delete from ADMIN_SACH.THONGTINSACH where MaSach = ?";
            Connection connection = OracleProvider.connect_database(user, pass);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, mas);
            
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static String get_TenSach(String mas, String user, String pass){
        try {
            String sql = "select *from ADMIN_SACH.THONGTINSACH where MaSach = ?";
            Connection con = OracleProvider.connect_database(user, pass);
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            String tenSach = "";
            while (rs.next()) {                
                tenSach = rs.getString("TenSach");
                return tenSach;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static boolean update_TOnKho(int sluong, String maSach, String user, String pass){
        try {//-----------------Update số lượng tồn kho của các sách đã được bán
            String sqlUP = "update ADMIN_SACH.SachTonKho\n" +
                            "set soLuongTon = soLuongTon - ?\n" +
                            "where MaSach = ?";
            Connection connect = OracleProvider.connect_database(user, pass);
            PreparedStatement preparedStatement = connect.prepareStatement(sqlUP);
            preparedStatement.setInt(1, sluong);
            preparedStatement.setString(2, maSach);

            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return false;
    }
    
    public static boolean find_sach(DefaultTableModel dtmSach, String dieu_kien, String user, String pass){
        dtmSach.setRowCount(0);
        boolean kt = false;
        boolean sc = false;
        Connection con = OracleProvider.connect_database(user, pass);
        int gb = 0;
        try {
            gb = Integer.parseInt(dieu_kien);
        } catch (Exception e) {
            kt = true;
        }
        if (!kt){
            String sql = String.format("select *from table(ADMIN_SACH.tk_sach_gia_ban(%d))",gb);
            try {
                PreparedStatement pre = con.prepareStatement(sql);
                ResultSet rs = pre.executeQuery();
                while (rs.next()) {                
                    Vector<Object> vec = new Vector<Object>();
                    vec.add(rs.getString(1));
                    vec.add(rs.getString(2));
                    vec.add(rs.getString(3));
                    vec.add(rs.getString(4));
                    vec.add(rs.getString(5));
                    vec.add(rs.getString(6));
                    vec.add(rs.getString(7));
                    vec.add(rs.getString(8));

                    dtmSach.addRow(vec);
                    sc = true;
                }
                if (sc)
                    return true;
                else return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }else {
            String sql = String.format("select *from table(ADMIN_SACH.tk_sach('%s'))", dieu_kien);
            try {
                PreparedStatement pre = con.prepareStatement(sql);
                ResultSet rs = pre.executeQuery();
                while (rs.next()) {                
                    Vector<Object> vec = new Vector<Object>();
                    vec.add(rs.getString(1));
                    vec.add(rs.getString(2));
                    vec.add(rs.getString(3));
                    vec.add(rs.getString(4));
                    vec.add(rs.getString(5));
                    vec.add(rs.getString(6));
                    vec.add(rs.getString(7));
                    vec.add(rs.getString(8));

                    dtmSach.addRow(vec);
                    sc = true;
                }
                if (sc)
                    return true;
                else return false;
            } catch (Exception e) {
                return false;
            }
        }        
    }
}
