/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.KategoriModel;
import View.KategoriView;
import Object.Employee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author zendy
 */
public class KategoriController implements ActionListener {
    private KategoriModel kategoriModel;
    KategoriView kategoriView;
    Employee user;

    public KategoriController(Employee user) {
        this.user = user;
        kategoriView = new KategoriView();
        kategoriView.setVisible(true);
        kategoriView.addListener(this);
        kategoriModel = new KategoriModel();
        kategoriView.fillCbHapus(kategoriModel.getDataKategori());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == kategoriView.getButtonTambah()){
            kategoriModel.addKategori(kategoriView.getTfTambah().getText());
            JOptionPane.showMessageDialog(kategoriView, "Tambah kategori berhasil!");
            new KategoriController(user);
            kategoriView.dispose();
        }else if(e.getSource() == kategoriView.getButtonHapus()){
            int ok = JOptionPane.showConfirmDialog(null,"Apakah anda Yakin Ingin Mengahpus Kategori???", "Confirmation",JOptionPane.YES_NO_OPTION);
            if (ok==0) {
                kategoriModel.deleteKategori(kategoriView.getCbHapus().getSelectedItem().toString());
                JOptionPane.showMessageDialog(kategoriView, "Hapus kategori berhasil!");
                new KategoriController(user);
                kategoriView.dispose();
            }
        }else if(e.getSource() == kategoriView.getButtonKembali()){
            new MenuAdminController(user);
            kategoriView.dispose();
        }
    }
}
