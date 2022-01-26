/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Object.Employee;
import Model.EmployeeModel;
import View.EmployeeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author zendy
 */
public class EmployeeController implements ActionListener, MouseListener{
    EmployeeView employeeView;
    private EmployeeModel employeeModel;
    private Employee user;
    public EmployeeController(Employee user) {
        this.user = user;
        employeeView = new EmployeeView();
        employeeView.setVisible(true);
        employeeView.addListener(this);
        employeeView.addMouseListener(this);
        employeeModel = new EmployeeModel();
        employeeView.fillTable(employeeModel.addToTable());
        employeeView.disableButton();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == employeeView.getButtonTambah()){
            new TambahEmployeeController(user);
            employeeView.dispose();
        }else if(e.getSource() == employeeView.getButtonEdit()){
            int row = employeeView.getTableEmployee().getSelectedRow();
            String value = employeeView.getTableEmployee().getModel().getValueAt(row, 0).toString();
            new EditEmployeeController(employeeModel.getEmployeeDataById(value), user);
            employeeView.dispose();
        }else if(e.getSource() == employeeView.getButtonHapus()){
            int row = employeeView.getTableEmployee().getSelectedRow();
            String value = employeeView.getTableEmployee().getModel().getValueAt(row, 0).toString();
            int ok = JOptionPane.showConfirmDialog(null,"Apakah anda Yakin Ingin Mengahpus Employee???", "Confirmation",JOptionPane.YES_NO_OPTION);
            if (ok==0) {
                employeeModel.deleteEmployee(value);
                employeeView.dispose();
                new EmployeeController(user);
            }
        }else if(e.getSource() == employeeView.getButtonKembali()){
            new MenuAdminController(user);
            employeeView.dispose();
        }
    }

    public void mouseClicked(MouseEvent e) {
        employeeView.enableButton();
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
