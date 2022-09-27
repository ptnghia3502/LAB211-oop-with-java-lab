/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.IOException;
import java.util.ArrayList;
import tools.NghiaUtils;

/**
 *
 * @author Nghia
 */
public class RequestList extends ArrayList<Request> implements R_List {

    @Override
    public boolean loadRequestFile() {
        boolean check = false;
        try {
            tools.ReadFromFile file = new tools.ReadFromFile("request.txt");
            String line;
            while ((line = file.readLine()) != null) {
                String[] tmp = line.split(", ");
                String id = tmp[0];
                String emp = tmp[1];
                String asset = tmp[2];
                int quantity = Integer.parseInt(tmp[3]);
                String rDate = tmp[4];
                String bDate = tmp[5];
                String returnDate = tmp[6];
                int curBorrow = Integer.parseInt(tmp[7]);
                Request request = new Request(id, emp, asset, quantity, rDate, bDate, returnDate, curBorrow);
                this.add(request);
            }
            file.inputClose();
            return true;
        } catch (IOException ex) {
            System.out.println("Error!!!");
        }
        return check;
    }

    @Override
    public boolean saveRequestFile() {
        try {
            tools.WriteToFile file = new tools.WriteToFile("request.txt");
            for (Request thi : this) {
                file.writeLine(((Request) thi).print());
            }
            file.outputClose();
            return true;
        } catch (Exception e) {
            System.out.println("Error!!!");
            return false;
        }
    }

    @Override
    public void show() {
        if (this.isEmpty() == true) {
            System.out.println("Empty!!!");
            return;
        }
        for (Request tRequest : this) {
            System.out.println(tRequest);
        }
    }

    @Override
    public boolean approve(String id) {
        boolean result = false;
        if (this.isEmpty() == true) {
            System.out.println("Empty!");
            return false;
        }
        try {
            int index = this.find(id);
            do {
                if (index < 0) {
                    System.out.println("Request doesn't exist");
                    id = NghiaUtils.getString("Please retype request ID you want to approve: ");
                    index = this.find(id);
                }
            } while (index < 0);
            if (index > -1) {
                Request request = new Request();
                request = (Request) this.get(index);
                request.accept();
                this.set(index, request);
                result = true;
            } else {
                System.out.println("Not found!!!");
                result = false;
                return result;
            }
        } catch (Exception e) {
            System.out.println("Error");
            result = false;
            return result;
        }
        return result;
    }

    @Override
    public int find(String id) {
        int index = -1;
        try {
            index = this.indexOf(new Request(id));

        } catch (Exception e) {
        }
        return index;
    }

    @Override
    public int value(String id) {
        int index = this.find(id);
        Request request = new Request();
        request = (Request) this.get(index);
        int tmp = request.valueBorrowQty();
        return tmp;
    }

    @Override
    public String idAssetBorrow(String id) {
        int index = this.find(id);
        Request request = new Request();
        request = (Request) this.get(index);
        String tmp = request.idAssetBorrow();
        return tmp;
    }
}
