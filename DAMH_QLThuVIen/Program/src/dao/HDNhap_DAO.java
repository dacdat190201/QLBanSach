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
public class HDNhap_DAO {
    public static void show_DS_HDNhap(DefaultTableModel dtmHDNhap, String user, String pass){
        try {
            String sql = "select maphieunhaphang, mancc, manv, To_Char(ngaylap_pn,'DD/MM/YYYY HH24:MI:SS'), tongsl, tongtien_nh from ADMIN_SACH.phieunhaphang";
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
                
                dtmHDNhap.addRow(vec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static boolean tk_hdn_ngay(DefaultTableModel dtmHDNhap, String ngay, String user, String pass){
        try {
            dtmHDNhap.setRowCount(0);
            boolean sc = false;
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
                
                dtmHDNhap.addRow(vec);
                sc = true;
            }
            if (sc)
                return true;
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean tk_hdn_manv(DefaultTableModel dtmHDNhap, String manv, String user, String pass){
        try {
            dtmHDNhap.setRowCount(0);
            boolean sc = false;
            String sql = String.format("Select V_Maphieunhap,V_MaNCC,V_Manv,To_Char(V_Ngaylap_pn,'DD/MM/YYYY HH24:MI:SS'),V_Tong_Sl_Nhap,V_TongTien_nhap\n" +
                                        "From Table (ADMIN_SACH.tk_nhap_hang_manv('%s'))", manv);
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
                
                dtmHDNhap.addRow(vec);
                sc = true;
            }
            if (sc)
                return true;
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }    
}
