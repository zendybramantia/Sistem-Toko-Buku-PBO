/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.BukuModel;
import View.UpdateStokView;
import Object.Employee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author zendy
 */
public class UpdateStokController implements ActionListener {
    private BukuModel bukuModel;
    private UpdateStokView updateStokView;
    private Employee user;

    public UpdateStokController(Employee user) {
        this.user = user;
        updateStokView = new UpdateStokView();
        updateStokView.setVisible(true);
        updateStokView.addListener(this);
        bukuModel = new BukuModel();
        updateStokView.fillCbJudul(bukuModel.getJudulBuku());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == updateStokView.getButtonKembali()){
            new MenuManagerController(user);
            updateStokView.dispose();
        }else if(e.getSource() == updateStokView.getButtonKonfirmasi()){
            if((Integer)updateStokView.getSpinnerStok().getValue() == 0 || updateStokView.getCbJudul().getSelectedItem().toString() == "Pilih Judul Buku"){
                JOptionPane.showMessageDialog(updateStokView,"Harap masukkan judul dan jumlah stok!");
            }else{
                bukuModel.updateStok(updateStokView.getCbJudul().getSelectedItem().toString(), (Integer)updateStokView.getSpinnerStok().getValue());
            }

        }
    }
}
