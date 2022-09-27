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
public class Motorbike extends Vehicles {
    
    private int maxSpeed;
    private boolean license;
    
    //constructor
    public Motorbike() {
    }

    public Motorbike(String id) {
        super(id);
    }

    public Motorbike(int maxSpeed, boolean license, String id, String name, String color, int price, String brand) {
        super(id, name, color, price, brand);
        this.maxSpeed = maxSpeed;
        this.license = license;
        this.setvType(2);
    }
    
    //getter setter
    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public boolean isLicense() {
        return license;
    }

    public void setLicense(boolean license) {
        this.license = license;
    }
    
    public String makeSound() {
        return " Tin tin tin";
    }
    
    //override
    @Override
    public String toString() {
        return super.toString() + " ,maxSpeed:" + maxSpeed + " ,license:" + license + this.makeSound();
    }
    
     @Override
    public String print() {
        super.print();
        return (this.getvType() + ", " + this.getId() + ", " + this.getName() + ", "
                + this.getColor() + ", " + this.getPrice() + ", " + this.getBrand() + ", "
                + this.maxSpeed + ", " + this.license);
    }
    
    @Override
    public void edit() {
        super.edit();
        this.maxSpeed = NghiaUtils.getInt("Input new vehicle speed (Old speed:" + this.getMaxSpeed() + "): ");
        this.license = NghiaUtils.confirmYesNo("Do vehicle require license (Y/N)? : ", this.isLicense());
    }

    @Override
    public void input() {
        super.input();
        this.maxSpeed = NghiaUtils.getInt("Input vehicle speed: ");
        this.license = NghiaUtils.confirmYesNo("Do vehicle require license (Y/N)? : ");
        this.setvType(2);
    }
    
    public void message() {
        System.out.println("Tin tin tin");
    }
}
