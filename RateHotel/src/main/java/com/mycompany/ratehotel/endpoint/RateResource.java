/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ratehotel.endpoint;

import com.mycompany.ratehotel.business.RateBusiness;
import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author student
 */
@Path("rate")
public class RateResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RateResource
     */
    public RateResource() {
    }

    /**
     * Retrieves representation of an instance of com.mycompany.ratehotel.endpoint.RateResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/{hID}/{r}")
    @Produces(MediaType.APPLICATION_XML)
    public String getXml(@PathParam("hID") int hID, @PathParam("r") int r) throws Exception {
        RateBusiness.addRating(hID, r);
        return null;
    }

    /**
     * PUT method for updating or creating an instance of RateResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Path("update/{hotelID}")
    public String updateBookHold(@FormParam("hotelID") int hotelID) throws InterruptedException, SQLException, Exception {
        RateBusiness hotel = new RateBusiness();
        boolean bs;
       
        hotel.updateRating(hotelID);
        return ("Inserted");   

    }
}
