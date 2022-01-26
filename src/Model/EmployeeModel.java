package Model;

import Object.Employee;
import Object.Kasir;
import Object.Manager;
import Object.Admin;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author zendy
 */
public class EmployeeModel {
    Koneksi conn;
    private Statement stmt;

    public EmployeeModel() {
        this.conn = new Koneksi();
        conn.buatKoneksi();
    }
    public boolean cekLogin(String username, String password) {
        try {
            stmt = conn.getConn().createStatement();
            String query = "select * from employee where username='"+username+"' and password = '"+password+"'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs != null && rs.next()) {
                return true;
            }else{
                return false;
            }
        } catch (SQLException throwables) {
            System.err.println("Login gagal");
        }
        return false;
    }
    public Employee getEmployeeData(String username, String password){
        Employee e;
        try {
            stmt = conn.getConn().createStatement();
            String query = "select * from employee where username='"+username+"' and password = '"+password+"'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs != null && rs.next()) {
                String level = rs.getString("posisi");
                if (level.equals("Kasir")) {
                    e = new Kasir(rs.getInt("id"), username, password, rs.getString("nama"),
                            rs.getString("telepon"), rs.getString("email"));
                    return e;
                } else if (level.equals("Manager")) {
                    e = new Manager(rs.getInt("id"), username, password, rs.getString("nama"),
                            rs.getString("telepon"), rs.getString("email"));
                    return e;
                } else if (level.equals("Admin")) {
                    e = new Admin(rs.getInt("id"), username, password, rs.getString("nama"),
                            rs.getString("telepon"), rs.getString("email"));
                    return e;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public Employee getEmployeeDataById(String id){
        Employee e;
        try {
            stmt = conn.getConn().createStatement();
            String query = "select * from employee where id ='"+id+"';";
            ResultSet rs = stmt.executeQuery(query);
            if (rs != null && rs.next()) {
                String level = rs.getString("posisi");
                if (level.equals("Kasir")) {
                    e = new Kasir(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("nama"),
                            rs.getString("telepon"), rs.getString("email"));
                    return e;
                } else if (level.equals("Manager")) {
                    e = new Manager(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("nama"),
                            rs.getString("telepon"), rs.getString("email"));
                    return e;
                } else if (level.equals("Admin")) {
                    e = new Admin(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("nama"),
                            rs.getString("telepon"), rs.getString("email"));
                    return e;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void addEmployee(Employee employee, String posisi){
        try{
            stmt = conn.getConn().createStatement();
            String query = "Insert into employee (username, password, nama, telepon, email, posisi) values('"
                    +employee.getUsername()+"','"+employee.getPassword()+"','"+employee.getNama()+"','"
                    +employee.getTelepon()+"','"+employee.getEmail()+"','"+posisi+"');";
            stmt.executeUpdate(query);


        }catch(SQLException e){
            System.err.println(e);
        }
    }
    public DefaultTableModel addToTable(){
        DefaultTableModel table = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        table.addColumn("id");
        table.addColumn("Username");
        table.addColumn("Nama");
        table.addColumn("Telepon");
        table.addColumn("Email");
        table.addColumn("posisi");
        try {
            stmt = conn.getConn().createStatement();
            String query = "select * from employee;";
            ResultSet rs;
            rs = stmt.executeQuery(query);
            while(rs.next()){
                table.addRow(new Object[]{rs.getString("id"), rs.getString("username") ,
                        rs.getString("nama") , rs.getString("telepon"),
                        rs.getString("email"), rs.getString("posisi")});
            }
            return table;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return table;
    }

    public void editEmployee(Employee e){
        try {
            stmt = conn.getConn().createStatement();
            String query = "UPDATE employee SET username = '"+e.getUsername()
                    +"', password = '"+e.getPassword()+"', nama = '"+e.getNama()
                    +"', telepon = '"+e.getTelepon()+"', email = '"+e.getEmail()
                    +"', posisi = '"+e.getClass().getSimpleName()+"' WHERE id = '" +e.getId()+"';";
            stmt.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteEmployee(String s){
        try {
            stmt = conn.getConn().createStatement();
            String query = "DELETE FROM employee WHERE id = '"+s+"';";
            stmt.executeUpdate(query);
            query = "ALTER TABLE employee AUTO_INCREMENT = 1;";
            stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
