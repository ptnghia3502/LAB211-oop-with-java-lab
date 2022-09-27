/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees;

import java.util.Vector;
import tools.NghiaUtils;
/**
 *
 * @author Nghia
 */
public class Menu extends Vector <String> {
 
    public Menu() {
        super();
    }
    void addMenuItem(String S) {
        this.add(S);
    }
    
    int getUserChoice() {
        int choice;
        choice = NghiaUtils.getInt("Input your choice (1-6): ", 1, 6);
        return choice;
    }
}
