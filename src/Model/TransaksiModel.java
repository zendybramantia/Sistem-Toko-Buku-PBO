/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Object.DetailTransaksi;

import javax.swing.table.DefaultTableModel;
import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author zendy
 */
public class TransaksiModel {
    Koneksi conn;
    private Statement stmt;

    public TransaksiModel() {
        this.conn = new Koneksi();
        conn.buatKoneksi();
    }

    public String buatTransaksi(String kasir, int harga){
        try {
            stmt = conn.getConn().createStatement();
            String query = "INSERT INTO `transaksi` (`nama_kasir`, `total_harga`) VALUES ('"+kasir+"', '"+harga+"');";
            stmt.executeUpdate(query);
            query = "SELECT * FROM transaksi WHERE id_transaksi=(SELECT max(id_transaksi) FROM transaksi);";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()){
                String id = rs.getString("id_transaksi");
                return id;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void buatDetilTransaksi(ArrayList<DetailTransaksi> detailTransaksi){
        try {
            stmt = conn.getConn().createStatement();
            int stok = 0;
            for (int i = 0;i<detailTransaksi.size();i++){
                String query = "INSERT INTO `detail_transaksi` (`judul_buku`, `jumlah`, `harga`, `id_transaksi`) VALUES ('"+detailTransaksi.get(i).getJudul()+"', '"+detailTransaksi.get(i).getJumlah()+"', '"+detailTransaksi.get(i).getHarga()+"', '"+detailTransaksi.get(i).getIdTransaksi()+"');";
                stmt.executeUpdate(query);

                query = "select * from buku where judul_buku = '"+detailTransaksi.get(i).getJudul()+"'";
                ResultSet rs = stmt.executeQuery(query);
                if (rs.next()){
                    stok = rs.getInt("stok");
                }
                query = "UPDATE `buku` SET `stok` = '"+(stok - detailTransaksi.get(i).getJumlah())+"' WHERE judul_buku = '"+detailTransaksi.get(i).getJudul()+"';";
                stmt.executeUpdate(query);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public DefaultTableModel addToTable(String id){
        DefaultTableModel table = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        table.addColumn("No");
        table.addColumn("Judul Buku");
        table.addColumn("Jumlah");
        table.addColumn("Harga");
        table.addColumn("Nama Kasir");
        
        try {
            stmt = conn.getConn().createStatement();
            String query = "SELECT * FROM `transaksi` WHERE id_transaksi = '"+id+"';";
            
            ResultSet rs = stmt.executeQuery(query);
            String kasir = "";
            if(rs.next()){
                kasir = rs.getString("nama_kasir");
            }
            query = "SELECT * FROM `detail_transaksi` WHERE id_transaksi = '"+id+"';";
            rs = stmt.executeQuery(query);
            int i = 1;
            while (rs.next()){
                table.addRow(new Object[]{i+"", rs.getString("judul_buku"),
                        rs.getString("jumlah"),
                        rs.getInt("harga"), kasir});
                i++;
            }
            return table;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return table;
    }
    public String[] getIDTransaksi(){
        try {
            String query = "SELECT * FROM transaksi;";
            stmt = conn.getConn().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<String> list= new ArrayList<String>();
            while (rs.next()) {
                list.add(rs.getString("id_transaksi"));
            }
            String[] result = new String[list.size()];
            result = list.toArray(result);
            return result;
        } catch (SQLException e) {
        }
        return null;
    }
}
