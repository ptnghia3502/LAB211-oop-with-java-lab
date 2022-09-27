/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import tools.NghiaUtils;

/**
 *
 * @author Nghia
 */
public class Employee {
    
    private String empID;
    private String empName;
    private String bDate;
    private String role;
    private boolean sex;
    private String pwd;

    public Employee() {
    }
    
    public Employee(String empID) {
        this.empID = empID;
    }

    public Employee(String empID, String empName, String bDate, String role, boolean sex, String pwd) {
        this.empID = empID;
        this.empName = empName;
        this.bDate = bDate;
        this.role = role;
        this.sex = sex;
        this.pwd = pwd;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getbDate() {
        return bDate;
    }

    public void setbDate(String bDate) {
        this.bDate = bDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    //==================================
    
    @Override
    public boolean equals(Object obj) {
        return this.empID.equalsIgnoreCase(((Employee) obj).getEmpID()); //so sanh id
    }
    
    public String passOfEmp() {
        return this.pwd;
    }
}
