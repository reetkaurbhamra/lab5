package com.mycompany.helper;


public class Room {
    private int hotelID;
    private int roomID;
    private int capacity;

    public Room(int hotelID, int roomID, int capacity) {
        this.hotelID = hotelID;
        this.roomID = roomID;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getroomID() {
        return roomID;
    }

    public void setroomID(int roomID) {
        this.roomID = roomID;
    }
}