package com.mycompany.searchhotels.helper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "hotel")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hotel {

    private int hotelID;
    private String location;
    private String name;
    private double price;
    private double rating;
    private int capacity;
//    ArrayList<Room> rooms; // capacity of hotel is length of this arraylist

//    public Hotel(int hotelID, double price, int capacity, int rating, String location, ArrayList<Room> rooms) {
//        this.hotelID = hotelID;
//        this.rating = rating;
//        this.location = location;
//        this.rooms = rooms;
//    }

    public Hotel(int hotelID, String location, String name, double price, double rating, int capacity) {
        this.hotelID = hotelID;
        this.location = location;
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.capacity = capacity;
    }

    public Hotel() {
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}