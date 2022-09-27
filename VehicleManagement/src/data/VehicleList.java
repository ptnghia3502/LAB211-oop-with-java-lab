/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import tools.NghiaUtils;

/**
 *
 * @author Nghia
 */
public class VehicleList extends ArrayList<Vehicles> implements I_List {
    
    @Override
    public boolean loadFromFile() {
        boolean check = false;
        boolean confirm;
        try {
            tools.ReadFromFile file = new tools.ReadFromFile("vehicles.txt");
            String line;
            while ((line = file.readLine()) != null) {
                String[] tmp = line.split(", ");
                int typeVe = Integer.parseInt(tmp[0]);
                if (typeVe == 1) {
                    String id = tmp[1];
                    String name = tmp[2];
                    String color = tmp[3];
                    int price = Integer.parseInt(tmp[4]);
                    String brand = tmp[5];
                    String type = tmp[6];
                    int yearMade = Integer.parseInt(tmp[7]);
                    Car car = new Car(type, yearMade, id, name, color, price, brand);
                    this.add(car);
                }
                if (typeVe == 2) {
                    String id = tmp[1];
                    String name = tmp[2];
                    String color = tmp[3];
                    int price = Integer.parseInt(tmp[4]);
                    String brand = tmp[5];
                    int speed = Integer.parseInt(tmp[6]);
                    boolean license = Boolean.parseBoolean(tmp[7]);
                    Motorbike motor = new Motorbike(speed, license, id, name, color, price, brand);
                    this.add(motor);
                }
            }
            file.inputClose();
            return true;
        } catch (IOException ex) {
            System.out.println("Error!!!");
        }
        return check;
    }

    @Override
    public boolean saveToFile() {
        boolean confirm = NghiaUtils.confirmYesNo("Do you want to overwrite your old file? (Y/N): ");
        if (confirm == false) {
            return false;
        }
        try {
            tools.WriteToFile file = new tools.WriteToFile("vehicles.txt");
            for (Vehicles thi : this) {
                if (thi.getvType() == 1) {
                    file.writeLine(((Car) thi).print());
                }
                if (thi.getvType() == 2) {
                    file.writeLine(((Motorbike) thi).print());
                }
            }
            file.outputClose();
            return true;
        } catch (Exception e) {
            System.out.println("Error!!!");
            return false;
        }
    }

    @Override
    public int find(String id) {
        int index = -1;
        try {
            index = this.indexOf(new Vehicles(id));

        } catch (Exception e) {
        }
        return index;
    }
    
    @Override
    public boolean addVehicle(int vType) {
        boolean result = false;
        try {
            String id = NghiaUtils.getString("Input vehicle ID: ");
            int index = this.find(id);
            do {
                if (index > -1) {
                    System.out.println("ID existed");
                    id = NghiaUtils.getString("Please retype another ID:");
                }
            } while (index > -1);
            if (index == -1 && vType == 1) {
                Car car = new Car(id);
                car.input();
                this.add(car);
                result = true;
                return result;
            }
            if (index == -1 && vType == 2) {
                Motorbike bike = new Motorbike(id);
                bike.input();
                this.add(bike);
                result = true;
                return result;
            }
            
        } catch (Exception e) {
            return false;
        }
        return result;
    }

    @Override
    public boolean removeVehicle() {
        boolean result = false;
        try {
            String id = NghiaUtils.getString("Input vehicle ID you want to delete: ");
            int index = this.find(id);
            if (index > -1) {
                boolean check = NghiaUtils.confirmYesNo("Do you really want to delete this vehicle(Y/N)?: " );
                if (check == true) {
                    this.remove(index);
                    result = true;
                } else {
                    result = false;
                    return result;
                }
            } else {
                System.out.println("Not found!!!");
                result = false;
                return result;
            }
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public boolean update() {
        boolean result = false;
        if (this.isEmpty() == true) {
            System.out.println("Empty!");
            return false;
        }
        try {
            String id = NghiaUtils.getString("Input vehicle ID you want to update: ");
            int index = this.find(id);
            do {
                if (index < 0) {
                    System.out.println("Vehicle doesn't exist");
                    id = NghiaUtils.getString("Please retype ID you want to update: ");
                    index = this.find(id);
                }
            } while (index < 0);
            if (index > -1) {
                if (this.get(index).getvType() == 1) {
                    Car car = new Car();
                    car = (Car) this.get(index);
                    car.edit();
                    this.set(index, car);
                    result = true;
                }
                if (this.get(index).getvType() == 2) {
                    Motorbike bike = new Motorbike();
                    bike = (Motorbike) this.get(index);
                    bike.edit();
                    this.set(index, bike);
                    result = true;
                }
            } else {
                System.out.println("Not found!!!");
                result = false;
                return result;
            }
        } catch (Exception e) {
            System.out.println("Error");
            result = false;
            return result;
        }
        return result;
    }
    
    @Override
    public boolean search() {
        boolean check = false;
        if (this.isEmpty() == true) {
            System.out.println("Empty!!!");
            return false;
        }
        System.out.println("1. Search by name");
        System.out.println("2. Search by ID");
        int choice = NghiaUtils.getInt("Input your choice: ", 1, 2);
        if (choice == 1) {
            String name = NghiaUtils.getString("Input name you want to search: ");
            if (searchByName(name) == false) {
                return false;
            } else {
                return true;
            }
        }
        if (choice == 2) {
            String id = NghiaUtils.getString("Input ID you want to search: ");
            int index = find(id);
            if (index < 0) {
                return false;
            } else {
                System.out.println(this.get(index));
                return true;
            }
        }
        return check;
    }

    @Override
    public boolean searchByName(String name) {
        boolean check = false;
        try {
            for (Vehicles thi : this) {
                if (thi.getName().equalsIgnoreCase(name) == true) {
                    System.out.println(thi);
                    check = true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error!");
            return false;
        }
        return check;
    }
    
    @Override
    public void show() {
        if (this.isEmpty() == true) {
            System.out.println("Empty!!!");
            return;
        }
        System.out.println("1. Show all of vehicle");
        System.out.println("2. Show all of vehicle (descending by price)");
        int choice = NghiaUtils.getInt("Input your choice: ", 1, 2);
        if (choice == 1) {
            for (Vehicles tVehicle : this) {
                System.out.println(tVehicle);
            }
        }
        if (choice == 2) {
            Collections.sort(this, Collections.reverseOrder()); //sap xep giam dan
            for (Vehicles tVehicle : this) {
                System.out.println(tVehicle);
            }
        }
    }
    
}
