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
public class HDBan_DAO {
    public static void show_DS_HDBan(DefaultTableModel dtmDSHDBan , String user, String pass){
        try {
            dtmDSHDBan.setRowCount(0);
            String sql = "select MAPHIEUDH, MANV, MAKH, To_Char(NGAYLAP_DH,'DD/MM/YYYY HH24:MI:SS'), p.tong_sl_dat, p.tongtien  \n" +
                        "from ADMIN_SACH.PHIEUDATHANG p";
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
                
                dtmDSHDBan.addRow(vec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static boolean tim_HDBan_theoNgay(DefaultTableModel dtmDSHDBan, String ngay, String user, String pass){
        try {
            boolean sc = false;
            dtmDSHDBan.setRowCount(0);
            String sql = String.format("Select V_Maphieudh,V_Manv,V_Makh,To_Char(V_Ngaylap_Dh,'DD/MM/YYYY'),V_Tong_Sl_Dat,V_Tongtien\n" +
                    "From Table (ADMIN_SACH.Return_Table_TK_Ngay('%s'))", ngay);
            Connection con = OracleProvider.connect_database(user, pass);
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
                
                dtmDSHDBan.addRow(vec);
                sc = true;
            }
            if (!sc)
                return false;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean tim_HDBan_theoMaKH(DefaultTableModel dtmDSHDBan, String makh, String user, String pass){
        try {
            boolean sc = false;
            dtmDSHDBan.setRowCount(0);
            String sql = String.format("Select V_Maphieudh,V_Manv,V_Makh,To_Char(V_Ngaylap_Dh,'DD/MM/YYYY HH24:MI:SS'),V_Tong_Sl_Dat,V_Tongtien   \n" +
                                    "From Table (ADMIN_SACH.Return_TableDHKH('%s'))", makh);
            Connection con = OracleProvider.connect_database(user, pass);
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
                
                dtmDSHDBan.addRow(vec);
                sc = true;
            }
            if (!sc)
                return false;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }    
    
    public static boolean insert_HDBan(int maphieu, String manv, String makh, String ngaylap, int tongsl, int tongtien,
            String user, String pass){
        try {
            String sql = "INSERT INTO PHIEUDATHANG VALUES(?, ?, ?, TO_DATE(?, 'DD/MM/YYYY HH24:MI:SS'), ?, ?)";
            Connection con = OracleProvider.connect_database(user, pass);
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, maphieu);
            pre.setString(2, manv);
            pre.setString(3, makh);
            pre.setString(4, ngaylap);
            pre.setInt(5, tongsl);
            pre.setInt(6, tongtien);
            
            return pre.executeUpdate() > -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
