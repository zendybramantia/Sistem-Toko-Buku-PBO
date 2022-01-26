/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zendy
 */

public class Koneksi {
    
    static final String DB_URL = "jdbc:mysql://localhost/db_toko_buku";
    static final String DB_USER = "root";
    static final String DB_PASS = "";
    private Connection conn;
    public void buatKoneksi(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            this.conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
            
        }catch(SQLException e){
            System.err.println("Koneksi gagal!");
            System.err.println(e);
        }
    }
    public Connection getConn() {
        return conn;
    }
}
