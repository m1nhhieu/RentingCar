/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dell
 */
public class Contract {
    String contractID;
    int CarId;
    String PickUpDateTime,ReturnDateTime;
    int pickUpLocation,returnLocation;
    String username;
    int totalRentPrice;
    
    //Them
    String specificLocation;
    String carName, carImg; 

    public Contract(String contractID, int CarId, String PickUpDateTime, String ReturnDateTime, int pickUpLocation, int returnLocation, String username, int totalRentPrice) {
        this.contractID = contractID;
        this.CarId = CarId;
        this.PickUpDateTime = PickUpDateTime;
        this.ReturnDateTime = ReturnDateTime;
        this.pickUpLocation = pickUpLocation;
        this.returnLocation = returnLocation;
        this.username = username;
        this.totalRentPrice = totalRentPrice;
    }

    public Contract() {
    }

    public Contract(String contractID, int CarId, String PickUpDateTime, String ReturnDateTime, int pickUpLocation, int returnLocation, String username, int totalRentPrice, String specificLocation, String carName, String carImg) {
        this.contractID = contractID;
        this.CarId = CarId;
        this.PickUpDateTime = PickUpDateTime;
        this.ReturnDateTime = ReturnDateTime;
        this.pickUpLocation = pickUpLocation;
        this.returnLocation = returnLocation;
        this.username = username;
        this.totalRentPrice = totalRentPrice;
        this.specificLocation = specificLocation;
        this.carName = carName;
        this.carImg = carImg;
    }
    
    

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarImg() {
        return carImg;
    }

    public void setCarImg(String carImg) {
        this.carImg = carImg;
    }

    

    public String getSpecificLocation() {
        return specificLocation;
    }

    public void setSpecificLocation(String specificLocation) {
        this.specificLocation = specificLocation;
    }

    
    
    public String getContractID() {
        return contractID;
    }

    public void setContractID(String contractID) {
        this.contractID = contractID;
    }

    public int getCarId() {
        return CarId;
    }

    public void setCarId(int CarId) {
        this.CarId = CarId;
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

    public int getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(int pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public int getReturnLocation() {
        return returnLocation;
    }

    public void setReturnLocation(int returnLocation) {
        this.returnLocation = returnLocation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTotalRentPrice() {
        return totalRentPrice;
    }

    public void setTotalRentPrice(int totalRentPrice) {
        this.totalRentPrice = totalRentPrice;
    }

    @Override
    public String toString() {
        return "{" + contractID + ", " + CarId + ", " + PickUpDateTime + ", " +
                ReturnDateTime + ", " + pickUpLocation + ", " + returnLocation + ", " + username + ", " + totalRentPrice + '}';
    }
    
    
    
    
}
