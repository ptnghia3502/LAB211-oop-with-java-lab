/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import data.AssetList;
import data.E_List;
import data.EmpList;
import data.I_Menu;
import data.Menu;
import data.R_List;
import data.RequestList;
import tools.NghiaUtils;
import data.A_List;

/**
 *
 * @author Nghia
 */
public class AssetManagement {

    public static void main(String[] args) {

        I_Menu menu = new Menu();
        menu.addItem("1. Login");
        menu.addItem("2. Search asset by name");
        menu.addItem("3. Create new asset");
        menu.addItem("4. Update asset");
        menu.addItem("5. Approve request");
        menu.addItem("6. Show list of  request/borrow asset");
        menu.addItem("7. Quit");

        int choice;
        int logged = 0;
        boolean cont = false;
        boolean check = false;
        A_List list = new AssetList();
        list.loadAssetFile();
        R_List rList = new RequestList();
        rList.loadRequestFile();
        E_List eList = new EmpList();
        eList.loadEmpFile();
        
        do {
            menu.showMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    check = eList.login();
                    if (check == true) {
                        System.out.println("Login successfully!!!\n");
                    } else {
                        System.out.println("Login fail!\n");
                    }
                    logged++;
                    break;

                case 2:
                    if (logged == 0) {
                        System.out.println("You much login to use this function\n");
                    } else {
                        String name = NghiaUtils.getString("Input name you want to search: ");
                        check = list.searchByName(name);
                        if (check == false) {
                            System.out.println("Not Found!\n");
                        }
                        System.out.println("\n");
                    }
                    break;

                case 3:
                    if (logged == 0) {
                        System.out.println("You much login to use this function\n");
                    } else {
                        check = list.create();
                        if (check == true) {
                            System.out.println("Add successfully!!!\n");
                        } else {
                            System.out.println("Add fail!\n");
                        }
                        list.saveAssetFile();
                    }
                    break;

                case 4:
                    if (logged == 0) {
                        System.out.println("You much login to use this function\n");
                    } else {
                        check = list.update();
                        if (check == true) {
                            System.out.println("Update successfully!!!\n");
                        } else {
                            System.out.println("Update fail!\n");
                        }
                        list.saveAssetFile();
                    }
                    break;

                case 5:
                    if (logged == 0) {
                        System.out.println("You much login to use this function\n");
                    } else {
                        String id = NghiaUtils.getString("Input request ID you want to approve: ");
                        check = rList.approve(id);
                        if (check == true) {
                            System.out.println("Approve successfully!!!\n");
                        } else {
                            System.out.println("Approve fail!\n");
                        }
                        rList.saveRequestFile();
                        int tmp = rList.value(id);
                        String assetBr = rList.idAssetBorrow(id);
                        list.approve(tmp, assetBr);
                        list.saveAssetFile();
                    }
                    break;

                case 6:
                    if (logged == 0) {
                        System.out.println("You much login to use this function\n");
                    } else {
                        rList.show();
                        System.out.println("\n");
                    }
                    break;

                case 7:
                    cont = menu.confirmYesNo("Do you want to quit?(Y/N): ");
                    break;
            }
        } while (!cont);
    }
}
