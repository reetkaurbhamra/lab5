package com.mycompany.business;

import com.mycompany.helper.BookingsXML;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.apache.commons.io.IOUtils;
import com.mycompany.helper.Hotel;
import com.mycompany.helper.HotelsXML;


public class Business {

    public static boolean isAuthenticated(String username, String password) {
        return true;
    }

    public static HotelsXML searchService(String query, String token) throws IOException {
        System.out.println("BUSINESSSSS");
        Client searchclient = ClientBuilder.newClient();
        System.out.println("CLIENT: " + searchclient);
        String searchService = System.getenv("searchService");
        WebTarget searchwebTarget = searchclient.target("http://" + searchService + "/SearchHotels/webresources/search/" + (query != null && !query.equals("") ? query : "all"));
        System.out.println("WEBTARGET: " + searchwebTarget);
        System.out.println("SOMETHING: " + searchwebTarget.request(MediaType.APPLICATION_XML));
        InputStream is = searchwebTarget.request(MediaType.APPLICATION_XML).get(InputStream.class);
        String xml = IOUtils.toString(is, "utf-8");
        System.out.println(xml);
        System.out.println(hotelxmltoObjects(xml));
        return hotelxmltoObjects(xml);   
    }
        
    public static void bookService(String hotelID, String username) {
        Client cl = ClientBuilder.newClient();
        System.out.println("IN BOOKSERIVEC: " + hotelID + " " + username + " test");
        String bookService = System.getenv("bookService");
        WebTarget wt = cl.target("http://" +bookService + "/BookHotel/webresources/book/" + username + "/" + hotelID + "/date/date");
        InputStream is = wt.request(MediaType.APPLICATION_XML).get(InputStream.class);
        System.out.println("bookedaadadadadadad");
    }
    
    public static BookingsXML userBookingsService(String username) throws IOException {
        Client cl = ClientBuilder.newClient();
        System.out.println("IN BOOKSERIVECae: " + username);
        
        String bookService = System.getenv("bookService");
        WebTarget wt = cl.target("http://"+bookService+"/BookHotel/webresources/book/" + username + "/z/z/z");
        InputStream is = wt.request(MediaType.APPLICATION_XML).get(InputStream.class);
        String xml = IOUtils.toString(is, "utf-8");
        
        return bookingxmltoObjects(xml);   
    }
    
    public static void rateService(String hotelID, int rating) {
        Client cl = ClientBuilder.newClient();
        System.out.println("Hotel Id " + hotelID +" Rating " + rating);
        String rateService = System.getenv("rateService");
        WebTarget wt = cl.target("http://" +rateService + "/RateHotel/webresources/rate/" + hotelID + "/" + rating);
        InputStream is = wt.request(MediaType.APPLICATION_XML).get(InputStream.class);
    }

    private static HotelsXML hotelxmltoObjects(String xml) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(HotelsXML.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            HotelsXML hotels = (HotelsXML) jaxbUnmarshaller.unmarshal(new StringReader(xml));
            return hotels;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private static BookingsXML bookingxmltoObjects(String xml) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(BookingsXML.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            BookingsXML bookings = (BookingsXML) jaxbUnmarshaller.unmarshal(new StringReader(xml));
            return bookings;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}