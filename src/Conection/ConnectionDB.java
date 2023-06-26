/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionDB
    {


 public static Connection dbConn() {
     Connection conn = null;
    try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;database=WorkManagementSystem;user=trello;password=1230321;encrypt=true;trustServerCertificate=true;";
         conn = DriverManager.getConnection(url);
    }
     catch (ClassNotFoundException | SQLException ex) {
          Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE,null,ex);

    }
    return conn;
}
 }