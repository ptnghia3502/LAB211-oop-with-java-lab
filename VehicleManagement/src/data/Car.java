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
public class Car extends Vehicles {
    
    private String type;
    private int yearMade;
    
    //constructor
    public Car() {
    }
    
    public Car(String id) {
        super(id);
    }
    
    public Car(String type, int yearMade, String id, String name, String color, int price, String brand) {
        super(id, name, color, price, brand);
        this.type = type;
        this.yearMade = yearMade;
        this.setvType(1);
    }
    
    // getter setter
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYearMade() {
        return yearMade;
    }

    public void setYearMade(int yearMade) {
        this.yearMade = yearMade;
    }
    
    // override
    @Override
    public String toString() {
         return super.toString() + " ,type:" + type + " ,yearMade:" + yearMade;
    }
    
    @Override
    public String print() {
        super.print();
        return (this.getvType() + ", " + this.getId() + ", " + this.getName() + ", "
                + this.getColor() + ", " + this.getPrice() + ", " + this.getBrand() + ", "
                + this.type + ", " + this.yearMade);
    }
    
    @Override
    public void edit() {
        super.edit();
        this.type = NghiaUtils.getString("Input new vehicle type (Old type:" + this.getType() + "): ");
        this.yearMade = NghiaUtils.getInt("Input new year of vehicle (Old year made:" + this.getYearMade() + "): ");
    }

    @Override
    public void input() {
        super.input();
        this.type = NghiaUtils.getString("Input vehicle type: ");
        this.yearMade = NghiaUtils.getInt("Input year made of vehicle: ");
        this.setvType(1);
    }
    
    
}
