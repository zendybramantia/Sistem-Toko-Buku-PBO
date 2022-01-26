/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Object.Kasir;
import Object.Manager;
import Object.Employee;
import Object.DetailTransaksi;
import Model.BukuModel;
import Model.TransaksiModel;
import View.TransaksiView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author zendy
 */
public class TransaksiController implements ActionListener {
    TransaksiView transaksiView;
    BukuModel bukuModel;
    TransaksiModel transaksiModel;
    private int i = 1;
    private Employee user;
    public TransaksiController(Employee user) {
        this.user = user;
        transaksiView = new TransaksiView();
        transaksiView.setVisible(true);
        bukuModel = new BukuModel();
        transaksiModel = new TransaksiModel();
        transaksiView.addListener(this);
        transaksiView.fillCbBuku(bukuModel.getJudulBuku());
    }

    private int hitungHarga(){
        int harga = 0;
        for (int i = 0;i<transaksiView.getTableTransaksi().getModel().getRowCount();i++){
            harga = harga + (Integer)transaksiView.getTableTransaksi().getModel().getValueAt(i,3);
        }
        return harga;
    }

    private Boolean CekTransaksi(){
        for (int i = 0; i<transaksiView.getTableTransaksi().getRowCount(); i++){
            if (transaksiView.getCbBuku().getSelectedItem() == transaksiView.getTableTransaksi().getValueAt(i, 1)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == transaksiView.getButtonTambah()){
            if (transaksiView.getCbBuku().getSelectedItem() == "Pilih Buku"){
                JOptionPane.showMessageDialog(transaksiView,"Harap Pilih Buku!");
            }else if(bukuModel.cekStok(transaksiView.getCbBuku().getSelectedItem().toString()) < (Integer)transaksiView.getSpinnerJumlah().getValue()){
                JOptionPane.showMessageDialog(transaksiView,"Stok tidak cukup!");
            }else if(CekTransaksi()){
                JOptionPane.showMessageDialog(transaksiView,"Tidak dapat menambahkan buku yang sama!");
            }else if((Integer)transaksiView.getSpinnerJumlah().getValue() == 0){
                JOptionPane.showMessageDialog(transaksiView,"Jumlah tidak valid!");
            }else {
                int jumlah = (Integer)transaksiView.getSpinnerJumlah().getValue();
                int harga = bukuModel.getHarga(transaksiView.getCbBuku().getSelectedItem().toString());
                transaksiView.addTableRow(new Object[]{i, transaksiView.getCbBuku().getSelectedItem(), jumlah, (harga * jumlah)});
                transaksiView.getTotalHarga().setText("Total Harga : Rp. "+hitungHarga());
                i++;
            }
        }else if (e.getSource() == transaksiView.getButtonReset()){
            new TransaksiController(user);
            transaksiView.dispose();
        }else if(e.getSource() ==transaksiView.getButtonKonfirmasi()){
            ArrayList<DetailTransaksi>detailTransaksi = new ArrayList<DetailTransaksi>();
            String idTransaksi = transaksiModel.buatTransaksi(user.getNama(), hitungHarga());
            for (int i = 0;i<transaksiView.getTableTransaksi().getModel().getRowCount();i++){
                detailTransaksi.add(new DetailTransaksi(transaksiView.getTableTransaksi().getModel().getValueAt(i,1).toString(),
                        (Integer)transaksiView.getTableTransaksi().getModel().getValueAt(i,2),
                        (Integer)transaksiView.getTableTransaksi().getModel().getValueAt(i,3),
                        idTransaksi));
            }
            transaksiModel.buatDetilTransaksi(detailTransaksi);
            new TransaksiController(user);
            transaksiView.dispose();
        }else if(e.getSource() == transaksiView.getButtonBatal()){
            if (user instanceof Kasir){
                new MenuKasirController(user);
            }else if (user instanceof Manager){
                new MenuManagerController(user);
            }
            transaksiView.dispose();
        }else if(e.getSource() == transaksiView.getButtonRiwayat()){
            new RiwayatController(user);
            transaksiView.dispose();
        }
    }
}
