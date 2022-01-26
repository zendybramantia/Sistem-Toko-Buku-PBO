/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

/**
 *
 * @author zendy
 */
public class DetailTransaksi {
    private String judul;
    private int jumlah;
    private int harga;
    private String idTransaksi;

    public DetailTransaksi(String judul, int jumlah, int harga, String idTransaksi) {
        this.judul = judul;
        this.jumlah = jumlah;
        this.harga = harga;
        this.idTransaksi = idTransaksi;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }
}
