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
public class Vehicles implements Comparable<Object> {
    
    private int vType;
    private String id;
    private String name;
    private String color;
    private int price;
    private String brand;

    //constructor    
    public Vehicles() {
    }
    
    public Vehicles(String id) {
        this.id = id;
    }

    public Vehicles(String id, String name, String color, int price, String brand) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
        this.brand = brand;
    }
    
    //getter setter
    public int getvType() {
        return vType;
    }

    public void setvType(int vType) {
        this.vType = vType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {    
        this.brand = brand;
    }

    // override
    @Override
    public int compareTo(Object o) {
        return this.getPrice()-(((Vehicles) o).getPrice()); //so sanh price
    }

    @Override
    public boolean equals(Object obj) {
        return this.id.equalsIgnoreCase(((Vehicles) obj).getId()); //so sanh id
    }
    
    @Override
    public String toString() {
        if (this.vType == 1) {
            return "Car:   " + "id: " + id + " ,name: " + name + " ,color: " + color + " ,price: " + price + " ,brand: " + brand;
        }
        if (this.vType == 2) {
            return "Motorbike:   " + "id: " + id + " ,name: " + name + " ,color: " + color + " ,price: " + price + " ,brand: " + brand;
        }
        return "Error!";
    }
    
    //ham ho tro
    public String print() {
        return (this.getvType()+ ", " + this.getId() + ", " + this.getName() + ", "
                + this.getColor() + ", " + this.getPrice() + ", " + this.getBrand() + ", ");
    }
    
    public void input() {
        this.name = NghiaUtils.getString("Input vehicle name: ");
        this.color = NghiaUtils.getString("Input vehicle color: ");
        this.price = NghiaUtils.getInt("Input vehicle price: ", 0, 999999999);
        this.brand = NghiaUtils.getString("Input vehicle brand: ");
    }
    
    public void edit() {
        this.name = NghiaUtils.getString("Input new vehicle name (Old name:" + this.getName() + "): ");
        this.color = NghiaUtils.getString("Input new vehicle color (Old color:" + this.getColor() + "): ");
        this.price = NghiaUtils.getInt("Input new vehicle price (Old price:" + this.getPrice() + "): ");
        this.brand = NghiaUtils.getString("Input new vehicle brand (Old brand:" + this.getBrand() + "): ");
        
    }
    
}
