/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees;

import java.util.Scanner;
import tools.NghiaUtils;

/**
 *
 * @author Nghia
 */
public class ManageProgram {

    public static void main(String[] args) {
        String filename = "employees.txt";
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        int userChoice;
        boolean changed = false;
        EmpList list = new EmpList();
        list.AddFromFile(filename);
        do {
            NghiaUtils.showMenu();
            userChoice = menu.getUserChoice();
            switch (userChoice) {
                case 1:
                    list.addNewEmp();
                    changed = true;
                    break;
                case 2:
                    list.removeEmp();
                    changed = true;
                    break;
                case 3:
                    list.promote();
                    changed = true;
                    break;
                case 4:
                    list.print();
                    break;
                case 5:
                    list.saveToFile(filename);
                    changed = false;
                    break;
                default:
                    if (changed) {
                        System.out.print("Save changes Y/N? ");
                        String response = sc.nextLine().toUpperCase();
                        if (response.startsWith("Y")) {
                            list.saveToFile(filename);
                        }
                    }
                    String quit = NghiaUtils.getString("Do you want to quit? (Y/N)");
                    if ("Y".equalsIgnoreCase(quit)) {
                        changed = false;
                    }
                    break;
            }
        } while (userChoice > 0 && userChoice < 6);
    }
}
