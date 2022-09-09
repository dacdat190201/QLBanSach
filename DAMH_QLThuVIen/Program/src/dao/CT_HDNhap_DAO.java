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
public class CT_HDNhap_DAO {
    public static void show_DS_CTHDNhap(DefaultTableModel dtmCTHDNhap, String user, String pass, String maDonNhap){
        try {
            dtmCTHDNhap.setRowCount(0);
            String sql = "select * from ADMIN_SACH.CT_PHIEUNHAPHANG where MaPhieuNhapHang = ?";
            Connection conn = OracleProvider.connect_database(user, pass);
            PreparedStatement prepared = conn.prepareStatement(sql);
            prepared.setString(1, maDonNhap);
            ResultSet rs = prepared.executeQuery();
            while (rs.next()) {                
                Vector<Object> vec = new Vector<Object>();
                vec.add(rs.getString("MaPhieuNhapHang"));
                vec.add(rs.getString("MaSach"));
                vec.add(rs.getString("Sluong"));
                vec.add(rs.getString("DonGiaNhap"));
                int sl = rs.getInt("Sluong");
                int dg = rs.getInt("DonGiaNhap");
                vec.add(sl * dg);
                
                dtmCTHDNhap.addRow(vec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
