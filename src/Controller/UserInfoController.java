/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Object.Kasir;
import Object.Admin;
import Object.Manager;
import Object.Employee;
import View.UserInfoView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author zendy
 */
public class UserInfoController implements ActionListener {
    UserInfoView userInfoView;
    Employee user;
    public UserInfoController(Employee user) {
        this.user = user;
        userInfoView = new UserInfoView();
        userInfoView.setVisible(true);
        userInfoView.addListener(this);
        userInfoView.setLabel(user);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (user instanceof Kasir){
            new MenuKasirController(user);
        }else if (user instanceof Admin){
            new MenuAdminController(user);
        }else if (user instanceof Manager){
            new MenuManagerController(user);
        }
        userInfoView.dispose();
    }
}
