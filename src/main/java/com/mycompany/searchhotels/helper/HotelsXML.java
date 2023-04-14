package com.mycompany.searchhotels.helper;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import com.mycompany.searchhotels.helper.Hotel;

@XmlRootElement(name = "hotels")
@XmlAccessorType(XmlAccessType.FIELD)
public class HotelsXML {
    @XmlElement(name = "hotel")
    private ArrayList<Hotel> hotels;

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(ArrayList<Hotel> hx) {
        hotels = hx;
    }
}