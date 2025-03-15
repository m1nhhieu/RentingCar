/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dell
 */
public class Cart {
    int cartID, carID;
    String username;
    String PickUpDateTime,ReturnDateTime;
    int pickUpStation,returnStation;
    int totalDayRent;
    String pickuplocation;
    
    

    public Cart() {
    }

    public Cart(int cartID, int carID, String username, String PickUpDateTime, String ReturnDateTime, int pickUpStation, int returnStation, int totalDayRent, String pickuplocation) {
        this.cartID = cartID;
        this.carID = carID;
        this.username = username;
        this.PickUpDateTime = PickUpDateTime;
        this.ReturnDateTime = ReturnDateTime;
        this.pickUpStation = pickUpStation;
        this.returnStation = returnStation;
        this.totalDayRent = totalDayRent;
        this.pickuplocation = pickuplocation;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPickUpDateTime() {
        return PickUpDateTime;
    }

    public void setPickUpDateTime(String PickUpDateTime) {
        this.PickUpDateTime = PickUpDateTime;
    }

    public String getReturnDateTime() {
        return ReturnDateTime;
    }

    public void setReturnDateTime(String ReturnDateTime) {
        this.ReturnDateTime = ReturnDateTime;
    }

    public int getPickUpStation() {
        return pickUpStation;
    }

    public void setPickUpStation(int pickUpStation) {
        this.pickUpStation = pickUpStation;
    }

    public int getReturnStation() {
        return returnStation;
    }

    public void setReturnStation(int returnStation) {
        this.returnStation = returnStation;
    }

    public int getTotalDayRent() {
        return totalDayRent;
    }

    public void setTotalDayRent(int totalDayRent) {
        this.totalDayRent = totalDayRent;
    }

    public String getPickuplocation() {
        return pickuplocation;
    }

    public void setPickuplocation(String pickuplocation) {
        this.pickuplocation = pickuplocation;
    }

    

    
    
    
    
}
