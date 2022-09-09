/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect_database.OracleProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class CT_HDBan_DAO {
    public static void show_CT_HDBan(DefaultTableModel dtmDSCTHDBan, String user, String pass, String maDonHang){
        try {
            dtmDSCTHDBan.setRowCount(0);
            String sql = "select *from ADMIN_SACH.CT_PHIEUDATHANG where MaPhieuDH = ?";
            Connection conn = OracleProvider.connect_database(user, pass);
            PreparedStatement prepared = conn.prepareStatement(sql);
            prepared.setString(1, maDonHang);
            ResultSet rs = prepared.executeQuery();
            while (rs.next()) {                
                Vector<Object> vec = new Vector<Object>();
                vec.add(rs.getString("MaPhieuDH"));
                vec.add(rs.getString("MaSach"));
                vec.add(rs.getString("SoLuong"));
                vec.add(rs.getString("DonGia"));
                int sl = rs.getInt("SoLuong");
                int dg = rs.getInt("DonGia");
                vec.add(sl * dg);
                
                dtmDSCTHDBan.addRow(vec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static boolean insert_CT_HDBan(int maphieu, String masach, int soLuong, int donGia, int thanhtien,
            String user, String pass){
        try {
            String sql = "INSERT INTO ADMIN_SACH.CT_PHIEUDATHANG VALUES(?,?,?,?,?)";
            Connection con = OracleProvider.connect_database(user, pass);
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, maphieu);
            pre.setString(2, masach);
            pre.setInt(3, soLuong);
            pre.setInt(4, donGia);
            pre.setInt(5, thanhtien);
            
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
