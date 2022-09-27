/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import tools.NghiaUtils;

/**
 *
 * @author Nghia
 */
public class Menu extends ArrayList<String> implements I_Menu {

    public Menu() {
        super();
    }
    
    @Override
    public void addItem(String s) {
        this.add(s);
    }

    @Override
    public int getChoice() {
        int choice;
        choice = NghiaUtils.getInt("Input your chocie: ", 1, this.size());
        return choice;
    }

    @Override
    public void showMenu() {
        for (String str : this) {
            System.out.println(str);
            
        }
    }

    @Override
    public boolean confirmYesNo(String welcome) {
        boolean result;
        result = NghiaUtils.confirmYesNo("Do you want to quit (Y/N): ");
        return result;
    }
    
}
