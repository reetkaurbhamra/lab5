/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.searchhotels.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mycompany.searchhotels.helper.Hotel;
import com.mycompany.searchhotels.helper.Room;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author student
 */
public class Hotel_CRUD {
    Connection conn = null;
    ArrayList<Hotel> hotelsAvailable = new ArrayList<>();

    private static Connection connect() throws SQLException, Exception {
        Connection conn = null;
        System.out.println("im in hotel crud");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connection = System.getenv("DB_URL");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://"+connection+"/SEARCH?allowPublicKeyRetrieval=true&useSSL=false", "root", "student");
            System.out.println("Connection Established");
        } catch (Exception e) {
            System.out.println("Where is your JBDC driver");
            e.printStackTrace();
            throw e;
        }
        return conn;
    }

    public static ArrayList<Hotel> searchForAvailableHotels(String query) throws SQLException, Exception {
        Connection conn = connect();
        ArrayList<Hotel> hotels = new ArrayList<>();

        try {
            String q = "select * from HOTELS"
                    + " WHERE HOTELS.location LIKE '%" + query + "%'"
                    + " OR HOTELS.price LIKE '%" +
                    query + "%' OR HOTELS.hotelName LIKE '%" + query + "%';";
            
            if (query.equals("all")) {
                System.out.println("GET ALL HOTELS AAAAAAA");
                q = "select * from HOTELS";
            }
            

            PreparedStatement ps = conn.prepareStatement(q);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int hotelID = rs.getInt("hotelID");
                double price = rs.getDouble("price");
                double rating = rs.getDouble("rating");
                String location = rs.getString("location");
                String name = rs.getString("hotelName");
                int capacity = rs.getInt("capacity");
//                ArrayList<Room> rooms = getRooms(hotelID);
                
                hotels.add(new Hotel(hotelID, location, name, price, rating, capacity));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        conn.close();
        return hotels;
    }

    private static ArrayList<Room> getRooms(int hotelID) throws SQLException, Exception {
        ArrayList<Room> rooms = new ArrayList<>();
        Connection conn = connect();

        // query room (for each hotel)
        String q = "SELECT * FROM ROOMS WHERE hotelID = " + hotelID;
        PreparedStatement ps = conn.prepareStatement(q);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int roomID = rs.getInt("roomID");
            int capacity = rs.getInt("capacity");
            rooms.add(new Room(hotelID, roomID, capacity));
        }

        conn.close();
        return rooms;
    }

    protected void createHotel() throws SQLException {
        // connect();
    }

    protected void updateHotel() throws SQLException {
        // connect();
    }

    protected void deleteHotel() throws SQLException {
        // connect();
    }
}