/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Car;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.tomcat.dbcp.dbcp2.PoolingConnection;

/**
 *
 * @author Dell
 */
public class CarDAO extends DBContext{
    public List<Car> getAllCityCar(String city){
        List<Car> cList = new ArrayList<>();
        
        
        String sql ="select c.*, s.pickupLocation, p.DailyPrice\n" +
                    "from Cars as c, Stations as s, PriceDetails as p\n" +
                    "where c.StationID = s.StationID and c.PriceID = p.PriceID\n" +
                    "and s.City = ? and c.Available=1";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, city);
            ResultSet rs = pre.executeQuery();
            
            
            while (rs.next()) {
                int carID = rs.getInt("carID");
                String name = rs.getString("name");
                boolean available = rs.getBoolean("available");
                String image = rs.getString("image");
                int priceID = rs.getInt("priceID");
                int stationID = rs.getInt("stationID");
                int numberOfSeats = rs.getInt("numberOfSeats");
                int largeBags = rs.getInt("largeBags");
                int smallBags = rs.getInt("smallBags");
                float reviewScore = rs.getFloat("reviewScore");
                int reviewers = rs.getInt("reviewers");
                String pickuplocation = rs.getString("pickuplocation");
                int dailyprice = rs.getInt("dailyprice");
                
                Car c = new Car(carID,name, available, image, priceID, stationID, numberOfSeats, largeBags, smallBags,reviewScore,reviewers,pickuplocation,dailyprice);
                cList.add(c);
            }
        } catch (SQLException ex) {
        }

                                    
        return cList;
    }
    
    
    public void updateAvailableTo0(String carid){
        String sql = "update Cars\n" +
                    "set Available = 0\n" +
                    "where carID = ?";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, carid);
            pre.executeUpdate();
        } catch (SQLException ex) {
        }
        
    }
    
    
    public void updateAvailableTo1(String carid){
        String sql = "update Cars\n" +
                    "set Available = 1\n" +
                    "where carID = ?";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, carid);
            pre.executeUpdate();
        } catch (SQLException ex) {
        }
        
    }
    
    public void deleteCarById(int id){
        String sql = "delete from Cars\n" +
                    "where CarID = ?";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            
            pre.executeUpdate();
        } catch (SQLException ex) {
        }
    }
    
    
    public List<Car> getAllCarAdmin(){
        List<Car> cList = new ArrayList<>();
        
        
        String sql ="select * from cars where Available=1";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            
            
            while (rs.next()) {
                int carID = rs.getInt("carID");
                String name = rs.getString("name");
                boolean available = rs.getBoolean("available");
                String image = rs.getString("image");
                int priceID = rs.getInt("priceID");
                int stationID = rs.getInt("stationID");
                int numberOfSeats = rs.getInt("numberOfSeats");
                int largeBags = rs.getInt("largeBags");
                int smallBags = rs.getInt("smallBags");
                float reviewScore = rs.getFloat("reviewScore");
                int reviewers = rs.getInt("reviewers");
                
                
                Car c = new Car(carID,name, available, image, priceID, stationID, numberOfSeats, largeBags, smallBags,reviewScore,reviewers);
                cList.add(c);
            }
        } catch (SQLException ex) {
        }

                                    
        return cList;
    }
    
    public List<Car> getAllCarAdminByName(String name1){
        List<Car> cList = new ArrayList<>();
        
        String s = "%"+name1+"%";
        String sql ="select * from cars where Available=1\n" +
                    "and Name like ?";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, s);
            ResultSet rs = pre.executeQuery();
            
            
            while (rs.next()) {
                int carID = rs.getInt("carID");
                String name = rs.getString("name");
                boolean available = rs.getBoolean("available");
                String image = rs.getString("image");
                int priceID = rs.getInt("priceID");
                int stationID = rs.getInt("stationID");
                int numberOfSeats = rs.getInt("numberOfSeats");
                int largeBags = rs.getInt("largeBags");
                int smallBags = rs.getInt("smallBags");
                float reviewScore = rs.getFloat("reviewScore");
                int reviewers = rs.getInt("reviewers");
                
                
                Car c = new Car(carID,name, available, image, priceID, stationID, numberOfSeats, largeBags, smallBags,reviewScore,reviewers);
                cList.add(c);
            }
        } catch (SQLException ex) {
        }

                                    
        return cList;
    }
    
    
    
    
     public Car getCarByIdAdmin(int id){
        Car c = null;
        
        
        String sql ="select * from Cars where CarID = ?";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            
            
            while (rs.next()) {
                int carID = rs.getInt("carID");
                String name = rs.getString("name");
                boolean available = rs.getBoolean("available");
                String image = rs.getString("image");
                int priceID = rs.getInt("priceID");
                int stationID = rs.getInt("stationID");
                int numberOfSeats = rs.getInt("numberOfSeats");
                int largeBags = rs.getInt("largeBags");
                int smallBags = rs.getInt("smallBags");
                float reviewScore = rs.getFloat("reviewScore");
                int reviewers = rs.getInt("reviewers");
                
                
                c = new Car(carID,name, available, image, priceID, stationID, numberOfSeats, largeBags, smallBags,reviewScore,reviewers);
                
            }
        } catch (SQLException ex) {
        }

                                    
        return c;
    }
    
     
     public List<Integer> getAllPriceID(){
        List<Integer> iList = new ArrayList<>();
        String sql = "select distinct PriceID\n" +
                    "from PriceDetails";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                int i = rs.getInt("PriceID");
                iList.add(i);
            }
            
        } catch (SQLException ex) {
        }
        
        return iList;
    }
     
     
    public int getTotalCarAdmin(){
        int count = 0;
        String sql = "select count(CarID) as TotalCar\n" +
                    "from Cars\n" +
                    "where Available = 1";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                count = rs.getInt("TotalCar");
            }
            
        } catch (SQLException ex) {
        }
        
        return count;
    }
    
    public int getTotalCategories(){
        int total = 0;
        String sql = "select count(distinct NumberOfSeats) as Categories\n" +
                    "from Cars";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                total = rs.getInt("Categories");
            }
            
        } catch (SQLException ex) {
        }
        return total;
    }
    
    public int getTotalCarBeingHired(){
        int count = 0;
        String sql = "select count(CarID) as TotalCar\n" +
                    "from Cars\n" +
                    "where Available = 0";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                count = rs.getInt("TotalCar");
            }
            
        } catch (SQLException ex) {
        }
        
        return count;
    }
    
    public int countTotalCar(String city){
        int count = 0;
        
        
        String sql ="select count(c.CarID) as TotalCar\n" +
                    "from Cars as c, Stations as s, PriceDetails as p \n" +
                    "where c.StationID = s.StationID and c.PriceID = p.PriceID \n" +
                    "and s.City = ? and c.Available=1 \n" +
                    "group by s.City";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, city);
            ResultSet rs = pre.executeQuery();
            
            
            while (rs.next()) {
                count = rs.getInt("TotalCar");
            }
        } catch (SQLException ex) {
        }

                                    
        return count;
    }
    
    
    public int countTotalCarFilter(String city, String sql){
        int count = 0;
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, city);
            ResultSet rs = pre.executeQuery();
            
            
            while (rs.next()) {
                count = rs.getInt("TotalCar");
            }
        } catch (SQLException ex) {
        }

                                    
        return count;
    }
    
    public List<Integer> getAllCategory(){
        List<Integer> iList = new ArrayList<>();
        String sql = "select distinct NumberOfSeats\n" +
                     "from Cars";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            
            while (rs.next()) {
                int seats = rs.getInt("NumberOfSeats");
                iList.add(seats);
            }
        } catch (SQLException ex) {
        }
        
        
        return iList;
    }
    
    
     public List<Car> getAllCarFilter(String sql, String city){
        List<Car> cList = new ArrayList<>();
        

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, city);
            ResultSet rs = pre.executeQuery();
            
            
            
            while (rs.next()) {
                int carID = rs.getInt("carID");
                String name = rs.getString("name");
                boolean available = rs.getBoolean("available");
                String image = rs.getString("image");
                int priceID = rs.getInt("priceID");
                int stationID = rs.getInt("stationID");
                int numberOfSeats = rs.getInt("numberOfSeats");
                int largeBags = rs.getInt("largeBags");
                int smallBags = rs.getInt("smallBags");
                float reviewScore = rs.getFloat("reviewScore");
                int reviewers = rs.getInt("reviewers");
                String pickuplocation = rs.getString("pickuplocation");
                int dailyprice = rs.getInt("dailyprice");
                
                Car c = new Car(carID,name, available, image, priceID, stationID, numberOfSeats, largeBags, smallBags,reviewScore,reviewers,pickuplocation,dailyprice);
                cList.add(c);
            }
        } catch (SQLException ex) {
        }

                                    
        return cList;
    }
     
     public List<Car> getAllCarInCart(String username){
         List<Car> cList = new ArrayList<>();
         
         String sql ="select c.*, s.pickupLocation, p.DailyPrice, p.Deposit, \n" +
                    "ca.totalDayRent\n" +
                    "from Cars as c, Stations as s, PriceDetails as p, Carts as ca\n" +
                    "where c.StationID = s.StationID and c.PriceID = p.PriceID \n" +
                    "and ca.CarID = c.CarID and ca.Username = ?";
         
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, username);
            ResultSet rs = pre.executeQuery();
            
            while (rs.next()) {
                int carID = rs.getInt("carID");
                String name = rs.getString("name");
                boolean available = rs.getBoolean("available");
                String image = rs.getString("image");
                int priceID = rs.getInt("priceID");
                int stationID = rs.getInt("stationID");
                int numberOfSeats = rs.getInt("numberOfSeats");
                int largeBags = rs.getInt("largeBags");
                int smallBags = rs.getInt("smallBags");
                float reviewScore = rs.getFloat("reviewScore");
                int reviewers = rs.getInt("reviewers");
                String pickuplocation = rs.getString("pickuplocation");
                int dailyprice = rs.getInt("dailyprice");
                int deposit = rs.getInt("deposit");
                int totalDayRent = rs.getInt("totalDayRent");
                Car c = new Car(carID,name, available, image, priceID, stationID, numberOfSeats, largeBags, smallBags,reviewScore,reviewers,pickuplocation,dailyprice,deposit,totalDayRent);
                
                cList.add(c);
            }
            
        } catch (SQLException ex) {
        }
         
         return cList;
     }
     
     
     public Car getCarInCartDetail(String carID, String username){
         Car car = null;
         
         String sql ="select c.*, s.pickupLocation, p.DailyPrice, p.Deposit, \n" +
                    "ca.totalDayRent\n" +
                    "from Cars as c, Stations as s, PriceDetails as p, Carts as ca\n" +
                    "where c.StationID = s.StationID and c.PriceID = p.PriceID \n" +
                    "and ca.CarID = c.CarID and ca.Username = ? \n" +
                    "and ca.carID = ?";

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, carID);
            ResultSet rs = pre.executeQuery();
            
            while (rs.next()) {
                int carid = rs.getInt("carID");
                String name = rs.getString("name");
                boolean available = rs.getBoolean("available");
                String image = rs.getString("image");
                int priceID = rs.getInt("priceID");
                int stationID = rs.getInt("stationID");
                int numberOfSeats = rs.getInt("numberOfSeats");
                int largeBags = rs.getInt("largeBags");
                int smallBags = rs.getInt("smallBags");
                float reviewScore = rs.getFloat("reviewScore");
                int reviewers = rs.getInt("reviewers");
                String pickuplocation = rs.getString("pickuplocation");
                int dailyprice = rs.getInt("dailyprice");
                int deposit = rs.getInt("deposit");
                int totalDayRent = rs.getInt("totalDayRent");
                car = new Car(carid,name, available, image, priceID, stationID, numberOfSeats, largeBags, smallBags,reviewScore,reviewers,pickuplocation,dailyprice,deposit,totalDayRent);
                
               
            }
            
        } catch (SQLException ex) {
        }
         
         return car;
     }
     
     
     public Car getCarByID(String id){
        Car c = null;
        
        String sql ="select c.*, s.pickupLocation, p.DailyPrice, p.Deposit\n" +
                    "from Cars as c, Stations as s, PriceDetails as p \n" +
                    "where c.StationID = s.StationID and c.PriceID = p.PriceID \n" +
                    "and c.carID = ?";

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, id);
            ResultSet rs = pre.executeQuery();
            
            while (rs.next()) {
                int carID = rs.getInt("carID");
                String name = rs.getString("name");
                boolean available = rs.getBoolean("available");
                String image = rs.getString("image");
                int priceID = rs.getInt("priceID");
                int stationID = rs.getInt("stationID");
                int numberOfSeats = rs.getInt("numberOfSeats");
                int largeBags = rs.getInt("largeBags");
                int smallBags = rs.getInt("smallBags");
                float reviewScore = rs.getFloat("reviewScore");
                int reviewers = rs.getInt("reviewers");
                String pickuplocation = rs.getString("pickuplocation");
                int dailyprice = rs.getInt("dailyprice");
                int deposit = rs.getInt("deposit");
                
                c = new Car(carID,name, available, image, priceID, stationID, numberOfSeats, largeBags, smallBags,reviewScore,reviewers,pickuplocation,dailyprice,deposit);
                
            }
        } catch (SQLException ex) {
        }

                                    
        return c;
    }
     
     
     
     public List<Car> getSimilarCar(Car car, String pickuplocation1){
        List<Car> cList = new ArrayList<>();
        
        String sql ="select c.*, s.pickupLocation, p.DailyPrice, p.Deposit\n" +
                    "from Cars as c, Stations as s, PriceDetails as p \n" +
                    "where c.StationID = s.StationID and c.PriceID = p.PriceID \n" +
                    "and c.NumberOfSeats=? and c.LargeBags=? and SmallBags=?\n" +
                    "and c.CarID != ? and s.City = ?";

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, car.getNumberOfSeats());
            pre.setInt(2, car.getLargeBags());
            pre.setInt(3, car.getSmallBags());
            pre.setInt(4, car.getCarID());
            pre.setString(5, pickuplocation1);
            ResultSet rs = pre.executeQuery();
            
            while (rs.next()) {
                int carID = rs.getInt("carID");
                String name = rs.getString("name");
                boolean available = rs.getBoolean("available");
                String image = rs.getString("image");
                int priceID = rs.getInt("priceID");
                int stationID = rs.getInt("stationID");
                int numberOfSeats = rs.getInt("numberOfSeats");
                int largeBags = rs.getInt("largeBags");
                int smallBags = rs.getInt("smallBags");
                float reviewScore = rs.getFloat("reviewScore");
                int reviewers = rs.getInt("reviewers");
                String pickuplocation = rs.getString("pickuplocation");
                int dailyprice = rs.getInt("dailyprice");
                int deposit = rs.getInt("deposit");
                
                Car c = new Car(carID,name, available, image, priceID, stationID, numberOfSeats, largeBags, smallBags,reviewScore,reviewers,pickuplocation,dailyprice,deposit);
                cList.add(c);
            }
        } catch (SQLException ex) {
        }

                                    
        return cList;
    }
     
     
     public void updateCar(Car car){
         String sql = "update Cars\n" +
                        "set\n" +
                        "Name = ?,\n" +
                        "Available = ?,\n" +
                        "Image =?,\n" +
                        "priceID=?,\n" +
                        "StationID=?,\n" +
                        "NumberOfSeats=?,\n" +
                        "LargeBags=?,\n" +
                        "SmallBags=?\n" +
                        "where CarID = ?";
         
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, car.getName());
            pre.setBoolean(2, car.isAvailable());
            pre.setString(3, car.getImgage());
            pre.setInt(4, car.getPriceID());
            pre.setInt(5, car.getStationID());
            pre.setInt(6, car.getNumberOfSeats());
            pre.setInt(7, car.getLargeBags());
            pre.setInt(8, car.getSmallBags());
            pre.setInt(9, car.getCarID());
            
            
            pre.executeUpdate();
        } catch (SQLException ex) {
        }
     }

     public void insertNewCar(Car car){
        String sql = "insert into Cars (Name,Available,Image,PriceID,StationID, NumberOfSeats\n" +
                    ",LargeBags,SmallBags,ReviewScore,Reviewers)\n" +
                    "values \n" +
                    "(?,?,?, ?, ?,?,?,?,?,?)";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, car.getName());
            pre.setBoolean(2, car.isAvailable());
            pre.setString(3, car.getImgage());
            pre.setInt(4, car.getPriceID());
            pre.setInt(5, car.getStationID());
            pre.setInt(6, car.getNumberOfSeats());
            pre.setInt(7, car.getLargeBags());
            pre.setInt(8, car.getSmallBags());
            pre.setFloat(9, car.getReviewScore());
            pre.setInt(10, car.getReviewer());
            
            pre.executeUpdate();
        } catch (SQLException ex) {
        }
    }
    
//    public static void main(String[] args) {
//        CarDAO cdao = new CarDAO();
//        List<Car> cList = cdao.getAll();
//        
//        for (Car car : cList) {
//            System.out.println(car);
//        }
//    }
}
