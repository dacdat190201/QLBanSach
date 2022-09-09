/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class OracleProvider {
    
    public static Connection connect_database(String user, String pass) {
        try {
            String url = "jdbc:oracle:thin:@localhost:1521:orcl2";

            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            return DriverManager.getConnection(url, user, pass);  

        } catch (Exception e) {
            return null;
        }
    }
}
