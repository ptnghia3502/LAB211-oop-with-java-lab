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
public interface A_List {
    
    boolean loadAssetFile();
    
    boolean saveAssetFile();
    
    int find(String id);
    
    boolean searchByName(String name);
    
    boolean create();
    
    boolean update();
    
    boolean approve(int tmp, String assetBr);
}
