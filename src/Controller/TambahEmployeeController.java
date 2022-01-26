/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Object.Employee;
import Object.Kasir;
import Model.EmployeeModel;
import View.SignUpView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author zendy
 */
public class TambahEmployeeController implements ActionListener {
    SignUpView signUpView;
    private EmployeeModel employeeModel;
    private Employee user;
    public TambahEmployeeController(Employee user) {
        this.user = user;
        signUpView = new SignUpView();
        signUpView.setVisible(true);
        signUpView.addListener(this);
        employeeModel = new EmployeeModel();
        signUpView.setSignupLabel("Tambah Employee");
    }

    private Employee addEmployee(){
        Employee employee;
        if (signUpView.getCbPosisi().getSelectedItem() == "Kasir") {
            employee = new Kasir(0, signUpView.getUsernameTextField().getText(),
                    signUpView.getPasswordTextField().getText(),
                    signUpView.getNamaTextField().getText(),
                    signUpView.getTeleponTextField().getText(),
                    signUpView.getEmailTextField().getText());
            return employee;
        }else if (signUpView.getCbPosisi().getSelectedItem() == "Manager") {
            employee = new Kasir(0, signUpView.getUsernameTextField().getText(),
                    signUpView.getPasswordTextField().getText(),
                    signUpView.getNamaTextField().getText(),
                    signUpView.getTeleponTextField().getText(),
                    signUpView.getEmailTextField().getText());
            return employee;
        }else if (signUpView.getCbPosisi().getSelectedItem() == "Admin") {
            employee = new Kasir(0, signUpView.getUsernameTextField().getText(),
                    signUpView.getPasswordTextField().getText(),
                    signUpView.getNamaTextField().getText(),
                    signUpView.getTeleponTextField().getText(),
                    signUpView.getEmailTextField().getText());
            return employee;
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUpView.getButtonKonfirmasi()){
            if(signUpView.getUsernameTextField().getText().isEmpty() ||
                    signUpView.getPasswordTextField().getText().isEmpty() ||
                    signUpView.getNamaTextField().getText().isEmpty() ||
                    signUpView.getTeleponTextField().getText().isEmpty() ||
                    signUpView.getEmailTextField().getText().isEmpty()){
                JOptionPane.showMessageDialog(signUpView, "field tidak boleh kosong!");
            }else{
                employeeModel.addEmployee(addEmployee(), signUpView.getCbPosisi().getSelectedItem()+"");
                JOptionPane.showMessageDialog(signUpView, "Tambah employee berhasil!");
                new EmployeeController(user);
                signUpView.dispose();
            }
        }else if (e.getSource() == signUpView.getButtonBack()){
            new EmployeeController(user);
            signUpView.dispose();
        }
    }
}
