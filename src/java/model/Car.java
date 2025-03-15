/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dell
 */
public class Car {
    int carID;
    String name;
    boolean available;
    String imgage;
    int priceID, stationID,numberOfSeats, largeBags, smallBags;
    float reviewScore;
    int reviewer;
    
    //Them
    String pickuplocation;
    int dailyprice;
    int deposit;
    int totalDayRent;

    public Car() {
    }

    public Car(int carID, String name, boolean available, String imgage, int priceID, int stationID, int numberOfSeats, int largeBags, int smallBags, float reviewScore, int reviewer) {
        this.carID = carID;
        this.name = name;
        this.available = available;
        this.imgage = imgage;
        this.priceID = priceID;
        this.stationID = stationID;
        this.numberOfSeats = numberOfSeats;
        this.largeBags = largeBags;
        this.smallBags = smallBags;
        this.reviewScore = reviewScore;
        this.reviewer = reviewer;
    }

    

    public Car(int carID, String name, boolean available, String imgage, int priceID, int stationID, int numberOfSeats, int largeBags, int smallBags, float reviewScore, int reviewer, String pickuplocation, int dailyprice) {
        this.carID = carID;
        this.name = name;
        this.available = available;
        this.imgage = imgage;
        this.priceID = priceID;
        this.stationID = stationID;
        this.numberOfSeats = numberOfSeats;
        this.largeBags = largeBags;
        this.smallBags = smallBags;
        this.reviewScore = reviewScore;
        this.reviewer = reviewer;
        this.pickuplocation = pickuplocation;
        this.dailyprice = dailyprice;
    }

    public Car(int carID, String name, boolean available, String imgage, int priceID, int stationID, int numberOfSeats, int largeBags, int smallBags, float reviewScore, int reviewer, String pickuplocation, int dailyprice, int deposit) {
        this.carID = carID;
        this.name = name;
        this.available = available;
        this.imgage = imgage;
        this.priceID = priceID;
        this.stationID = stationID;
        this.numberOfSeats = numberOfSeats;
        this.largeBags = largeBags;
        this.smallBags = smallBags;
        this.reviewScore = reviewScore;
        this.reviewer = reviewer;
        this.pickuplocation = pickuplocation;
        this.dailyprice = dailyprice;
        this.deposit = deposit;
    }

    public Car(int carID, String name, boolean available, String imgage, int priceID, int stationID, int numberOfSeats, int largeBags, int smallBags, float reviewScore, int reviewer, String pickuplocation, int dailyprice, int deposit, int totalDayRent) {
        this.carID = carID;
        this.name = name;
        this.available = available;
        this.imgage = imgage;
        this.priceID = priceID;
        this.stationID = stationID;
        this.numberOfSeats = numberOfSeats;
        this.largeBags = largeBags;
        this.smallBags = smallBags;
        this.reviewScore = reviewScore;
        this.reviewer = reviewer;
        this.pickuplocation = pickuplocation;
        this.dailyprice = dailyprice;
        this.deposit = deposit;
        this.totalDayRent = totalDayRent;
    }

    public int getTotalDayRent() {
        return totalDayRent;
    }

    public void setTotalDayRent(int totalDayRent) {
        this.totalDayRent = totalDayRent;
    }
    
    
    
    

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    
    
    public int getDailyprice() {
        return dailyprice;
    }

    public void setDailyprice(int dailyprice) {
        this.dailyprice = dailyprice;
    }
    
    
    

    public String getPickuplocation() {
        return pickuplocation;
    }

    public void setPickuplocation(String pickuplocation) {
        this.pickuplocation = pickuplocation;
    }

    

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(float reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getReviewer() {
        return reviewer;
    }

    public void setReviewer(int reviewer) {
        this.reviewer = reviewer;
    }

    

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getImgage() {
        return imgage;
    }

    public void setImgage(String imgage) {
        this.imgage = imgage;
    }

    public int getPriceID() {
        return priceID;
    }

    public void setPriceID(int priceID) {
        this.priceID = priceID;
    }

    public int getStationID() {
        return stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getLargeBags() {
        return largeBags;
    }

    public void setLargeBags(int largeBags) {
        this.largeBags = largeBags;
    }

    public int getSmallBags() {
        return smallBags;
    }

    public void setSmallBag(int smallBags) {
        this.smallBags = smallBags;
    }

    @Override
    public String toString() {
        return "{"+name+ ", " + carID + ", " + available + ", " + imgage + ", " + priceID + ", " + stationID + ", " + numberOfSeats + ", " + largeBags + ", " + smallBags + '}';
    }
    
    
    
}
