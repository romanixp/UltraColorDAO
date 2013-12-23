/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.ds;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Sistemas
 */
public class AccesoDB {
    private static Connection connection = null;
    public static Connection getConnection() throws Exception{        
        
        String url = "jdbc:mysql://localhost/ultracolor";
        String user = "root";
        String pwd = "romani";
        
        if (connection == null){
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url,user,pwd);            
        }   
        return connection;
    } //getConnection
} // AccesoBD
