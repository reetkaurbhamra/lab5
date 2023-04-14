package com.mycompany.ratehotel.business;

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
import com.mycompany.ratehotel.helper.Rating;
import com.mycompany.ratehotel.persistence.Rating_CRUD;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 *
 * @author student
 */
public class RateBusiness {
        
    public static void addRating(int hotelID, int rating) throws Exception {
        Rating_CRUD.CreateRating(hotelID, rating);
        //updateRating(hotelID);
    }
    
    public static void updateRating(int hotelID) throws ClassNotFoundException, SQLException, InterruptedException, Exception {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.now();
        Messaging.sendmessage("RATING:"+Rating_CRUD.getAvgRating(hotelID)+":"+hotelID+":"+date.format(formatter));           
        
        return;
    }
}