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
public class Request {
    
    private String rID;
    private String emp;
    private String asset;
    private int qty;
    private String rDate;
    private String bDate;
    private String returnDate;
    private int curBorrow;

    public Request() {
    }
    
    public Request(String rID) {
        this.rID = rID;
    }

    public Request(String rID, String emp, String asset, int qty, String rDate, String bDate, String returnDate, int curBorrow) {
        this.rID = rID;
        this.emp = emp;
        this.asset = asset;
        this.qty = qty;
        this.rDate = rDate;
        this.bDate = bDate;
        this.returnDate = returnDate;
        this.curBorrow = curBorrow;
    }

    public String getrID() {
        return rID;
    }

    public void setrID(String rID) {
        this.rID = rID;
    }

    public String getEmp() {
        return emp;
    }

    public void setEmp(String emp) {
        this.emp = emp;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getrDate() {
        return rDate;
    }

    public void setrDate(String rDate) {
        this.rDate = rDate;
    }

    public String getbDate() {
        return bDate;
    }

    public void setbDate(String bDate) {
        this.bDate = bDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public int getCurBorrow() {
        return curBorrow;
    }

    public void setCurBorrow(int curBorrow) {
        this.curBorrow = curBorrow;
    }
    
    
    
    //==================================

    @Override
    public boolean equals(Object obj) {
        return this.rID.equalsIgnoreCase(((Request) obj).getrID()); //so sanh id
    }
    
    @Override
    public String toString() {
        return " Request ID: " + rID + " , Employee: " + emp + " ,Asset: " + asset + " ,Quantity request: " + qty 
                + " ,Request date: " + rDate + " ,Borrow date: " + bDate + " ,Return date: " + returnDate + " ,Current borrow: " + curBorrow;
    }
    
    public String print() {
        return (this.getrID()+ ", " + this.getEmp() + ", " + this.getAsset() + ", "
                + this.getQty() + ", " + this.getrDate() + ", " + this.getbDate() + ", " + this.getReturnDate() + ", " + this.getCurBorrow());
    }

    public void accept() {
        this.curBorrow +=qty;
        this.qty -= qty;
    }
    
    public int valueBorrowQty() {
        return this.curBorrow;
    }
    
    public String idAssetBorrow() {
        return this.getAsset();
    }
}
