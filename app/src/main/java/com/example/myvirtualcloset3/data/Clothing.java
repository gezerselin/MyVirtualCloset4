package com.example.myvirtualcloset3.data;

import java.util.Date;

public class Clothing {
    private String name;
    private String type;
    private String color;
    private String texture;
    private String buyTime;
    private float price;
    private byte[] image;
    private int id;
    private int drawerID;
    public Clothing(int id ,String name,String type,String color,String texture,float price,String date,int drawerID,byte[] image){
        this.id = id;
        this.name=name;
        this.type=type;
        this.color=color;
        this.texture=texture;
        this.image = image;
        this.price=price;
        this.drawerID= drawerID;
        this.buyTime = date;


    }
    public Clothing(String name,String type,String color,String texture,float price){
        this.name=name;
        this.type=type;
        this.color=color;
        this.texture=texture;

        this.price=price;


    }
   public Clothing(){

   }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

//    public Date getBuyTime() {
//        return buyTime;
//    }
//
//    public void setBuyTime(Date buyTime) {
//        this.buyTime = buyTime;
//    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    public int getId() {
        return id;
    }

    public int getDrawerID() {
        return drawerID;
    }

    public void setDrawerID(int drawerID) {
        this.drawerID = drawerID;
    }
}
