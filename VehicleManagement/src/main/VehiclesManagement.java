/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import data.I_List;
import data.I_Menu;
import data.Menu;
import data.VehicleList;
import tools.NghiaUtils;

/**
 *
 * @author Nghia
 */
public class VehiclesManagement {
    
    public static void main(String[] args) {
        
        I_Menu menu = new Menu();
        menu.addItem("1. Add new vehicle");
        menu.addItem("2. Update vehicle by ID");
        menu.addItem("3. Delete vehicle by ID");
        menu.addItem("4. Search vehicle");
        menu.addItem("5. Show list of vehicles");
        menu.addItem("6. Store data to file");
        menu.addItem("7. Quit");

        int choice;
        boolean cont = false;
        boolean check = false;
        I_List list = new VehicleList();
        list.loadFromFile(); //auto load file when run program
        do {
            menu.showMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    NghiaUtils.smallMenu();
                    int type = NghiaUtils.getInt("Select vehicle type: ", 1, 2);
                    check = list.addVehicle(type);
                    if (check == true) {
                        System.out.println("Add successfully!!!\n");
                    } else {
                        System.out.println("Add fail!\n");
                    }
                    break;
                case 2:
                    check = list.update();
                    if (check == true) {
                        System.out.println("Update successfully!!!\n");
                    } else {
                        System.out.println("Update fail!\n");
                    }
                    break;
                case 3:
                    check = list.removeVehicle();
                    if (check == true) {
                        System.out.println("Remove successfully!!!\n");
                    } else {
                        System.out.println("Remove fail!\n");
                    }
                    break;
                case 4:
                    check = list.search();
                    if (check == false) {
                        System.out.println("Not Found!\n");
                    }
                    System.out.println("\n");
                    break;
                case 5:
                    list.show();
                    System.out.println("\n");
                    break;
                case 6: 
                    list.saveToFile();
                    check = false;
                    System.out.println("Saved!");
                    System.out.println("\n");
                    break;
                case 7:
                    cont = menu.confirmYesNo("Do you want to quit?(Y/N): ");
                    break;               
            }
        }
        while (!cont);
    }
    
}
