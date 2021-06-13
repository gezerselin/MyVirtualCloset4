package com.example.myvirtualcloset3.data;

import java.util.ArrayList;

public class Drawer {
    private ArrayList<Clothing> Clothes;
    private String name;
    private int id;
    public ArrayList<Clothing> getClothes() {
        return getC();
    }
    public Drawer(){

    }
    public Drawer(int id,String name){
        this.id = id;
        this.name = name;
    }
    public void setClothes(ArrayList<Clothing> clothes) {
        Clothes = clothes;
    }

    public static ArrayList<Drawer> getData() {
        ArrayList<Drawer> drawerList = new ArrayList<Drawer>();

        for(int i= 0; i< 4;i++){
           Drawer tempDrawer = new Drawer();
            tempDrawer.setClothes(getC());
            drawerList.add(tempDrawer);
        }


        return  drawerList;
    }
    private static ArrayList<Clothing> getC(){
        ArrayList<Clothing> productList = new ArrayList<Clothing>();
        String[] productNames = {"Geleceği Yazanlar", "Paycell", "Tv+","Dergilik","Bip","GNC","Hesabım","Sim","LifeBox","Merhaba Umut","Yaani","Hayal Ortağım","Goller Cepte","Piri"};

        for (int i = 0; i < productNames.length; i++) {
            Clothing temp = new Clothing();
            temp.setName(productNames[i]);
            productList.add(temp);

        }
        return productList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
