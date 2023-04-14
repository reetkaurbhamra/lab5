package com.mycompany.helper;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import com.mycompany.helper.Booking;

@XmlRootElement(name = "bookings")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookingsXML {
    @XmlElement(name = "booking")
    private ArrayList<Booking> bookings;

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }
}