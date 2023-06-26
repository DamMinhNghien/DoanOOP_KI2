/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WMS;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author dangh
 */
public class ConnectionDB {

    public static Connection connectDb() {

        try {
            //Class.forName("com.mysql.jbdc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=WorkManagementSystem;user=trello;password=1230321;encrypt=true;trustServerCertificate=true;");
            return connect;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
