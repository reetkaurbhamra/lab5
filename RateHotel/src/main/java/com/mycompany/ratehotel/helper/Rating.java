/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ratehotel.helper;

/**
 *
 * @author student
 */
public class Rating {
    int ratingID;
    int hotelID;
    int rating;

    public Rating(int ratingID, int hotelID, int rating) {
        this.ratingID = ratingID;
        this.hotelID = hotelID;
        this.rating = rating;
    }

    public int getRatingID() {
        return ratingID;
    }

    public void setRatingID(int ratingID) {
        this.ratingID = ratingID;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
    
}
