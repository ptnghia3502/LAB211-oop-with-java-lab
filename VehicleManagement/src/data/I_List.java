/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Nghia
 */
public interface I_List {
    
    boolean loadFromFile();
    
    boolean saveToFile();
    
    int find(String id);
    
    boolean addVehicle(int vType);
    
    boolean removeVehicle();
    
    boolean update();
    
    boolean search();
    
    boolean searchByName(String name);
    
    void show();
    
}
