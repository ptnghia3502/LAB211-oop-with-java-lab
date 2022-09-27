/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * @author Nghia
 */
public class EmpList extends Vector <Employee> {
    Scanner sc = new Scanner(System.in);
    public EmpList() {
        super();
    }
    
    public void AddFromFile(String fName) {
        try {
            File f = new File(fName);
            if(!f.exists()) return;
            FileReader fr= new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while ((details = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details,",");
                String code = stk.nextToken().toUpperCase();
                String name = stk.nextToken().toUpperCase();
                int salary = Integer.parseInt(stk.nextToken());
                
                Employee emp = new Employee(code, name, salary);
                this.add(emp);
            }
            bf.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }     
    }
    
    public void saveToFile(String fName) {
        if (this.size()==0) {
            System.out.println("Empty List");
            return;
        }
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Employee x:this) {
                pw.println(x.getCode() + "," + x.getName() + "," + x.getSalary());
            }
            pw.close();
            fw.close();
            System.out.println("The information have been saved to file.\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private int find(String sCode) {
        for (int i=0; i<this.size();i++) {
            if (this.get(i).getCode().equals(sCode)) return i;
        }
        return -1;
    }
    
    public void addNewEmp() {
        String newCode, newName;
        int salary;
        int pos;
        System.out.println("Enter New Employee Details: ");
        do {
            System.out.print("     code:");
            newCode = sc.nextLine().toUpperCase();
            pos = find(newCode);
            if (pos >= 0) System.out.println("The code is duplicated");
        }
        while (pos >= 0);
        System.out.print("     name:");
        newName = sc.nextLine().toUpperCase();
        System.out.print("     salary:");
        salary = Integer.parseInt(sc.nextLine());
        this.add(new Employee(newCode, newName, salary));
        System.out.println("New Employee has been added.\n");
    }
    
    public void removeEmp() {
        String code;
        System.out.print("Enter the code of removed employee: ");
        code = sc.nextLine().toUpperCase();
        int pos = find(code);
        if (pos < 0) System.out.println("This code dose not exist.");
        else {
            this.remove(pos);
            System.out.println("The employee " + code + " has been removed.\n");
        }
    }
    
    public void promote() {
        String code;
        System.out.print("Enter the code of promoted employee: ");
        code = sc.nextLine().toUpperCase();
        int pos = find(code);
        if (pos < 0) System.out.println("This code does not exist");
        else {
            int oldSalary = this.get(pos).getSalary();
            int newSalary;
            do {
                System.out.print("Old salary: " + oldSalary + ", new salary: ");
                newSalary = Integer.parseInt(sc.nextLine());
                if(newSalary < oldSalary) System.out.println("New salary must bigger than old salary");
            }
            while (newSalary < oldSalary);
            this.get(pos).setSalary(newSalary);
            System.out.println("The employee " + code + " has been updated.\n");
        }
    }
    
    public void print() {
        if (this.size() == 0) {
            System.out.println("Empty List");
            return;
        }
        Collections.sort(this);
        System.out.print("\nEMPLOYEE LIST\n");
        System.out.print("----------------------\n");
        for (Employee x: this)x.print();
        System.out.print("\n");
    }
}
