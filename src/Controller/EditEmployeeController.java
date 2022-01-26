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
import Model.EmployeeModel;
import View.SignUpView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author zendy
 */
public class EditEmployeeController implements ActionListener {
    SignUpView signUpView;
    private EmployeeModel employeeModel;
    private Employee employee, user;
    public EditEmployeeController(Employee employee, Employee user) {
        this.user = user;
        this.employee = employee;
        signUpView = new SignUpView();
        signUpView.setVisible(true);
        signUpView.addListener(this);
        employeeModel = new EmployeeModel();
        signUpView.setSignupLabel("Edit Employee");
        signUpView.fillTextField(this.employee);
    }
    
    private Employee addEmployee(){
        Employee employee;
        if (signUpView.getCbPosisi().getSelectedItem() == "Kasir") {
            employee = new Kasir(this.employee.getId(), signUpView.getUsernameTextField().getText(),
                    signUpView.getPasswordTextField().getText(),
                    signUpView.getNamaTextField().getText(),
                    signUpView.getTeleponTextField().getText(),
                    signUpView.getEmailTextField().getText());
            return employee;
        }else if (signUpView.getCbPosisi().getSelectedItem() == "Manager") {
            employee = new Manager(this.employee.getId(), signUpView.getUsernameTextField().getText(),
                    signUpView.getPasswordTextField().getText(),
                    signUpView.getNamaTextField().getText(),
                    signUpView.getTeleponTextField().getText(),
                    signUpView.getEmailTextField().getText());
            return employee;
        }else if (signUpView.getCbPosisi().getSelectedItem() == "Admin") {
            employee = new Admin(this.employee.getId(), signUpView.getUsernameTextField().getText(),
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
                employeeModel.editEmployee(addEmployee());
                JOptionPane.showMessageDialog(signUpView, "Edit employee berhasil!");
                new EmployeeController(user);
                signUpView.dispose();
            }
        }else if (e.getSource() == signUpView.getButtonBack()){
            new EmployeeController(user);
            signUpView.dispose();
        }

    }
}
