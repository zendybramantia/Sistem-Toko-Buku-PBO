/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Object.Employee;
import View.MenuAdminView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author zendy
 */
public class MenuAdminController implements ActionListener{
    MenuAdminView menuAdminView;
    private Employee user;
    public MenuAdminController(Employee user) {
        this.user = user;
        menuAdminView = new MenuAdminView();
        menuAdminView.setVisible(true);
        menuAdminView.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object actionEvent = e.getSource();
        if (e.getSource() == menuAdminView.getButtonManageBuku()){
            new BukuController(user);
            menuAdminView.dispose();
        }else if(actionEvent == menuAdminView.getButtonManageKategori()){
            new KategoriController(user);
            menuAdminView.dispose();
        }else if(actionEvent == menuAdminView.getButtonManageUser()){
            new EmployeeController(user);
            menuAdminView.dispose();
        }else if(actionEvent == menuAdminView.getButtonLogout()){
            new LoginController();
            menuAdminView.dispose();
        }
    }
}
