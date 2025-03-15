/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Cart;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class CartDAO extends DBContext{
    public void insertCart(Cart cart){
        String sql = "insert into Carts(CarID, Username,PickUpDateTime,ReturnDateTime,\n" +
        "pickUpStation,returnStation,totalDayRent,pickuplocation)\n" +
        "values\n" +
        "(?,?,?, ?,?,?,?,?)";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, cart.getCarID());
            pre.setString(2, cart.getUsername());
            pre.setString(3, cart.getPickUpDateTime());
            pre.setString(4, cart.getReturnDateTime());
            pre.setInt(5, cart.getPickUpStation());
            pre.setInt(6, cart.getPickUpStation());
            pre.setInt(7, cart.getTotalDayRent());
            pre.setString(8, cart.getPickuplocation());
            
            pre.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    
    public void deleteCartByID(String carID, String username){
        String sql ="delete from carts\n" +
                    "where carID=? and username = ?";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, carID);
            pre.setString(2, username);
            
            pre.executeUpdate();
        } catch (SQLException ex) {
        }
        
    }
    
    public int selectCarIDinCart(String carID, String username){
        int id = 0;
        String sql = "select carID\n" +
                "from carts\n" +
                "where carID = ? and username = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, carID);
            pre.setString(2, username);
            
            ResultSet rs = pre.executeQuery();
            
            
            while (rs.next()) {
                id = rs.getInt("carID");
            }
            
        } catch (SQLException ex) {
        }
        return id;
    }
    
    
    public Cart getCartByCarIdAndUsename(String carID1, String username1){
        Cart cart = null;
        
        String sql = "select *\n" +
                    "from carts\n" +
                    "where username = ? and carid = ?";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, username1);
            pre.setString(2, carID1);
             
            ResultSet rs = pre.executeQuery();
            
            while(rs.next()){
                int cartID = rs.getInt("cartID");
                int carID = rs.getInt("carID");
                String username = rs.getString("username");
                String PickUpDateTime = rs.getString("PickUpDateTime");
                String ReturnDateTime = rs.getString("ReturnDateTime");
                int pickUpStation = rs.getInt("pickUpStation");
                int returnStation = rs.getInt("returnStation");
                int totalDayRent = rs.getInt("totalDayRent");
                String pickuplocation = rs.getString("pickuplocation");
                
                cart = new Cart(cartID, carID, username, PickUpDateTime, ReturnDateTime, pickUpStation, returnStation, totalDayRent, pickuplocation);
            }
        } catch (SQLException ex) {
        }
        
        return cart;
    }
    
    
    public int countTotalCarInCart(String username){
        int count = 0;
        
        
        String sql ="select count(CartID) as totalCart\n" +
                    "from Carts\n" +
                    "where username = ?";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, username);
            ResultSet rs = pre.executeQuery();
            
            
            while (rs.next()) {
                count = rs.getInt("totalCart");
            }
        } catch (SQLException ex) {
        }

                                    
        return count;
    }
    
    
    
    
}
