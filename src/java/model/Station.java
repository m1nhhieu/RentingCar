/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dell
 */
public class Station {
    int stationID;
    String address;
    int carAvailable;
    String pickupLocation, country,city; 

    public Station() {
    }

    public Station(int stationID, String address, int carAvailable, String pickupLocation, String country, String city) {
        this.stationID = stationID;
        this.address = address;
        this.carAvailable = carAvailable;
        this.pickupLocation = pickupLocation;
        this.country = country;
        this.city = city;
    }

    public int getStationID() {
        return stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCarAvailable() {
        return carAvailable;
    }

    public void setCarAvailable(int carAvailable) {
        this.carAvailable = carAvailable;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "{" + stationID + ", " + address + ", " + carAvailable + ", " + pickupLocation + ", " + country + ", " + city + '}';
    }
    
    
}
