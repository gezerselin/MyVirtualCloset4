package com.example.myvirtualcloset3.data;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class VeriKaynagi {
    SQLiteDatabase db;
    SqliteKatmani bdb;

    public VeriKaynagi(Context c){

        bdb=new SqliteKatmani(c);
    }
    public void open(){
        db=bdb.getWritableDatabase();
    }
    public void close(){
        bdb.close();
    }

    public void createClothing(Clothing clothing){
        ContentValues val = new ContentValues();
        val.put("name",clothing.getName());
        val.put("type",clothing.getType());
        val.put("color",clothing.getColor());
        val.put("texture",clothing.getTexture());
        val.put("price",clothing.getPrice());
        val.put("image",clothing.getImage());
        val.put("DrawerId",clothing.getDrawerID());
        val.put("buyTime",clothing.getBuyTime());
        long pkey =db.insert("Clothing",null,val);
    }
    public void createEvent(Event event){
        ContentValues val = new ContentValues();
        val.put("name",event.getName());
        val.put("type",event.getType());
        val.put("date",event.getDate());
        val.put("location",event.getLocation());
        db.insert("Event",null,val);
    }
    public void createDrawer(Drawer drawer){
        ContentValues val = new ContentValues();
        val.put("name",drawer.getName());
        db.insert("Drawer",null,val);
    }



    public int deleteClothesImage(Clothing clothing){

        ContentValues val = new ContentValues();
        val.put("name",clothing.getName());
        val.put("type",clothing.getType());
        val.put("color",clothing.getColor());
        val.put("texture",clothing.getTexture());
        val.put("price",clothing.getPrice());
        val.putNull("image");
        val.put("DrawerId",clothing.getDrawerID());
        int id=clothing.getId();

        return db.update("Clothing",val,"id=?",new String[]{String.valueOf(id)});
    }


public int urunSil(int id){
        return db.delete("Clothing","id=?",new String[]{String.valueOf(id)});
    }


    public ArrayList<Drawer> getAllDrawers(){
        ArrayList<Drawer> sorular = new ArrayList<Drawer>();
        String q="SELECT * FROM Drawer" ;
        Cursor cursor = db.rawQuery(q,null);
        if(cursor.moveToFirst()){
            do{
                int id= cursor.getInt(0);

                String name=cursor.getString(1);
                Drawer s = new Drawer(id,name);
                sorular.add(s);
            }
            while(cursor.moveToNext());
        }

        return sorular;
   }
    public ArrayList<Event> getAllEvents(){
        ArrayList<Event> sorular = new ArrayList<Event>();
        String q="SELECT * FROM Event" ;
        Cursor cursor = db.rawQuery(q,null);
        if(cursor.moveToFirst()){
            do{
                int id= cursor.getInt(0);
                String name = cursor.getString(1);
                String type = cursor.getString(2);
                String date = cursor.getString(3);
                String location = cursor.getString(4);

                Event s = new Event(id,name,type,date,location);
                sorular.add(s);
            }
            while(cursor.moveToNext());
        }

        return sorular;
    }
    public ArrayList<Clothing> getAllClothing(){
        ArrayList<Clothing> sorular = new ArrayList<Clothing>();
        String q="SELECT * FROM Clothing" ;
        Cursor cursor = db.rawQuery(q,null);
        if(cursor.moveToFirst()){
            do{
                int id= cursor.getInt(0);
                String name=cursor.getString(1);
                String type=cursor.getString(2);
                String color=cursor.getString(3);
                String texture=cursor.getString(4);
                float price=cursor.getFloat(5);
                byte[] image = cursor.getBlob(8);
                int drawerId = cursor.getInt(7);
               String date = cursor.getString(6);


                Clothing s = new  Clothing(id,name,type,color,texture,price,date,drawerId,image);
                sorular.add(s);
            }
            while(cursor.moveToNext());
        }

        return sorular;
    }
    public ArrayList<Clothing> getClothingByDrawerId(int drawerID){
        ArrayList<Clothing> sorular = new ArrayList<Clothing>();
        Cursor cursor = db.rawQuery("SELECT * FROM Clothing WHERE DrawerId="+drawerID ,null);
        if(cursor.moveToFirst()){
            do{
                int id= cursor.getInt(0);
                String name=cursor.getString(1);
                String type=cursor.getString(2);
                String color=cursor.getString(3);
                String texture=cursor.getString(4);
                float price=cursor.getFloat(5);
                byte[] image = cursor.getBlob(8);
                int drawerId = cursor.getInt(7);
                String date = cursor.getString(6);




                Clothing s = new  Clothing(id,name,type,color,texture,price,date,drawerId,image);
                sorular.add(s);
            }
            while(cursor.moveToNext());
        }

        return sorular;
    }
    public Clothing getClothingById(int clothingId){

        Cursor cursor = db.rawQuery("SELECT * FROM Clothing WHERE id="+clothingId ,null);
        cursor.moveToNext();
        int id= cursor.getInt(0);
        String name=cursor.getString(1);
        String type=cursor.getString(2);
        String color=cursor.getString(3);
        String texture=cursor.getString(4);

        float price=cursor.getFloat(5);
        String date = cursor.getString(6);
        int drawerId = cursor.getInt(7);
        byte[] image = cursor.getBlob(8);
        Clothing s = new Clothing(id,name,type,color,texture,price,date,drawerId,image);




        return s;
    }
    public int getDrawerIdByName(String drawerName){
        Cursor cursor = db.rawQuery("SELECT * FROM Drawer WHERE name=?" , new String[]{drawerName},null);
        int count = cursor.getCount();
        cursor.moveToNext();
        int drawerId;
        if(count == 0){
             drawerId= -1;
        }
        else{
             drawerId = cursor.getInt(0);
        }

        return drawerId;
    }
//    public Kullanici getKullanici(int gelen_id){
//        String q="SELECT * FROM Kullanici WHERE  id="+gelen_id;
//        Cursor cursor = db.rawQuery(q,null);
//        cursor.moveToNext();
//        int id= cursor.getInt(0);
//        String ad=cursor.getString(1);
//        String soyad=cursor.getString(2);
//        String email =cursor.getString(3);
//        String telNo=cursor.getString(4);
//        String sifre=cursor.getString(5);
//        Kullanici k = new Kullanici(id,ad,soyad,email,telNo,sifre);
//
//        return k;
//    }
//
//    public boolean girisIzni(String gelenEmail,String gelenSifre){
//        String[] columns ={ "id" };
//        return bdb.checkUser(gelenEmail,gelenSifre);
//
//    }
//
//    public boolean aynıMailVarMi(String gelenEmail){
//        String[] columns ={ "id" };
//        return bdb.checkEmail(gelenEmail);
//
//    }
//
//    public int  kullaniciId(String email){
//        return bdb.getUserId(email);
//    }

}