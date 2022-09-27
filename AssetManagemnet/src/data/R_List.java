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
public interface R_List {
    
    void show();
    
    boolean loadRequestFile();
    
    boolean saveRequestFile();
    
    boolean approve(String id);
    
    int find(String id);
    
    int value (String id);
    
    String idAssetBorrow(String id);
}
