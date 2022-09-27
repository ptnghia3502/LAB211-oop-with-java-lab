/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import tools.NghiaUtils;

/**
 *
 * @author Nghia
 */
public class AssetList extends ArrayList<Asset> implements A_List {

    @Override
    public boolean loadAssetFile() {
        boolean check = false;
        try {
            tools.ReadFromFile file = new tools.ReadFromFile("asset.txt");
            String line;
            while ((line = file.readLine()) != null) {
                String[] tmp = line.split(", ");
                String id = tmp[0];
                String name = tmp[1];
                String color = tmp[2];
                int price = Integer.parseInt(tmp[3]);
                double weight = Double.parseDouble(tmp[4]);
                int quantity = Integer.parseInt(tmp[5]);
                int curQty = Integer.parseInt(tmp[6]);
                Asset asset = new Asset(id, name, color, price, weight, quantity, curQty);
                this.add(asset);
            }
            file.inputClose();
            return true;
        } catch (IOException ex) {
            System.out.println("Error!!!");
        }
        return check;
    }

    @Override
    public boolean saveAssetFile() {
        try {
            tools.WriteToFile file = new tools.WriteToFile("asset.txt");
            for (Asset thi : this) {
                file.writeLine(((Asset) thi).print());
            }
            file.outputClose();
            return true;
        } catch (Exception e) {
            System.out.println("Error!!!");
            return false;
        }
    }

    @Override
    public int find(String id) {
        int index = -1;
        try {
            index = this.indexOf(new Asset(id));

        } catch (Exception e) {
        }
        return index;
    }

    @Override
    public boolean searchByName(String name) {
        boolean check = false;
        try {
            for (Asset thi : this) {
                if (thi.getAssetName().equalsIgnoreCase(name) == true) {
                    System.out.println(thi);
                    check = true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error!");
            return false;
        }
        return check;
    }

    @Override
    public boolean create() {
        boolean result = false;
        try {
            String id = NghiaUtils.getString("Input asset ID: ");
            int index = this.find(id);
            do {
                if (index > -1) {
                    System.out.println("ID existed");
                    id = NghiaUtils.getString("Please retype another ID:");
                }
            } while (index > -1);
            if (index == -1) {
                Asset asset = new Asset(id);
                asset.input();
                this.add(asset);
                result = true;
                return result;
            }
        } catch (Exception e) {
            return false;
        }
        return result;
    }

    @Override
    public boolean update() {
        boolean result = false;
        if (this.isEmpty() == true) {
            System.out.println("Empty!");
            return false;
        }
        try {
            String id = NghiaUtils.getString("Input asset ID you want to update: ");
            int index = this.find(id);
            do {
                if (index < 0) {
                    System.out.println("Asset doesn't exist");
                    id = NghiaUtils.getString("Please retype ID you want to update: ");
                    index = this.find(id);
                }
            } while (index < 0);
            if (index > -1) {
                Asset asset = new Asset();
                asset = (Asset) this.get(index);
                asset.edit();
                this.set(index, asset);
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
    public boolean approve(int tmp, String assetBr) {
        boolean result = false;
        try {
            String id = assetBr;
            int index = this.find(id);
            Asset asset = new Asset();
            asset = (Asset) this.get(index);
            int quantity = tmp;
            asset.accept(quantity);
            this.set(index, asset);
            result = true;
        } catch (Exception e) {
            System.out.println("Error");
            result = false;
            return result;
        }
        return result;
    }
}
