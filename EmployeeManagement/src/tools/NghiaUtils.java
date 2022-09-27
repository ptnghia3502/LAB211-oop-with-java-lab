/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Scanner;

/**
 *
 * @author Nghia
 */
public class NghiaUtils {
    
    public static void showMenu() {
        System.out.println("==============================");
        System.out.println("Welcome to Employees Management");
        System.out.println("Select your choice:");
        System.out.println("1. Adding new employee");
        System.out.println("2. Removing employee");
        System.out.println("3. Promoting the salary of an employee");
        System.out.println("4. Listing employee details");
        System.out.println("5. Save the lisst to file");
        System.out.println("6. Quit");
        System.out.println("==============================");
    }
    
    public static int getInt(String welcome, int min, int max) {
        int number = 0;
        boolean check = true;

        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                number = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.print("Input Interger!\n");
            }
        } while (check || number > max || number < min);
        return number;
    }
    
    public static String getString(String welcome) {
        String result = "";
        boolean check = true;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(welcome);
            result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println("Input text!!!");
            } else {
                check = false;
            }
        } while (check);
        return result;
    }
    
    public static boolean confirmYesNo(String welcome) {
        boolean result = false;
        String confirm = NghiaUtils.getString(welcome);
        if ("Y".equalsIgnoreCase(confirm)) {
            result = true;
        }
        return result;
    }
}
