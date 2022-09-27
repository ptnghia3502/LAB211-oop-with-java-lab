/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import tools.NghiaUtils;

/**
 *
 * @author Nghia
 */
public class Asset {
    
    private String assetID;
    private String assetName;
    private String color;
    private int price;
    private double weight;
    private int quantity;
    private int curQty;

    public Asset() {
    }

    public Asset(String assetID) {
        this.assetID = assetID;
    }
    
    public Asset(int curQty) {
        this.curQty = curQty;
    }

    public Asset(String assetID, String assetName, String color, int price, double weight, int quantity, int curQty) {
        this.assetID = assetID;
        this.assetName = assetName;
        this.color = color;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
        this.curQty = curQty;
    }

    public String getAssetID() {
        return assetID;
    }

    public void setAssetID(String assetID) {
        this.assetID = assetID;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCurQty() {
        return curQty;
    }

    public void setCurQty(int curQty) {
        this.curQty = curQty;
    }

    //==================================
    
    @Override
    public boolean equals(Object obj) {
        return this.assetID.equalsIgnoreCase(((Asset) obj).getAssetID()); //so sanh id
    }
    
    @Override
    public String toString() {
        return "Asset ID: " + assetID + " ,Name: " + assetName + " ,Color: " + color + " ,Price: " + price 
                + " ,Weight: " + weight + " ,Quantity: " + quantity + " ,Current quantity: " + curQty;
    }
    
    public String print() {
        return (this.getAssetID()+ ", " + this.getAssetName() + ", " + this.getColor() + ", "
                + this.getPrice() + ", " + this.getWeight() + ", " + this.getQuantity() + ", " + this.getCurQty());
    }
    
    public void input() {
        this.assetName = NghiaUtils.getString("Input asset name: ");
        this.color = NghiaUtils.getString("Input aseet color: : ");
        this.price = NghiaUtils.getInt("Input asset price: ");
        this.weight = NghiaUtils.getDouble("Input asset weight: ");
        this.quantity = NghiaUtils.getInt("Input quantity: ");
        this.curQty = NghiaUtils.getInt("Input current quantity: ");
    }
    
    public void edit() {
        this.assetName = NghiaUtils.getString("Input new asset name (Old name:" + this.getAssetName() + "): ");
        this.color = NghiaUtils.getString("Input new asset color (Old color:" + this.getColor() + "): ");
        this.price = NghiaUtils.getInt("Input new asset price (Old price:" + this.getPrice() + "): ");
        this.weight = NghiaUtils.getDouble("Input new asset weight (Old weight:" + this.getWeight() + "): ");
        this.quantity = NghiaUtils.getInt("Input new asset quantity (Old quantity:" + this.getQuantity() + "): ");
        this.curQty = NghiaUtils.getInt("Input new asset quantity (Old quantity:" + this.getCurQty() + "): ");
    }
    
    public void accept(int quantity) {
        this.curQty = curQty - quantity;
    }
    
}
