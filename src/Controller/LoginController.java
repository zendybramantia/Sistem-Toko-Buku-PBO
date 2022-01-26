/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.EmployeeModel;
import View.LoginView;
import Object.Employee;
import Object.Kasir;
import Object.Manager;
import Object.Admin;
import View.MenuManagerView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author zendy
 */
public class LoginController  implements ActionListener{
    LoginView loginView;
    private EmployeeModel employeeModel;
    public LoginController(){
        loginView = new LoginView();
        loginView.setVisible(true);
        loginView.addListener(this);
        employeeModel = new EmployeeModel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object actionEvent = e.getSource();

        if (actionEvent == loginView.getLoginButton()){
            if ((loginView.getUsernameTextField().getText().isEmpty()) ||
                    loginView.getUsernameTextField().getText().isEmpty()) {
                JOptionPane.showMessageDialog(loginView, "Data Pengguna tidak boleh kosong");
            }else{
                boolean log = false;
                log = employeeModel.cekLogin(loginView.getUsernameTextField().getText(),
                        loginView.getPasswordField().getText());
                if (log){
                    JOptionPane.showMessageDialog(loginView,"Log In Berhasil!!!");

                    Employee employee = employeeModel.getEmployeeData(loginView.getUsernameTextField().getText(),
                            loginView.getPasswordField().getText());
                    if (employee instanceof Kasir){
                        new MenuKasirController(employee);
                    }else if (employee instanceof Manager){
                        new MenuManagerController(employee);
                    }else if (employee instanceof Admin){
                        new MenuAdminController(employee);
                    }
                    loginView.dispose();
                }else{
                    JOptionPane.showMessageDialog(loginView, "Username atau Password Salah!!!");
                }
            }
        }else if (actionEvent == loginView.getDaftarButton()){
            new SignupController();
            loginView.dispose();
        }
    }

    public static void main(String[] args) {
        new LoginController();
    }
}
