package Controller;

import Model.EmployeeModel;
import View.SignUpView;
import Object.Employee;
import Object.Kasir;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupController implements ActionListener {
    SignUpView signUpView;
    private EmployeeModel employeeModel;

    public SignupController() {
        signUpView = new SignUpView();
        signUpView.setVisible(true);
        signUpView.addListener(this);
        employeeModel = new EmployeeModel();
        signUpView.disablePosisi();
        signUpView.setSignupLabel("DAFTAR");
    }

    private Employee addEmployee(){
        Employee employee = new Kasir(0, signUpView.getUsernameTextField().getText(),
                signUpView.getPasswordTextField().getText(),
                signUpView.getNamaTextField().getText(),
                signUpView.getTeleponTextField().getText(),
                signUpView.getEmailTextField().getText());
        return employee;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object actionEvent = e.getSource();
        if (actionEvent == signUpView.getButtonKonfirmasi()){
            if(signUpView.getUsernameTextField().getText().isEmpty() ||
                    signUpView.getPasswordTextField().getText().isEmpty() ||
                    signUpView.getNamaTextField().getText().isEmpty() ||
                    signUpView.getTeleponTextField().getText().isEmpty() ||
                    signUpView.getEmailTextField().getText().isEmpty()){
                JOptionPane.showMessageDialog(signUpView, "field tidak boleh kosong");
            }else {
                employeeModel.addEmployee(addEmployee(), "Kasir");
                JOptionPane.showMessageDialog(signUpView, "Sign Up berhasil dilakukan");
                new LoginController();
                signUpView.dispose();
            }
        }else if(actionEvent == signUpView.getLoginButton()){
            new LoginController();
            signUpView.dispose();
        }
    }
}
