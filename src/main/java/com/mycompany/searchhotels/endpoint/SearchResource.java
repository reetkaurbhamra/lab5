package com.mycompany.searchhotels.endpoint;

import com.mycompany.searchhotels.business.SearchBusiness;
import com.mycompany.searchhotels.helper.HotelsXML;
import java.io.StringWriter;
import java.util.Collection;
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

/**
 * REST Web Service
 *
 * @author student
 */
@Path("search")
public class SearchResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SearchResource
     */
    public SearchResource() {
    }

    /**
     * Retrieves representation of an instance of com.mycompany.searchhotels.endpoint.SearchResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML + ";charset=utf-8")
    @Path("/{query}")
    public String getXml(@PathParam("query") String query) throws Exception {
        System.out.println("get searchres: help me im in the water: " + query);
        HotelsXML hotels = SearchBusiness.getHotelsByQuery(query);
        System.out.println(">>>>>>>>>>>>>>>>>>" + hotels);

        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(HotelsXML.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(hotels, sw);

            return (sw.toString());

        } catch (JAXBException ex) {
            Logger.getLogger(SearchResource.class.getName()).log(Level.SEVERE, null, ex);
            return ("error happened searchres.java");
        }
    }

    /**
     * PUT method for updating or creating an instance of SearchResource
     * @param content representation for the resource
     */
//    @PUT
//    @Consumes(MediaType.APPLICATION_XML)
//    public void putXml(String content) {
//    }
}
