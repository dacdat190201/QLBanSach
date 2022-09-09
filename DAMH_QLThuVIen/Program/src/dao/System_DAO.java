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
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.naming.spi.DirStateFactory;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class System_DAO {
    static String user = "Admin_sach";
    static String pass = "admin123";
    
    public static boolean revoke_grant_user(String username, String revoke){
        try {
            String sql = String.format("revoke %s from %s", revoke, username);
            Connection con = OracleProvider.connect_database(user, pass);
            PreparedStatement pre = con.prepareStatement(sql);
            
            return pre.executeUpdate() > -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean add_grant(String username, String grant){
        try {
            String sql = String.format("grant %s to %s", grant, username);
            Connection con = OracleProvider.connect_database(user, pass);
            PreparedStatement pre = con.prepareStatement(sql);
            
            return pre.executeUpdate() > -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static void show_DS_Process(DefaultTableModel dtmProcess){
        try {
            String sql = "select pid, sosid, execution_type, pname, username, serial#, terminal, program, traceid, background from v$process";
            Connection conn = OracleProvider.connect_database(user, pass);
            PreparedStatement pre = conn.prepareStatement(sql);
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
                vec.add(rs.getString(9));
                vec.add(rs.getString(10));
                
                dtmProcess.addRow(vec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void show_DS_Instance(DefaultTableModel dtmInstance){
        try {
            String sql = "select instance_number, instance_name, host_name, version, startup_time, status, parallel, thread#, archiver, logins, database_status, instance_role, instance_mode from v$instance";
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
                vec.add(rs.getString(7));
                vec.add(rs.getString(8));
                vec.add(rs.getString(9));
                vec.add(rs.getString(10));
                vec.add(rs.getString(11));
                vec.add(rs.getString(12));
                vec.add(rs.getString(13));
                
                dtmInstance.addRow(vec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void show_DS_Database(DefaultTableModel dtmDatabase){
        try {
            String sql = "select name, to_char(created, 'fmDD - MM - YYYY'),  Resetlogs_time, Prior_resetlogs_time, log_mode, controlfile_type,\n" +
                        "controlfile_created, controlfile_time, open_resetlogs, version_time, open_mode, protection_mode\n" +
                        "from v$database";
            Connection con = OracleProvider.connect_database(user, pass);
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {                
                Vector<Object> vec = new Vector<Object>();
                vec.add((rs.getString(1)));
                vec.add((rs.getString(2)));
                vec.add((rs.getString(3)));
                vec.add((rs.getString(4)));
                vec.add((rs.getString(5)));
                vec.add((rs.getString(6)));
                vec.add((rs.getString(7)));
                vec.add((rs.getString(8)));
                vec.add((rs.getString(9)));
                vec.add((rs.getString(10)));
                vec.add((rs.getString(11)));
                vec.add((rs.getString(12)));
                dtmDatabase.addRow(vec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    

    public static void show_DS_Datafiles(DefaultTableModel dtmDatafiles){
        try {
            String sql = "select name, file#, creation_change#, creation_time, ts#, rfile#, status, enabled, checkpoint_change#, checkpoint_time, online_time\n" +
                        "from v$datafile";
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
                vec.add(rs.getString(7));
                vec.add(rs.getString(8));
                vec.add(rs.getString(9));
                vec.add(rs.getString(10));
                vec.add(rs.getString(11));
                
                dtmDatafiles.addRow(vec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
    
    public static void show_DS_Session(DefaultTableModel dtmSession){
        try {
            dtmSession.setRowCount(0);
            String sql = "select sid, serial#, username, status, server, osuser, process, machine, port, program, type, logon_time, resource_consumer_group\n" +
                    "from v$session where username is not null";
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
                vec.add(rs.getString(7));
                vec.add(rs.getString(8));
                vec.add(rs.getString(9));
                vec.add(rs.getString(10));
                vec.add(rs.getString(11));
                vec.add(rs.getString(12));
                vec.add(rs.getString(13));
                
                dtmSession.addRow(vec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
    
    public static boolean kill_Session(String sid, String serial){
        try {
            Connection conn = OracleProvider.connect_database(user, pass);
            String sql = String.format("alter system kill session '%s,%s' immediate", sid, serial);
            PreparedStatement pre = conn.prepareStatement(sql);
            
            
            return pre.executeUpdate() > -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static void show_DS_Tablespace(DefaultTableModel dtmTablespace){
        try {
            String sql = "select tablespace_name, block_size, initial_extent, min_extents, max_extents, max_size, status, contents, logging, force_logging, extent_management,\n" +
                        "allocation_type, plugged_in, segment_space_management, retention\n" +
                        "from dba_tablespaces";
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
                vec.add(rs.getString(7));
                vec.add(rs.getString(8));
                vec.add(rs.getString(9));
                vec.add(rs.getString(10));
                vec.add(rs.getString(11));
                vec.add(rs.getString(12));
                vec.add(rs.getString(13));
                vec.add(rs.getString(14));
                vec.add(rs.getString(15));
                
                dtmTablespace.addRow(vec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }      
    
    public static boolean create_tablesapce(String tablespace_name){
        try {
            String sql = String.format("CREATE TABLESPACE %s DATAFILE 'C:\\app\\Admin\\oradata\\orcl2\\%s.DBF' SIZE 10M",
                    tablespace_name, tablespace_name);
            Connection conn = OracleProvider.connect_database(user, pass);
            PreparedStatement pre = conn.prepareStatement(sql);
            
            return pre.executeUpdate() > -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean delete_tablespace(String table_name){
        try {
            String sql = String.format("drop TABLESPACE %s INCLUDING CONTENTS", table_name);
            Connection conn = OracleProvider.connect_database(user, pass);
            PreparedStatement pre = conn.prepareStatement(sql);
            
            return pre.executeUpdate() > -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static void get_tablespace_name(JComboBox cboTablespace){
        try {
            String sql = "select tablespace_name\n" +
                         "from dba_tablespaces";
            Connection con = OracleProvider.connect_database(user, pass);
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {                
                cboTablespace.addItem(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void show_DS_User(DefaultTableModel dtmUser){
        try {
            String sql = "select username, DBMS_OBFUSCATION_TOOLKIT.md5(input => UTL_I18N.STRING_TO_RAW (PASSWORD||'46728595335', 'AL32UTF8')),\n" +
                        "to_char(created, 'fmDD - MM - YYYY'), to_char(expiry_date, 'fmDD - MM - YYYY'), \n" +
                        "account_status, to_char(last_login, 'fmDD - MM - YYYY HH24:MI:SS'), default_tablespace, profile\n" +
                        "from dba_users order by 1";
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
                if (rs.getString(6) == null){
                    vec.add("Chưa đăng nhập");
                }else {
                    vec.add(rs.getString(6));
                }
                vec.add(rs.getString(7));
                vec.add(rs.getString(8));
                
                dtmUser.addRow(vec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }  
    
    public static boolean create_user(String username, String tablespace, String profile){
        try {
            String sql = String.format("create user %s identified by %s\n" +
                            "default tablespace %s\n" +
                            "temporary tablespace temp\n" +
                            "profile %s\n" + 
                            "quota 1M on users", username, username, tablespace, profile);
            Connection con = OracleProvider.connect_database(user, pass);
            PreparedStatement pre = con.prepareStatement(sql);
            
            return pre.executeUpdate() > -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean delete_user(String username){
        try {
            String sql = String.format("drop user %s cascade", username);
            Connection con = OracleProvider.connect_database(user, pass);
            PreparedStatement pre = con.prepareStatement(sql);
            
            return pre.executeUpdate() > -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean update_user(String username, String status, String tablespace, String profile){
        String sql1 = String.format("alter user %s\n" +
                        "default tablespace %s\n" +
                        "profile %s\n" +
                        "account unlock", username, tablespace, profile, status);
        String sql2 = String.format("alter user %s\n" +
                        "default tablespace %s\n" +
                        "profile %s", username, tablespace, profile);
        try {
            Connection con = OracleProvider.connect_database(user, pass);
            if (status.equals("OPEN")){
                PreparedStatement pre = con.prepareStatement(sql1);
                
                return pre.executeUpdate() > -1;
            }else {
                PreparedStatement pre = con.prepareStatement(sql2);
                
                return pre.executeUpdate() > -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String[] show_DS_Quyen_User_Click(String username){
        
        try {
            String sql = "select privilege from DBA_SYS_PRIVS where grantee = ?";
            Connection con = OracleProvider.connect_database(user, pass);
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, username);
            ResultSet rs1 = pre.executeQuery();
            int dem = 0;
            while (rs1.next()) {                
                dem++;
            }
            ResultSet rs = pre.executeQuery();
            String[] lst = new String[dem];
            int i = 0;
            while (rs.next()) {                
                lst[i] = rs.getString(1);
                i++;
            }
            
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }  
    
    public static void show_DS_Profile(DefaultTableModel dtmProfile){
        try {
            String sql = "select *from dba_profiles order by 1";
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
                
                dtmProfile.addRow(vec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }   
    
    public static boolean create_profile(String profile_name, String use_time, 
            String soLanDN_sai, String slThayDoiPass, String tgKhoaTK){
        try {
            String sql = String.format("create profile %s limit\n" +
                                        "CPU_PER_SESSION %s\n" +
                                        "FAILED_LOGIN_ATTEMPTS %s\n" +
                                        "PASSWORD_REUSE_TIME 30\n" +
                                        "PASSWORD_REUSE_MAX %s\n" +
                                        "PASSWORD_LOCK_TIME %s", profile_name, use_time, soLanDN_sai, slThayDoiPass, tgKhoaTK);
            Connection con = OracleProvider.connect_database(user, pass);
            PreparedStatement pre = con.prepareStatement(sql);
            
            return pre.executeUpdate() > -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean delete_profile(String profile_name){
        try {
            String sql = String.format("drop profile %s cascade", profile_name);
            Connection con = OracleProvider.connect_database(user, pass);
            PreparedStatement pre = con.prepareStatement(sql);
            
            return pre.executeUpdate() > -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static void get_profile(JComboBox cboProfile){
        try {
            String sql = "select distinct profile from DBA_PROFILES order by 1";
            Connection con = OracleProvider.connect_database(user, pass);
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {                
                cboProfile.addItem(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void show_DS_Role(DefaultTableModel dtmRole){
        try {
            dtmRole.setRowCount(0);
            String sql = "select *from DBA_ROLES";
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
                
                dtmRole.addRow(vec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static String[] show_DS_Quyen_Role_Click(String role_name){
        try {
            String sql = "select privilege from role_sys_privs where ROLE = ?";
            Connection con = OracleProvider.connect_database(user, pass);
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, role_name.toUpperCase());
            ResultSet rs1 = pre.executeQuery();
            int dem = 0;
            while (rs1.next()) {                
                dem++;
            }
            ResultSet rs = pre.executeQuery();
            String[] lst = new String[dem];
            int i = 0;
            while (rs.next()) {                
                lst[i] = rs.getString(1);
                i++;
            }
            
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;        
    }
    
    public static boolean create_role(String role_name, String lst_role){
        try {
            Connection con = OracleProvider.connect_database(user, pass);
            if (lst_role.length() <= 0){
                String sql = String.format("create role %s identified by %s", role_name, role_name);
                PreparedStatement pre = con.prepareStatement(sql);
                
                return pre.executeUpdate() > -1;
            }else {
                String sql2 = String.format("create role %s identified by %s ", role_name, role_name);
                PreparedStatement prepared = con.prepareStatement(sql2);
                
                prepared.executeUpdate();
                
                String sql3 = String.format("grant %s to %s ", lst_role, role_name);
                PreparedStatement pre = con.prepareStatement(sql3);
                
                return pre.executeUpdate() > -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean delete_role(String role_name){
        try {
            String sql = String.format("drop role %s", role_name);
            Connection conn = OracleProvider.connect_database(user, pass);
            PreparedStatement pre = conn.prepareStatement(sql);
            
            return pre.executeUpdate() > -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static String show_LS_DN(){
        try {
            String ls = "";
            String sql = "select * from ADMIN_SACH.event_users_log where activity = 'LOGON'\n" +
                                "order by logon_date DESC, logon_time DESC\n" +
                                "offset 1 rows fetch next 1 rows only";
            Connection con = OracleProvider.connect_database(user, pass);
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {                
                ls = rs.getString(1);
                ls += "  " + rs.getString(3);
                ls += "  " + rs.getString(4);
                
                return ls;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    
    public static void show_DS_LS_DN(DefaultTableModel dtmLSDN){
        try {
            String sql = "select * from ADMIN_SACH.event_users_log\n" +
                        "order by logon_date DESC, logon_time DESC";
            Connection con = OracleProvider.connect_database(user, pass);
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {                
                Vector<Object> vec = new Vector<Object>();
                vec.add(rs.getString(1));
                vec.add(rs.getString(2));
                vec.add(rs.getString(3));
                vec.add(rs.getString(4));
                
                dtmLSDN.addRow(vec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void show_DS_Policy(DefaultTableModel dtmDSPolicy){
        try {
            dtmDSPolicy.setRowCount(0);
            String sql = "select object_schema, object_name, policy_owner, policy_name, "
                    + "enabled, sel, ins, upd, del, audit_trail, policy_column_options from dba_audit_policies";
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
                vec.add(rs.getString(7));
                vec.add(rs.getString(8));
                vec.add(rs.getString(9));
                vec.add(rs.getString(10));
                vec.add(rs.getString(11));
                
                dtmDSPolicy.addRow(vec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void show_DS_Audit(DefaultTableModel dtmDSAudit){
        try {
            dtmDSAudit.setRowCount(0);
            String sql = "select TIMESTAMP, db_user, os_user, userhost, object_schema, object_name, policy_name,"
                    + " sql_text, statement_type, extended_timestamp from dba_fga_audit_trail order by 1 DESC";
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
                vec.add(rs.getString(7));
                vec.add(rs.getString(8));
                vec.add(rs.getString(9));
                vec.add(rs.getString(10));
                
                dtmDSAudit.addRow(vec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void show_DS_Audit_Ngay(DefaultTableModel dtmDSAudit){
        try {
            dtmDSAudit.setRowCount(0);
            String sql = "select to_char(sysdate, 'DD/MM/YYYY'), dbuid, osuid, oshst, obj$schema, obj$name, policyname, lsqltext,"
                    + " stmt_type, ntimestamp# from sys.fga_log$ where ntimestamp# > SYSDATE - 1 order by ntimestamp# DESC";
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
                vec.add(rs.getString(7));
                vec.add(rs.getString(8));
                vec.add(rs.getString(9));
                vec.add(rs.getString(10));
                
                dtmDSAudit.addRow(vec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }     
    }
    
    public static boolean create_policy(String schema, String name, String policy_name, String type){
        try {
            String sql = String.format("begin\n" +
                                    "dbms_fga.add_policy(\n" +
                                    "    object_schema => '%s',\n" +
                                    "    object_name => '%s',\n" +
                                    "    policy_name => '%s',\n" +
                                    "    statement_types => '%s'\n" +
                                    "    );\n" +
                                    "end;", schema, name, policy_name, type);
            Connection con = OracleProvider.connect_database("sys as sysdba", "123");
            PreparedStatement pre = con.prepareStatement(sql);
            
            return pre.executeUpdate() > -1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean drop_policy(String schema, String object_name, String policy_name){
        try {
            String sql = String.format("begin\n" +
                                    "dbms_fga.drop_policy(\n" +
                                    "     object_schema => '%s',\n" +
                                    "     object_name => '%s',\n" +
                                    "     policy_name => '%s'\n" +
                                    "    );\n" +
                                    "end;", schema, object_name, policy_name);
            Connection con = OracleProvider.connect_database("sys as sysdba", "123");
            PreparedStatement pre = con.prepareStatement(sql);
            
            return pre.executeUpdate() > -1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }    
    }
}
