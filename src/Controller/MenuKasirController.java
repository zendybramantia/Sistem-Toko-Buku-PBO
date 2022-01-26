/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.MenuKasirView;

import Object.Employee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author zendy
 */
public class MenuKasirController implements ActionListener {
    MenuKasirView menuKasirView;
    Employee user;
    public MenuKasirController(Employee user) {
        this.user = user;
        menuKasirView = new MenuKasirView();
        menuKasirView.setVisible(true);
        menuKasirView.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuKasirView.getTransaksi()){
            new TransaksiController(user);
            menuKasirView.dispose();
        }else if(e.getSource() == menuKasirView.getInfoBuku()){
            new BukuController(user);
            menuKasirView.dispose();
        }else if (e.getSource() == menuKasirView.getInfoSaya()){
            new UserInfoController(user);
            menuKasirView.dispose();
        }else if(e.getSource() == menuKasirView.getButtonLogout()){
            new LoginController();
            menuKasirView.dispose();
        }
    }
}
