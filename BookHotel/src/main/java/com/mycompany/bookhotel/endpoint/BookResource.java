package com.mycompany.bookhotel.endpoint;

import com.mycompany.bookhotel.business.BookingBusiness;
import com.mycompany.bookhotel.helper.BookingsXML;
import java.io.StringWriter;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


@Path("book")
public class BookResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of BookResource
     */
    public BookResource() {
    }

    /**
     * Retrieves representation of an instance of com.mycompany.bookhotel.endpoint.BookResource
     * @return an instance of java.lang.String
     */
//    @GET 
//    @Produces(MediaType.APPLICATION_XML + ";charset=utf-8")
//    @Path("/{uID}")
//    public String getXml(@PathParam("uID") int uID) throws Exception {
//        System.out.println("get bookingres: help me im in the water: " + uID);
//        BookingsXML bookings = BookingBusiness.getBookingsByUser(uID);
//        System.out.println(">>>>>>>>>>>>>>>>>>" + bookings);
//
//        JAXBContext jaxbContext;
//        try {
//            jaxbContext = JAXBContext.newInstance(BookingsXML.class);
//            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            StringWriter sw = new StringWriter();
//            jaxbMarshaller.marshal(bookings, sw);
//
//            return (sw.toString());
//
//        } catch (JAXBException ex) {
//            Logger.getLogger(BookResource.class.getName()).log(Level.SEVERE, null, ex);
//            return ("error happened searchres.java");
//        }
//    }
    
    @GET 
    @Produces(MediaType.APPLICATION_XML + ";charset=utf-8")
    @Path("/{uName}/{hID}/{sDate}/{eDate}") // should be post but not working
    public String getXml(@PathParam("uName") String uName, @PathParam("hID") String hID, @PathParam("sDate") String sDate, @PathParam("eDate") String eDate) throws Exception {
        System.out.println("HI IM IN BOOKRESOURCEAAAA");
        System.out.println(uName + " " + hID);
        if (!hID.equals("z")) {
            BookingBusiness.setBookings(uName, Integer.parseInt(hID), sDate, eDate);
            return "";
        }
        
        System.out.println("get bookingres: help me im in the water: " + uName);
        BookingsXML bookings = BookingBusiness.getBookingsByUser(uName);
        System.out.println(">>>>>>>>>>>>>>>>>>" + bookings);

        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(BookingsXML.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(bookings, sw);

            return (sw.toString());

        } catch (JAXBException ex) {
            Logger.getLogger(BookResource.class.getName()).log(Level.SEVERE, null, ex);
            return ("error happened searchres.java");
        }
    }

    /**
     * PUT method for updating or creating an instance of BookResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml() throws Exception {

    }
    
    
}
