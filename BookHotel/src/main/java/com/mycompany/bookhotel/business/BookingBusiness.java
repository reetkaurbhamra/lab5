/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bookhotel.business;

import com.mycompany.bookhotel.helper.BookingsXML;
import com.mycompany.bookhotel.persistence.Booking_CRUD;
import java.sql.Date;

/**
 *
 * @author student
 */
public class BookingBusiness {

    public static BookingsXML getBookingsByUser(String username) throws Exception {
        BookingsXML bx = new BookingsXML();
        bx.setBookings(Booking_CRUD.getUserBookings(username));
        return bx;
    }

    public static void setBookings(String username, int hotelID, String startDate1, String endDate1) throws Exception {
        Date startDate = new Date(2002, 12, 19);
        Date endDate = new Date(2022, 05, 30);
        Booking_CRUD.createUserBooking(username, hotelID, startDate, endDate);
    }
}