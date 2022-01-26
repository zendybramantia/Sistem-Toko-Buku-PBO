/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Object.Employee;
import Object.Kasir;
import Object.Admin;
import Object.Manager;
import Object.Buku;
import Model.BukuModel;
import View.BukuView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author zendy
 */
public class BukuController implements ActionListener, MouseListener{
    BukuView bukuView;
    BukuModel bukuModel;
    private Employee user;
    public BukuController(Employee user) {
        this.user = user;
        bukuView = new BukuView();
        bukuView.setVisible(true);
        bukuView.addListener(this);
        bukuView.addMouseClicked(this);
        bukuModel = new BukuModel();
        bukuView.fillJlist(bukuModel.getJudulBuku());
        if (user instanceof Kasir){
            bukuView.hideButton();
        }else if (user instanceof Admin){
            bukuView.disableButton();
        }else if (user instanceof Manager){
            bukuView.hideButton();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bukuView.getButtonTambah()){
            new TambahBukuController(user);
            bukuView.dispose();
        }else if(e.getSource() == bukuView.getButtonEdit()){
            String s = (String) bukuView.getjListBuku().getSelectedValue();
            Buku buku;
            buku = bukuModel.getDataBuku(s);
            new EditBukuController(buku, user);
            bukuView.dispose();
        }else if(e.getSource() == bukuView.getButtonHapus()){
            String s = (String) bukuView.getjListBuku().getSelectedValue();
            Buku buku = bukuModel.getDataBuku(s);
            int ok = JOptionPane.showConfirmDialog(null,"Apakah anda Yakin Ingin Mengahpus Buku???", "Confirmation",JOptionPane.YES_NO_OPTION);
            if (ok==0) {
                bukuModel.deleteBuku(buku);
                bukuView.fillJlist(bukuModel.getJudulBuku());
            }
        }else if(e.getSource() == bukuView.getButtonKembali()){
            if (user instanceof Kasir){
                new MenuKasirController(user);
            }else if (user instanceof Admin){
                new MenuAdminController(user);
            }else if (user instanceof Manager){
                new MenuManagerController(user);
            }
            bukuView.dispose();
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
            String s = (String) bukuView.getjListBuku().getSelectedValue();
            Buku buku;
            buku = bukuModel.getDataBuku(s);
            bukuView.setLabel(buku.getISBN(), buku.getJudul(), buku.getPenulis(), buku.getPenerbit(), buku.getTahunTerbit(), buku.getHarga(), buku.getStok());
            bukuView.enableButton();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
