/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.MenuManagerView;
import Object.Employee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author zendy
 */
public class MenuManagerController implements ActionListener {
    MenuManagerView menuManagerView;
    private Employee user;

    public MenuManagerController(Employee user) {
        this.user = user;
        menuManagerView = new MenuManagerView();
        menuManagerView.setVisible(true);
        menuManagerView.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == menuManagerView.getTransaksi()){
            new TransaksiController(user);
        }else if (e.getSource() == menuManagerView.getUpdateStok()){
            new UpdateStokController(user);
        }else if (e.getSource() == menuManagerView.getInfoBuku()){
            new BukuController(user);
        }else if (e.getSource() == menuManagerView.getInfoSaya()){
            new UserInfoController(user);
        }else if(e.getSource() == menuManagerView.getButtonLogout()){
            new LoginController();
            menuManagerView.dispose();
        }
        menuManagerView.dispose();
    }
}
