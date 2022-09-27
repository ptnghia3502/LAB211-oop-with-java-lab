/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Nghia
 */
public class ReadFromFile {
    private File file;
    BufferedReader br;
    FileReader fr;

    public ReadFromFile(String filename) throws IOException {
        file = new File(filename);
        boolean checkfile = file.exists();
        if (checkfile == false) {
            file.createNewFile();
        }
        fr = new FileReader(file);
        br = new BufferedReader(fr);
    }

    public String readLine() throws IOException{
        return br.readLine();
    }
    
    public void inputClose() throws IOException {
        br.close();
        fr.close();
    }
}
