/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ratehotel.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Rating_CRUD {
    Connection conn = null;

    private static Connection connect() throws SQLException, Exception {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connection = System.getenv("DB_URL");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://"+connection+"/RATE?allowPublicKeyRetrieval=true&useSSL=false", "root", "student");
            System.out.println("Connection Established");
        } catch (Exception e) {
            System.out.println("Where is your JBDC driver");
            e.printStackTrace();
            throw e;
        }
        return conn;
    }
    
    public static void CreateRating(int hotelID, int rating) throws SQLException, Exception {
        Connection conn = connect();

        String q = "INSERT INTO RATINGS VALUES(" + getLastRatingID() + ",'" + hotelID + "'," + rating + ")";
        System.out.println(q);
        PreparedStatement st = conn.prepareStatement(q);
        int rs = st.executeUpdate();

    }
    
    private static int getLastRatingID() throws SQLException, Exception {
        Connection conn = connect();
        System.out.println("getlastbookingID");
        int rs_1 = 100;
        String currentMaxBookingNumber = "SELECT MAX(bookingID) AS maxID FROM BOOKINGS";
        try {
            PreparedStatement sub_st = conn.prepareStatement(currentMaxBookingNumber);
            ResultSet rs_0 = sub_st.executeQuery();
            if (rs_0.next()) {
                rs_1 = rs_0.getInt("maxID") + 1;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return rs_1;
    }
    
    public static double getAvgRating(int hotelID) throws Exception{
        Connection conn = connect();
        double rs_1 = 0;
        String q = "SELECT AVG(RATING) FROM RATINGS WHERE hotelID = '" + hotelID + "'";
        System.out.println(q);
        PreparedStatement st = conn.prepareStatement(q);
        ResultSet rs_0 = st.executeQuery();
        if (rs_0.next()) {
            rs_1 = rs_0.getInt("AVG(RATING)") + 1;
        }
        
        return rs_1;
    }    
}
