package com.mycompany.helper;

import java.sql.Date;

/**
 *
 * @author student
 */
public class Booking {
    int bookingID;
    String username;
    int hotelID;
    String startDate;
    String endDate;
    String hotelName;
    String hotelLocation;
    
    public Booking() {}
    
    public Booking(int bookingID, String username, int hotelID, String startDate, String endDate, String hotelName, String hotelLocation) {
        this.bookingID = bookingID;
        this.username = username;
        this.hotelID = hotelID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.hotelName = hotelName;
        this.hotelLocation = hotelLocation;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getUserID() {
        return username;
    }

    public void setUserID(String username) {
        this.username = username;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelLocation() {
        return hotelLocation;
    }

    public void setHotelLocation(String hotelLocation) {
        this.hotelLocation = hotelLocation;
    }
}