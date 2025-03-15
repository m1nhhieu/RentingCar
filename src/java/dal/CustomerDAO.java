/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Dell
 */
public class CustomerDAO extends DBContext{
    public Customer getCustomerByUsernameAndPassWord(String userName1, String password1){
        Customer c = null;
        String sql = "select * from Customers\n" +
        "where username =? and password = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, userName1);
            pre.setString(2, password1);
            ResultSet rs = pre.executeQuery();
            
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String firsrName = rs.getString("firsrName");
                String lastName = rs.getString("lastName");
                String gender = rs.getString("gender");
                Date dob = rs.getDate("dob");
                String phoneNumber = rs.getString("phoneNumber");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String role = rs.getString("role");
                
                c = new Customer(username, password, firsrName, lastName, gender, dob, phoneNumber, email, address, role);
                
            }
            
        } catch (SQLException ex) {
        }

        return c;
    }
    
    
    public Customer getCustomerByUsername(String userName1){
        Customer c = null;
        String sql = "select * from Customers\n" +
        "where username =?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, userName1);
            ResultSet rs = pre.executeQuery();
            
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String firsrName = rs.getString("firsrName");
                String lastName = rs.getString("lastName");
                String gender = rs.getString("gender");
                Date dob = rs.getDate("dob");
                String phoneNumber = rs.getString("phoneNumber");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String role = rs.getString("role");
                
                c = new Customer(username, password, firsrName, lastName, gender, dob, phoneNumber, email, address, role);
                
            }
            
        } catch (SQLException ex) {
        }

        return c;
    }
    
    
    public void insertCustomer(Customer c){
        String sql = "insert into Customers (Username,Password, FirsrName, LastName, " +
                    "Gender,Dob, phoneNumber, Email, Address,Role) " +
                    "values " +
                    "(?, ?, ?, ?,?, ?, ?,?, ?,?)";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, c.getUsername());
            pre.setString(2, c.getPassword());
            pre.setString(3, c.getFirstName());
            pre.setString(4, c.getLastName());
            pre.setString(5, c.getGender());
            pre.setDate(6, (Date) c.getDob());
            pre.setString(7, c.getPhoneNumber());
            pre.setString(8, c.getEmail());
            pre.setString(9, c.getAddress());
            pre.setString(10, c.getRole());
            
            pre.executeUpdate();
        } catch (SQLException ex) {
        }  
    }
    
    
    public void deleteCustomer(String username){
        String sql = "delete from customers where username = ?";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, username);
            pre.executeUpdate();
        } catch (SQLException ex) {
        }  
    }
    
    
    public List<Customer> getAllCustomer() {
        List<Customer> cList = new ArrayList<>();
        String sql = "select * from Customers";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
             ResultSet rs = pre.executeQuery();
            
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String firsrName = rs.getString("firsrName");
                String lastName = rs.getString("lastName");
                String gender = rs.getString("gender");
                Date dob = rs.getDate("dob");
                String phoneNumber = rs.getString("phoneNumber");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String role = rs.getString("role");
                
                cList.add(new Customer(username, password, firsrName, lastName, gender, dob, phoneNumber, email, address, role));
                
            }
        } catch (SQLException ex) {
        }
        
        
        return cList;
    }
    
    
    public List<Customer> getAllCustomerByName(String name1) {
        
        String s = "%"+name1+"%";
        List<Customer> cList = new ArrayList<>();
        String sql = "select * from Customers where \n" +
                    "(FirsrName+' '+LastName) like ?";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, s);
             ResultSet rs = pre.executeQuery();
            
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String firsrName = rs.getString("firsrName");
                String lastName = rs.getString("lastName");
                String gender = rs.getString("gender");
                Date dob = rs.getDate("dob");
                String phoneNumber = rs.getString("phoneNumber");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String role = rs.getString("role");
                
                cList.add(new Customer(username, password, firsrName, lastName, gender, dob, phoneNumber, email, address, role));
                
            }
        } catch (SQLException ex) {
        }
        
        
        return cList;
    }
    
    
    public void updateCustomer(Customer customer){
        String sql = "update Customers \n" +
                        "set \n" +
                        "FirsrName = ?," +
                        "LastName = ?," +
                        "Gender =?," +
                        "Dob=?," +
                        "phoneNumber=?," +
                        "Email=?," +
                        "Address =? ,"+
                        "Role =? "+
                        "where Username =?";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, customer.getFirstName());
            pre.setString(2, customer.getLastName());
            pre.setString(3, customer.getGender());
            pre.setDate(4, (Date) customer.getDob());
            pre.setString(5, customer.getPhoneNumber());
            pre.setString(6, customer.getEmail());
            pre.setString(7, customer.getAddress());
            pre.setString(8, customer.getRole());
            pre.setString(9, customer.getUsername());
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Can not update!");
        }
    }
    
    
    public int getTotalCustomer(){
        int total = 0;
        String sql = "select count(Username) as TotalUser\n" +
                    "from Customers";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                total = rs.getInt("TotalUser");
            }
            
        } catch (SQLException ex) {
        }
        return total;
    }
    
    public void changePasswordByUsername(Customer c, String newpassword){
        String sql = "update Customers\n" +
                    "set\n" +
                    "password = ?\n" +
                    "where username = ?";
        
        PreparedStatement pre;
        try {
            pre = connection.prepareStatement(sql);
            pre.setString(1, newpassword);
            pre.setString(2, c.getUsername());
            
            pre.executeUpdate();
        } catch (SQLException ex) {
        }
       
   }
    
//    public static void main(String[] args) {
//        CustomerDAO cudao = new CustomerDAO();
//        Customer c = cudao.getCustomerByUsernameAndPassWord("david", "123");
//        System.out.println(c);
//    }
}
