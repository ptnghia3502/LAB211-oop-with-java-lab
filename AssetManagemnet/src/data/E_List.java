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
public interface E_List {
    
    boolean loadEmpFile();
    
    boolean login();
    
    int find(String id);
    
    String passOfID(String id);
    
    char shift(char c, int nPos);
    
    String encode(String src);
    
    String decode(String encodeStr);
}
