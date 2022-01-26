/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.TransaksiModel;
import View.RiwayatView;
import Object.Employee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author zendy
 */
public class RiwayatController implements ActionListener {
    RiwayatView riwayatView;
    TransaksiModel transaksiModel;
    Employee user;

    public RiwayatController(Employee user) {
        this.user = user;
        riwayatView = new RiwayatView();
        riwayatView.setVisible(true);
        riwayatView.addListener(this);
        transaksiModel = new TransaksiModel();
        riwayatView.fillCbID(transaksiModel.getIDTransaksi());
    }

    private int hitungHarga(){
        int harga = 0;
        for (int i = 0;i<riwayatView.getTableTransaksi().getModel().getRowCount();i++){
            harga = harga + (Integer)riwayatView.getTableTransaksi().getModel().getValueAt(i,3);
        }
        return harga;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == riwayatView.getButtonTampil()){
            riwayatView.getTableTransaksi().setModel(transaksiModel.addToTable(riwayatView.getCbID().getSelectedItem().toString()));
            riwayatView.getLabelHarga().setText("Total Harga : Rp."+hitungHarga());
        }else if(e.getSource() == riwayatView.getButtonKembali()){
            new TransaksiController(user);
            riwayatView.dispose();
        }
    }
}
