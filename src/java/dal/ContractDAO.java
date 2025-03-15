/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Contract;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.el.util.ConcurrentCache;

/**
 *
 * @author Dell
 */
public class ContractDAO extends DBContext{
    public void addContract(Contract contract){
        String sql = "insert into Contracts (ContractID,CarID, PickUpDateTime, \n" +
                    "ReturnDateTime, pickUpLocation,returnLocation, username,totalRentPrice)\n" +
                    "values \n" +
                    "(?,? ,?, ?, ?, \n" +
                    "?, ?,?)";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, contract.getContractID());
            pre.setInt(2, contract.getCarId());
            pre.setString(3, contract.getPickUpDateTime());
            pre.setString(4, contract.getReturnDateTime());
            pre.setInt(5, contract.getPickUpLocation());
            pre.setInt(6, contract.getReturnLocation());
            pre.setString(7, contract.getUsername());
            pre.setInt(8, contract.getTotalRentPrice());
            
            pre.executeUpdate();
        } catch (SQLException ex) {
        }
    }
    
    public int getTotalSale(){
        int TotalSales = 0;
        String sql = "select sum(totalRentPrice) as TotalSales \n" +
                        "from Contracts";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                TotalSales = rs.getInt("TotalSales");
            }
            
        } catch (SQLException ex) {
        }
        return TotalSales;
    }
    
    
    
    
    
    public List<Contract> getContractByUsername(String username1){
        List<Contract> cList = new ArrayList<>();
        
        String sql = "select c.*, s.pickupLocation, ca.Name, ca.Image\n" +
                    "from Contracts as c, Stations as s , Cars as ca\n" +
                    "where c.pickUpLocation = s.StationID and c.CarID = ca.CarID\n" +
                    "and username = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, username1);
            ResultSet rs = pre.executeQuery();
            
            while(rs.next()){
                 String contractID = rs.getString("ContractID");
                 int carID = rs.getInt("CarID");
                 String PickUpDateTime = rs.getString("PickUpDateTime");
                 String ReturnDateTime = rs.getString("ReturnDateTime");
                 int pickUpLocation = rs.getInt("pickUpLocation");
                 int returnLocation = rs.getInt("returnLocation");
                 String username = rs.getString("username");
                 int totalRentPrice = rs.getInt("totalRentPrice");
                 String specificLocation = rs.getString("pickupLocation");
                 String carName = rs.getString("name");
                 String carImg = rs.getString("image");
                 
                 cList.add(new Contract(contractID, carID, PickUpDateTime, ReturnDateTime, pickUpLocation, returnLocation, username, totalRentPrice, specificLocation, carName, carImg));
            }
            
        } catch (SQLException ex) {
        }
        
        return cList;
    }
    
    
    public List<Contract> getAllContract(){
        List<Contract> cList = new ArrayList<>();
        
        String sql = "select c.*, s.pickupLocation, ca.Name, ca.Image\n" +
                    "from Contracts as c, Stations as s , Cars as ca\n" +
                    "where c.pickUpLocation = s.StationID and c.CarID = ca.CarID\n";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            
            ResultSet rs = pre.executeQuery();
            
            while(rs.next()){
                 String contractID = rs.getString("ContractID");
                 int carID = rs.getInt("CarID");
                 String PickUpDateTime = rs.getString("PickUpDateTime");
                 String ReturnDateTime = rs.getString("ReturnDateTime");
                 int pickUpLocation = rs.getInt("pickUpLocation");
                 int returnLocation = rs.getInt("returnLocation");
                 String username = rs.getString("username");
                 int totalRentPrice = rs.getInt("totalRentPrice");
                 String specificLocation = rs.getString("pickupLocation");
                 String carName = rs.getString("name");
                 String carImg = rs.getString("image");
                 
                 cList.add(new Contract(contractID, carID, PickUpDateTime, ReturnDateTime, pickUpLocation, returnLocation, username, totalRentPrice, specificLocation, carName, carImg));
            }
            
        } catch (SQLException ex) {
        }
        
        return cList;
    }
    
    
    
    public List<Contract> getAllContractByName(String username1){
        String s = "%"+username1+"%";
        List<Contract> cList = new ArrayList<>();
        
        String sql = "select c.*, s.pickupLocation, ca.Name, ca.Image\n" +
                    "from Contracts as c, Stations as s , Cars as ca\n" +
                    "where c.pickUpLocation = s.StationID and c.CarID = ca.CarID\n" +
                    "and c.username like ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, s);
            ResultSet rs = pre.executeQuery();
            
            while(rs.next()){
                 String contractID = rs.getString("ContractID");
                 int carID = rs.getInt("CarID");
                 String PickUpDateTime = rs.getString("PickUpDateTime");
                 String ReturnDateTime = rs.getString("ReturnDateTime");
                 int pickUpLocation = rs.getInt("pickUpLocation");
                 int returnLocation = rs.getInt("returnLocation");
                 String username = rs.getString("username");
                 int totalRentPrice = rs.getInt("totalRentPrice");
                 String specificLocation = rs.getString("pickupLocation");
                 String carName = rs.getString("name");
                 String carImg = rs.getString("image");
                 
                 cList.add(new Contract(contractID, carID, PickUpDateTime, ReturnDateTime, pickUpLocation, returnLocation, username, totalRentPrice, specificLocation, carName, carImg));
            }
            
        } catch (SQLException ex) {
        }
        
        return cList;
    }
    
    public void deleteContractById(String id){
        String sql = "delete from Contracts\n" +
                    "where contractId = ?";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, id);
            pre.executeUpdate();
            
        } catch (SQLException ex) {
        }
    }
    
    
    public int getTotalContractByUsername(String username){
        int count = 0;
        String sql = "select count(ContractID) as TotalContract\n" +
                    "from Contracts\n" +
                    "where username = ?\n" +
                    "group by username";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, username);
            
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                count = rs.getInt("TotalContract");
            }
        } catch (SQLException ex) {
        }
        
        return count;
    }
}
