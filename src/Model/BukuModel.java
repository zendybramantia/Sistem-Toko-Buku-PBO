package Model;

import Object.Buku;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BukuModel {
    Koneksi conn;
    private Statement stmt;

    public BukuModel() {
        this.conn = new Koneksi();
        conn.buatKoneksi();
    }
    public void addBuku (Buku buku){
        try {
            stmt = conn.getConn().createStatement();
            String query = "INSERT INTO buku (ISBN, judul_buku, penulis, penerbit, tahun_terbit, harga, stok, id_kategori) VALUES ('"+ buku.getISBN() +"', '"+buku.getJudul()+"', '"+buku.getPenulis()+"', '"+buku.getPenerbit()+"', '"+buku.getTahunTerbit()+"', '"+buku.getHarga()+"', '"+buku.getStok()+"', '"+buku.getIdKategori()+"');";
            stmt.executeUpdate(query);
        }  catch(SQLException e){
            System.out.println("input tidak valid");
        }
    }
    public String[] getJudulBuku(){
        try {
            stmt = conn.getConn().createStatement();
            String query = "SELECT * FROM buku;";
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<String> list= new ArrayList<String>();
            while (rs.next()){
                list.add(rs.getString("judul_buku"));
            }
            String[] result = new String[list.size()];
            result = list.toArray(result);
            return result;
        } catch(SQLException ex){}
        return null;
    }
    public Buku getDataBuku(String judul){
        try{
            Buku buku = null;
            stmt = conn.getConn().createStatement();
            String query =  "Select * from buku where judul_buku = '"+judul+"'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                buku = new Buku(rs.getString("ISBN"), rs.getInt("id_kategori"),
                        rs.getString("judul_buku"), rs.getString("penulis"),
                        rs.getString("penerbit"), rs.getString("tahun_terbit"),
                        rs.getInt("harga"), rs.getInt("stok"));
            }
            return buku;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public void editBuku(Buku buku){
        try {
            stmt = conn.getConn().createStatement();
            String query = "UPDATE buku SET judul_buku = '"+buku.getJudul()+"', penulis = '"+buku.getPenulis()+
                    "', penerbit = '"+buku.getPenerbit()+"', tahun_terbit = '"+buku.getTahunTerbit()+
                    "', harga = '"+buku.getHarga()+"', stok = '"+buku.getStok()+"', id_kategori = '"+buku.getIdKategori()+
                    "' WHERE ISBN = '"+buku.getISBN()+"';";
            stmt.executeUpdate(query);
        } catch (Exception e) {

        }
    }
    public void deleteBuku(Buku buku){
        try {
            stmt = conn.getConn().createStatement();
            String query = "DELETE FROM buku WHERE ISBN = '" + buku.getISBN() + "';";
            stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int getHarga(String judul){
        try {
            stmt = conn.getConn().createStatement();
            String query = "SELECT * FROM buku WHERE judul_buku = '"+judul+"';";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()){
                return rs.getInt("harga");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int cekStok(String judul){
        try {
            stmt = conn.getConn().createStatement();
            String query = "SELECT * FROM buku WHERE judul_buku = '"+judul+"';";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()){
                return rs.getInt("stok");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
    public void updateStok(String judul, int stok){
        try {
            int stokLama = 0;
            stmt = conn.getConn().createStatement();
            String query = "select * from buku where judul_buku = '"+judul+"';";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()){
                stokLama = rs.getInt("stok");
            }
            query = "UPDATE `buku` SET `stok` = '"+(stokLama+stok)+"' WHERE judul_buku = '"+judul+"';";
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Update Stok Berhasil!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null,"Update Stok Gagal!");
        }
    }
}
