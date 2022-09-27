/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.IOException;
import java.util.ArrayList;
import data.Employee;
import tools.NghiaUtils;

/**
 *
 * @author Nghia
 */
public class EmpList extends ArrayList<Employee> implements E_List {

    private int TABLE_SIZE = 65536; //so ky tu unicode
    int nPosition = 3;

    @Override
    public boolean loadEmpFile() {
        boolean check = false;
        try {
            tools.ReadFromFile file = new tools.ReadFromFile("employee.txt");
            String line;
            while ((line = file.readLine()) != null) {
                String[] tmp = line.split(", ");
                String id = tmp[0];
                String name = tmp[1];
                String birthday = tmp[2];
                String role = tmp[3];
                boolean sex = Boolean.parseBoolean(tmp[4]);
                String pass = tmp[5];
                Employee emp = new Employee(id, name, birthday, role, sex, pass);
                this.add(emp);
            }
            file.inputClose();
            return true;
        } catch (IOException ex) {
            System.out.println("Error!!!");
        }
        return check;
    }

    @Override
    public boolean login() {
        boolean result = false;
        try {
            String id = NghiaUtils.getString("Input your employee ID: ");
            int index = this.find(id);
            do {
                if (index < 0) {
                    System.out.println("ID employee doesn't exist");
                    id = NghiaUtils.getString("Please retype your employee ID: ");
                    index = this.find(id);
                }
            } while (index < 0);
            
            String pwd = NghiaUtils.getString("Input your password: "); //123456
            //456789 -> txt
            String tmpPass = decode(passOfID(id)); 
            //pass of id = 456789
            //-> decode = 123456
            //tmpPasss =  123456
            do {
                if (pwd.equals(tmpPass) == false) {
                    System.out.println("Wrong password!!");
                    pwd = NghiaUtils.getString("Please retype your password:");
                }
            } while (pwd.equals(tmpPass) == false);
            //123456=123456
            encode(tmpPass); //123456 -> 456789
            result = true;
        } catch (Exception e) {
            return false;
        }
        return result;
    }

    @Override
    public int find(String id) {
        int index = -1;
        try {
            index = this.indexOf(new Employee(id));

        } catch (Exception e) {
        }
        return index;
    }

    @Override
    public String passOfID(String id) {
        int index = this.find(id);
        Employee employee = new Employee();
        employee = (Employee) this.get(index);
        String tmp = employee.passOfEmp();
        return tmp;
    }

    @Override
    public char shift(char c, int nPos) {
        int charCode = (int) c + nPos;
        if (charCode < 0) {
            charCode += TABLE_SIZE;
        }
        return (char) (charCode % TABLE_SIZE);
    }

    @Override
    public String encode(String src) {
        String result = "";
        for (int i = 0; i < src.length(); i++) {
            result += shift(src.charAt(i), nPosition);
        }
        return result;
    }

    @Override
    public String decode(String encodeStr) {
        String src = "";
        for (int i = 0; i < encodeStr.length(); i++) {
            src += shift(encodeStr.charAt(i), -nPosition);
        }
        return src;
    }
}
