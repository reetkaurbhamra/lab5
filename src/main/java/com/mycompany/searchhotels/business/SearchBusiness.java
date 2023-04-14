package com.mycompany.searchhotels.business;

import com.mycompany.searchhotels.helper.HotelsXML;
import com.mycompany.searchhotels.helper.Hotel;
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import com.mycompany.searchhotels.helper.Room;
import com.mycompany.searchhotels.persistence.Hotel_CRUD;
import java.sql.SQLException;
import java.util.Arrays;

/**
 *
 * @author student
 */
public class SearchBusiness {
    
    public static HotelsXML getHotelsByQuery(String query) throws Exception {
        HotelsXML hx = new HotelsXML();
        hx.setHotels(Hotel_CRUD.searchForAvailableHotels(query));
        return hx;
    }  
    
    
}