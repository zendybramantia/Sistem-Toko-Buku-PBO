package Model;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class KategoriModel {
    Koneksi conn;
    private Statement stmt;

    public KategoriModel() {
        this.conn = new Koneksi();
        conn.buatKoneksi();
    }

    public void addKategori(String namaKategori){
        try {
            stmt = conn.getConn().createStatement();
            String query = "INSERT INTO `kategori` (`nama_kategori`) VALUES ('"+namaKategori+"');";
            stmt.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteKategori(String namaKategori){
        try {
            stmt = conn.getConn().createStatement();
            String query = "DELETE FROM `kategori` WHERE nama_kategori = '"+namaKategori+"';";
            stmt.executeUpdate(query);
            query = "ALTER TABLE kategori AUTO_INCREMENT = 1;";
            stmt.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String[] getDataKategori(){
        try {
            String query = "SELECT * FROM kategori";
            stmt = conn.getConn().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<String> list= new ArrayList<String>();
            while (rs.next()) {
                list.add(rs.getString("nama_kategori"));
            }
            String[] result = new String[list.size()];
            result = list.toArray(result);
            return result;
        } catch (SQLException e) {
        }
        return null;
    }
    public int getIDKategori(String nama){
        try {
            stmt = conn.getConn().createStatement();
            String query = "SELECT * FROM kategori where nama_kategori = '"+nama+"'";
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                int idKategori = rs.getInt("id_kategori");
                return idKategori;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}