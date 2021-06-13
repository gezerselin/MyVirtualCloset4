package com.example.myvirtualcloset3.data;

public class Event {

    private String name;
    private String type;
    private String date ;
    private String  location;
    private int id;
    public Event(){

    }
    public Event(String name,String type,String date,String location){
        this.name=name;
        this.type=type;
        this.date=date;
        this.location=location;
    }
    public Event(int id, String name,String type,String date,String location){
        this.id = id;
        this.name=name;
        this.type=type;
        this.date=date;
        this.location=location;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }
}
