/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.security.interfaces.RSAKey;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Station;

/**
 *
 * @author Dell
 */
public class StationDAO extends DBContext{
    public List<String> selectAllCity(){
        List<String> sList = new ArrayList<>();
        String sql = "select distinct city from Stations";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            
            while (rs.next()) {
                String city = rs.getString("city");
                sList.add(city);
                
            }
        } catch (SQLException ex) {
        }
        
        return sList;
    }
    
    
    public void addNewStation(Station station){
        String sql = "insert into Stations (Address, carAvailable, pickupLocation, \n" +
                    "Country, City)\n" +
                    "values\n" +
                    "(?, ?,?, ?, ?)";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, station.getAddress());
            pre.setInt(2, station.getCarAvailable());
            pre.setString(3, station.getPickupLocation());
            pre.setString(4, station.getCountry());
            pre.setString(5, station.getCity());
            
            pre.executeUpdate();
        } catch (SQLException ex) {
        }
        
    }
    
    
    public void updateStation(Station station){
        String sql = "update Stations\n" +
                        "set Address = ?,\n" +
                        "carAvailable = ?,\n" +
                        "pickupLocation = ?,\n" +
                        "Country = ?,\n" +
                        "City = ?\n" +
                        "where StationID = ?";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, station.getAddress());
            pre.setInt(2, station.getCarAvailable());
            pre.setString(3, station.getPickupLocation());
            pre.setString(4, station.getCountry());
            pre.setString(5, station.getCity());
            pre.setInt(6, station.getStationID());
            pre.executeUpdate();
        } catch (SQLException ex) {
        }
        
    }
    
    
    public void deleteStationById(String stationid){
        String sql = "delete from Stations\n" +
                    "where StationID = ?";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, stationid);
            pre.executeUpdate();
        } catch (SQLException ex) {
        }
        
    }
    
    public List<Integer> getAllSationID(){
        List<Integer> iList = new ArrayList<>();
        String sql = "select distinct StationID\n" +
                    "from Stations";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                int i = rs.getInt("StationID");
                iList.add(i);
            }
            
        } catch (SQLException ex) {
        }
        
        return iList;
    }
    
    
    
    public void increaseCarAvailableBy1(String stationID){
        
        String sql = "update Stations set carAvailable=carAvailable+1 where stationID = ?";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, stationID);
            pre.executeUpdate();

            
            
        } catch (SQLException ex) {
        }
        
        
    }
    
    public void decreaseCarAvailableBy1(String carID){
        
        String sql = "update Stations \n" +
                    "set carAvailable = carAvailable-1\n" +
                    "where StationID=(\n" +
                    " select stationID \n" +
                    " from Cars where CarID=?\n" +
                    ")";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, carID);
            pre.executeUpdate();

            
            
        } catch (SQLException ex) {
        }
        
        
    }
    public List<Station> getAllSation(){
        List<Station> sList = new ArrayList<>();
        String sql = "select *\n" +
                    "from Stations";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                int stationID = rs.getInt("stationID");
                String address = rs.getString("Address");
                int carAvailable = rs.getInt("carAvailable");
                String pickupLocation = rs.getString("pickupLocation");
                String country = rs.getString("Country");
                String city = rs.getString("City");
                
                Station s = new Station(stationID, address, carAvailable, pickupLocation, country, city);
                sList.add(s);
            
            }
            
        } catch (SQLException ex) {
        }
        
        return sList;
    }
    
    
    public List<Station> getAllSationByAddress(String address1){
        String ad = "%"+address1+"%";
        List<Station> sList = new ArrayList<>();
        String sql = "select *\n" +
                    "from Stations where Address like ?";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, ad);
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                int stationID = rs.getInt("stationID");
                String address = rs.getString("Address");
                int carAvailable = rs.getInt("carAvailable");
                String pickupLocation = rs.getString("pickupLocation");
                String country = rs.getString("Country");
                String city = rs.getString("City");
                
                Station s = new Station(stationID, address, carAvailable, pickupLocation, country, city);
                sList.add(s);
            
            }
            
        } catch (SQLException ex) {
        }
        
        return sList;
    }
    
    
    public Station getSationById(String stationid){
        Station s = null;
        String sql = "select *\n" +
                    "from Stations where StationID = ?";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, stationid);
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                int stationID = rs.getInt("stationID");
                String address = rs.getString("Address");
                int carAvailable = rs.getInt("carAvailable");
                String pickupLocation = rs.getString("pickupLocation");
                String country = rs.getString("Country");
                String city = rs.getString("City");
                
                s = new Station(stationID, address, carAvailable, pickupLocation, country, city);
            
            }
            
        } catch (SQLException ex) {
        }
        
        return s;
    }
    
    public int getTotalStation(){
        int Total = 0;
        String sql = "select count(StationID) as TotalStation\n" +
                        "from Stations";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                Total = rs.getInt("TotalStation");
            }
            
        } catch (SQLException ex) {
        }
        return Total;
    }
    
    public Station selectSationByLocation(String pickuplocation){
        Station s = null;
        String sql = "select top 1 *\n" +
                    "from Stations \n" +
                    "where city=?\n" +
                    "order by carAvailable asc";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, pickuplocation);
            ResultSet rs = pre.executeQuery();
            
            while (rs.next()) {
                int stationID = rs.getInt("StationID");
                String address = rs.getString("Address");
                int carAvailable = rs.getInt("carAvailable");
                String pickupLocation = rs.getString("pickupLocation");
                String Country = rs.getString("Country");
                String city = rs.getString("City");
                s = new Station(stationID, address, carAvailable, pickupLocation, Country, city);
                
                
            }
        } catch (SQLException ex) {
        }
        
        return s;
    }
}
