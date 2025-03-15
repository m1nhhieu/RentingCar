/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dell
 */
public class PriceDetail {
    int priceID;
    String brand;
    int manufactureYear;
    String model;
    int dailyPrice;
    int deposit;

    public PriceDetail() {
    }

    public PriceDetail(int priceID, String brand, int manufactureYear, String model, int dailyPrice, int deposit) {
        this.priceID = priceID;
        this.brand = brand;
        this.manufactureYear = manufactureYear;
        this.model = model;
        this.dailyPrice = dailyPrice;
        this.deposit = deposit;
    }

    public int getPriceID() {
        return priceID;
    }

    public void setPriceID(int priceID) {
        this.priceID = priceID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(int dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    @Override
    public String toString() {
        return "{" + priceID + ", " + brand + ", " + manufactureYear + ", " + model + ", " + dailyPrice + ", " + deposit + '}';
    }
    
    
    
}
